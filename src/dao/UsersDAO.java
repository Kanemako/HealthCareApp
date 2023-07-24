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
		String sql = "SELECT ID,NAME,PASS,MAIL,AGE FROM USERS ORDER BY ID ASC";
		// データベースに接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery()) {

			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String age = rs.getString("AGE");
				User user = new User(id, name, pass, mail, age);
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
			String sql = "INSERT INTO USERS(NAME, PASS, MAIL, AGE) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getAge());

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
