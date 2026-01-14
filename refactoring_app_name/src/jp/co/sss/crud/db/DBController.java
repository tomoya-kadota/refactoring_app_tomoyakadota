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
