/**
* 获取本周、本季度、本月、上月的开始日期、结束日期
*/
var now = new Date(); //当前日期 
var nowDayOfWeek = now.getDay(); //今天本周的第几天 
var nowDay = now.getDate(); //当前日 
var nowMonth = now.getMonth(); //当前月 
var nowYear = now.getYear(); //当前年 
nowYear += (nowYear < 2000) ? 1900 : 0; //

var lastMonthDate = new Date(); //上月日期
lastMonthDate.setDate(1);
lastMonthDate.setMonth(lastMonthDate.getMonth()-1);
var lastYear = lastMonthDate.getYear();
var lastMonth = lastMonthDate.getMonth();

//格式化日期：yyyy-MM-dd 
function formatDate(date) { 
var myyear = date.getFullYear(); 
var mymonth = date.getMonth()+1; 
var myweekday = date.getDate(); 

if(mymonth < 10){ 
mymonth = "0" + mymonth; 
} 
if(myweekday < 10){ 
myweekday = "0" + myweekday; 
} 
return (myyear+"-"+mymonth + "-" + myweekday); 
} 

//获得某月的天数 
function getMonthDays(myMonth){ 
var monthStartDate = new Date(nowYear, myMonth, 1); 
var monthEndDate = new Date(nowYear, myMonth + 1, 1); 
var days = (monthEndDate - monthStartDate)/(1000 * 60 * 60 * 24); 
return days; 
} 

//获得本季度的开始月份 
function getQuarterStartMonth(){ 
var quarterStartMonth = 0; 
if(nowMonth<3){ 
quarterStartMonth = 0; 
} 
if(2<nowMonth && nowMonth<6){ 
quarterStartMonth = 3; 
} 
if(5<nowMonth && nowMonth<9){ 
quarterStartMonth = 6; 
} 
if(nowMonth>8){ 
quarterStartMonth = 9; 
} 
return quarterStartMonth; 
} 

//获得本周的开始日期 
function getWeekStartDate() { 
var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek); 
return formatDate(weekStartDate); 
} 

//获得本周的结束日期 
function getWeekEndDate() { 
var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek)); 
return formatDate(weekEndDate); 
} 

//获得本月的开始日期 
function getMonthStartDate(){ 
var monthStartDate = new Date(nowYear, nowMonth, 1); 
return formatDate(monthStartDate); 
} 

//获得本月的结束日期 
function getMonthEndDate(){ 

 var days= getMonthDays(nowMonth);//获取当月总共有多少天
 var monthEndDate = new Date(nowYear, nowMonth, days); 
 return formatDate(monthEndDate); //返回当月结束时间
}

注意：因为上面这个方法里的getMonthDays(nowMonth)方法 我尝试使用失败，我不知道是什么原因 所以我用了另外个方法如下（获得某月的天数,需要配合文章开头的公式 ）：

//获得某月的天数 （与上面有重复可删除，不然本月结束日期报错）
    function getMonthDays(nowyear,myMonth){
     var lastMonthStartDate = new Date(nowyear, lastMonth, 1);
     var lastMonthEndDate= new Date(nowyear, lastMonth+ 1, 1);
     var days = (lastMonthEndDate- lastMonthStartDate) / (1000 * 60 * 60 * 24);//格式转换
    alert(days);
   }

//获得上月开始时间
function getLastMonthStartDate(){
var lastMonthStartDate = new Date(nowYear, lastMonth, 1);
return formatDate(lastMonthStartDate); 
}

//获得上月结束时间
function getLastMonthEndDate(){
var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));
return formatDate(lastMonthEndDate); 
}

//获得本季度的开始日期 
function getQuarterStartDate(){ 

var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1); 
return formatDate(quarterStartDate); 
} 

//或的本季度的结束日期 
function getQuarterEndDate(){ 
var quarterEndMonth = getQuarterStartMonth() + 2; 
var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth)); 
return formatDate(quarterStartDate); 
}

//获取本年开始-当前时间

var currentYear=now.getFullYear();//获得当前年份4位年

var currentYearFirstDate=new Date(currentYear,0,1); //本年第一天

var startTime = currentYearFirstDate.getFullYear() + '-' + (currentYearFirstDate.getMonth() +1) + '-' + currentYearFirstDate.getDate()+''+currentYearFirstDate.getHours()+':'+currentYearFirstDate.getMinutes()+':'+

currentYearFirstDate.getSeconds(); //格式化本年第一天日期

var currentYearEndDate=now; //当前时间