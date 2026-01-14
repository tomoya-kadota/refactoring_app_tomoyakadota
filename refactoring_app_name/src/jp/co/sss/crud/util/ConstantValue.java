package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(検索処理の結果表示関連)
 *
 * @author 角田 智哉
 *
 */
public class ConstantValue {

	/** インスタンス化を禁止 */
	private ConstantValue() {
	}
	// ***** メニュー番号 *****
	/** メニュー番号：１（全件表示） */
	public static final int FIND_ALL = 1;
	/** メニュー番号：２（社員名検索） */
	public static final int FIND_BY_EMP_NAME = 2;
	/** メニュー番号：３（部署ID検索） */
	public static final int FIND_BY_DEPT_ID = 3;
	/** メニュー番号：４（新規登録） */
	public static final int INSERT = 4;
	/** メニュー番号：５（更新） */
	public static final int UPDATE = 5;
	/** メニュー番号：６（削除） */
	public static final int DELETE = 6;
	/** メニュー番号：７（終了） */
	public static final int SHUTDOWN = 7;
	
	// ***** 検索結果出力に関連する文字列 *****

	/** 社員ID */
	public static final String EMP_ID = "emp_id";
	/** 社員名 */
	public static final String EMP_NAME = "emp_name";
	/** 性別 */
	public static final String GENDER = "gender";
	/** 性別 未回答 */
	public static final String GENDER_NO_ANSWER = "回答なし";
	/** 性別 未回答 選択肢番号 */
	public static final int GENDER_NO_ANSWER_NUMBER = 0;
	/** 性別 男性 */
	public static final String GENDER_MALE = "男性";
	/** 性別 男性 選択肢番号 */
	public static final int GENDER_MALE_NUMBER = 1;
	/** 性別 女性 */
	public static final String GENDER_FEMALE = "女性";
	/** 性別 女性 選択肢番号 */
	public static final int GENDER_FEMALE_NUMBER = 2;
	/** 性別 その他 */
	public static final String GENDER_OTHER = "その他";
	/** 性別 その他 選択肢番号 */
	public static final int GENDER_OTHER_NUMBER = 9;
	/** 生年月日 */
	public static final String BIRTHDAY = "birthday";
	/** 部署ID */
	public static final String DEPT_ID = "dept_id";
	/** 部署名 */
	public static final String DEPT_NAME = "dept_name";
	/** 部署名 営業部 */
	public static final String DEPT_SALES = "営業部";
	/** 部署名 営業部 選択肢番号 */
	public static final int DEPT_SALES_NUMBER = 1;
	/** 部署名 経理部 */
	public static final String DEPT_ACCOUNTING = "経理部";
	/** 部署名 経理部 選択肢番号 */
	public static final int DEPT_ACCOUNTING_NUMBER = 2;
	/** 部署名 総務部 */
	public static final String DEPT_GENERAL = "総務部";
	/** 部署名 総務部 選択肢番号 */
	public static final int DEPT_GENERAL_NUMBER = 3;


	// ***** 形式指定に関連する文字列 *****

	/** yyyy/MM/dd形式でのフォーマット */
	public static final String DATE_FORMAT = "yyyy/MM/dd";
	/** 削除処理SQL実行時、失敗した場合に設定する戻り値 */
	public static final int DELETE_FAILURE = 0;
		
}
