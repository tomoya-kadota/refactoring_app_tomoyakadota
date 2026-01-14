package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
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
	public static void main(String[] args) throws SystemErrorException {

		int menuNo = 0;
		MenuNoReader menuNoReader = new MenuNoReader();
		do {
			try {
				// メニューの表示
				ConsoleWriter.showMenu();

				menuNo = (int) menuNoReader.input();

				if (menuNo != ConstantValue.SHUTDOWN) {
					// メニュー番号の入力、及び機能の呼び出し
					IEmployeeService iEmployeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
					iEmployeeService.execute();
				}

			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}

		} while (menuNo != ConstantValue.SHUTDOWN);
		ConsoleWriter.showSystemShutDown();
	}
}
