package model;

import java.util.ArrayList;

import bean.Todo;
import bean.User;
import dao.TodoDAO;

public class GetTodoListLogic {
	/*
	 * todolistテーブルから全てのデータを摘出
	 */
	public ArrayList<Todo> execute(User user) {
		TodoDAO dao = new TodoDAO();
		ArrayList<Todo> todoList = dao.findAll(user);
		return todoList;
	}

}
