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

/**
 * Monthly 뷰 서비스 Class
 */
@Service
public class MonthlyServiceImpl implements MonthlyService{
    private static Logger logger = LoggerFactory.getLogger(MonthlyServiceImpl.class);

    private static int YEAR = 2,SIGN= 2;
    private static int MONTH = 0,HOUR = 0;
    private static int DAY = 1,MINUTE= 1;

    @Resource
    private MonthlyRepo monthlyRepo;

    /**
     * 스케쥴 등록
     * @param monthlyDTO
     * @return
     */
    @Override
    public int regSchedule(MonthlyDTO monthlyDTO) {
        logger.info("regSchedule ={}",monthlyDTO);

        int res = 0;
        boolean allDay = monthlyDTO.isAll_day();
        boolean repeat = monthlyDTO.isRepeat_month();

        // 날짜 년/월/일, 시간 시/분 시간대 각각 분류로직
        String[] sSchedule = dateParse(monthlyDTO.getStartSchedule());
        String[] eSchedule = dateParse(monthlyDTO.getEndSchedule());

        String[] sTime = timeParse(allDay?"12:00 AM":monthlyDTO.getStartTime());
        String[] eTime = timeParse(allDay?"11:59 PM":monthlyDTO.getEndTime());

        monthlyDTO.setStart_hour(sTime[HOUR]);
        monthlyDTO.setStart_minute(sTime[MINUTE]);
        monthlyDTO.setStart_sign(sTime[SIGN]);

        monthlyDTO.setEnd_hour(eTime[HOUR]);
        monthlyDTO.setEnd_minute(eTime[MINUTE]);
        monthlyDTO.setEnd_sign(eTime[SIGN]);

        monthlyDTO.setStart_year(sSchedule[YEAR]);
        monthlyDTO.setStart_month(sSchedule[MONTH]);
        monthlyDTO.setStart_day(sSchedule[DAY]);

        monthlyDTO.setEnd_year(eSchedule[YEAR]);
        monthlyDTO.setEnd_month(eSchedule[MONTH]);
        monthlyDTO.setEnd_day(eSchedule[DAY]);

        // 매월반복
        if(repeat){
            logger.info("매월반복 처리");
            int smonth = Integer.parseInt(monthlyDTO.getStart_month());
            int emonth = Integer.parseInt(monthlyDTO.getEnd_month());

            for(int i = 0; i+smonth <=12; i++){
                monthlyDTO.setStart_month(String.format("%02d",smonth+i));
                monthlyDTO.setEnd_month((String.format("%02d",emonth+i)));
              res = monthlyRepo.createSchedule(monthlyDTO);
            }
        }else{
            res = monthlyRepo.createSchedule(monthlyDTO);
        }
        return res;
    }

    /**
     * 해당 월 스케쥴 목록
     * @param calendarDTO
     * @return
     */
    @Override
    public Map<String,Object> scheduleMonthlyList(CalendarDTO calendarDTO) {
        Map<String,Object> resultMap = new HashMap<>();
        initCalendar(calendarDTO);

        List<CalendarDTO> scheduleList = monthlyRepo.getScheduleStatus(calendarDTO);
        List<CalendarDTO>[] weekList = dayOfWeekList(scheduleList,startDayOfMonth(calendarDTO));

        resultMap.put("weekList",weekList);
        return resultMap;
    }

    /**
     * 해당년월 Calendar 테이블 초기화
     * @param calendarDTO
     */
    @Override
    public void initCalendar(CalendarDTO calendarDTO) {
        checkYearAndMonthAndDay(calendarDTO);
        int lastDay = lastDayOfMonth(Integer.parseInt(calendarDTO.getMonth()));
        if(monthlyRepo.getCountCalender(calendarDTO) == 0){
            logger.info(calendarDTO.getYear()+"년"+calendarDTO.getMonth()+"월 Calendar 초기화");
            List<CalendarDTO> initDayOfMonthList = new ArrayList<>();
            for(int day = 1; day <= lastDay; day++){
                initDayOfMonthList.add(new CalendarDTO(calendarDTO.getYear()
                        ,calendarDTO.getMonth()
                        ,String.format("%02d", day)));
            }
            monthlyRepo.createMonthCalendar(initDayOfMonthList);
        }
    }

    /**
     * 스케줄목록 주차별 분류
     * @param scheduleList
     * @param stratDay
     * @return
     */
    @Override
    public List<CalendarDTO>[] dayOfWeekList(List<CalendarDTO> scheduleList,int stratDay) {
        List<CalendarDTO>[] weekList = new ArrayList[5];
        logger.info("시작날짜 : ",String.valueOf(stratDay));
        logger.info("Week단위로 일정 분류");

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


    /**
     * 현재 년월로 초기화
     * @param calendarDTO
     */
    @Override
    public void checkYearAndMonthAndDay(CalendarDTO calendarDTO) {
        String month = calendarDTO.getMonth();
        String year = calendarDTO.getYear();
        String day = calendarDTO.getDay();

        if(month == null && year == null && day == null) {
            logger.info("년/월/일 초기화");
            Date today = new Date();
            SimpleDateFormat dateFormatYear = new SimpleDateFormat("YYYY");
            SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
            SimpleDateFormat dateFormatDay = new SimpleDateFormat("dd");
            year = dateFormatYear.format(today);
            month = dateFormatMonth.format(today);
            day = dateFormatDay.format(today);
            calendarDTO.setYear(year);
            calendarDTO.setMonth(month);
            calendarDTO.setDay(day);
        }else if((month!=null)&&(year!=null)&&day==null){
            // 초기값설정
            logger.info("일 초기화");
            calendarDTO.setDay("01");
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

    /**
     * 월의 시작날짜
     * @param calendarDTO
     * @return
     */
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

    /**
     * 월의 마지막 날짜
     * @param month
     * @return
     */
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
