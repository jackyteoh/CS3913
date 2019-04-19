// 04/18/2019 Java Class Lecture Notes - 
/*
DBMS
Oracle
MSSQL
MySQL/Maria
MongoDB
Postgresql

**JDBC - Java Database Connectivity

Schema - mutiple tables. --> multiple fields

Insert - add a tuple to a table
delete - remove row from a table
update - change row in a table
select - get row from table
*/

import java.sql.*;
import java.io.*;

public class CS3913Spring2019JDBC {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://127.0.0.1/cs3913";
			String dbuser = "cs3913";
			String password = "abc123";
			conn = DriverManager.getConnection(url, dbuser, password);
			Statement s = conn.createStatement();
			s.executeQuery("select * from test;");
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				int id = rs,getInt(1);
				String name = rs.getString("name");
				Date bday = rs.getDate("bday");
				System.out.println(id + " " + name + " " + bday.toString());
			}
			rs.close();
			s.close();
			conn.close();
		}
		catch(Exception e) {

		}
	}
}