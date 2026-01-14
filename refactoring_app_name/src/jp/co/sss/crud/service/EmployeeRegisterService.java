package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

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
	public static void insert() throws SystemErrorException {

		// 登録する値を入力
		ConsoleWriter.showInputEmpName();
		String insertEmpName = EmployeeNameReader.input();
		ConsoleWriter.showInputGender();
		String insertGender = EmployeeGenderReader.input();
		ConsoleWriter.showInputBirthday();
		String insertBirthday = EmployeeBirthdayReader.input();
		ConsoleWriter.showInputDeptId();
		String insertDeptId = EmployeeDeptIdReader.input();

		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.insert(insertEmpName, insertGender, insertBirthday, insertDeptId);
		ConsoleWriter.showInsertComplete();

	}
}
