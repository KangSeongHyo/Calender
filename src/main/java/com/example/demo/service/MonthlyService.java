package com.example.demo.service;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;

import java.util.List;
import java.util.Map;

public interface MonthlyService {
    public void initCalendar(CalendarDTO calendarDTO);
    public int regSchedule(MonthlyDTO monthlyDTO);
    public Map<String,Object> scheduleMonthlyList(CalendarDTO calendarDTO);
    public int startDayOfMonth(CalendarDTO calendarDTO);
    public int lastDayOfMonth(int month);
    public List<CalendarDTO>[] dayOfWeekList(List<CalendarDTO> scheduleList,int stratDay);
    public void checkYearAndMonthAndDay(CalendarDTO calendarDTO);
    public String[] dateParse(String date);
    public String[] timeParse(String date);
}
