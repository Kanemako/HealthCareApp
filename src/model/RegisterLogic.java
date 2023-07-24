package model;

import java.util.ArrayList;

import bean.User;

public class RegisterLogic {
	public boolean check(String name, ArrayList<User> userList) {
		System.out.println(userList);
		for (User target : userList) {
			if (name.equals(target.getName())) {
				System.out.println("ok");
				return true;
			}
		}
		return false;

	}

}
