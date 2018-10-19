package jeu;

import java.util.Scanner;

public class RolePlayUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenue dans le Royaume de Dar Elnor.");
		String classe = "Mage";
		System.out.println("Choississez le nom de votre personnage :");
		String nom = sc.next();
		System.out.println("Choississez le sexe de votre personnage : Femme [F], Homme [M].");
		String sexe = sc.next();
		Personnage personnage = Magicien.getInstance(nom, sexe, classe);
		
		System.out.println(personnage.toString());
		
		Jeu jeu = new Jeu("Partie", personnage, 15);
		System.out.println(jeu.toString());
		jeu.afficheCases();
		
		LoupGarou loup1 = new LoupGarou("Grouf", "M", 50, 100, (double) (2), 4, 20, false);
		Monstre bb = loup1.naissance();
		
		System.out.println("Un nouveau bébé est né : "+bb);
		if (bb instanceof LoupGarou)
		{
			System.out.println("Le bébé est bien un Loup Garou.");
		}
		System.out.println(loup1.toString());
		loup1.ajouterForce();
		System.out.println(loup1.getForce());
		System.out.println(loup1.son());
		Plaine case1 = new Plaine(1, 2, 0);
		System.out.println(case1.toString());
		System.out.println("Affichage 1");
		case1.ajoutMonsre(loup1);
		case1.afficheCarac();
		case1.ajoutMonsre(bb);

		System.out.println("Affichage 2");
		case1.afficheCarac();
	}

}
