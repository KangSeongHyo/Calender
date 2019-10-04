package com.example.demo.test;
import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.service.MonthlyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonthlyServiceImplTest {

    private static final int FAIL = 0,SUCCESS = 1;

    @Resource
    MonthlyService monthlyService;
    CalendarDTO calendarDTO;
    MonthlyDTO monthlyDTO;

    @Before
    public void init(){
        calendarDTO = new CalendarDTO();
        calendarDTO.setYear("2019");
        calendarDTO.setMonth("10");
        calendarDTO.setDay("03");

        monthlyDTO = new MonthlyDTO();
        monthlyDTO.setTitle("테스트 일정");
        monthlyDTO.setExplanation("설명");
        monthlyDTO.setStartSchedule("10/03/2019");
        monthlyDTO.setEndSchedule("10/03/2019");
        monthlyDTO.setStartTime("8:14 AM");
        monthlyDTO.setEndTime("10:14 PM");
        monthlyDTO.setAll_day(false);
        monthlyDTO.setRepeat_month(false);
    }

    @Test
    public void regScheduleTest(){
        int res = FAIL;
        res = monthlyService.regSchedule(monthlyDTO);
        Assert.assertEquals(SUCCESS,res);
    }

    @Test
    public void scheduleMonthlyListTest(){
       Map<String,Object> map = monthlyService.scheduleMonthlyList(calendarDTO);
       Assert.assertNotEquals(FAIL,map.size());
    }

}
