package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByDeptIdService {

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
		List<Employee> searchedEmployees = employeeDAO.findByDeptId(deptId);
		ConsoleWriter.showEmployees(searchedEmployees);
	}
}
