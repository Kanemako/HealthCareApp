package model;

import java.util.ArrayList;
import java.util.Collections;

import bean.Todo;
import bean.TodoComparator;

/**
 * Todoデータ操作を実行するクラス
 */
public class TodoModel {

	/**
	 * 1件分のデータを登録する
	 * @param todoList Todoリスト（結果は直接設定される）
	 * @param todo 追加するTodo情報
	 */
	public void regist(ArrayList<Todo> todoList, Todo todo) {
		// データ追加
		todoList.add(todo);

		// リストの並び替え
		Collections.sort(todoList, new TodoComparator());
	}

	/**
	 * 1件分のデータを更新する
	 * @param todoList Todoリスト（結果は直接設定される）
	 * @param todo 更新するTodo情報
	 * @param index 更新する添字
	 */
	public void update(ArrayList<Todo> todoList, Todo todo, int index) {
		// 変更後データで更新
		todoList.set(index, todo);

		// リストの並び替え
		Collections.sort(todoList, new TodoComparator());
	}

	/**
	 * 1件分のデータを削除する
	 * @param todoList Todoリスト（結果は直接設定される）
	 * @param index 削除する添字
	 */
	public void remove(ArrayList<Todo> todoList, int index) {
		// データ削除
		todoList.remove(index);

		// リストの並び替え
		Collections.sort(todoList, new TodoComparator());
	}

}
