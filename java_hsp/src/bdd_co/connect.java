package bdd_co;

import java.sql.*;
public class connect{
	public Connection db() {
		String url="jdbc:mysql://localhost/Java_Hsp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="";

		try {
			Connection cnx = DriverManager.getConnection(url, user, password);
			return cnx;
		}

		catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion à la base de données");
			e.printStackTrace();
		}
		return null;
	}
}