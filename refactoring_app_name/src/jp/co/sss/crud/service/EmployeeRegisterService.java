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

		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		// 登録する値を入力
		ConsoleWriter.showInputEmpName();
		String insertEmpName = (String) employeeNameReader.input();
		ConsoleWriter.showInputGender();
		String insertGender = (String) employeeGenderReader.input();
		ConsoleWriter.showInputBirthday();
		String insertBirthday = (String) employeeBirthdayReader.input();
		ConsoleWriter.showInputDeptId();
		String insertDeptId = (String) employeeDeptIdReader.input();

		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.insert(insertEmpName, insertGender, insertBirthday, insertDeptId);
		ConsoleWriter.showInsertComplete();

	}
}
