package com.example.demo.domain;

public class MonthlyDTO {
    private String title;
    private String explanation;
    private String start_schedule;
    private String end_schedule;
    private String start_time;
    private String end_time;
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

    public String getStart_schedule() {
        return start_schedule;
    }

    public void setStart_schedule(String start_schedule) {
        this.start_schedule = start_schedule;
    }

    public String getEnd_schedule() {
        return end_schedule;
    }

    public void setEnd_schedule(String end_schedule) {
        this.end_schedule = end_schedule;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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
                ", start_schedule='" + start_schedule + '\'' +
                ", end_schedule='" + end_schedule + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", repeat_month=" + repeat_month +
                ", all_day=" + all_day +
                '}';
    }
}
