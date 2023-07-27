package model;

import java.util.ArrayList;

import bean.Todo;
import bean.User;
import dao.TodoDAO;

/**
 * Todoデータ操作を実行するクラス
 */
public class TodoModel {

	/**
	 * 1件分のデータを登録する
	 * @param todo 追加するTodo情報
	 * @param user 
	 */
	public void regist(Todo todo, User user) {
		// データ追加
		new TodoDAO().create(todo, user);
	}

	/**
	 * 1件分のデータを更新する
	 * @param todo 更新するTodo情報
	 */
	public void update(Todo todo) {
		// 変更後データで更新
		new TodoDAO().update(todo);

	}

	/**
	 * 1件分のデータを削除する
	 * @param todoList Todoリスト（結果は直接設定される）
	 * @param index 削除する添字
	 */
	public void remove(ArrayList<Todo> todoList, int index) {
		// データ削除
		new TodoDAO().delete(todoList.get(index));

	}

}
