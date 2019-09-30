package com.example.demo.repos;

import com.example.demo.domain.MonthlyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MonthlyRepo {
    public int createSchedule(MonthlyDTO monthlyDTO);
    public List<MonthlyDTO> getScheduleList(String year, String month);
}
