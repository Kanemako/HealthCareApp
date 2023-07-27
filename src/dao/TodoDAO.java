package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Todo;
import bean.User;

public class TodoDAO {
	private static final String URL = "jdbc:postgresql://192.168.56.101:5501/appdb";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";//各自のパスワードに変更

	public ArrayList<Todo> findAll(User user) {
		ArrayList<Todo> todoList = new ArrayList<>();

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		// SELECT文を準備
		String sql = "SELECT IMPORTANT,INFO,DEADLINE,MOMENTUM FROM TODOLIST WHERE NAME = ? ORDER BY IMPORTANT DESC,DEADLINE ASC";
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
				int id = rs.getInt("ID");
				int important = rs.getInt("IMPORTANT");
				String info = rs.getString("INFO");
				String deadline = rs.getString("DEADLINE");
				String momentum = rs.getString("MOMENTM");
				Todo todo = new Todo(id, important, info, deadline, momentum);
				todoList.add(todo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return todoList;
	}

	public boolean create(Todo todo, User user) {

		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"ドライバを読み込めませんでした");
		//		}

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO TODOLIST(NAME, IMPORTANT, INFO, DEADLINE, MOMENTUM) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println("デバック：" + todo.getDeadline());
			pStmt.setString(1, user.getName());
			pStmt.setInt(2, todo.getImportant());
			pStmt.setString(3, todo.getInfo());
			pStmt.setString(4, todo.getDeadline());
			pStmt.setString(5, todo.getMomentum());

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

	public void update(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "UPDATE BMI SET(IMPORTANT, INFO, DEADLINE, MOMENTUM) = (?, ?, ?, ?) WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, todo.getImportant());
			pStmt.setString(2, todo.getInfo());
			pStmt.setString(3, todo.getDeadline());
			pStmt.setInt(4, todo.getId());

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

	public boolean delete(Todo todo) {

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "DELETE FROM TODOLIST WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, todo.getId());

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
