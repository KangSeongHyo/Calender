$(document).ready(function(){
    let year = $("#present").data("year");
    let month = $("#present").data("month");

    $("#next").click(function () {
        let year_parse = parseInt(year);
        let month_parse = parseInt(month);
        month_parse += 1;
        if(month_parse==13){
            year_parse += 1;
            month_parse = 1;
        }
        month_parse = $.format(month_parse);
        location.href="?year="+year_parse+"&month="+month_parse;
    });

    $("#perv").click(function () {
        let year_parse = parseInt(year);
        let month_parse = parseInt(month);
        month_parse -= 1;
        if(month==0){
            year_parse -= 1;
            month_parse = 12;
        }
        month_parse = $.format(month_parse);
        location.href="?year="+year_parse+"&month="+month_parse;
    });

    $("#all_day").click(function () {

        let check = $(this).is(":checked");
        let date = $("#startSchedule").val();

        if(date==""){
            alert("시작날짜를 확인해주세요");
            $(this).prop("checked",false);
            return;
        }

        if(check){
            $("#endDatePicker").data("datetimepicker").date(date);
            $("#startTime").prop("disabled",true);
            $("#endTime").prop("disabled",true);
            $("#startSchedule").prop("disabled",true);
            $("#endSchedule").prop("disabled",true);
        }else {
            $("#startTime").prop("disabled",false);
            $("#endTime").prop("disabled",false);
            $("#startSchedule").prop("disabled",false);
            $("#endSchedule").prop("disabled",false);
        }
    });
    
    $("#make_schedule").click(function () {
        $.ajax({
            url : "/monthly/register",
            data : $("#monthly_day_form").serialize()
                   +"&all_day="+$("#all_day").is(":checked")
                   +"&repeat_month="+$("#repeat_month").is(":checked"),
            method : "POST",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType : "JSON"
        }).done(function(result) {
            $('#registerSchedule').modal('hide');
            location.reload();
        }).fail(function (xhr,status) {

        });
    });
    

    $('[data-toggle="tooltip"]').tooltip();
    $('#view li:first-child a').tab('show');

    $('[data-toggle="popover"]').popover().on('inserted.bs.popover');
    $('.week, .daily-calendar').click(function() {
        $('#registerSchedule').modal('show');
    });


    $('.day').click(function() {

        let day = $(this).find(".day-label").text();
        $('#startDatePicker').data("datetimepicker").date(month+"/"+day+"/"+year);
        $('#registerSchedule').modal('show');
    });

    $(".event-consecutive, .event, .event-repeated").click(function(event) {
        event.stopPropagation();
    });



    $('#startDatePicker').datetimepicker({
        format: 'L'
    });
    $('#endDatePicker').datetimepicker({
        format: 'L'
    });
    $('#startTImePicker').datetimepicker({
        format: 'LT'
    });
    $('#endTImePicker').datetimepicker({
        format: 'LT'
    });
});
