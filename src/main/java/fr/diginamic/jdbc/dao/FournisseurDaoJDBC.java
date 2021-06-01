package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJDBC implements FournisseurDAO {

	private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES('%s')";
	private static final String FIND_ALL_QUERY = "SELECT * FROM FOURNISSEUR";
	private static final String FIND_BY_ID_QUERY = "SELECT * FOURNISSEUR WHERE ID = '%s'";
	private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = '%s' WHERE NOM = '%s'";
	private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = '%s'";
	
	@Override
	public List<Fournisseur> extraire() throws SQLException {
		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
		String login = properties.getString("db.login");
		String pwd = properties.getString("db.password");

		ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

		try (Connection connexion = DriverManager.getConnection(url, login, pwd)) {
			Statement monStatement = connexion.createStatement();
			try (ResultSet curseur = monStatement.executeQuery(String.format(FIND_ALL_QUERY, null))) {
				while (curseur.next()) {
					fournisseurs.add(new Fournisseur(curseur.getString("ID"), curseur.getString("NOM")));
				}
			}
		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {
		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
		String login = properties.getString("db.login");
		String pwd = properties.getString("db.password");

		try (Connection connexion = DriverManager.getConnection(url, login, pwd);
				Statement monStatement = connexion.createStatement()) {
			monStatement.executeUpdate(String.format(INSERT_QUERY, fournisseur.getNom()));
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {

		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
		String login = properties.getString("db.login");
		String pwd = properties.getString("db.password");
		int nb = -1;
		try (Connection connexion = DriverManager.getConnection(url, login, pwd)) {
			Statement monStatement = connexion.createStatement();
			nb = monStatement
					.executeUpdate(String.format(UPDATE_QUERY, nouveauNom, ancienNom));
		}
		return nb;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {
		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
		String login = properties.getString("db.login");
		String pwd = properties.getString("db.password");
		int nb = -1;
		try (Connection connexion = DriverManager.getConnection(url, login, pwd)) {
			Statement monStatement = connexion.createStatement();
			nb = monStatement.executeUpdate(String.format(DELETE_QUERY, fournisseur.getNom()));
			System.out.println(nb + " Nombre de ligne suprimmée(s).");
		}
		if (nb > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
