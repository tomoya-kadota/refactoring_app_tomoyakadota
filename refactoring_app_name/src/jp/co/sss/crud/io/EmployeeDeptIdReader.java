package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeptIdReader {

	public static String input() throws SystemErrorException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String deptId = "";

		try {
			deptId = br.readLine();
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.SYSTEM_ERROR_MSG, e);
		}

		return deptId;
	}
}
