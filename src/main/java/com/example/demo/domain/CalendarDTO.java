package com.example.demo.domain;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("CalendarDTO")
public class CalendarDTO {
    String year;
    String month;
    String day;
    int size;
    List<MonthlyDTO> scheduleList;

    public CalendarDTO() {
    }

    public CalendarDTO(String year, String month) {
        this.year = year;
        this.month = month;
    }

    public CalendarDTO(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<MonthlyDTO> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<MonthlyDTO> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "CalendarDTO{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", size=" + size +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
