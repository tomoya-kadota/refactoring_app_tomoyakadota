package jp.co.sss.crud.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDeptIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {

		return ConstantMsg.DEPTID_ERROR_MSG;
	}

	@Override
	public boolean isValid(String inputString) {
		Pattern p = Pattern.compile(ConstantValue.DEPTID_PATTERN);
		Matcher m = p.matcher(inputString);
		return m.find();
	}

	@Override
	public boolean isParseInt() {
		return false;
	}


}
