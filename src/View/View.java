package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Jeu;
import Model.Monstre;
import Model.Personnage;

public class View {
	
	public void afficherUnMessage(String message)
	{
		System.out.println(message);
	}
	
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
				+ "Te déplacer[0] - 1 heure \n "
				+ "Manger[1] - 1 heure \n "
				+ "Boire une potion[2] - 1 heure \n "
				+ "Attaquer[3] - 1 heure \n "
				+ "Lancer un sort[4] - 1 heure \n "
				+ "Nettoyer la case suivante[5] - 1 heure \n "
				+ "Examiner une case[6] - 1 heure \n "
				+ "Afficher des infos sur ta case actuelle[7] - gratuit \n "
				+ "Afficher des infos sur le jeu (simplifié)[8] - gratuit \n "
				+ "Passer le tour[9]");
		
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
				+ "Retour[-1]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	public int afficherChoixCase(int nbCases)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Le jeu est composé de "+nbCases+" cases.\n");
		
		System.out.println("Entrez le numéro de la case à étudier \n"
				+ "Retour[-1]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	public int afficherChoixChasseur()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous êtes chasseur. Vous pouvez attaquer à distance. Voulez-vous attaquer d'une case supplémentaire ? Oui[0]/Non[1]");
		int choix = sc.nextInt();
		
		return choix;
	}
	
	public int afficherChoixCaseChasseur()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous voulez attaquer la case précédente ou la case suivante ? Précédente[0]/Suivante[1]");
		int choix = sc.nextInt();
		
		return choix;
	}
}
