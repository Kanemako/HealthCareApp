package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Bmi;
import bean.User;
import model.BmiLogic;

public class BmiDAO {
	private static final String URL = "jdbc:postgresql://192.168.56.101:5501/appdb";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";//各自のパスワードに変更

	public ArrayList<Bmi> findAll(User user) {
		ArrayList<Bmi> bmiList = new ArrayList<>();

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		// SELECT文を準備
		String sql = "SELECT DAY,HEIGHT,WEIGHT,MSG FROM BMI WHERE NAME = ? ORDER BY NAME, DAY DESC";
		// データベースに接続
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String day = rs.getString("DAY");
				int height = rs.getInt("HEIGHT");
				int weight = rs.getInt("WEIGHT");
				String msg = rs.getString("MSG");

				Bmi bmiDate = new Bmi(day, height, weight, new BmiLogic().calculation(height, weight), msg);
				bmiList.add(bmiDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bmiList;
	}

	public boolean create(Bmi bmi) {

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO BMI(NAME, DAY, HEIGHT, WEIGHT, MSG) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println("デバック：" + bmi.getName());
			pStmt.setString(1, bmi.getName());
			pStmt.setString(2, bmi.getDay());
			pStmt.setInt(3, bmi.getHeight());
			pStmt.setInt(4, bmi.getWeight());
			pStmt.setString(5, bmi.getMsg());

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
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "UPDATE BMI SET(HEIGHT, WEIGHT, MSG) = (?, ?, ?) WHERE NAME = ? AND DAY = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, bmiDate.getHeight());
			pStmt.setInt(2, bmiDate.getWeight());
			pStmt.setString(3, bmiDate.getMsg());
			pStmt.setString(4, bmiDate.getName());
			pStmt.setString(5, bmiDate.getDay());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		return;

	}
}
