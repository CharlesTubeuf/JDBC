import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDaoJDBC;
import fr.diginamic.jdbc.entites.Fournisseur;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		List<Fournisseur> fournisseurs = new ArrayList<>();
		FournisseurDaoJDBC service = new FournisseurDaoJDBC();
		try {
			fournisseurs = service.extraire();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for (Fournisseur f :fournisseurs) {
			System.out.println(f);
		}
		
		Fournisseur carouf = new Fournisseur ("Carouf");
		try {
			service.insert(carouf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
//	
		try {
			service.update("Carouf", "Carrefour");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		carouf.setNom("Carrefour");
		try {
			service.delete(carouf);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
