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
import model.TodoModel;

/**
 * Todoの削除機能を制御するServlet
 * 本Servletの実行にはログインを必要とする
 */
@WebServlet("/TodoRemoveServlet")
public class TodoRemoveServlet extends LoginCheckServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメータ取得
		int index = Integer.parseInt(request.getParameter("index"));

		// リスト取得
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Todo> todoList = new TodoDAO().findAll(user);
		if (todoList == null) {
			// 取得できなかった場合は新規作成
			todoList = new ArrayList<Todo>();
		}

		// 処理
		new TodoModel().remove(todoList, index);

		response.sendRedirect("TodoServlet");
		return;
	}

}
