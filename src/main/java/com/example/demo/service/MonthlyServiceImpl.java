package com.example.demo.service;

import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MonthlyServiceImpl  implements MonthlyService{

    @Resource
    private MonthlyRepo monthlyRepo;

    @Override
    public int regSchedule(MonthlyDTO monthlyDTO) {
        monthlyRepo.createSchedule(monthlyDTO);
        return 0;
    }
}
