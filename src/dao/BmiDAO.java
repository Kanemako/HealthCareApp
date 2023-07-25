package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Bmi;

public class BmiDAO {
	private static final String URL = "jdbc:postgresql://192.168.56.101:5501/appdb";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";//各自のパスワードに変更

	public Bmi findAll() {
		Bmi bmiDate = new Bmi();

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		// SELECT文を準備
		String sql = "SELECT NAME,DAY,HEIGHT,WEIGHT FROM BMI WHERE NAME = ? ORDER BY NAME, DAY";
		// データベースに接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				pStmt.setString(1,user.getName());
				// SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery()) {

			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String name = rs.getString("NAME");
				String day = rs.getString("DAY");
				int height = rs.getInt("HEIGHT");
				int weight = rs.getInt("WEIGHT");
				bmiDate = new Bmi(name, day, height, weight);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bmiDate;
	}

	public boolean create(Bmi bmi) {

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO USERDATE(NAME, PASS, GENDER, BIRTHDAY, AGE) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println("デバック：" + bmi.getName());
			pStmt.setString(1, bmi.getName());
			pStmt.setString(2, bmi.getDay());
			pStmt.setInt(3, bmi.getHeight());
			pStmt.setInt(4, bmi.getWeight());

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

	public void update(Bmi bmiDate) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
