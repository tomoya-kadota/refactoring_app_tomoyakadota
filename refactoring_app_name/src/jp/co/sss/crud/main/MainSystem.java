package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.MENU);
			System.out.print(ConstantMsg.INPUT_MENU_NUMBER);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.FIND_ALL:
				// 全件表示機能の呼出
				EmployeeAllFindService.findAll();
				break;

			case ConstantValue.FIND_BY_EMP_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.INPUT_EMPNAME);

				// 検索機能の呼出
				EmployeeFindByEmpNameService.findByEmpName();
				break;

			case ConstantValue.FIND_BY_DEPT_ID:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.INPUT_DEPTID_MSG);
				String inputDeptId = br.readLine();

				// 検索機能の呼出
				EmployeeFindByDeptIdService.findByDeptId(inputDeptId);
				break;

			case ConstantValue.INSERT:
				// 登録する値を入力
				System.out.print(ConstantMsg.INPUT_EMPNAME);
				String insertEmpName = br.readLine();
				System.out.print(ConstantMsg.INPUT_GENDER);
				String insertGender = br.readLine();
				System.out.print(ConstantMsg.INPUT_BIRTHDAY);
				String insertBirthday = br.readLine();
				System.out.print(ConstantMsg.INPUT_DEPTID);
				String insertDeptId = br.readLine();

				// 登録機能の呼出
				EmployeeRegisterService.insert(insertEmpName, insertGender, insertBirthday, insertDeptId);
				break;

			case ConstantValue.UPDATE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.UPDATE_EMPID_MSG);

				// 更新する値を入力する
				String updateEmpId = br.readLine();
				Integer.parseInt(updateEmpId);

				// 更新機能の呼出
				DBController.update(updateEmpId);
				System.out.println(ConstantMsg.EMPLOYEE_UPDATE_COMPLETE);

				break;

			case ConstantValue.DELETE:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.DELETE_DEPTID_MSG);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != ConstantValue.SHUTDOWN);
		System.out.println(ConstantMsg.SYSTEM_SHUTDOWN);
	}
}
