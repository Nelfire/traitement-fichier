package fr.diginamic.entite;

public class Allergene {
	private String libelle;
	
	/** Constructeur
	 * @param libelle
	 */
	public Allergene(String libelle) {
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
