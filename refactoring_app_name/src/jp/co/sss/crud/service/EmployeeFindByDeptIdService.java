package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		
		ConsoleWriter.showInputDeptId();
		List<Employee> searchedEmployees = employeeDAO.findByDeptId((String) employeeDeptIdReader.input());
		ConsoleWriter.showEmployees(searchedEmployees);
		
	}
}
