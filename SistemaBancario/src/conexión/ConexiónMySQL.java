package conexión;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexiónMySQL {
	public static Connection getconexión() {
		Connection cnx = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado correctamente");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_SistemaBancario","root","my29_sql");
			System.out.println("Conexión realizada corectamente");
		} catch (Exception e) {
			System.out.println("Error"+e);
		}
		return cnx;
	}
	public static void main(String[] args) {
		getconexión();
	}
}
