package virnet.management.timemanagement.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import virnet.management.timemanagement.service.TimeManagementService;

import com.opensymphony.xwork2.ActionSupport;

public class TimeManagementAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4448513339645955944L;
	
	private TimeManagementService timeService = new TimeManagementService();
	
	private HttpServletRequest request;
	
	private Map<String, Object> results = new HashMap<String, Object>();
	private Map<String, Object> info = new HashMap<String, Object>();
	
	public String showTimeArrange(){
		String username = this.request.getParameter("user");
		String week = this.request.getParameter("week");
		String date = this.request.getParameter("date");
		System.out.println("time Management, username : " + username + ", week : " + week + ", date : " + date);
		
		this.results = this.timeService.showTimeArrange(username, week, date);
		
		return SUCCESS;
	}

	public String courseTableInfo(){
		String username = this.request.getParameter("user");
		System.out.println("time Management, username : " + username);
		Map<String, Object> info = this.timeService.courseTableInfo(username);
		
		this.setInfo(info);
		
		return SUCCESS;
	}
	
	public String classInfo(){
		String username = this.request.getParameter("user");
		Map<String, Object> info = this.timeService.classInfo(username);
		
		this.setInfo(info);		
		
		return SUCCESS;
	}
	
	public void setTimeService(TimeManagementService t){
		this.timeService = t;
	}
	
	public TimeManagementService getTimeService(){
		return this.timeService;
	}

	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	
	public void setResults(Map<String, Object> list){
		this.results = list;
	}
	
	public Map<String, Object> getResults(){
		return this.results;
	}
	
	public void setInfo(Map<String, Object> list){
		this.info = list;
	}
	
	public Map<String, Object> getInfo(){
		return this.info;
	}
}
