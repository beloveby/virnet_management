package virnet.management.combinedao;

import virnet.management.dao.UserDAO;
import virnet.management.entity.User;

public class UserInfoCDAO {
	private UserDAO uDAO = new UserDAO();
	
	public String getUserName(int userid){
		User u = this.uDAO.getUniqueByProperty("userId", userid);

		return u.getUserNickname();
	}
	
	public User getUser(int userid){
		User u = this.uDAO.getUniqueByProperty("userId", userid);

		return u;
	}
}
