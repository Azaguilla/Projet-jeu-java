package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Jeu;
import Model.Monstre;
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
	
	public String choixDeplacement()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Comment voulez-vous vous déplacer ? \n Avancer[A] \n Reculer[R]");
		String choix = sc.next();
		
		return choix;
	}
	
	public int AfficherMenu(String message, Personnage personnage)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(message);
		System.out.println(personnage);
		
		System.out.println("Tu as le choix entre diverses actions dans ce monde. Que veux-tu faire ? \n "
				+ "Te déplacer[0] \n "
				+ "Manger[1] \n "
				+ "Attaquer[2] \n "
				+ "Lancer un sort[3] \n "
				+ "Nettoyer une case[4] \n "
				+ "Examiner une case[5] \n "
				+ "Afficher des infos sur ta case actuelle[6] \n "
				+ "Afficher des infos sur le jeu (simplifié)[7] \n "
				+ "Passer le tour[8]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	public void AfficheInfoJeu(Jeu jeu)
	{
		System.out.println("Le jeu : "+jeu.getNom()+ ". \n Vous avez "+jeu.getNbJour()+" jours pour atteindre le bout de la carte. "
		+ "Vous disposez d'encore "+jeu.getNbHeure()+" heures avant la fin de ce jour. \n Voici la liste des cases et des monstres qui y sont placés:\n\n"+
		jeu.getCases() + "\n\n");
	}
	
	public int afficherChoixMonstre(ArrayList<Monstre> monstres)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(monstres);
		
		System.out.println("Quel monstre veux-tu attaquer ? Indique son numéro de 0 à 2 \n"
				+ "Retour[3]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
}
