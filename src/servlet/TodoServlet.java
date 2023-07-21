package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Todo画面を制御するServlet
 * 本Servletの実行にはログインを必要とする
 */
@WebServlet("/TodoServlet")
public class TodoServlet extends LoginCheckServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp").forward(request, response);
	}

}
