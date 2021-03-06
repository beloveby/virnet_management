package virnet.management.information.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import virnet.management.combinedao.ClassInfoCDAO;
import virnet.management.combinedao.GroupInfoCDAO;
import virnet.management.combinedao.StudentInfoCDAO;
import virnet.management.entity.Class;
import virnet.management.entity.Classgroup;
import virnet.management.util.UserInfoProcessUtil;

public class MyGroup implements InformationQuery {

	private StudentInfoCDAO sDAO = new StudentInfoCDAO();
	private ClassInfoCDAO cDAO = new ClassInfoCDAO();
	private GroupInfoCDAO gDAO = new GroupInfoCDAO();
	
	private UserInfoProcessUtil usercheck = new UserInfoProcessUtil();
	
	@SuppressWarnings("unchecked")
	@Override
	/*
	 * (non-Javadoc)
	 * @see virnet.management.information.service.InformationQuery#query(java.lang.String, int, java.lang.String)
	 * @return map
	 * button_new
	 * select
	 * data --- rough information, show in table
	 * detail --- specific information about class, group, experiment, and so on.
	 * button_switch --- a special one for time management, for now.
	 * 
	 */
	public Map<String, Object> query(String user, int page, String select) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		
		int userid = this.usercheck.checkUsername(user);
		
		List<Class> clist = this.sDAO.getMyClass(userid);
		
		int size = clist.size();
		List<Object> selectlist = new ArrayList<Object>();
		for(int i = 0; i < size; i++){
			Map<String, Object> cmap = new HashMap<String, Object>();
			
			int classid = clist.get(i).getClassId();
			cmap.put("id", classid);
			
			cmap.put("class", this.cDAO.getClassName(classid));
			selectlist.add(cmap);
		}
		
		//get the request class id
		int s = selectlist.size();
		int classid;
		if(s == 0){
			//list is null
			classid = -1;
		}
		else{
			classid = (int) ((Map<String, Object>) selectlist.get(0)).get("id");
		}
		
		for(int i = 0; i < s; i++){
			if(select.equals(((Map<String, Object>) selectlist.get(i)).get("class"))){
				classid = (int) ((Map<String, Object>) selectlist.get(i)).get("id");
			}
		}
		
		//group list
		List<List<Map<String, Object>>> list = new ArrayList<List<Map<String, Object>>>();
		
		List<Map<String, Object>> head = new ArrayList<Map<String, Object>>();
		Map<String, Object> head_id = new HashMap<String, Object>();
		head_id.put("name", "小组编号");
		head_id.put("class", "");
		head.add(head_id);
		
		Map<String, Object> head_name = new HashMap<String, Object>();
		head_name.put("name", "小组名称");
		head_name.put("class", "");
		head.add(head_name);
		
		Map<String, Object> head_member = new HashMap<String, Object>();
		head_member.put("name", "小组成员");
		head_member.put("class", "");
		head.add(head_member);
		
		list.add(head);
		
		Classgroup g = this.gDAO.getGroupOfStuInClass(userid, classid);
		
		if(g != null){
			List<Map<String, Object>> gInfo = new ArrayList<Map<String, Object>>();
			Map<String, Object> g_id = new HashMap<String, Object>();
			g_id.put("name", g.getClassgroupId());
			g_id.put("class", "");
			gInfo.add(g_id);
			
			Map<String, Object> g_name = new HashMap<String, Object>();
			g_name.put("name", g.getClassgroupName());
			g_name.put("class", "btn btn-link");
			g_name.put("onclick", "showDetail('" + g.getClassgroupName() + "', 'group');");
			gInfo.add(g_name);
			
			Map<String, Object> g_member = new HashMap<String, Object>();
			g_member.put("name", this.gDAO.getGroupMember(g.getClassgroupId()));
			g_member.put("class", "collapse");
			gInfo.add(g_member);
			
			list.add(gInfo);
		}
		
		//detail is still required;
		
		map.put("select", selectlist);
		map.put("data", list);
		map.put("page", 1);
		
		return map;
	}

}
