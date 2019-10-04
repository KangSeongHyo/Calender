package com.example.demo.controller;

import com.example.demo.domain.MonthlyDTO;
import com.example.demo.service.MonthlyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Monthly 뷰 데이터 Controller
 */
@RestController
@RequestMapping(value = "/monthly")
public class MonthlyController {

    private static Logger logger = LoggerFactory.getLogger(MonthlyController.class);
    private static final int FAIL = 0;
    @Resource
    MonthlyService monthlyService;
    /**
     * 일정 등록
     * @param monthlyDTO
     * @return HTTPStatus(등록 완료 200, 등록실패(요청오류 400))
     */
    @PostMapping(value = "/register")
    public HttpStatus register(@ModelAttribute MonthlyDTO monthlyDTO){
            logger.info("[Request] 일정등록 = {}",monthlyDTO);
            int res = monthlyService.regSchedule(monthlyDTO);

            if(res==FAIL){
                logger.error("[Error] 일정등록 오류 = {}",monthlyDTO);
                return HttpStatus.BAD_REQUEST;
            }else{
                logger.info("[Response] 일정등록 = {}",monthlyDTO);
                return HttpStatus.OK;
            }

    }
}
