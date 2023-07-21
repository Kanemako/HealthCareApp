package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Todo;
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
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Todo> todoList = (ArrayList<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			// 取得できなかった場合は新規作成
			todoList = new ArrayList<Todo>();
		}

		// 処理
		new TodoModel().remove(todoList, index);

		// リスト格納
		session.setAttribute("todoList", todoList);

		response.sendRedirect("TodoServlet");
		return;
	}

}
