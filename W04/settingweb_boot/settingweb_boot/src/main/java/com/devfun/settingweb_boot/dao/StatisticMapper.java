package com.devfun.settingweb_boot.dao;
import java.util.HashMap;
 
//import com.devfun.settingweb_boot.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    
    // 총 접속자 수 조회
    public HashMap<String, Object> selectTotalVisitors();
    
    //부서별 접속자 수 조회
    public HashMap<String, Object> selectDepartmentVisitors(String department);
    
	// 월별 접속자 수 조회
    public HashMap<String, Object> monthlyVisitors(String month);
    
    // 일별 접속자 수 조회
    public HashMap<String, Object> dailyLoginRequests(String date);
    
    // 평균 하루 로그인 수 조회
    public HashMap<String, Object> averageDailyLogins();
    
    // 부서별 월별 로그인 수 조회
    public HashMap<String, Object> departmentMonthlyLogins(String department, String month);
    
    // 휴일을 제외한 로그인 수 조회
    public HashMap<String, Object> nonHolidayLogins();
}



