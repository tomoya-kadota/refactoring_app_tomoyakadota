package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByEmpNameService {

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
		List<Employee> searchedEmployees = employeeDAO.findByEmpName(searchName);
		ConsoleWriter.showEmployees(searchedEmployees);
	}
}
