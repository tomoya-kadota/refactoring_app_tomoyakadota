package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();

		ConsoleWriter.showDeleteInputEmpId();
		if (employeeDAO.delete() != ConstantValue.DELETE_FAILURE) {
			ConsoleWriter.showDeleteComplete();
		}
	}
}
