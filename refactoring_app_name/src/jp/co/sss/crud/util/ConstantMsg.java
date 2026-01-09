package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(表示メッセージ関連)
 *
 * @author 角田 智哉
 *
 */
public class ConstantMsg {

	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	// ***** 定型メッセージ *****

	/** 検索の結果、該当社員なしの場合に表示するメッセージ */
	public static final String EMPLOYEE_NOT_FOUND = "該当者はいませんでした";
	/** 社員情報の登録を実施した場合に表示するメッセージ */
	public static final String EMPLOYEE_INSERT_COMPLETE = "社員情報を登録しました";
	/** 社員情報の削除を実施した場合に表示するメッセージ */
	public static final String EMPLOYEE_DELETE_COMPLETE = "社員情報を削除しました";

}
