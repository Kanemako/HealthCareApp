package model;

import java.util.ArrayList;

import bean.User;

public class RegisterLogic {
	/*
	 * ユーザ名が被ってないか
	 */
	public boolean check(String name, ArrayList<User> userList) {
		System.out.println(userList);
		for (User target : userList) {
			if (name.equals(target.getName())) {
				return true;
			}
		}
		return false;

	}

}
