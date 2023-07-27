package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bmi;
import bean.Todo;
import bean.User;
import dao.BmiDAO;
import dao.TodoDAO;

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
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Todo> todoList = new TodoDAO().findAll(user);
		if (todoList != null && todoList.size() > 0) {
			// 先頭1件を取得する
			request.setAttribute("todoTopic", todoList.get(0));
		}

		ArrayList<Bmi> bmiList = new BmiDAO().findAll(user);
		ArrayList<Bmi> bmiTopic = new ArrayList<>();
		if (bmiList != null && bmiList.size() > 0) {
			for (int i = 0; i < 3; i++) {
				bmiTopic.add(bmiList.get(i));
				if (bmiList.size() == i + 1) {
					break;
				}
			}

		}
		request.setAttribute("bmiTopic", bmiTopic);

		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
	}

}