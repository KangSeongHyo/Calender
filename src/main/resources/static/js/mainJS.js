$(document).ready(function(){
    $("#next").click(function () {
        let year = parseInt($("#present").data("year"));
        let month = parseInt($("#present").data("month"));
        month += 1;
        if(month==13){
            year += 1;
            month = 1;
        }
        month = $.format(month);
        location.href="?year="+year+"&month="+month;
    });

    $("#perv").click(function () {
        let year = parseInt($("#present").data("year"));
        let month = parseInt($("#present").data("month"));
        month -= 1;
        if(month==0){
            year -= 1;
            month = 12;
        }
        month = $.format(month);
        location.href="?year="+year+"&month="+month;
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
    
    
    
    $('[data-toggle="tooltip"]').tooltip();
    $('#view li:first-child a').tab('show');

    $('[data-toggle="popover"]').popover().on('inserted.bs.popover');
    $('.week, .daily-calendar').click(function() {
        $('#registerSchedule').modal('show');
    });
    $(".event-consecutive, .event, .event-repeated").click(function(event) {
        event.stopPropagation();
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
