package model;

import bean.Bmi;
import bean.User;
import dao.BmiDAO;

public class AddBmi {
	public void addSort(Bmi bmiDate, Bmi target, User user) {
		BmiDAO dao = new BmiDAO();
		if (bmiDate.getDay().equals(target.getDay())) {
			dao.update(target);
		} else {
			dao.create(target);
		}
	}

}
