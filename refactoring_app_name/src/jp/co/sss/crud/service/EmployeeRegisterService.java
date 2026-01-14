package jp.co.sss.crud.service;


import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
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
