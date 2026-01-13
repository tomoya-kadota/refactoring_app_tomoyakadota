package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import jp.co.sss.crud.util.ConstantMsg;
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
	public static void findAll() throws ClassNotFoundException, SQLException, ParseException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.findAll();
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchName = br.readLine();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.findByEmpName(searchName);
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByDeptId(String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.findByDeptId(deptId);
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

		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.insert(empName, gender, birthday, deptId);
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

		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.update(empId);
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void delete() {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		if(employeeDAO.delete() != ConstantValue.DELETE_FAILURE) {
			System.out.println(ConstantMsg.EMPLOYEE_DELETE_COMPLETE);
		}
	}
}
