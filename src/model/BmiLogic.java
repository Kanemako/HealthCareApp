package model;

public class BmiLogic {
	/*
	 * bmiの算出
	 */
	public double calculation(int height, int weight) {
		double hei = ((double) height * height) / 10000;
		double bmi = weight / hei;
		bmi = Math.floor(bmi * 100);
		return bmi / 100;

	}

	/*
	 * bmiの判定
	 */
	public String chack(double bmi) {
		if (bmi < 16) {
			return "痩せすぎ";
		}
		if (bmi < 17) {
			return "痩せ";
		}
		if (bmi < 18.5) {
			return "痩せぎみ";
		}
		if (bmi < 25) {
			return "普通体重";
		}
		if (bmi < 30) {
			return "前肥満";
		}
		if (bmi < 35) {
			return "肥満(1度)";
		}
		if (bmi < 40) {
			return "肥満(2度)";
		} else {
			return "肥満(3度)";
		}

	}

}
