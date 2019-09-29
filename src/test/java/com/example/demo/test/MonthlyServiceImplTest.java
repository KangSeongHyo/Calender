package com.example.demo.test;


import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonthlyServiceImplTest {

    @Resource
    MonthlyRepo monthlyRepo;

    @Test
    public void regScheduleTest(){
        MonthlyDTO monthlyDTO = new MonthlyDTO();
        monthlyDTO.setTitle("제목");
        monthlyDTO.setExplanation("설명");
        monthlyDTO.setStart_schedule(new Date());
        monthlyDTO.setEnd_schedule(new Date());
        monthlyDTO.setStart_time("8:14 PM");
        monthlyDTO.setEnd_time("8:14 PM");
        monthlyDTO.setAll_day(false);
        monthlyDTO.setRepeat_month(false);
        int res = monthlyRepo.createSchedule(monthlyDTO);
        Assert.assertEquals(1,res);
    }

}
