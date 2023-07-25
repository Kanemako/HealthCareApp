package model;

import bean.Bmi;
import dao.BmiDAO;

public class GetBmiesLogic {
	public Bmi execute() {
		BmiDAO dao = new BmiDAO();
		Bmi bmiDate = dao.findAll();
		return bmiDate;
	}

}
