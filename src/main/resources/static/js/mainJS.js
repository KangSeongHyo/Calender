$(document).ready(function(){

    $('[data-toggle="tooltip"]').tooltip();

    $('#view li:first-child a').tab('show');

    $('[data-toggle="popover"]').popover().on('inserted.bs.popover');

    $('.week, .daily-calendar').click(function() {
        $('#registerSchedule').modal('show');
    });
    $(".event-consecutive, .event, .event-repeated").click(function(event) {
        event.stopPropagation();
    });

    $("#make_schedule").click(function () {
        $.ajax({
            url : "/monthly/register",
            data : $("#monthly_day_form").serialize(),
            method : "POST",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType : "JSON"
        }).done(function(result) {
            $('#registerSchedule').modal('hide');
            location.reload();
        }).fail(function (xhr,status) {

        });
    });

    $('#datetimepicker1').datetimepicker({
        format: 'L'
    });
    $('#datetimepicker3').datetimepicker({
        format: 'L'
    });
    $('#datetimepicker2').datetimepicker({
        format: 'LT'
    });
    $('#datetimepicker4').datetimepicker({
        format: 'LT'
    });
});

/*
tag += "<class='event event-start event-end' data-span='1' data-toggle='popover'" +
    " data-html="+boo+
    " data-content=<div class=content-line>" +
    "<div class=event-marking></div>" +
    "<div class=title>" +
    "<h5>"+dayList[idx].title+"</h5>" +
    "<h7 class=reservation>" +
    dayList[idx].start_year+"년 " +
    dayList[idx].start_month+"월 " +
    dayList[idx].start_day+"일 -" +
    dayList[idx].end_day+"일 " +
    "<span class=reservation-time>" +
    dayList[idx].start_sign+" " +
    dayList[idx].start_hour+" : " +
    dayList[idx].start_minute+" ~ " +
    dayList[idx].end_sign+" " +
    dayList[idx].end_hour+" : " +
    dayList[idx].end_minute+" </span></h7>" +
    "</div>" +
    "</div>" +
    "<div class='content-line'>" +
    "<i class='material-icons'>" +
    "notes</i>" +
    "<div class='title'><h7 class='reservation'>" +
    dayList[idx].explanation+"</div>" +
    "일반일정 "+idx+
    "</div>";*/
