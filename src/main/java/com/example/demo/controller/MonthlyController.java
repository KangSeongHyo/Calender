package com.example.demo.controller;

import com.example.demo.domain.MonthlyDTO;
import com.example.demo.service.MonthlyService;
import com.example.demo.service.MonthlyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/monthly")
public class MonthlyController {

    private static Logger logger = LoggerFactory.getLogger(MonthlyController.class);

    @Resource
    MonthlyService monthlyService;

    @PostMapping("/register")
    public HttpStatus register(@ModelAttribute MonthlyDTO monthlyDTO){
            logger.info("monthlyDTO = {}",monthlyDTO);
            monthlyService.regSchedule(monthlyDTO);
            return HttpStatus.OK;
    }
}
