package com.example.demo.controller;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.service.DailyService;
import com.example.demo.service.MonthlyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * index.html 처리하는 Controller
 */
@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MonthlyController.class);

    @Resource
    MonthlyService monthlyService;
    @Resource
    DailyService dailyService;

    /**
     * 메인페이지 처리
     * @param calendarDTO 요청데이터(year, month, day)
     * @return [Monthly 뷰] weekList, [Daily 뷰]scheduleOfDay
     */
    @RequestMapping("/")
    private ModelAndView index(@ModelAttribute CalendarDTO calendarDTO) {
        logger.info("[Request] 메인페이지(index) - {} ",calendarDTO);

        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> resultMap = monthlyService.scheduleMonthlyList(calendarDTO);
        List<MonthlyDTO> scheduleOfDay = dailyService.scheduleOfDay(calendarDTO);

        modelAndView.addObject("scheduleOfDay",scheduleOfDay);
        modelAndView.addObject("weekList",resultMap.get("weekList"));
        modelAndView.setViewName("index");

        logger.info("[Response] 메인페이지(index) - {} ",calendarDTO);
        return modelAndView;
    }
}
