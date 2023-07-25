package model;

import bean.Bmi;
import dao.BmiDAO;

public class AddBmi {
	public void addSort(Bmi bmiDate, Bmi target) {
		BmiDAO dao = new BmiDAO();
		if (bmiDate.getDay().equals(target.getDay())) {
			dao.update(target);
		} else {
			dao.create(target);
		}
	}

}
