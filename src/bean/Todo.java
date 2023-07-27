package bean;

import java.io.Serializable;

/**
 * Todo情報を管理するBean
 */
public class Todo implements Serializable {

	/**ID*/
	private int id;
	/** 重要度 */
	private int important;
	/** メニュー */
	private String info;
	/** 予定 */
	private String deadline;
	/**目標運動量*/
	private String momentum;

	public Todo() {
	}

	public Todo(int important, String info, String deadline, String momentum) {
		this.important = important;
		this.info = info;
		this.deadline = deadline;
		this.momentum = momentum;
	}

	public Todo(int id, int important, String info, String deadline, String momentum) {
		this.id = id;
		this.important = important;
		this.info = info;
		this.deadline = deadline;
		this.momentum = momentum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImportant() {
		return important;
	}

	public void setImportant(int important) {
		this.important = important;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getMomentum() {
		return momentum;
	}

	public void setMomentum(String momentum) {
		this.momentum = momentum;
	}

}
