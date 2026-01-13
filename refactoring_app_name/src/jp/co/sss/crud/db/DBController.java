package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class DBController {

	/** インスタンス化を禁止 */
	private DBController() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.EMPLOYEE_NOT_FOUND);
				return;
			}

			// レコードを出力
			System.out.println(ConstantValue.RESULT_HEADER);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantValue.EMP_ID) + "\t");
				System.out.print(resultSet.getString(ConstantValue.EMP_NAME) + "\t");

				int gender = Integer.parseInt(resultSet.getString(ConstantValue.GENDER));
				if (gender == ConstantValue.GENDER_NO_ANSWER_NUMBER) {
					System.out.print(ConstantValue.GENDER_NO_ANSWER + "\t");
				} else if (gender == ConstantValue.GENDER_MALE_NUMBER) {
					System.out.print(ConstantValue.GENDER_MALE + "\t");

				} else if (gender == ConstantValue.GENDER_FEMALE_NUMBER) {
					System.out.print(ConstantValue.GENDER_FEMALE + "\t");

				} else if (gender == ConstantValue.GENDER_OTHER_NUMBER) {
					System.out.print(ConstantValue.GENDER_OTHER + "\t");

				}

				System.out.print(resultSet.getString(ConstantValue.BIRTHDAY) + "\t");
				System.out.println(resultSet.getString(ConstantValue.DEPT_NAME));
			}

			System.out.println("");
		} finally {
			// ResultSetをクローズ
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.EMPLOYEE_NOT_FOUND);
				return;
			}

			System.out.println(ConstantValue.RESULT_HEADER);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantValue.EMP_ID));
				System.out.print("\t");

				System.out.print(resultSet.getString(ConstantValue.EMP_NAME));
				System.out.print("\t");

				String genderString = resultSet.getString(ConstantValue.GENDER);
				int gender = Integer.parseInt(genderString);
				if (gender == ConstantValue.GENDER_NO_ANSWER_NUMBER) {
					System.out.print(ConstantValue.GENDER_NO_ANSWER);
				} else if (gender == ConstantValue.GENDER_MALE_NUMBER) {
					System.out.print(ConstantValue.GENDER_MALE);

				} else if (gender == ConstantValue.GENDER_FEMALE_NUMBER) {
					System.out.print(ConstantValue.GENDER_FEMALE);

				} else if (gender == ConstantValue.GENDER_OTHER_NUMBER) {
					System.out.print(ConstantValue.GENDER_OTHER);

				}

				System.out.print("\t");
				System.out.print(resultSet.getString(ConstantValue.BIRTHDAY));
				System.out.print("\t");

				System.out.println(resultSet.getString(ConstantValue.DEPT_NAME));
			}

			System.out.println("");

		} finally {
			// クローズ処理
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.EMPLOYEE_NOT_FOUND);
				return;
			}

			System.out.println(ConstantValue.RESULT_HEADER);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantValue.EMP_ID));
				System.out.print("\t");

				System.out.print(resultSet.getString(ConstantValue.EMP_NAME));
				System.out.print("\t");

				String genderString = resultSet.getString(ConstantValue.GENDER);
				int gender = Integer.parseInt(genderString);
				if (gender == ConstantValue.GENDER_NO_ANSWER_NUMBER) {
					System.out.print(ConstantValue.GENDER_NO_ANSWER);
				} else if (gender == ConstantValue.GENDER_MALE_NUMBER) {
					System.out.print(ConstantValue.GENDER_MALE);

				} else if (gender == ConstantValue.GENDER_FEMALE_NUMBER) {
					System.out.print(ConstantValue.GENDER_FEMALE);

				} else if (gender == ConstantValue.GENDER_OTHER_NUMBER) {
					System.out.print(ConstantValue.GENDER_OTHER);

				}

				System.out.print("\t");
				System.out.print(resultSet.getString(ConstantValue.BIRTHDAY));
				System.out.print("\t");

				String deptIdString = resultSet.getString(ConstantValue.DEPT_ID);
				int resultDeptId = Integer.parseInt(deptIdString);
				if (resultDeptId == ConstantValue.DEPT_SALES_NUMBER) {
					System.out.println(ConstantValue.DEPT_SALES);
				} else if (resultDeptId == ConstantValue.DEPT_ACCOUNTING_NUMBER) {
					System.out.println(ConstantValue.DEPT_ACCOUNTING);
				} else if (resultDeptId == ConstantValue.DEPT_GENERAL_NUMBER) {
					System.out.println(ConstantValue.DEPT_GENERAL);

				}
			}

			System.out.println("");
		} finally {
			// クローズ処理
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName  社員名
	 * @param gender   性別
	 * @param birthday 生年月日
	 * @param deptId   部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException
	 */
	public static void insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.EMPLOYEE_INSERT_COMPLETE);
		} finally {
			DBManager.closePreparedStatement(preparedStatement);
			DBManager.closeDBConnection(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException
	 */
	public static void update(String empId) throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print(ConstantValue.UPDATE_EMPNAME);
			String emp_name = br.readLine();
			// 性別を入力
			System.out.print(ConstantValue.UPDATE_GENDER);
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print(ConstantValue.UPDATE_BIRTHDAY);
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print(ConstantValue.UPDATE_DEPTID);
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, emp_name);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.EMPLOYEE_DELETE_COMPLETE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.closePreparedStatement(preparedStatement);
				DBManager.closeDBConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
