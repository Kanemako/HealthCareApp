package model;

import java.util.List;

import bean.User;
import dao.UsersDAO;

public class GetUsersLogic {
	public List<User> execute() {
		UsersDAO dao = new UsersDAO();
		List<User> todoList = dao.findAll();
		return todoList;
	}

}