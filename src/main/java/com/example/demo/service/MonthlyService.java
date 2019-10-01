package com.example.demo.service;

import com.example.demo.domain.MonthlyDTO;

import java.util.List;
import java.util.Map;

public interface MonthlyService {
    public int regSchedule(MonthlyDTO monthlyDTO);
    public Map<String,Object> scheduleMonthlyList(String year, String month);
    public String[] dateParse(String date);
    public String[] timeParse(String date);
}
