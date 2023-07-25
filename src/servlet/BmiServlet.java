package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bmi;
import bean.User;
import model.AddBmi;
import model.BmiLogic;
import model.GetBmiesLogic;

/**
 * Servlet implementation class BmiServlet
 */
@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BmiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String errorMsg = "";
		int height = 0;
		int weight = 0;
		try {
			height = Integer.parseInt(request.getParameter("height"));
			weight = Integer.parseInt(request.getParameter("weight"));
		} catch (NumberFormatException e) {
			errorMsg = "身長、体重に正しい値を入力してください";
			request.setAttribute("errorMsg", errorMsg.toString());
			request.getRequestDispatcher("WEB-INF/jsp/bmi.jsp").forward(request, response);
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String day = sdf.format(new Date());

		BmiLogic logic = new BmiLogic();
		double bmi = logic.calculation(height, weight);
		String msg = logic.chack(bmi);

		GetBmiesLogic getBmiesLogic = new GetBmiesLogic();
		Bmi bmiDate = getBmiesLogic.execute();

		Bmi target = new Bmi(day, height, weight);

		User user = (User) session.getAttribute("user");
		new AddBmi().addSort(bmiDate, target, user);

	}

}
