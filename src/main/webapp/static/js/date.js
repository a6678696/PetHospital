
function genTodayStr(){
	var date = new Date();
	return date.getFullYear()+"-"+formatZero(date.getMonth()+1)+"-"+formatZero(date.getDate());
}

function genTodayStrAddOne(){
	var date = new Date();
	return date.getFullYear()+"-"+formatZero(date.getMonth()+1)+"-"+formatZero(date.getDate()+1);
}

function genLastYearStr(){
	var date = new Date();
	date.setFullYear(date.getFullYear()-1);
	return date.getFullYear()+"-"+formatZero(date.getMonth()+1)+"-"+formatZero(date.getDate());
}

function genLastMonthDayStr(){
	var date = new Date();
	var month=(date.getMonth()+1-1)<10?"0"+(date.getMonth()+1-1):(date.getMonth()+1-1);
	return date.getFullYear()+"-"+formatZero(month)+"-"+formatZero(date.getDate());
}

function genLastWeekDayStr(){
	var date = new Date();
	date.setDate(date.getDate()-6);
	return date.getFullYear()+"-"+formatZero(date.getMonth()+1)+"-"+formatZero(date.getDate());
}

function formatZero(n){
	if(n<10){
		return "0"+n;
	}else{
		return n;
	}
}