package virnet.management.timemanagement.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import virnet.management.combinedao.ClassInfoCDAO;
import virnet.management.combinedao.PeriodArrangeCDAO;
import virnet.management.dao.ClassDAO;
import virnet.management.dao.CourseDAO;
import virnet.management.dao.PeriodarrangeDAO;
import virnet.management.dao.PeriodarrangeWeekDAO;
import virnet.management.entity.Course;
import virnet.management.entity.Periodarrange;
import virnet.management.entity.PeriodarrangeWeek;
import virnet.management.entity.Class;
import virnet.management.util.DateUtil;

public class TimeManagementService {
	private DateUtil dateutil = new DateUtil();
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showTimeArrange(String User, String Sweek, String date){
		Map<String, Object> map = new HashMap<String, Object>();
		int returnweek = 0;
		String sweek = new String();
		String returndate = new String();
		dateutil.setSysInfo();
		
		int week;
		List<Object> list = new ArrayList<Object>();
		
		try{
			week = Integer.parseInt(Sweek) ;
        }
		catch(Exception e){
			week = 0;
        }
		
		if(week == -1){
			//use date
			Map<String, Object> datemap = this.dateutil.CalDate(date);
			
			returnweek = (int) datemap.get("weekNO");
			if(returnweek == 0 || returnweek > dateutil.getTotalWeek()){
				list = defaultWeekInfo();
				sweek = "0";
				returndate = "";
			}
			else{
				list = selectWeek(returnweek, (List<String>) datemap.get("datelist"));
				sweek = returnweek + "";
				returndate = ((List<String>) datemap.get("datelist")).get(0);
			}
		}
		else if(week == 0){
			//use default week
			list = defaultWeekInfo();
			returnweek = 0;
			sweek = "0";
			returndate = "";
		}
		else{
			//use select week
			Map<String, Object> datemap = this.dateutil.CalWeek(week);
			
			returnweek = (int) datemap.get("weekNO");
			if(returnweek == 0 || returnweek > dateutil.getTotalWeek()){
				list = defaultWeekInfo();
				sweek = "0";
				returndate = "";
			}
			else{
				list = selectWeek(returnweek, (List<String>) datemap.get("datelist"));
				sweek = returnweek + "";
				returndate = ((List<String>) datemap.get("datelist")).get(0);
			}
		}
		
		map.put("data", list);
		map.put("date", returndate);
		map.put("week", sweek);
		
		return map;
	}
	
	public Map<String, Object> courseTableInfo(String User){
		DateUtil dateutil = new DateUtil();
		dateutil.setSysInfo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalweek", dateutil.getTotalWeek());
		
		return map;
	}
	
