package model;

import java.util.ArrayList;

import bean.User;
import dao.UsersDAO;

public class AddUser {
	/*
	 * Userdateテーブルに値を追加
	 */
	public void addSort(User user, ArrayList<User> userList) {
		UsersDAO dao = new UsersDAO();
		dao.create(user);
	}

}
