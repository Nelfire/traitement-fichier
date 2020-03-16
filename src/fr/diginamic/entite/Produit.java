package fr.diginamic.entite;

import java.util.ArrayList;

public class Produit {

	private String nom;
	private Categorie categorie;
	private Marque marque;
	private char scoreNutritionnel;
	private ArrayList<Ingredient> listeIngredients;
	private ArrayList<Additif> listeAdditifs;
	private ArrayList<Allergene> listeAllergene;
	/** Constructeur
	 * @param categorie
	 * @param marque
	 * @param scoreNutritionnel
	 * @param listeIngredients
	 * @param listeAdditifs
	 * @param listeAllergene
	 */
	public Produit(String nom,char scoreNutritionnel, Categorie categorie, Marque marque) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.marque = marque;
		this.scoreNutritionnel = scoreNutritionnel;
	}
	/** Getter
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/** Getter
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}
	/** Setter
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	/** Getter
	 * @return the scoreNutritionnel
	 */
	public char getScoreNutritionnel() {
		return scoreNutritionnel;
	}
	/** Setter
	 * @param scoreNutritionnel the scoreNutritionnel to set
	 */
	public void setScoreNutritionnel(char scoreNutritionnel) {
		this.scoreNutritionnel = scoreNutritionnel;
	}
	/** Getter
	 * @return the listeIngredients
	 */
	public ArrayList<Ingredient> getListeIngredients() {
		return listeIngredients;
	}
	/** Setter
	 * @param listeIngredients the listeIngredients to set
	 */
	public void setListeIngredients(ArrayList<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}
	/** Getter
	 * @return the listeAdditifs
	 */
	public ArrayList<Additif> getListeAdditifs() {
		return listeAdditifs;
	}
	/** Setter
	 * @param listeAdditifs the listeAdditifs to set
	 */
	public void setListeAdditifs(ArrayList<Additif> listeAdditifs) {
		this.listeAdditifs = listeAdditifs;
	}
	/** Getter
	 * @return the listeAllergene
	 */
	public ArrayList<Allergene> getListeAllergene() {
		return listeAllergene;
	}
	/** Setter
	 * @param listeAllergene the listeAllergene to set
	 */
	public void setListeAllergene(ArrayList<Allergene> listeAllergene) {
		this.listeAllergene = listeAllergene;
	}
	@Override
	public String toString() {
		return "Produit : " + nom + ", Categorie : " + categorie + ", Marque : " + marque + ", Score Nutritionnel : "
				+ scoreNutritionnel + ", Liste Ingredients : " + listeIngredients + ", Liste Additifs : " + listeAdditifs
				+ ", Liste Allergenes : " + listeAllergene;
	}
	
	
	
	
	

}