	public Map<String, Object> classInfo(String user){
		Map<String, Object> map = new HashMap<String, Object>();
		
		ClassInfoCDAO cDAO = new ClassInfoCDAO();
		List<Class> clist = cDAO.getAllClass();
		
		List<Map<String, Object>> cl = new ArrayList<Map<String, Object>>();
		for(Class c : clist){
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("classname", c.getClassName());
			m.put("coursename", c.getCourse().getCourseName());
			m.put("classid", c.getClassId());
			cl.add(m);
		}
		
		map.put("class", cl);
		
		return map;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	private List<Object> selectWeek(int week, List<String> datelist){
		List<Object> list = new ArrayList<Object>();
		PeriodarrangeDAO pDAO = new PeriodarrangeDAO();
		//get the id of each class who is in period table
		
		int s = datelist.size();
		for(int i = 0; i < s; i++){
			//get each date's p list
			int[] intdate = this.dateutil.StringToIntlist(datelist.get(i));
			Date date = new Date(intdate[0] - 1900, intdate[1] -1, intdate[2]);
			
			List<Periodarrange> plist = pDAO.getListByProperty("periodarrangeStartDate", date);
			
			int l = plist.size();
			for(int j = 0; j < l; j++){
				int classid = plist.get(j).getclass().getClassId();
				ClassDAO cDAO = new ClassDAO();
				List<Class> clist = cDAO.getListByProperty("classId", classid);
				
				int courseid = clist.get(0).getCourse().getCourseId();
				CourseDAO courseDAO = new CourseDAO();
				List<Course> courselist = courseDAO.getListByProperty("courseId", courseid);
				
				String cname = courselist.get(0).getCourseName() + clist.get(0).getClassName();
				
				int[] tempdate = this.dateutil.StringToIntlist(this.dateutil.dateToString(plist.get(j).getPeriodarrangeStartDate()));
				int startday = this.dateutil.weekdayJudge(tempdate[0], tempdate[1], tempdate[2]) - 1;
				if(startday == 0){
					startday = 7;
				}
				
				tempdate = this.dateutil.StringToIntlist(this.dateutil.dateToString(plist.get(j).getPeriodarrangeEndDate()));
				int endday = this.dateutil.weekdayJudge(tempdate[0], tempdate[1], tempdate[2]) - 1;
				if(endday == 0){
					endday = 7;
				}
				
				int has = 0;
				int size = list.size();
				for(int z = 0; z < size; z++){
					Map<String, Object> map = (Map<String, Object>) list.get(z);
					
					if(map.get("class").equals(cname)){						
						((List<String>) ((Map<String, Object>) ((List<Object>) ((Map<String, Object>) list.get(z)).get("timelist")).get(0)).get("timelist")).addAll(this.dateutil.processDateToCTable(startday, plist.get(j).getPeriodarrangeStartTime(), endday, plist.get(j).getPeriodarrangeEndTime()));
						
						has = 1;
						break;
					}
				}
				
				if(has == 0){
					Map<String, Object> map = new HashMap<String, Object>();
					
					map.put("classid", classid);
					map.put("class", cname);
					
					List<Object> timelist = new ArrayList<Object>();
					
					Map<String, Object> mweek = new HashMap<String, Object>();
					mweek.put("weekNO", week);				
					mweek.put("timelist", this.dateutil.processDateToCTable(startday, plist.get(j).getPeriodarrangeStartTime(), endday, plist.get(j).getPeriodarrangeEndTime()));
					
					timelist.add(mweek);
					
					map.put("timelist", timelist);

					list.add(map);
				}
			}
		}
		
		
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private List<Object> defaultWeek(){
		PeriodarrangeWeekDAO pDAO = new PeriodarrangeWeekDAO();
		List<Object> dwlist = new ArrayList<Object>();
		
		//get the id of each class who is in period table
		String hql = "SELECT model from " + PeriodarrangeWeek.class.getName() + " as model group by model.periodarrangeWeekClassid";
		List<PeriodarrangeWeek> plist = pDAO.getListByHql(hql);
		
		int s = plist.size();
		
		for(int i = 0; i < s; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			
			//find class name
			ClassDAO cDAO = new ClassDAO();
			
			int classid = plist.get(i).getPeriodarrangeWeekClassid();
			List<Class> clist = cDAO.getListByProperty("classId", classid);
			
			int courseid = clist.get(0).getCourse().getCourseId();
			CourseDAO courseDAO = new CourseDAO();
			List<Course> courselist = courseDAO.getListByProperty("courseId", courseid);
			
			String cname = courselist.get(0).getCourseName() + clist.get(0).getClassName();
									
			//find class time
			
			List<PeriodarrangeWeek> pclist = pDAO.getListByProperty("periodarrangeWeekClassid", classid);
			
			int l = pclist.size();
			
			List<String> timelist = new ArrayList<String>();
			for(int j = 0; j < l; j++){
				timelist.addAll(this.dateutil.processDateToCTable(pclist.get(j).getPeriodarrangeWeekStartDay(), pclist.get(j).getPeriodarrangeWeekStartTime(), pclist.get(j).getPeriodarrangeWeekEndDay(), pclist.get(j).getPeriodarrangeWeekEndTime()));
			}
			
			map.put("class", cname);
			map.put("timelist", timelist);
			
			dwlist.add(map);
		}
		
		defaultWeekInfo();
		
		return dwlist;
	}

	/**
	 * get all period arrangement, and change date to weekday + the number of week
	 * @return a list of all class period arrangement, and in format of "class-weekday-time"; list of map, the map key is class name, and the map value is list of this class time management
	 */
	private List<Object> defaultWeekInfo(){
		List<Object> dwlist = new ArrayList<Object>();
		PeriodArrangeCDAO pDAO = new PeriodArrangeCDAO();

		dwlist.addAll(pDAO.getDefaultWeekInfo());
		
		System.out.println("dwlist size : " + dwlist.size());
		return dwlist;
	}
}
