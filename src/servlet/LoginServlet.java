package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Todo;
import bean.User;
import model.GetUsersLogic;
import model.LoginModel;
import model.TodoModel;

/**
 * ログイン処理を実行するServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメータ取得
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		// パラメータチェック
		StringBuilder errorMsg = new StringBuilder();
		if (name == null || name.length() <= 0) {
			errorMsg.append("ユーザー名が入力されていません<br>");
		}
		if (pass == null || pass.length() == 0) {
			errorMsg.append("パスワードが入力されていません<br>");
		}
		if (errorMsg.length() > 0) {
			// エラー
			request.setAttribute("errorMsg", errorMsg.toString());

			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// 処理
		GetUsersLogic getUsersLogic = new GetUsersLogic();
		ArrayList<User> userList = (ArrayList<User>) getUsersLogic.execute();

		System.out.println(userList);
		if (userList == null || userList.size() <= 0) {
			userList = new ArrayList<>();
		}

		User user = new User(name, pass);
		user = new LoginModel().auth(user, userList);

		// 結果
		if (user != null) {
			// 認証成功
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// FIXME テスト用に仮のTODOデータを作成
			ArrayList<Todo> todoList = new ArrayList<Todo>();
			new TodoModel().regist(todoList, new Todo(3, "OOPやる", "2021-07-21"));
			new TodoModel().regist(todoList, new Todo(5, "WAC1やる", "2021-07-28"));
			new TodoModel().regist(todoList, new Todo(4, "WAC2やる", "2021-10-20"));
			session.setAttribute("todoList", todoList);

			response.sendRedirect("MainServlet");
			return;
		} else {
			// 認証失敗
			request.setAttribute("errorMsg", "ユーザー名または、パスワードに誤りがあります。<br>");

			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

}