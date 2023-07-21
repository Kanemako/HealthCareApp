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
 * Todoの更新機能を制御するServlet
 * 本Servletの実行にはログインを必要とする
 */
@WebServlet("/TodoUpdateServlet")
public class TodoUpdateServlet extends LoginCheckServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメータ取得
		int index = Integer.parseInt(request.getParameter("index"));
		String important = request.getParameter("important");
		String info = request.getParameter("info");
		String deadline = request.getParameter("deadline");

		// リスト取得
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Todo> todoList = (ArrayList<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			// 取得できなかった場合は新規作成
			todoList = new ArrayList<Todo>();
		}

		// 変更前のデータを取得
		Todo todo = todoList.get(index);
		// 値更新チェック
		if (important != null && important.length() != 0) {
			todo.setImportant(Integer.parseInt(important));
		}
		if (info != null && info.length() != 0) {
			todo.setInfo(info);
		}
		if (deadline != null && deadline.length() != 0) {
			todo.setDeadline(deadline);
		}

		// 処理
		new TodoModel().update(todoList, todo, index);

		// リスト格納
		session.setAttribute("todoList", todoList);

		response.sendRedirect("TodoServlet");
		return;
	}

}
