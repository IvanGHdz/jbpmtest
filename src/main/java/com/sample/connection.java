package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	
	public String conn()
	{
		String driver = "com.mysql.jdbc.Driver";

		String database = "intplan";

		String hostname = "localhost";

		String port = "33060";

		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false";

		String username = "root";

		String password = "pw123";

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		
			System.out.println("try");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());

		}

		String consulta = "SELECT * FROM casos";
		String result = null;
		try {
			Statement sentencia = conn.createStatement();
			ResultSet resultado = sentencia.executeQuery(consulta);
			while (resultado.next()) {
				result = resultado.getString(1);
			}

		} catch (SQLException e) {

			result = e.getMessage();
		}
		
		 
		return result;

	}

}
