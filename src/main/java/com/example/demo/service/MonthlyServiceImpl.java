package com.example.demo.service;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
        int res = 0;
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

    /**
     *
     * @param calendarDTO
     * @return
     */
    @Override
    public Map<String,Object> scheduleMonthlyList(CalendarDTO calendarDTO) {
        Map<String,Object> resultMap = new HashMap<>();
        initCalendar(calendarDTO);

        List<CalendarDTO> scheduleList = monthlyRepo.getSchedlueStatus(calendarDTO);
        List<CalendarDTO>[] weekList = dayOfWeekList(scheduleList,startDayOfMonth(calendarDTO));

        resultMap.put("weekList",weekList);
        return resultMap;
    }

    @Override
    public int initCalendar(CalendarDTO calendarDTO) {
        checkYearAndMonth(calendarDTO);
        int lastDay = lastDayOfMonth(Integer.parseInt(calendarDTO.getMonth()));

        if(monthlyRepo.getCountCalender(calendarDTO) == 0){
            List<CalendarDTO> initDayOfMonthList = new ArrayList<>();
            for(int day = 1; day <= lastDay; day++){
                initDayOfMonthList.add(new CalendarDTO(calendarDTO.getYear()
                        ,calendarDTO.getMonth()
                        ,String.format("%02d", day)));
            }

            monthlyRepo.createMonthCalendar(initDayOfMonthList);
        }
        return 0;
    }

    /**
     *
     * @param scheduleList
     * @param stratDay
     * @return
     */
    @Override
    public List<CalendarDTO>[] dayOfWeekList(List<CalendarDTO> scheduleList,int stratDay) {
        List<CalendarDTO>[] weekList = new ArrayList[5];
        int count = stratDay;
        int week = 0;
        int idx = 0;
        for(int i = 0; i < 5; i++){
            weekList[i] = new ArrayList<>();
        }

        for(int i = 1; i < stratDay; i++){
            weekList[0].add(new CalendarDTO());
            week++;
        }
        for(CalendarDTO dto : scheduleList){
            if(week==7){
                idx++;
                week=0;
            }
            weekList[idx].add(dto);
            week++;
        }

        return weekList;
    }


    @Override
    public void checkYearAndMonth(CalendarDTO calendarDTO) {
        String month = calendarDTO.getMonth();
        String year = calendarDTO.getYear();

        if(month == null ||year == null) {
            Date today = new Date();
            SimpleDateFormat dateFormatYear = new SimpleDateFormat("YYYY");
            SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
            year = dateFormatYear.format(today);
            month = dateFormatMonth.format(today);
            calendarDTO.setYear(year);
            calendarDTO.setMonth(month);
        }

    }


    @Override
    public String[] dateParse(String date) {
        return date.split("\\/");
    }

    @Override
    public String[] timeParse(String date) {
        return date.split("\\s|\\:");
    }


    @Override
    public int startDayOfMonth(CalendarDTO calendarDTO) {
        int mSum = 0;
        int dSum = 1;
        int start = 0;
        int year = Integer.parseInt(calendarDTO.getYear());
        int month = Integer.parseInt(calendarDTO.getMonth());

        for (int i = 1; i < year; i++) {
            mSum += 365;
        }

        for (int i = 1; i < month; i++) {
            dSum += lastDayOfMonth(i);
        }
        start = (mSum + dSum)%7;
        return start;

    }

    @Override
    public int lastDayOfMonth(int month) {
        int last = 0;
        switch (month){
            case 2:
                last = 28;
                break;
            case 4: case 6: case 9: case 11:
                last = 30;
                break;
            default:
                last = 31;
                break;
        }

        return last;
    }


}
