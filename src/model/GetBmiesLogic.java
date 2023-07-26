package model;

import java.util.ArrayList;

import bean.Bmi;
import bean.User;
import dao.BmiDAO;

public class GetBmiesLogic {
	public ArrayList<Bmi> execute(User user) {
		BmiDAO dao = new BmiDAO();
		ArrayList<Bmi> bmiList = dao.findAll(user);
		return bmiList;
	}

}
