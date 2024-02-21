package PersonFile;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import CPF.ConnectionFactory;

//program :- To insert the file into dataBase.
public class InsertPersonDetails {

	public static void main(String[] args) throws Exception {

		Connection con = ConnectionFactory.getDBConnection();

		File file = new File("C:\\Users\\Srikanth Gmk\\Downloads\\download.jpg");
		FileInputStream fis = new FileInputStream(file);

		String sql = "INSERT INTO PERSON VALUES(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setBlob(2, fis);
		int count = pstmt.executeUpdate();
		System.out.println("Record is inserted!!" + count);
		pstmt.close();
		con.close();

	}
}
