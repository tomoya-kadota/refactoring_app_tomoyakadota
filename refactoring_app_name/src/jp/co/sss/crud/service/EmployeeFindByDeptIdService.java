package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService {

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findByDeptId() throws SystemErrorException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		List<Employee> searchedEmployees = employeeDAO.findByDeptId((String) employeeDeptIdReader.input());
		ConsoleWriter.showEmployees(searchedEmployees);
	}
}
