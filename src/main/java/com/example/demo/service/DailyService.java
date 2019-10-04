package com.example.demo.service;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;

import java.util.List;

public interface DailyService {
    public List<MonthlyDTO> scheduleOfDay(CalendarDTO calendarDTO);

}
