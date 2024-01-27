package com.devfun.settingweb_boot.service;
 
 
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    public static HashMap<String, Object> createResponse(Object data) {
    	HashMap<String, Object> retVal = new HashMap<>();

        if (data == null) {
            retVal.put("returnCode", "400");
            retVal.put("returnMessage", "Invalid request");
        } else {
            retVal.put("returnCode", "200");
            retVal.put("returnMessage", "Success");
            retVal.put("data", data);
        }

        return retVal;
    }
    
    @Override
    public HashMap<String, Object> yearloginNum (String year) throws Exception {
        // TODO Auto-generated method stub
        HashMap<String, Object> data = new HashMap<>();
   
        data = uMapper.selectYearLogin(year);
        
        return createResponse(data);
    }
    
	/* 총 접속자 수 조회 */
    @Override
    public HashMap<String, Object> totalVisitors() throws Exception {
        HashMap<String, Object> data = new HashMap<>();

        data = uMapper.selectTotalVisitors();
        
        return createResponse(data);
    }
    
	/* 부서별 접속자 수 조회 */
    @Override
    public HashMap<String, Object> departmentVisitors(String department) {
        HashMap<String, Object> data = new HashMap<>();

        data = uMapper.selectDepartmentVisitors(department);

        return createResponse(data);
    }
    
	/* 월별 접속자 수 조회 */
    @Override
    public HashMap<String, Object> monthlyVisitors(String month) {
    	HashMap<String, Object> data = new HashMap<>();

    	data = uMapper.monthlyVisitors(month);

        return createResponse(data);
    }

    /* 일별 로그인 요청 수 조회 */
    @Override
    public HashMap<String, Object> dailyLoginRequests(String date) {
    	HashMap<String, Object> data = new HashMap<>();

    	data = uMapper.dailyLoginRequests(date);

        return createResponse(data);
    }

	/* 평균 하루 로그인 수 조회 */
    @Override
    public HashMap<String, Object> averageDailyLogins() {
    	HashMap<String, Object> data = new HashMap<>();

    	data = uMapper.averageDailyLogins();

        return createResponse(data);
    }

	/* 부서별 월별 로그인 수 조회 */
    @Override
    public HashMap<String, Object> departmentMonthlyLogins(String department, String month) {
    	HashMap<String, Object> data = new HashMap<>();

    	data = uMapper.departmentMonthlyLogins(department, month);

        return createResponse(data);
    }
    
    /* 휴일을 제외한 로그인 수 조회 */
    @Override
    public HashMap<String, Object> nonHolidayLogins() {
    	HashMap<String, Object> data = new HashMap<>();

    	data = uMapper.nonHolidayLogins();

        return createResponse(data);
    }
    
 
}