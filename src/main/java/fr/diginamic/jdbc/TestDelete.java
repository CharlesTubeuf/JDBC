package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
        String login = properties.getString("db.login");
        String pwd = properties.getString("db.password");
       
        try (Connection connexion = DriverManager.getConnection(url, login, pwd)){
            System.out.println(connexion);
            System.out.println("connected");
            Statement monStatement = connexion.createStatement();
            int nb =  monStatement.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM=('La Maison Des Peintures')");
            System.out.println(nb + " Nombre de ligne suprimmée(s).");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
		
	}

}
