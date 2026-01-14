package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeUpdateService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		
		ConsoleWriter.showUpdateInputEmpId();
		// 更新する値を入力する
		employeeDAO.update((String) employeeEmpIdReader.input());
		ConsoleWriter.showUpdateComplete();

	}
}
