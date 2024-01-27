package com.devfun.settingweb_boot.test;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.service.StatisticService;
 
 
 
@Controller
public class settingTest {
    
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/sqlyear-statistic")
    public Map<String, Object> sqltest(String year) throws Exception{ 
        return service.yearloginNum(year);
    }
    
	/* 총 접속자 수 조회 */
    @ResponseBody 
    @RequestMapping("/statistics/totalVisitors")
    public Map<String, Object> totalVisitors() throws Exception{ 
        return service.totalVisitors();
    }
    
	/* 부서별 접속자 수 조회 */
    @ResponseBody 
    @RequestMapping("/statistics/departmentVisitors")
    public Map<String, Object> departmentVisitors(@RequestParam String department) throws Exception{ 
        return service.departmentVisitors(department);
    }
    
	/* 월별 접속자 수 조회 API */
    @ResponseBody 
    @RequestMapping("/statistics/monthlyVisitors")
    public HashMap<String, Object> monthlyVisitors(@RequestParam String month) throws Exception {
        return service.monthlyVisitors(month);
    }

	/* 일별 로그인 요청 수 조회 API */
    @ResponseBody 
    @RequestMapping("/statistics/dailyLoginRequests")
    public HashMap<String, Object> dailyLoginRequests(@RequestParam String date) throws Exception {
        return service.dailyLoginRequests(date);
    }

	/* 평균 하루 로그인 수 조회 API */
    @ResponseBody 
    @RequestMapping("/statistics/averageDailyLogins")
    public HashMap<String, Object> averageDailyLogins() throws Exception {
        return service.averageDailyLogins();
    }

	/* 부서별 월별 로그인 수 조회 API */
    @ResponseBody 
    @RequestMapping("/statistics/departmentMonthlyLogins")
    public HashMap<String, Object> departmentMonthlyLogins(@RequestParam String department, @RequestParam String month) throws Exception {
        return service.departmentMonthlyLogins(department, month);
    }
    
    /* 휴일을 제외한 로그인 수 조회 */
    @ResponseBody 
    @RequestMapping("/statistics/nonHolidayLogins")
    public HashMap<String, Object> nonHolidayLogins() throws Exception {
        return service.nonHolidayLogins();
    }

    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}