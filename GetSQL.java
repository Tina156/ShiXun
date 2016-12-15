//数据库的实现。包括连接，查询，修改功能的实现
package GitHub;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class GetSQL {

	Connection conn = null;
	static Statement stmt = null;

	public static void ConnectSQL() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String urser = "root";
			String password = "Windows10";
			Connection conn = DriverManager.getConnection(url, urser, password);
			stmt = conn.createStatement();
			System.out.println("The SQL is connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql) {
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(String sql) {
		try {
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void close() {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
