$.format = function (item) {
    if(item<10){
        item = "0"+item;
    }
    return item;
}