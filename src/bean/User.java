package bean;

import java.io.Serializable;

/**
 * ユーザ情報を管理するBean
 */
public class User implements Serializable {

	private int age;
	private String name, pass, gender, birthday;

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public User(String name, String pass, String gender, String birthday, int age) {
		this.pass = pass;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}