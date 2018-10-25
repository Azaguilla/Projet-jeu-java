package View;

import java.util.Scanner;

import Model.Jeu;
import Model.Personnage;

public class View {
	
	public int AfficherDemandeClasse()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez la classe de votre personnage : Chasseur [1], Guerrier [2], Magicien [3], Rodeur [4] -- Plus de détails [0]");
		int classe = sc.nextInt();
		
		return classe;
	}
	
	public String AfficherDemandeSexe()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez le sexe de votre personnage : Femme [F], Homme [M].");
		String sexe = sc.next();
		
		return sexe;
	}
	
	public String AfficherDemandePersonnage()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez le nom de votre personnage :");
		String nom = sc.next();
		
		return nom;
	}
	
	public int AfficherMenu(String message, Personnage personnage)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(message);
		System.out.println(personnage);
		
		System.out.println("Tu as le choix entre diverses actions dans ce monde. Que veux-tu faire ? \n"
				+ "Avancer[1] \n "
				+ "Reculer[2] \n "
				+ "Manger[3] \n "
				+ "Attaquer[4] \n "
				+ "Lancer un sort[5] \n "
				+ "Nettoyer une case[6] \n "
				+ "Examiner une case[7] \n "
				+ "Afficher des infos sur ta case actuelle[8] \n "
				+ "Afficher les informations de ton personnage[9] \n "
				+ "Passer le tour[10]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	public void AfficheInfoJeu(Jeu jeu)
	{
		System.out.println("Le jeu : "+jeu.getNom()+ ". \n Vous avez "+jeu.getNbJour()+" jours pour atteindre le bout de la carte. "
				+ "Vous disposez d'encore "+jeu.getNbHeure()+" heures avant la fin de ce jour. \n Voici la liste des cases et des monstres qui y sont placés:"+
							jeu.getCases());
	}
}
