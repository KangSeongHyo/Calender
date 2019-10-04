package com.example.demo.repos;

import com.example.demo.domain.CalendarDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Mapper
@Repository
public interface DailyRepo {

    public List<MonthlyRepo> getScheduleOfDay(CalendarDTO calendarDTO);

}
