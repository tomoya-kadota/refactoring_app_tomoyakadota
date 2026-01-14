package jp.co.sss.crud.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeEmpIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		// TODO 自動生成されたメソッド・スタブ
		return ConstantMsg.EMPID_ERROR_MSG;
	}

	@Override
	public boolean isValid(String inputString) {
		Pattern p = Pattern.compile(ConstantValue.EMPID_PATTERN);
		Matcher m = p.matcher(inputString);
		return m.find();
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
