package com.example.demo.test;
import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.service.MonthlyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonthlyServiceImplTest {

    private static Logger logger = LoggerFactory.getLogger(MonthlyServiceImplTest.class);

    @Resource
    MonthlyService monthlyService;

    @Test
    public void scheduleMonthlyListTest(){

    }

    @Test
    public void regScheduleTest(){
        int res = 0;
        MonthlyDTO monthlyDTO = new MonthlyDTO();

        monthlyDTO.setTitle("테스트 일정");
        monthlyDTO.setExplanation("설명");
        monthlyDTO.setStartSchedule("10/03/2019");
        monthlyDTO.setEndSchedule("10/03/2019");
        monthlyDTO.setStartTime("8:14 AM");
        monthlyDTO.setEndTime("10:14 PM");
        monthlyDTO.setAll_day(false);
        monthlyDTO.setRepeat_month(false);
        res = monthlyService.regSchedule(monthlyDTO);
        Assert.assertEquals(1,res);
    }

    @Test
    public void initCalendarTest(){
        CalendarDTO calendarDTO = new CalendarDTO();
        int res = 0;
        res = monthlyService.initCalendar(calendarDTO);

        Assert.assertNotEquals(0,res);
    }

}
