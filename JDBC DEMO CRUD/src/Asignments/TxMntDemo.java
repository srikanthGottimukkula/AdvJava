package Asignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//Pgrm:- Read Employee and EMP add data from the keyboard and insert into db table 
// emp: emp_id,emp_name,emp_salary
//emp_add:- city,state,country

public class TxMntDemo {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String DB_EMP_INSERT = "INSERT INTO EMP VALUES (?,?,?)";
	private static final String DB_EMP_ADD_INSERT = "INSERT INTO EMPADDRESS VALUES (?,?,?,?)";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Emp id value!!");
		int Emp_Id = sc.nextInt();
		System.out.println("Enter the Emp name!!");
		String Emp_Name = sc.next();
		System.out.println("Enter the Emp Double!!");
		Double Emp_Salary = sc.nextDouble();
		System.out.println("Enter the Emp city!!");
		String Emp_City = sc.next();
		System.out.println("Enter the Emp State!!");
		String Emp_State = sc.next();
		System.out.println("Enter the Emp Country!!");
		String Emp_Country = sc.next();

		// By default con-auto commit mode is true
		con.setAutoCommit(false);

		try {

			PreparedStatement pstmt = con.prepareStatement(DB_EMP_INSERT);
			pstmt.setInt(1, Emp_Id);
			pstmt.setString(2, Emp_Name);
			pstmt.setDouble(3, Emp_Salary);

			pstmt.executeUpdate();

			pstmt = con.prepareStatement(DB_EMP_ADD_INSERT);
			pstmt.setString(1, Emp_City);
			pstmt.setString(2, Emp_State);
			pstmt.setString(3, Emp_Country);
			pstmt.setInt(4, Emp_Id);

			pstmt.executeUpdate();
			con.commit();
			System.out.println("Record is inserted!!");

		} catch (Exception e) {
			System.out.println("Transaction rolled back!!");
			con.rollback();
			e.printStackTrace();
		}
		con.close();

	}
}
