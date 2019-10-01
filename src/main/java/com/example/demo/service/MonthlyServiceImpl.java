package com.example.demo.service;

import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MonthlyServiceImpl implements MonthlyService{
    private static Logger logger = LoggerFactory.getLogger(MonthlyServiceImpl.class);

    private static int YEAR = 2,SIGN= 2;
    private static int MONTH = 0,HOUR = 0;
    private static int DAY = 1,MINUTE= 1;

    @Resource
    private MonthlyRepo monthlyRepo;

    @Override
    public int regSchedule(MonthlyDTO monthlyDTO) {
        int res;
        String[] sSchedule = dateParse(monthlyDTO.getStartSchedule());
        String[] eSchedule = dateParse(monthlyDTO.getEndSchedule());
        String[] sTime = timeParse(monthlyDTO.getStartTime());
        String[] eTime = timeParse(monthlyDTO.getEndTime());

        monthlyDTO.setStart_year(sSchedule[YEAR]);
        monthlyDTO.setStart_month(sSchedule[MONTH]);
        monthlyDTO.setStart_day(sSchedule[DAY]);

        monthlyDTO.setEnd_year(eSchedule[YEAR]);
        monthlyDTO.setEnd_month(eSchedule[MONTH]);
        monthlyDTO.setEnd_day(eSchedule[DAY]);

        monthlyDTO.setStart_hour(sTime[HOUR]);
        monthlyDTO.setStart_minute(sTime[MINUTE]);
        monthlyDTO.setStart_sign(sTime[SIGN]);

        monthlyDTO.setEnd_hour(eTime[HOUR]);
        monthlyDTO.setEnd_minute(eTime[MINUTE]);
        monthlyDTO.setEnd_sign(eTime[SIGN]);

        res = monthlyRepo.createSchedule(monthlyDTO);

        return res;
    }

    @Override
    public Map<String,Object> scheduleMonthlyList(String year, String month) {
        Map<String,Object> resultMap = new HashMap<>();
        if(month.equals("")||year.equals("")){
            Date today = new Date();
            SimpleDateFormat dateFormatYear = new SimpleDateFormat("YYYY");
            SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
            year = dateFormatYear.format(today);
            month = dateFormatMonth.format(today);
        }
        List<MonthlyDTO> scheduleList = monthlyRepo.getScheduleList(year,month);
        List<Integer> dayList = scheduleList
                                    .stream()
                                    .map(dto->Integer.parseInt(dto.getStart_day()))
                                    .collect(Collectors.toList());
        resultMap.put("scheduleList",scheduleList);
        resultMap.put("dayList",dayList);

        return resultMap;
    }

    @Override
    public String[] dateParse(String date) {
        return date.split("\\/");
    }

    @Override
    public String[] timeParse(String date) {
        return date.split("\\s|\\:");
    }
}
