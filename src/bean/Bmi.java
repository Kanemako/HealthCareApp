package bean;

public class Bmi {
	private int height, weight;
	private String name, day, Msg;
	private double bmi;

	public Bmi() {
	}

	public Bmi(String day, int height, int weight, double bmi, String Msg) {
		this.day = day;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.Msg = Msg;
	}

	public Bmi(String name, String day, int height, int weight, double bmi, String Msg) {
		this.name = name;
		this.day = day;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.Msg = Msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

}
