package virnet.management.information.service;

import java.util.HashMap;
import java.util.Map;

import virnet.management.combinedao.ClassInfoCDAO;
import virnet.management.combinedao.CourseInfoCDAO;
import virnet.management.combinedao.ExpInfoCDAO;
import virnet.management.combinedao.GroupInfoCDAO;

public class InformationService {
	
	private InformationQuery query;
	private ExpInfoCDAO eDAO = new ExpInfoCDAO();
	@SuppressWarnings("unused")
	private GroupInfoCDAO gDAO = new GroupInfoCDAO();
	private CourseInfoCDAO cDAO = new CourseInfoCDAO();
	private ClassInfoCDAO classDAO = new ClassInfoCDAO();

	
	public Map<String, Object> loadInfo(String user, String id, int page, String select){
		Map<String, Object> list = new HashMap<String, Object>();
		
		switch(id){
		case "exp-management": query = new ExpManagement(); break;
		case "course-management": query = new CourseManagement(); break;
		case "class-management": query = new ClassManagement(); break;
		case "time-management": query = new TimeManagement(); break;
		case "exp-staff": query = new ExpStaff(); break;
		case "teacher": query = new Teacher(); break;
		case "student": query = new Student(); break;
		case "class-detail": query = new ClassDetail(); break;
		case "group": query = new Group(); break;
		case "exp-arrangement": query = new ExpArrangement(); break;
		case "my-class": query = new MyClass(); break;
		case "my-group": query = new MyGroup(); break;
		case "my-exp": query = new MyExp(); break;
		case "enter-exp": query = new EnterExp(); break;
		default: break;
		}
		
		list = query.query(user, page, select);
		return list;
	}

	public Map<String, Object> showDetail(String user, String id, String key, String name){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//Divided by key : user, experiment, course, class, group
		switch(key){
		case "user" : break;
		case "exp" : map = this.eDAO.showExpDetail(id, name); break;
		case "course" : map = this.cDAO.showCourseDetail(id, name); break;
		case "class" : map = this.classDAO.showClassDetail(id, name); break;
		case "group" : break;
		default : break;
		}
	
		return map;
	}

	public Map<String, Object> Edit(String user, String id, String name){
		Map<String, Object> map = new HashMap<String, Object>();
		
		switch(id){
		case "exp-management" : map = this.eDAO.Edit(name); break;
		case "course-management" : map = this.cDAO.Edit(name); break;
		case "class-management" : map = this.classDAO.Edit(name); break;
		case "time-management" : 
		}
		
		return map;
	}
	
	public Map<String, Object> add(String user, String id){
		Map<String, Object> map = new HashMap<String, Object>();
		
		switch(id){
		case "exp-management" : map = this.eDAO.Add(); break;
		case "course-management" : map = this.cDAO.Add(); break;
		case "class-management" :
		case "time-management" : 
		}
		
		return map;
	}
	
	public Map<String, Object> submit(String user, String id, String name, Map<String, Object> map){
		Map<String, Object> r;
		switch(id){
		case "exp-management" : r = this.eDAO.save(name, map); break;
		case "course-management" : r = this.cDAO.save(name, map);break;
		default : r = null;
		}
		
		return r;
	}
}
