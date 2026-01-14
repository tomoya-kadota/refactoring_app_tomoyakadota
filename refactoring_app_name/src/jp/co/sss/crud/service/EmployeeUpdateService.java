package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService {

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException
	 */
	public static void update() throws SystemErrorException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 更新する値を入力する
			String updateEmpId = br.readLine();
			Integer.parseInt(updateEmpId);

			EmployeeDAO employeeDAO = new EmployeeDAO();
			employeeDAO.update(updateEmpId);
			ConsoleWriter.showUpdateComplete();
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR_MSG, e);
		}
	}
}
