package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bmi;
import bean.User;
import dao.BmiDAO;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//bmiのデータ入手
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Bmi> bmiList = new BmiDAO().findAll(user);

		if (bmiList == null || bmiList.size() <= 0) {
			bmiList = new ArrayList<>();
		}
		request.setAttribute("bmiList", bmiList);
		request.getRequestDispatcher("WEB-INF/jsp/bmi.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

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
		ArrayList<Bmi> bmiList = getBmiesLogic.execute(user);
		Bmi bmiDate = new Bmi(user.getName(), "", 1, 1, 1, "");

		if (bmiList == null || bmiList.size() <= 0) {
			bmiList = new ArrayList<>();
		} else {
			System.out.println("BMILIST false");
			bmiDate = bmiList.get(0);
		}

		System.out.println(day + height + weight + bmi + msg);
		Bmi target = new Bmi(user.getName(), day, height, weight, bmi, msg);

		new AddBmi().addSort(bmiDate, target, bmiList);

		request.setAttribute("errorMsg", errorMsg);
		request.setAttribute("bmiList", bmiList);
		request.getRequestDispatcher("WEB-INF/jsp/bmi.jsp").forward(request, response);

	}

}
