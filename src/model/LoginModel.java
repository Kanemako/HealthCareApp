package model;

import bean.User;

/**
 * ログイン認証を実行するクラス
 */
public class LoginModel {

	/**
	 * ユーザ情報でログイン認証を行う
	 * @param name ユーザ名
	 * @param pass パスワード
	 * @return true:認証成功, false:認証失敗
	 */
	public boolean auth(User user) {
		// FIXME 固定パスワードで暫定実装中
		if (user.getPass().equals("1234")) {
			// 認証成功
			return true;
		} else {
			// 認証失敗
			return false;
		}
	}

}