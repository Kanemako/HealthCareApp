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
 * Todoの登録機能を制御するServlet
 * 本Servletの実行にはログインを必要とする
 */
@WebServlet("/TodoRegistServlet")
public class TodoRegistServlet extends LoginCheckServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメータ取得
		String important = request.getParameter("important");
		String info = request.getParameter("info");
		String deadline = request.getParameter("deadline");

		// パラメータチェック
		StringBuilder errorMsg = new StringBuilder();
		if (important == null || important.length() == 0) {
			errorMsg.append("重要度が入力されていません<br>");
		}
		if (info == null || info.length() == 0) {
			errorMsg.append("内容が入力されていません<br>");
		}
		if (deadline == null || deadline.length() == 0) {
			errorMsg.append("期日が入力されていません<br>");
		}
		if (errorMsg.length() > 0) {
			// エラー発生
			request.setAttribute("errorMsg", errorMsg);

			request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp").forward(request, response);
			return;
		}

		// リスト取得
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Todo> todoList = (ArrayList<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			// 取得できなかった場合は新規作成
			todoList = new ArrayList<Todo>();
		}

		// 処理
		Todo todo = new Todo(Integer.parseInt(important), info, deadline);
		new TodoModel().regist(todoList, todo);

		// リスト格納
		session.setAttribute("todoList", todoList);

		response.sendRedirect("TodoServlet");
		return;
	}

}
