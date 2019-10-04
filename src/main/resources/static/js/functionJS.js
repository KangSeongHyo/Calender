$.format = function (item) {
    if(item<10){
        item = "0"+item;
    }
    return item;
}

$.vaildate = function (data) {
    if(data==null||data == ""){
        return false;
    }else{
        return true;
    }
}