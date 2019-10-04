package com.example.demo.test.repo;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import com.example.demo.test.MonthlyServiceImplTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonthlyRepoTest {

    private static Logger logger = LoggerFactory.getLogger(MonthlyServiceImplTest.class);
    private static final int FAIL = 0;
    @Resource
    MonthlyRepo monthlyRepo;

    CalendarDTO calendarDTO;
    MonthlyDTO monthlyDTO;

    @Before
    public void init(){
        calendarDTO = new CalendarDTO();
        calendarDTO.setYear("2019");
        calendarDTO.setMonth("10");
        calendarDTO.setDay("03");

        monthlyDTO = new MonthlyDTO();
        monthlyDTO.setTitle("테스트 제목");
        monthlyDTO.setExplanation("테스트");
        monthlyDTO.setStart_year("2019");
        monthlyDTO.setStart_month("10");
        monthlyDTO.setStart_day("03");
        monthlyDTO.setEnd_year("2019");
        monthlyDTO.setEnd_month("10");
        monthlyDTO.setEnd_day("03");
        monthlyDTO.setAll_day(false);
        monthlyDTO.setRepeat_month(false);
    }

    @Test
    @Order(1)
    public void createTest(){
       int res = monthlyRepo.createSchedule(monthlyDTO);
        Assert.assertNotEquals(FAIL,res);
    }

    @Test
    public void getScheduleStatusTest(){
        List<CalendarDTO> resList
                = monthlyRepo.getScheduleStatus(calendarDTO);

        Assert.assertNotEquals(0,resList.size());
    }

    @Test
    public void getScheduleListTest(){
        List<MonthlyDTO> monthlyDTOList
                = monthlyRepo.getScheduleList(calendarDTO);
        Assert.assertNotEquals(0,monthlyDTOList.size());
    }


}
