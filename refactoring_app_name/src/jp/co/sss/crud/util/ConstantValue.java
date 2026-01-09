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

	// ***** 検索結果出力に関連する文字列 *****

	/** ヘッダー */
	public static final String RESULT_HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";

	/** 社員ID */
	public static final String EMP_ID = "emp_id";
	/** 社員名 */
	public static final String EMP_NAME = "emp_name";
	/** 性別 */
	public static final String GENDER = "gender";
	/** 性別 未回答 */
	public static final String GENDER_NO_ANSWER = "回答なし";
	/** 性別 男性 */
	public static final String GENDER_MALE = "男性";
	/** 性別 女性 */
	public static final String GENDER_FEMALE = "女性";
	/** 性別 その他 */
	public static final String GENDER_OTHER = "その他";
	/** 生年月日 */
	public static final String BIRTHDAY = "birthday";
	/** 部署ID */
	public static final String DEPT_ID = "dept_id";
	/** 部署名 */
	public static final String DEPT_NAME = "dept_name";
	/** 部署名 営業部 */
	public static final String DEPT_SALES = "営業部";
	/** 部署名 経理部 */
	public static final String DEPT_ACCOUNTING = "経理部";
	/** 部署名 総務部 */
	public static final String DEPT_GENERAL = "総務部";

	// ***** 登録、更新処理用の出力文字列 *****

	/** 更新 社員名 */
	public static final String UPDATE_EMPNAME = "社員名：";
	/** 更新 性別 */
	public static final String UPDATE_GENDER = "性別(0:回答しない, 1:男性, 2:女性, 9:その他):";
	/** 更新 社員名 */
	public static final String UPDATE_BIRTHDAY = "生年月日(西暦年/月/日)：";
	/** 更新 部署ID */
	public static final String UPDATE_DEPTID = "部署ID(1：営業部、2：経理部、3：総務部)：";

	// ***** SimpleDateFormatを用いた日付形式の指定用文字列 *****

	/** yyyy/MM/dd形式でのフォーマット */
	public static final String DATE_FORMAT = "yyyy/MM/dd";
}
