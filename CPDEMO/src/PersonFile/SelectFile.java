package PersonFile;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import CPF.ConnectionFactory;

//program:- To RetrieveFile 
public class SelectFile {
	public static void main(String[] args) throws Exception {

		Connection con = ConnectionFactory.getDBConnection();
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM PERSON";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			System.out.println(rs.getInt(1));
			byte[] streams = rs.getBytes(2);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Srikanth Gmk\\Downloads\\image.png");
			fos.write(streams);
			fos.close();
		}
		con.close();

	}
}
