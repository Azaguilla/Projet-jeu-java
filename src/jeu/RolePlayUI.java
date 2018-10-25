package jeu;

import java.util.Scanner;

public class RolePlayUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez la classe de votre personnage : Chasseur [1], Guerrier [2], Magicien [3], Rodeur [4] -- Plus de détails [0]");
		int tmp_classe = sc.nextInt();
		System.out.println("Choississez le nom de votre personnage :");
		String nom = sc.next();
		System.out.println("Choississez le sexe de votre personnage : Femme [F], Homme [M].");
		char sexe = sc.useDelimiter(pattern);
		String classe;
		
		System.out.println("Bienvenue dans le Royaume de Dar Elnor, " + nom + ".\n");
		System.out.println("Scénario...\n");
		
		switch(tmp_classe)
		{
			case 1:	if(sexe == 'M') System.out.println("Agile chasseur, ");
					if(sexe == 'F') System.out.println("Agile chasseresse, ");
					classe = "chasseur";
					break;
			case 2:	if(sexe == 'M') System.out.println("Grand guerrier, ");
					if(sexe == 'F') System.out.println("Grande guerriere, ");
					classe = "guerrier";
					break;
			case 3: if(sexe == 'M') System.out.println("Puissant magicien, ");
					if(sexe == 'F') System.out.println("Puissante magicienne, ");
					classe = "mage";
					break;
			case 4:	if(sexe == 'M') System.out.println("Sournois rôdeur, ");
					if(sexe == 'F') System.out.println("Sournoise rôdeuse, ");
					classe = "rodeur";
					break;
		}
		
		Personnage personnage = Magicien.getInstance(nom, sexe, classe);
		
		int n = rand.nextInt(3);
		switch (n)
		{
			case 0: System.out.println("quête 1...");
					break;
			case 1: System.out.println("quête 2...");
					break;
			case 2: System.out.println("quête 3...");
					break;
		}
		
		System.out.println(personnage.toString());
		
		/*initialisation*/
		
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
		System.out.println(jeu.toString());
		System.out.println(case1.toString());
		System.out.println("Affichage 1");
		case1.ajoutMonsre(loup1);
		case1.afficheCarac();
		case1.ajoutMonsre(bb);

		System.out.println("Affichage 2");
		case1.afficheCarac();
	}

}
