package com.example.demo.controller;

import com.example.demo.domain.MonthlyDTO;
import com.example.demo.service.MonthlyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "/monthly")
public class MonthlyController {

    private static Logger logger = LoggerFactory.getLogger(MonthlyController.class);

    @Resource
    MonthlyService monthlyService;

    /**
     * 일정 등록
     * @param monthlyDTO
     * @return
     */
    @PostMapping(value = "/register")
    public HttpStatus register(@ModelAttribute MonthlyDTO monthlyDTO){
            logger.info("일정등록 = {}",monthlyDTO);
            monthlyService.regSchedule(monthlyDTO);
            return HttpStatus.OK;
    }
}
