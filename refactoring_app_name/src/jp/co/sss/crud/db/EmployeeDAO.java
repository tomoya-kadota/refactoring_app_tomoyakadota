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
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public List<Employee> findAll() throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// resultSetの結果Setがない場合はreturn
			if (!resultSet.isBeforeFirst()) {
				return employees;
			}

			// レコードを出力
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt(ConstantValue.EMP_ID));
				employee.setEmpName(resultSet.getString(ConstantValue.EMP_NAME));

				int gender = Integer.parseInt(resultSet.getString(ConstantValue.GENDER));
				employee.setGender(gender);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString(ConstantValue.BIRTHDAY)));

				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.DEPT_NAME));
				employee.setDepartment(department);

				employees.add(employee);
			}

		} finally {
			// ResultSetをクローズ
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
		return employees;
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> findByEmpName(String searchName)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// resultSetの結果Setがない場合はreturn
			if (!resultSet.isBeforeFirst()) {
				return employees;
			}

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt(ConstantValue.EMP_ID));
				employee.setEmpName(resultSet.getString(ConstantValue.EMP_NAME));

				int gender = Integer.parseInt(resultSet.getString(ConstantValue.GENDER));
				employee.setGender(gender);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString(ConstantValue.BIRTHDAY)));

				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.DEPT_NAME));
				employee.setDepartment(department);

				employees.add(employee);
			}

		} finally {
			// クローズ処理
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
		return employees;
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> findByDeptId(String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

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
				return employees;
			}

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt(ConstantValue.EMP_ID));
				employee.setEmpName(resultSet.getString(ConstantValue.EMP_NAME));

				int gender = Integer.parseInt(resultSet.getString(ConstantValue.GENDER));
				employee.setGender(gender);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString(ConstantValue.BIRTHDAY)));

				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.DEPT_NAME));
				employee.setDepartment(department);

				employees.add(employee);
			}
		} finally {
			// クローズ処理
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
		return employees;
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
	public void insert(String empName, String gender, String birthday, String deptId)
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
	public Integer update(String empId) throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);
			
			// 社員名を入力
			ConsoleWriter.showInputEmpName();
			String empName = br.readLine();
			// 性別を入力
			ConsoleWriter.showInputGender();
			String gender = br.readLine();
			// 誕生日を入力
			ConsoleWriter.showInputBirthday();
			String birthday = br.readLine();
			// 部署IDを入力
			ConsoleWriter.showInputDeptId();
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

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
	public Integer delete() {

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
			return preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return ConstantValue.DELETE_FAILURE;

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
