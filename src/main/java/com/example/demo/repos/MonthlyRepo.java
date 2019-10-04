package com.example.demo.repos;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Mapper
@Repository
public interface MonthlyRepo {
    public int createSchedule(MonthlyDTO monthlyDTO);
    public List<MonthlyDTO> getScheduleList(CalendarDTO calendarDTO);
    public List<CalendarDTO> getSchedlueStatus(CalendarDTO monthlyDTO);
    public int getCountCalender(CalendarDTO calendarDTO);
    public int createMonthCalendar(List<CalendarDTO> initDayOfMonthList);
    public List<CalendarDTO> test(CalendarDTO calendarDTO);
}
