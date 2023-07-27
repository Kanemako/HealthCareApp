package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Todo;
import bean.User;
import dao.TodoDAO;

/**
 * Todo画面を制御するServlet
 * 本Servletの実行にはログインを必要とする
 */
@WebServlet("/TodoServlet")
public class TodoServlet extends LoginCheckServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Todo> todoList = new TodoDAO().findAll(user);
		request.setAttribute("todoList", todoList);
		request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp").forward(request, response);
	}

}
