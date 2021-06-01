package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
		String login = properties.getString("db.login");
		String pwd = properties.getString("db.password");

		try (Connection connexion = DriverManager.getConnection(url, login, pwd)) {
			System.out.println(connexion);
			System.out.println("connected");
			Statement monStatement = connexion.createStatement();
			ResultSet curseur = monStatement.executeQuery("SELECT * FROM FOURNISSEUR");

			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

			while (curseur.next()) {
				fournisseurs.add(new Fournisseur(curseur.getString("ID"), curseur.getString("NOM")));
			}
			for (Fournisseur le : fournisseurs) {
				System.out.println(le);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
