package model;

import java.util.ArrayList;

import bean.User;

/**
 * ログイン認証を実行するクラス
 */
public class LoginModel {

	/**
	 * ユーザ情報でログイン認証を行う
	 * @param userList 
	 * @param name ユーザ名
	 * @param pass パスワード
	 * @return true:認証成功, false:認証失敗
	 */
	public User auth(User user, ArrayList<User> userList) {
		// FIXME 固定パスワードで暫定実装中
		for (User target : userList) {
			if (user.getName().equals(target.getName())) {
				if (user.getPass().equals(target.getPass())) {
					// 認証成功
					return target;
				} else {
					// 認証失敗
					return null;
				}
			}
		}
		return null;

	}

}