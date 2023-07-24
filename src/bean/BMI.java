package bean;

public class BMI {
	private int userId, height, weight;
	private double bmi;
	private String date;

	public BMI() {
	}

	public BMI(int height, int weight, double bmi) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}

	public BMI(int id, int height, int weight, double bmi) {
		this.userId = id;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
