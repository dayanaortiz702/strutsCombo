package pe.edu.cibertec.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/prueba", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
