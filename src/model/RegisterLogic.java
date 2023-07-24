package model;

import java.util.ArrayList;

import bean.User;

public class RegisterLogic {
	public boolean check(String name, ArrayList<User> userList) {
		for (User target : userList) {
			if (name.equals(target.getName())) {
				return true;
			}
		}
		return false;

	}

}
