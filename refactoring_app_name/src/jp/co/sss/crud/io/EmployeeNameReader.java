package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.EMPNAME_ERROR_MSG;
	}

	@Override
	public boolean isValid(String inputString) {
		if (!inputString.isBlank()) {
			if (inputString.length() >= 1 && 30 >= inputString.length()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}
