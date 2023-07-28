package model;

import java.util.ArrayList;

import bean.Bmi;
import dao.BmiDAO;

public class AddBmi {
	/*
	 * BMIテーブルに値を追加
	 * もし同じ日のデータがある場合、上書き更新
	 */
	public void addSort(Bmi bmiDate, Bmi target, ArrayList<Bmi> bmiList) {
		BmiDAO dao = new BmiDAO();
		if (bmiDate.getDay().equals(target.getDay())) {
			System.out.println("ok");
			dao.update(target);
			bmiList.remove(0);
			bmiList.add(0, target);
		} else {
			System.out.println("ng");
			dao.create(target);
			bmiList.add(0, target);
		}
	}

}
