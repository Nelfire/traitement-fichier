package fr.diginamic.entite;

public class Ingredient {
	private String libelle;
	
	/** Constructeur
	 * @param libelle
	 */
	public Ingredient(String libelle) {
		super();
		this.libelle = libelle;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
