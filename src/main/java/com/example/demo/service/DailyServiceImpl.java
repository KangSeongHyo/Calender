package com.example.demo.service;

import com.example.demo.domain.CalendarDTO;
import com.example.demo.domain.MonthlyDTO;
import com.example.demo.repos.MonthlyRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Daily 뷰 서비스 Class
 */
@Service
public class DailyServiceImpl implements DailyService {

    @Resource
    MonthlyRepo monthlyRepo;

    /**
     * 요청 년/월/일에 대한 Daily 일정 리스트
     * @param calendarDTO
     * @return
     */
    @Override
    public List<MonthlyDTO> scheduleOfDay(CalendarDTO calendarDTO) {
        MonthlyDTO monthlyDTO = new MonthlyDTO();
        new MonthlyServiceImpl().checkYearAndMonthAndDay(calendarDTO);
        List<MonthlyDTO> monthlyDTOList = monthlyRepo.getScheduleList(calendarDTO);
        if(monthlyDTOList.size() == 0){
            monthlyDTO.setStart_day(calendarDTO.getDay());
            monthlyDTOList.add(monthlyDTO);
        }
        return monthlyDTOList;
    }
}
