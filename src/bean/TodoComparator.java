package bean;

import java.util.Comparator;

/**
 * ArrayList<Todo>用並び替え処理クラス
 */
public class TodoComparator implements Comparator<Todo> {

	@Override
	public int compare(Todo t1, Todo t2) {
		return t1.getImportant() > t2.getImportant() ? -1 : 1;
	}

}
