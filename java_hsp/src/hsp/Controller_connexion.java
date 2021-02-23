package hsp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.Shell;

public class Controller_connexion{
public boolean Connexion(String identifiant, String mdp, Shell shell) throws SQLException {
Database db = new Database();
Connection cnx = db.DbConnexion();
String requete = "Select * from utilisateur where identifiant = '"+identifiant+"' and mdp = '"+mdp+"'";
String role = "role";
ResultSet resultat = db.Request(cnx, requete);
while(resultat.next()) {
String Globidentifiant = resultat.getString("identifiant");
String Globnom = resultat.getString("nom");
if(resultat.getString(role).equals("Admin")) {
try { //Connexion en tant qu'Administrateur
shell.close();
Admin window_Admin = new Admin();
window_Admin.open();
return false;
} catch (Exception e) {
e.printStackTrace();
}
}
else { //Connexion en tant que user
try {
shell.close();
user window = new user();
window.open();
return false;
} catch (Exception e) {
e.printStackTrace();
}
}
}
return true;
}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public boolean Login_system(String text, String text2, Shell shell) {
		// TODO Auto-generated method stub
		return false;
	}

}
