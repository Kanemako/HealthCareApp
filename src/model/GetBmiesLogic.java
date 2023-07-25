package model;

import bean.Bmi;
import bean.User;
import dao.BmiDAO;

public class GetBmiesLogic {
	public Bmi execute(User user) {
		BmiDAO dao = new BmiDAO();
		Bmi bmiDate = dao.findAll(user);
		return bmiDate;
	}

}
