package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Todo;

/**
 * メイン画面を制御するServlet
 * 本Servletの実行にはログインを必要とする
 */
@WebServlet("/MainServlet")
public class MainServlet extends LoginCheckServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 表示用のTODO情報を取得する
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Todo> todoList = (ArrayList<Todo>) session.getAttribute("todoList");
		if (todoList != null && todoList.size() > 0) {
			// 先頭1件を取得する
			request.setAttribute("todoTopic", todoList.get(0));
		}

		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
	}

}