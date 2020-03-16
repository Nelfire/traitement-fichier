package fr.diginamic.test;


import java.util.ArrayList;
import fr.diginamic.entite.Produit;

public class Stock {

	/**liste : ArrayList<Produit>*/
	private ArrayList<Produit> liste;
	
	/**
	 * ajouter un produit a la liste
	 * @param produit
	 */
	public void ajouter (Produit produit) {
		liste.add(produit);
	}

	/**Constructor
	 * @param liste
	 */
	public Stock() {
		super();
		this.liste = new ArrayList<Produit>();
	}

	/**Getter
	 * @return the liste
	 */
	public ArrayList<Produit> getListe() {
		return liste;
	}
	
	
}
