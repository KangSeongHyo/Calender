package com.example.demo.repos;

import com.example.demo.domain.MonthlyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MonthlyRepo {
    public int createSchedule(MonthlyDTO monthlyDTO);
}
