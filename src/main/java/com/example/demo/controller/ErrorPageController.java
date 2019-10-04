package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Error 페이지 커스텀
 */
@Controller
public class ErrorPageController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ModelAndView error(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));

        modelAndView.addObject("code", status.toString());
        modelAndView.addObject("msg", httpStatus.getReasonPhrase());
        modelAndView.setViewName("error");

        return modelAndView;
    }


}
