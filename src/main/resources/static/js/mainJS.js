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
            dataType : "JSON"
        }).done(function(result) {
            $('#registerSchedule').modal('hide');
            location.reload();
        }).fail(function (xhr,status) {

        });
    });

});




$(function () {
    $('#datetimepicker1').datetimepicker({
        format: 'L'
    });
    $('#datetimepicker3').datetimepicker({
        format: 'L'
    });
});

$(function () {
    $('#datetimepicker2').datetimepicker({
        format: 'LT'
    });
    $('#datetimepicker4').datetimepicker({
        format: 'LT'
    });
});
