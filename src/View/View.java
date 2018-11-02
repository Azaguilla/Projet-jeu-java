package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.ModelJeu.Jeu;
import Model.ModelMonstre.Monstre;
import Model.ModelPersonnage.Personnage;

public class View {
	
	/**
	 * Afficher le message
	 * @param Le message à afficher
	 */
	public void afficherUnMessage(String message)
	{
		System.out.println(message);
	}
	
	/**
	 * Affiche le choix de classe
	 * @return La classe choisie
	 */
	public int AfficherDemandeClasse()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez la classe de votre personnage : Chasseur [1], Guerrier [2], Magicien [3], Rodeur [4] -- Plus de détails [0]");
		int classe = sc.nextInt();
		
		return classe;
	}
	
	/**
	 * Affiche le choix de sexe, femme ou homme
	 * @return Le sexe choisi
	 */
	public String AfficherDemandeSexe()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez le sexe de votre personnage : Femme [F], Homme [M].");
		String sexe = sc.next();
		
		return sexe;
	}
	
	/**
	 * Affiche la demande du nom
	 * @return Le nom choisi
	 */
	public String AfficherDemandePersonnage()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choississez le nom de votre personnage :");
		String nom = sc.next();
		
		return nom;
	}
	
	/**
	 * Affiche le choix de déplacement, avancer ou reculer
	 * @return choix Le choix de déplacement
	 */
	public int choixDeplacement()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Comment voulez-vous vous déplacer ? \n Avancer[0] \n Reculer[1]");
		int choix = sc.nextInt();
		
		return choix;
	}
	
	/**
	 * Affiche le menu du choix des actions
	 * @param message Le message à afficher
	 * @param personnage Le personnage du joueur
	 * @return Le choix de l'action
	 */
	public int AfficherMenu(String message, Personnage personnage)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(message);
		System.out.println(personnage);
		
		System.out.println("Vous avez le choix entre diverses actions dans ce monde. Que voulez-vous faire ? \n "
				+ "Vous déplacer[0] - 1 heure \n "
				+ "Manger[1] - 1 heure \n "
				+ "Boire une potion[2] - 1 heure \n "
				+ "Attaquer[3] - 1 heure \n "
				+ "Lancer un sort[4] - 1 heure \n "
				+ "Nettoyer la case suivante[5] - 2 heures \n "
				+ "Examiner une case[6] - 1 heure \n "
				+ "Afficher des infos sur votre case actuelle[7] - gratuit \n "
				+ "Afficher des infos sur le jeu (simplifié)[8] - gratuit \n "
				+ "Passer le tour[9]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	/**
	 * Affiche les informations du jeu
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public void AfficheInfoJeu(Jeu jeu)
	{
		System.out.println("Voici la liste des cases et des monstres qui y sont placés:\n\n"+
		jeu.getCases() 
		+ "\n\n Le jeu : "+jeu.getNom()+ ". \nVous avez "+jeu.getNbJour()+" jours pour atteindre le bout de la carte."
		+ "Vous disposez d'encore "+jeu.getNbHeure()+" heures avant la fin de ce jour. Ci-dessus, vous pouvez voir l'inialisation du jeu.\n"
		+ "Attention, dorénavant, pour connaître les informations concernant les monstres et les cases, vous devrez dépenser une heure. Seules les informations de base du jeu\n"
		+ "ainsi que les informations concernant votre case actuelle seront gratuites.\n" );
	}
	
	/**
	 * Affiche le choix du monstre à attaquer
	 * @param monstres
	 * @return Le choix du monstre à attaquer
	 */
	public int afficherChoixMonstre(ArrayList<Monstre> monstres)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(monstres);
		
		System.out.println("Quel monstre veux-tu attaquer ? Indique son numéro de 0 à 2 \n"
				+ "Retour[-1]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	/**
	 * Affiche le choix de la case à examiner
	 * @param nbCases Le nombre de cases
	 * @return Le choix de la case à examiner
	 */
	public int afficherChoixCase(int nbCases)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nLe jeu est composé de "+nbCases+" cases.");
		
		nbCases = nbCases-1;
		
		System.out.println("Entrez le numéro de la case à étudier, en indiquant un nombre en 0 et "+nbCases+". \n"
				+ "Retour[-1]");
		
		int choix = sc.nextInt();
		
		return choix;
	}
	
	/**
	 * Affiche le choix d'attaquer à distance pour un chasseur
	 * @return Le choix d'attaque
	 */
	public int afficherChoixChasseur()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous êtes chasseur. Vous pouvez attaquer à distance. Voulez-vous attaquer d'une case supplémentaire ? Oui[0]/Non[1]");
		int choix = sc.nextInt();
		
		return choix;
	}
	
	/**
	 * Affiche le choix de la case à attaquer
	 * @return Le choix de la case à attaquer
	 */
	public int afficherChoixCaseChasseur()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous voulez attaquer la case précédente ou la case suivante ? Précédente[0]/Suivante[1]");
		int choix = sc.nextInt();
		
		return choix;
	}
}
