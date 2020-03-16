package fr.diginamic.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import fr.diginamic.entite.Additif;
import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Categorie;
import fr.diginamic.entite.Marque;
import fr.diginamic.entite.Produit;

public class Utilitaire {

	/**
	 * Initialiser le stock de produits
	 * @return un stock
	 */
	public Stock loadStock() {

//		HashSet<String> listeIngredients = new HashSet<>();
//		HashSet<String> listeAdditifs = new HashSet<>();
//		HashSet<String> listeAllergenes = new HashSet<>();
		Stock stock = new Stock();
		try {
			File document = new File("C:/Users/20-100/Desktop/COURS DTA/open-food-facts.csv");
			List<String> lignes = FileUtils.readLines(document, "UTF-8");
			for (int i = 1; i < lignes.size(); i++) {
				String ligne = lignes.get(i);

				// On commence par découpe.
				String[] morceaux = ligne.split("\\|");
				String nom = morceaux[0];
				char grade = morceaux[1].charAt(0);
				Categorie categorie = new Categorie(morceaux[2]);
				Marque marque = new Marque(morceaux[3]);

				// Creation du produit
				Produit produit = new Produit(nom, grade, categorie, marque);
				String ingredients = morceaux[4];
				String energie100g = morceaux[5];
				String graisse100g = morceaux[6];
				String graisseSaturee100g = morceaux[7];
				String hydratesCarbones100g = morceaux[8];
				String sucres100g = morceaux[9];
				String fibres100g = morceaux[10];
				String proteines100g = morceaux[11];
				String sel100g = morceaux[12];
				String vitA100g = morceaux[13];
				String vitD100g = morceaux[14];
				String vitE100g = morceaux[15];
				String vitK100g = morceaux[16];
				String vitC100g = morceaux[17];
				String vitB1100g = morceaux[18];
				String vitB2100g = morceaux[19];
				String vitPP100g = morceaux[20];
				String vitB6100g = morceaux[21];
				String vitB9100g = morceaux[22];
				String vitB12100g = morceaux[23];
				String calcium100g = morceaux[24];
				String magnesium100g = morceaux[25];
				String fer100g = morceaux[26];
				String betaCarotene100g = morceaux[27];
				String presenceHuilePalme = morceaux[28];
				String pourcentageFruitsLegumes100g = morceaux[29];
				String allergenes = morceaux[30];

				// Allergenes
				ArrayList<Allergene> listeAllergenes = new ArrayList<>();
				// Enlever caracteres speciaux
				String allergenesSansCaracteres = allergenes.replaceAll("\\s", "");
				allergenesSansCaracteres = allergenes.replaceAll("\\[", "");
				allergenesSansCaracteres = allergenes.replaceAll("\\]", "");
				for (String allergene : allergenes.split(",")) {
					listeAllergenes.add(new Allergene(allergene.toLowerCase()));
				}
				produit.setListeAllergene(listeAllergenes);

				// Additifs
				String additifs = morceaux[31];
				ArrayList<Additif> listeAdditifs = new ArrayList<>();
				// Enlever caracteres speciaux
				String additifsSansCaracteres = additifs.replaceAll("\\s", "");
				additifsSansCaracteres = additifs.replaceAll("\\[", "");
				additifsSansCaracteres = additifs.replaceAll("\\]", "");
				for (String additif : additifs.split(",")) {
					listeAdditifs.add(new Additif(additif.toLowerCase()));
				}
				produit.setListeAdditifs(listeAdditifs);

				stock.ajouter(produit);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return stock;
	}
	/**
	 * Afficher tous les produits d'une marque
	 * @param stock
	 */
	public void afficherLesProduitsParMarque(Stock stock) {
		boolean flag = false;
		ArrayList<Produit> produits = stock.getListe();
		Scanner sc = new Scanner(System.in);
		System.out.println("Les produits de quelle marque souhaitez-vous voir ?");
		String choix = sc.nextLine();
		for (Produit produit : produits) {
			if(produit.getMarque().getNom().equals(choix)) {
				System.out.println(produit.toString());
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Aucun produit ne correspond à votre recherche.");
		}
	}
	/**
	 * Afficher les meilleurs produits par marque
	 * @param stock
	 */
	public void afficherLesMeilleursProduitsParMarque(Stock stock) {
		boolean flag = false;
		ArrayList<Produit> produits = stock.getListe();
		Scanner sc = new Scanner(System.in);
		System.out.println("Les meilleurs produits de quelle [marque] souhaitez-vous voir ?");
		String choix = sc.nextLine();
		for (Produit produit : produits) {
			if(produit.getMarque().getNom().equals(choix) && produit.getScoreNutritionnel() == 'a') {
				System.out.println(produit.toString());
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Aucun produit ne correspond à votre recherche.");
		}
	}
	
	/**
	 * Afficher les meilleurs produits par categorie
	 * @param stock
	 */
	public void afficherLesMeilleursProduitsParCategorie(Stock stock) {
		boolean flag = false;
		ArrayList<Produit> produits = stock.getListe();
		Scanner sc = new Scanner(System.in);
		System.out.println("Les meilleurs produits de quelle [catégorie] souhaitez-vous voir ?");
		String choix = sc.nextLine();
		for (Produit produit : produits) {
			if(produit.getCategorie().getLibelle().equals(choix) && produit.getScoreNutritionnel() == 'a') {
				System.out.println(produit.toString());
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Aucun produit ne correspond à votre recherche.");
		}
	}
	
	/**
	 * Afficher les meilleurs produits par categorie et par marque
	 * @param stock
	 */
	public void afficherLesMeilleursProduitsParCategorieEtParMarque(Stock stock) {
		boolean flag = false;
		ArrayList<Produit> produits = stock.getListe();
		Scanner sc = new Scanner(System.in);
		System.out.println("Les meilleurs produits de quelle [catégorie] souhaitez-vous voir ?");
		String choixCategorie = sc.nextLine();
		System.out.println("Et de quelle [marque] ?");
		String choixMarque = sc.nextLine();
		for (Produit produit : produits) {
			if(produit.getCategorie().getLibelle().equals(choixCategorie) && produit.getMarque().getNom().equals(choixMarque) && produit.getScoreNutritionnel() == 'a') {
				System.out.println(produit.toString());
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("Aucun produit ne correspond à votre recherche.");
		}
	}
	
	public void rechercherAllergenesLesPlusCourant(Stock stock) {
		ArrayList<Produit> produits = stock.getListe();
		ArrayList<Allergene> allergenesTotaux = new ArrayList<>();
		Map<Allergene,Integer> listeAllergene = new HashMap<>();
		for (Produit produit : produits) {
			ArrayList<Allergene> allergenes = produit.getListeAllergene();
			for (Allergene allergene : allergenes) {
				allergenesTotaux.add(allergene);
			}
		}	
		for (Allergene allergene : allergenesTotaux) {
			System.out.println(allergene.getLibelle());
		}
	}

	
	public void rechercherAdditifsLesPlusCourant(Stock stock) {
		ArrayList<Produit> produits = stock.getListe();
		ArrayList<Additif> additifsTotaux = new ArrayList<>();
		Map<Additif,Integer> listeAdditif = new HashMap<>();
		for (Produit produit : produits) {
			ArrayList<Additif> additifs = produit.getListeAdditifs();
			for (Additif additif : additifs) {
				additifsTotaux.add(additif);
			}
		}	
		for (Additif additif : additifsTotaux) {
			System.out.println(additif.getLibelle());
		}
	}

}
