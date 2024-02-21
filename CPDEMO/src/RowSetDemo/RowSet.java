package RowSetDemo;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSet {
	public static void main(String[] args) throws Exception {

		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/advjava");
		rowSet.setUsername("root");
		rowSet.setPassword("Srigmk@28");
		rowSet.setCommand("SELECT * FROM BOOKS");
		rowSet.execute();

		while (rowSet.next()) {
			System.out.print(rowSet.getInt(1)+" \t");
			System.out.print(rowSet.getString(2)+"\t");
			System.out.println(rowSet.getDouble(3));
		}
		rowSet.close();
	}
}
