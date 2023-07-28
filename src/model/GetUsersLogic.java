package model;

import java.util.List;

import bean.User;
import dao.UsersDAO;

/*
 * userdataテーブルから全てデータを摘出
 */
public class GetUsersLogic {
	public List<User> execute() {
		UsersDAO dao = new UsersDAO();
		List<User> userList = dao.findAll();
		return userList;
	}

}
