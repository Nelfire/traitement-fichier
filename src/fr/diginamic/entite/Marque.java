package fr.diginamic.entite;

public class Marque {
	private String nom;
	
	/** Constructeur
	 * @param nom
	 */
	public Marque(String nom) {
		super();
		this.nom = nom;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
