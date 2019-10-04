$(document).ready(function(){
    let year = $("#present").data("year");
    let month = $("#present").data("month");
    let day = $(".day-daily").text().substr(0,2);

    $("#dailyReg").click(function () {
        $("#startDatePicker").data("datetimepicker").date(month+"/"+day+"/"+year);
        $("#endDatePicker").data("datetimepicker").date(month+"/"+day+"/"+year);
    });

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
   $("#nextDay").click(function () {
        let month_parse = parseInt(month);
        let day_parse = parseInt(day);
        if(day_parse==31){
            alert("마지막날입니다.")
            return;
        }
        day_parse+=1;
        month_parse = $.format(month_parse);
        day_parse = $.format(day_parse);
        location.href="?year="+year+"&month="+month_parse+"&day="+day_parse;
    });

    $("#pervDay").click(function () {
        let month_parse = parseInt(month);
        let day_parse = parseInt(day);

        if(month==1){
            alert("첫째날입니다.")
            return;
        }
        day_parse-=1;
        month_parse = $.format(month_parse);
        day_parse = $.format(day_parse);
        location.href="?year="+year+"&month="+month_parse+"&day="+day_parse;
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
            $("#startTime").val("");
            $("#endTime").val("");
            $("#startTime").prop("readOnly",true);
            $("#endTime").prop("readOnly",true);
            $("#startSchedule").prop("readOnly",true);
            $("#endSchedule").prop("readOnly",true);
        }else {
            $("#startTime").prop("readOnly",false);
            $("#endTime").prop("readOnly",false);
            $("#startSchedule").prop("readOnly",false);
            $("#endSchedule").prop("readOnly",false);
        }
    });
    
    $("#make_schedule").click(function () {
        let ids = ["#message-text","#recipient-name","#startSchedule","#endSchedule","#startTime","#endTime"];
        for(let i = 0; i < ids.length; i++){

            if(i > 3 && $("#all_day").is(":checked")){
                //alert("내용을 입력해주세요")
                continue;
            }

            if(!$.vaildate($(ids[i]).val())){
               alert("내용을 입력해주세요");
               return;
           }
.2        }

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
            if(xhr.status==500){
                alert("서버에 오류가 발생하였습니다.");
            }else if(xhr.status==400){
                alert("요청에 오류가 있습니다.");
            }else{
                alert("오류가 발생하였습니다.");
            }
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
