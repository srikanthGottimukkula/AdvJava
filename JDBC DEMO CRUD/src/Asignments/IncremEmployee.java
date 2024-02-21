package Asignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//program: increment salary by each employee
public class IncremEmployee {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String UPDATE_SQL = "UPDATE EMPLOYEE SET EMP_SALARY=EMP_SALARY+(EMP_SALARY*?)/100";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee Hike percentage!!");
		int emp_hike = sc.nextInt();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		PreparedStatement pstmt = con.prepareStatement(UPDATE_SQL);
		pstmt.setDouble(1, emp_hike);
		int incremented = pstmt.executeUpdate();
		if (incremented == 5) {
			System.out.println("Incremented emp_salary!!");
		}
		con.close();
	}
}
