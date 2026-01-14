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
	/** メニュー */
	public static final String MENU ="=== 社員管理システム ===\n"
									+ "1.全件表示\n"
									+ "2.社員名検索\n"
									+ "3.部署ID検索\n"
									+ "4.新規登録\n"
									+ "5.更新\n"
									+ "6.削除\n"
									+ "7.終了";
	/** 検索結果表示用のヘッダー */
	public static final String RESULT_HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";
	
	// ***** 入力を促すメッセージ *****
	/** メニュー番号の入力を促すメッセージ */
	public static final String INPUT_MENU_NUMBER = "メニュー番号を入力してください：";
	/** 更新対象の社員IDの入力を促すメッセージ */
	public static final String UPDATE_EMPID_MSG = "更新する社員の社員IDを入力してください：";
	/** 削除対象の社員IDの入力を促すメッセージ */
	public static final String DELETE_EMPID_MSG = "削除する社員の社員IDを入力してください：";
	/** 部署IDの入力を促すメッセージ */
	public static final String INPUT_DEPTID_MSG = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	/** 社員名の入力を促すメッセージ */
	public static final String INPUT_EMPNAME = "社員名：";
	/** 性別の入力を促すメッセージ */
	public static final String INPUT_GENDER = "性別(0:回答しない, 1:男性, 2:女性, 9:その他):";
	/** 社員名の入力を促すメッセージ */
	public static final String INPUT_BIRTHDAY = "生年月日(西暦年/月/日)：";
	/** 部署IDの入力を促すメッセージ */
	public static final String INPUT_DEPTID = "部署ID(1：営業部、2：経理部、3：総務部)：";
	
	// ***** 結果表示用メッセージ *****
	/** 検索の結果、該当社員なしの場合に表示するメッセージ */
	public static final String EMPLOYEE_NOT_FOUND = "該当者はいませんでした";
	/** 社員情報の登録を実施した場合に表示するメッセージ */
	public static final String EMPLOYEE_INSERT_COMPLETE = "社員情報を登録しました";
	/** 社員情報の更新を実施した場合に表示するメッセージ */
	public static final String EMPLOYEE_UPDATE_COMPLETE = "社員情報を更新しました";
	/** 社員情報の削除を実施した場合に表示するメッセージ */
	public static final String EMPLOYEE_DELETE_COMPLETE = "社員情報を削除しました";
	/** システム終了時に表示するメッセージ */
	public static final String SYSTEM_SHUTDOWN = "システムを終了します。";
	/** 検査例外が発生した場合に表示するメッセージ */
	public static final String SYSTEM_ERROR_MSG = "システムエラーです。";

}
