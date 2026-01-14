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

public class EmployeeRegisterService {

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
	public static void insert()
			throws SystemErrorException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 登録する値を入力
			ConsoleWriter.showInputEmpName();
			String insertEmpName = br.readLine();
			ConsoleWriter.showInputGender();
			String insertGender = br.readLine();
			ConsoleWriter.showInputBirthday();
			String insertBirthday = br.readLine();
			ConsoleWriter.showInputDeptId();
			String insertDeptId = br.readLine();

			EmployeeDAO employeeDAO = new EmployeeDAO();
			employeeDAO.insert(insertEmpName, insertGender, insertBirthday, insertDeptId);
			ConsoleWriter.showInsertComplete();
			
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR_MSG,e);
		}

	}
}
