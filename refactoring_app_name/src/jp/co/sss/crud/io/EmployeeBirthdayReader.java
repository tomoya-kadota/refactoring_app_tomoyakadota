package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.BIRTHDAY_ERROR_MSG;
	}

	@Override
	public boolean isValid(String inputString) {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);

		try {
			sdf.parse(inputString);

		} catch (ParseException e) {
			return false;

		}
		return true;
	}

	@Override
	public boolean isParseInt() {
		return false;
	}
}