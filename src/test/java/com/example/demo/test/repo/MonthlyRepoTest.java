package com.example.demo.test.repo;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import com.example.demo.test.MonthlyServiceImplTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonthlyRepoTest {

    private static Logger logger = LoggerFactory.getLogger(MonthlyServiceImplTest.class);

    @Resource
    MonthlyRepo monthlyRepo;

    @Test
    public void createScheduleTest(){
        CalendarDTO calendarDTO = new CalendarDTO();
        calendarDTO.setYear("2019");
        calendarDTO.setMonth("10");
        List<CalendarDTO> resList = monthlyRepo.getSchedlueStatus(calendarDTO);
        Assert.assertNotEquals(0,resList.size());
    }


}
