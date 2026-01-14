package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	
	/**
	 * 
	 */
	public static void showMenu() {

		// メニューの表示
		System.out.println(ConstantMsg.MENU);
		System.out.print(ConstantMsg.INPUT_MENU_NUMBER);
	}
	
	/**
	 * 
	 */
	public static void showInputEmpName() {
		
		// 社員名の入力を促すメッセージを出力
		System.out.print(ConstantMsg.INPUT_EMPNAME);
	}
	/**
	 * 
	 */
	public static void showInputEmpId() {
		
		// 社員IDの入力を促すメッセージを出力
		System.out.print(ConstantMsg.UPDATE_EMPID_MSG);
	}
	
	/**
	 * 
	 */
	public static void showInputDeptId() {
		
		// 部署IDの入力を促すメッセージを出力
		System.out.print(ConstantMsg.INPUT_DEPTID_MSG);
	}
	
	/**
	 * 
	 */
	public static void showInputGender() {
		
		// 性別の入力を促すメッセージを出力
		System.out.print(ConstantMsg.INPUT_GENDER);
	}
	/**
	 * 
	 */
	public static void showInputBirthday() {
		
		// 生年月日の入力を促すメッセージを出力
		System.out.print(ConstantMsg.INPUT_BIRTHDAY);
	}

	/**
	 * @param employees
	 */
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();
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
	private static void showHeader() {

		// 検索結果表示用のヘッダーを出力
		System.out.println(ConstantMsg.RESULT_HEADER);
	}

	/**
	 * 
	 */
	private static void showNonExistTarget() {

		// 対象者が見つからなかった旨のメッセージを出力
		System.out.println(ConstantMsg.EMPLOYEE_NOT_FOUND);
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

	/**
	 * 
	 */
	public static void showDeleteComplete() {

		// 削除完了メッセージを出力
		System.out.println(ConstantMsg.EMPLOYEE_DELETE_COMPLETE);
	}
	
	/**
	 * 
	 */
	public static void showSystemShutDown() {
		
		// システムの終了メッセージを出力
		System.out.println(ConstantMsg.SYSTEM_SHUTDOWN);
	}

}
