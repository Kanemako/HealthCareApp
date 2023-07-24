package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import model.AddUser;
import model.GetUsersLogic;
import model.RegisterLogic;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		int age;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			age = -1;
		}

		GetUsersLogic getUsersLogic = new GetUsersLogic();
		ArrayList<User> userList = (ArrayList<User>) getUsersLogic.execute();

		String errorMsg = "";

		if (userList == null || userList.size() == 0) {
			userList = new ArrayList<User>();
		}
		RegisterLogic logic = new RegisterLogic();

		if (name == null || name.length() <= 0) {
			errorMsg += "ユーザ名を設定してください。<br>";
		}

		if (pass1.length() < 8) {
			errorMsg += "パスワードを 8 文字以上で設定してください。<br>";
		} else if (!(pass1.equals(pass2))) {
			errorMsg += "パスワードが一致しませんでした。もう一度お試しください。<br>";
		}

		if (age < 0) {
			errorMsg += "年齢を設定してください。<br>";
		}

		if (logic.check(name, userList)) {
			errorMsg = "そのユーザ名は使われています。<br>";
		}
		RequestDispatcher dispatcher;

		System.out.println("デバック：" + errorMsg);

		if (errorMsg.length() == 0) {
			User user = new User(name, pass1, gender, birthday, age);
			new AddUser().addSort(user, userList);
			dispatcher = request.getRequestDispatcher("login.jsp");
		} else {
			request.setAttribute("registerErrorMsg", errorMsg);
			dispatcher = request.getRequestDispatcher("register.jsp");
		}
		dispatcher.forward(request, response);

	}

}
