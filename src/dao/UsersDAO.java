package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UsersDAO {
	private static final String URL = "jdbc:postgresql://192.168.56.101:5501/appdb";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";//各自のパスワードに変更

	public List<User> findAll() {
		List<User> Users = new ArrayList<>();

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		// SELECT文を準備
		String sql = "SELECT NAME,PASS,GENDER,BIRTHDAY,AGE FROM USERDATE ORDER BY NAME ASC";
		// データベースに接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery()) {

			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String gender = rs.getString("GENDER");
				String birthday = rs.getString("BIRTHDAY");
				int age = rs.getInt("AGE");
				User user = new User(name, pass, gender, birthday, age);
				Users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return Users;
	}

	public boolean create(User user) {

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO USERDATE(NAME, PASS, GENDER, BIRTHDAY, AGE) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println("デバック：" + user.getAge());
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getGender());
			pStmt.setString(4, user.getBirthday());
			pStmt.setInt(5, user.getAge());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
