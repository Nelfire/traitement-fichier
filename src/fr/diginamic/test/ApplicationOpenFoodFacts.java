package fr.diginamic.test;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
Creez une classe exécutable ApplicationOpenFoodFacts avec un menu permettant
o de rechercher les meilleurs produits pour une Marque donnée
o de rechercher les meilleurs produits pour une Catégorie donnée
o de rechercher les meilleurs produits par Marque et par Catégorie
o d’afficher les allergènes les plus courants avec le nb de produits dans lesquels ils
apparaissent.
o d’afficher les additifs les plus courants avec le nb de produits dans lesquels ils
apparaissent.
 *
 */
public class ApplicationOpenFoodFacts {

	public static void main(String[] args) throws IOException {
		Utilitaire service = new Utilitaire();
		Stock stock = service.loadStock();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		while (flag != true) {
			System.out.println("----------------------------------------------");
			System.out.println("0 - Sortir");
			System.out.println("1 - Afficher les produits par marque");
			System.out.println("2 - Afficher les meilleurs produits pour une Marque donnée");
			System.out.println("3 - Afficher les meilleurs produits pour une Catégorie donnée");
			System.out.println("4 - Afficher les meilleurs produits par Marque et par Catégorie");
			System.out.println("5 - Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent");
			System.out.println("6 - Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent");
			System.out.println("----------------------------------------------");

			int choixClient = sc.nextInt();
			
			
			switch (choixClient) {
			case 0:
				System.out.println("A bientôt !");
				flag = true;
				break;
			case 1:
				service.afficherLesProduitsParMarque(stock);
				break;
			case 2:
				service.afficherLesMeilleursProduitsParMarque(stock);
				break;
			case 3:
				service.afficherLesMeilleursProduitsParCategorie(stock);
				break;
			case 4:
				service.afficherLesMeilleursProduitsParCategorieEtParMarque(stock);
				break;
			case 5:
				service.rechercherAllergenesLesPlusCourant(stock);
				break;
			case 6:
				service.rechercherAdditifsLesPlusCourant(stock);
				break;
			default:
				System.out.println("Erreur de saisie");
				break;
			}
		}
		sc.close();
	}
}
