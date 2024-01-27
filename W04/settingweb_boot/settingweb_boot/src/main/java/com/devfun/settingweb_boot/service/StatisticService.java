package com.devfun.settingweb_boot.service;
 
import java.util.HashMap;
 
public interface StatisticService {
    public HashMap<String,Object> yearloginNum (String year) throws Exception;
    
	/* 총 접속자 수 조회 */
    public HashMap<String, Object> totalVisitors() throws Exception;
    
	/* 부서별 접속자 수 조회 */
    public HashMap<String, Object> departmentVisitors(String department);
    
	/* 월별 접속자 수 조회 */
    public HashMap<String, Object> monthlyVisitors(String month) throws Exception;

	/* 일별 로그인 요청 수 조회 */ 
    public HashMap<String, Object> dailyLoginRequests(String date) throws Exception;
    
	/* 평균 하루 로그인 수 조회 */
    public HashMap<String, Object> averageDailyLogins() throws Exception;

	/* 부서별 월별 로그인 수 조회 */
    public HashMap<String, Object> departmentMonthlyLogins(String department, String month) throws Exception;
    
    public HashMap<String, Object> nonHolidayLogins() throws Exception;
}