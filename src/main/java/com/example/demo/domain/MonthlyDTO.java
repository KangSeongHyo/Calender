package com.example.demo.domain;

import com.example.demo.common.DateTimePicker;
import org.apache.ibatis.type.Alias;

@Alias("MonthlyDTO")
public class MonthlyDTO extends DateTimePicker {
    private String title;
    private String explanation;
    private String start_year;
    private String start_month;
    private String start_day;
    private String end_year;
    private String end_month;
    private String end_day;
    private String start_hour;
    private String start_minute;
    private String start_sign;
    private String end_hour;
    private String end_minute;
    private String end_sign;
    private boolean repeat_month;
    private boolean all_day;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

    public String getStart_month() {
        return start_month;
    }

    public void setStart_month(String start_month) {
        this.start_month = start_month;
    }

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String getEnd_year() {
        return end_year;
    }

    public void setEnd_year(String end_year) {
        this.end_year = end_year;
    }

    public String getEnd_month() {
        return end_month;
    }

    public void setEnd_month(String end_month) {
        this.end_month = end_month;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public String getStart_minute() {
        return start_minute;
    }

    public void setStart_minute(String start_minute) {
        this.start_minute = start_minute;
    }

    public String getStart_sign() {
        return start_sign;
    }

    public void setStart_sign(String start_sign) {
        this.start_sign = start_sign;
    }

    public String getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(String end_hour) {
        this.end_hour = end_hour;
    }

    public String getEnd_minute() {
        return end_minute;
    }

    public void setEnd_minute(String end_minute) {
        this.end_minute = end_minute;
    }

    public String getEnd_sign() {
        return end_sign;
    }

    public void setEnd_sign(String end_sign) {
        this.end_sign = end_sign;
    }

    public boolean isRepeat_month() {
        return repeat_month;
    }

    public void setRepeat_month(boolean repeat_month) {
        this.repeat_month = repeat_month;
    }

    public boolean isAll_day() {
        return all_day;
    }

    public void setAll_day(boolean all_day) {
        this.all_day = all_day;
    }

    @Override
    public String toString() {
        return "MonthlyDTO{" +
                "title='" + title + '\'' +
                ", explanation='" + explanation + '\'' +
                ", start_year='" + start_year + '\'' +
                ", start_month='" + start_month + '\'' +
                ", start_day='" + start_day + '\'' +
                ", end_year='" + end_year + '\'' +
                ", end_month='" + end_month + '\'' +
                ", end_day='" + end_day + '\'' +
                ", start_hour='" + start_hour + '\'' +
                ", start_minute='" + start_minute + '\'' +
                ", start_sign='" + start_sign + '\'' +
                ", end_hour='" + end_hour + '\'' +
                ", end_minute='" + end_minute + '\'' +
                ", end_sign='" + end_sign + '\'' +
                ", repeat_month=" + repeat_month +
                ", all_day=" + all_day +
                '}';
    }
}
