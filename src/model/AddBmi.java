package model;

import java.util.ArrayList;

import bean.Bmi;
import dao.BmiDAO;

public class AddBmi {
	public void addSort(Bmi bmiDate, Bmi target, ArrayList<Bmi> bmiList) {
		BmiDAO dao = new BmiDAO();
		if (bmiDate.getDay().equals(target.getDay())) {
			dao.update(target);
			bmiList.add(0, target);
		} else {
			dao.create(target);
			bmiList.remove(0);
			bmiList.add(0, target);
		}
	}

}
