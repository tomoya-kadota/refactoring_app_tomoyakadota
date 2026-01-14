package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDeleteService {

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
			ConsoleWriter.showDeleteComplete();
		}
	}
}
