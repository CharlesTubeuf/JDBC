package fr.diginamic.jdbc.entites;

public class Fournisseur {
	
	private String id; 
	private String nom;
	
	public Fournisseur(String id, String nom) {
		this.id=id;
		this.nom=nom;
	}
	public Fournisseur(String nom) {
		this.nom=nom;
	}


	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}


	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
