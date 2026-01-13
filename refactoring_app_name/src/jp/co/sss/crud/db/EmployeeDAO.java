package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public List<Employee> findAll() throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.EMPLOYEE_NOT_FOUND);
				return employees;
			}

			// レコードを出力
			System.out.println(ConstantMsg.RESULT_HEADER);
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt(ConstantValue.EMP_ID));
				employee.setEmpName(resultSet.getString(ConstantValue.EMP_NAME));

				int gender = Integer.parseInt(resultSet.getString(ConstantValue.GENDER));

				if (gender == ConstantValue.GENDER_NO_ANSWER_NUMBER) {
					employee.setGender(resultSet.getInt(ConstantValue.GENDER_NO_ANSWER_NUMBER));

				} else if (gender == ConstantValue.GENDER_MALE_NUMBER) {
					employee.setGender(resultSet.getInt(ConstantValue.GENDER_MALE_NUMBER));

				} else if (gender == ConstantValue.GENDER_FEMALE_NUMBER) {
					employee.setGender(resultSet.getInt(ConstantValue.GENDER_FEMALE_NUMBER));

				} else if (gender == ConstantValue.GENDER_OTHER_NUMBER) {
					employee.setGender(resultSet.getInt(ConstantValue.GENDER_OTHER_NUMBER));

				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString(ConstantValue.BIRTHDAY)));
				
				Department department = new Department();
				department.setDeptName(resultSet.getString(ConstantValue.DEPT_NAME));
				employee.setDepartment(department);
				
				employees.add(employee);
			}

		} finally {
			// ResultSetをクローズ
			DBManager.closeResultSet(resultSet);
			// Statementをクローズ
			DBManager.closePreparedStatement(preparedStatement);
			// DBとの接続を切断
			DBManager.closeDBConnection(connection);
		}
		return employees;
	}
}
