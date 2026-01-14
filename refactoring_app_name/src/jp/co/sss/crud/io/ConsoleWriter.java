package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {

	
	/**
	 * @param employees
	 */
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();//対象者がいませんでした と表示
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}
	
	/**
	 * 
	 */
	public static void showInsertComplete() {
		
		// 登録完了メッセージを出力
		System.out.println(ConstantMsg.EMPLOYEE_INSERT_COMPLETE);
	}
	/**
	 * 
	 */
	public static void showUpdateComplete() {
		
		// 更新完了メッセージを出力
		System.out.println(ConstantMsg.EMPLOYEE_UPDATE_COMPLETE);
	}
	public static void showDeleteComplete() {
		
		// 更新完了メッセージを出力
		System.out.println(ConstantMsg.EMPLOYEE_DELETE_COMPLETE);
	}

	/**
	 * 
	 */
	private static void showHeader() {
		
		System.out.println(ConstantMsg.RESULT_HEADER);
	}

	/**
	 * 
	 */
	private static void showNonExistTarget() {
		
		System.out.println(ConstantMsg.EMPLOYEE_NOT_FOUND);
	}
	
}
