package com.example.demo.service;

import com.example.demo.domain.MonthlyDTO;

import java.util.List;

public interface MonthlyService {
    public int regSchedule(MonthlyDTO monthlyDTO);
    public List<MonthlyDTO> scheduleMonthlyList(String year,String month);
    public String[] dateParse(String date);
    public String[] timeParse(String date);
}
