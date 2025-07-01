package conexión;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexiónMySQL {
	public static Connection getconexión() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado correctamente");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_banco","root","");
			System.out.println("Conexión realizada corectamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
		return connection;
	}
}
