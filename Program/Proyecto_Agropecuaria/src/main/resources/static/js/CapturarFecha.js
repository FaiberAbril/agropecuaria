var Time = new Date();

function CapturarDate(){
    var Year =Time.getFullYear.toString
    var Month = Time.getMonth.toString
    var Day = Time.getDay.toString
    var Hour = Time.getHours.toString
    var Minute = Time.getMinutes.toString
    var Second = Time.getSeconds.toString

    var TotalDate = Year+Month+Day+Hour+Minute+Second;
    return TotalDate;
}