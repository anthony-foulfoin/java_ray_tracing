package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Cette classe gere les entrees-sorties liees au clavier lors du deroulement
 * du jeu
 *
 */
public class GetInput {
	
	/**
	 * Le caractere representant le oui
	 */
	public static final String OUI = "o";

	/**
	 * Le caractere representant le non
	 */
	public static final String NON = "n";

	/**
	 * Methode permettant d'obtenir un booleen et d'afficher un texte
	 * @param s Le texte a afficher
	 * @return True si l'utilisateur saisi O, false sinon
	 */
	public static boolean getBoolean(String s) {

		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		String lu;
		boolean OK = false;
		boolean retour = false;
		System.out.print(s);
		while (!OK) {
			try {
				lu = reader.readLine();
				if (lu.equals(OUI) || lu.equals(OUI.toUpperCase())) {
					retour = true;
					OK = true;
				} else if (lu.equals(NON) || lu.equals(NON.toUpperCase())) {
					retour = false;
					OK = true;
				} else {
					System.out.print("Erreur, veuillez saisir " + OUI+ " pour OUI ou " + NON + " pour non : ");
				}
			} catch (Exception e) {

				System.out.print("\nErreur : Veuillez ressaisir une lettre : ");
			}
		}
		return retour;
	}

	/**
	 * Methode permettant d'obtenir un entier et d'afficher un texte
	 * @param s Le texte a affcher
	 * @return l'entier saisi par l'utilisateur
	 */
	public static int getInt(String s) {

		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		int lu = 0;
		boolean OK = false;
		System.out.print(s);

		while (!OK) {
			try {
				lu = Integer.parseInt(reader.readLine());
				OK = true;
			} catch (Exception e) {
				System.out.print("\nErreur : Veuillez ressaisir un entier : ");
				OK = false;
			}
		}
		return lu;
	}
	/**
	 * Methode permettant d'obtenir un String et d'afficher un texte
	 * @param s Le texte a afficher
	 * @return La chaine de caractere saisie par l'utilisateur
	 */
	public static String getString(String s) {

		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		String lu = "";
		boolean OK = false;
		System.out.print(s);

		while (!OK) {
			try {
				lu = reader.readLine();
				OK = true;
			} catch (Exception e) {
				System.out.print("\nErreur : Veuillez ressaisir une chaine de caracteres : ");
				OK = false;
			}
		}
		return lu;
	}
	/**
	 * Methode permettant d'obtenir un caractere et d'afficher un texte
	 * @param s Le texte a afficher
	 * @return Le caractere saisi par l'utilisateur
	 */
	public static char getChar(String s) {

		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		String lu;
		char retour = '0';
		boolean OK = false;
		System.out.print(s);

		while (!OK) {
			try {
				lu = reader.readLine();
				if (lu.length() == 1) {
					retour = lu.charAt(0);
					OK = true;
				}
				else System.out.print("\nErreur : Veuillez ressaisir un caractere : ");
			} catch (Exception e) {
				System.out.print("\nErreur : Veuillez ressaisir un caractere : ");
				OK = false;
			}
		}
		return retour;
	}
}
