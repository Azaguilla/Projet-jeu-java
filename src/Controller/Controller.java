package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Case;
import Model.Chasseur;
import Model.Jeu;
import Model.Model;
import Model.Monstre;
import Model.Personnage;
import View.View;

public class Controller {
	private View vue;
	private Model model;
	private Jeu jeu;
	private Random rand = new Random();
	
	/**
	 * Constructeur permettant d'informer le controller de la vue et du model principal
	 * @param vue La classe qui permettra de g�n�rer la vue 
	 * @param model La classe qui permettra de manipuler les donn�es
	 */
	public Controller(View vue, Model model) {
		super();
		this.vue = vue;
		this.model = model;
	}
	
	/**
	 * Lance le d�but du jeu
	 * Affiche et saisi les informations a entrer par l'utilisateur
	 * Initialise le personnage
	 */
	public void debutJeu()
	{
		int classe = this.vue.AfficherDemandeClasse();
		while(classe > 4 || classe < 0)
		{
			this.vue.afficherUnMessage("Saisie incorrecte.");
			classe = this.vue.AfficherDemandeClasse();
		}
		while(classe == 0)
		{
			this.vue.afficherUnMessage("Descriptif des classes :\n Le Chasseur est capable d'attaquer � distance,\n Le magicien poss�de un bonus de d�g�ts lorsqu'il lance un sort, \n le Guerrier poss�de un bonus de d�g�ts au corps-�-corps,\n le R�deur a 50% de chance d'infliger des coups critiques et 50% de chance d'esquiver un coup.\n\n");
			classe = this.vue.AfficherDemandeClasse();
		}
		
		
		String nom = this.vue.AfficherDemandePersonnage();
		
		String sexe = this.vue.AfficherDemandeSexe();
		
		Personnage personnage = this.model.creerPersonnage(classe, sexe, nom);
		
		
		this.initialisation(personnage);
	}
	
	/**
	 * Initialise le jeu
	 * Cr�e les cases, les monstres et les assemble dans le jeu
	 * Affiche une qu�te au hasard et un message de bienvenue
	 * Appel la m�thode d'actions
	 * @param personnage Le personnage du joueur
	 */
	public void initialisation(Personnage personnage)
	{
		Monstre[] monstres = this.model.creerMonstres();
		Case[] cases = this.model.creerCases(monstres);
		this.jeu = this.model.creerJeu(cases, personnage);
		
		this.vue.AfficheInfoJeu(this.jeu);
		String quete = null;
		int n = rand.nextInt(4);
		switch (n)
		{
			case 0: quete = "Le roi est tr�s malade. Le Mestre de votre village a trouv� une plante m�dicinale capable de soigner la maladie du roi. Il vous charge d�apporter cette plante au ch�teau qui se trouve � "+this.jeu.getCases().size()+" lieux du village. L'avenir du Royaume repose entre vos main, h�ros !";
					break;
			case 1: quete = "Vous vous r�veillez seul dans les bois sans aucun souvenir. Vous croisez un chasseur qui vous indique la direction du village le plus proche, se trouvant � "+this.jeu.getCases().size()+" lieux d'ici. \nRien n'est s�r mais peut-�tre ce village est-il le v�tre ?";
					break;
			case 2: quete = "Apr�s une chasse dans les bois, vous rentrez vers votre village, mais lorsque vous vous en approchez vous entendez du bruit et des cris de plus en plus fort. Une bande de brigands \nest en train de ravager le village, volant et pillant les villageois. L�attaque �tait bien organis�e et personne n�a rien vu venir mais les gardes ont tout de m�me r�ussi � capturer un des brigands \nqui vous indique l'emplacement de leur campement qui se trouve � "+this.jeu.getCases().size()+" lieux du village. Vous d�cidez de partir en chasse�";
					break;
			case 3: quete = "Dans les bois vous rencontrez un vieil homme qui poss�de une carte indiquant un tr�sor enfoui dans des ruines se trouvant � "+this.jeu.getCases().size()+" lieux. C�est un voyage bien trop dangereux \npour un vieil homme comme lui, il vous propose donc d�aller chercher ce tr�sor pour lui en �change de la moiti� du butin. Comment refuser une telle proposition ?";
					break;
		}
		int choix = this.vue.AfficherMenu("Bienvenue dans le Royaume de Dar Elnor, " + personnage.getNom() + ".\n\n"+quete+"\n\n", personnage);
		actions(choix);
	}
	
	/**
	 * Permet de choisir une action � effectuer
	 * V�rifie que l'entr�e est correct
	 * @param action L'action choisie
	 */
	public void actions(int action)
	{
		int choix;
		switch (action)
		{
			case 0: 
				this.seDeplacer();
				break;
			case 1: 
				this.manger();
				break;
			case 2: 
				this.boirePotion();
				break;
			case 3: 
				this.attaquer();
				break;
			case 4: 
				this.lancerSort();
				break;
			case 5: 
				this.nettoyerCase();
				break;
			case 6: 
				this.examinerCase();
				break;
			case 7: 
				this.afficheInfosCaseActuelle();
				break;
			case 8:
				this.afficheInfoJeu();
				break;
			case 9:
				this.passerTour();
				break;
			default:
				this.vue.afficherUnMessage("Veuillez recommencer");
				choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
				break;
		}
	}
	
	/**
	 * Permet au personnage de se d�placer selon son choix
	 * V�rifie que l'entr�e du choix est correcte
	 */
	public void seDeplacer()
	{
		int choixDeplacement = this.vue.choixDeplacement();

		if (choixDeplacement != 0)
		{
			if(choixDeplacement != 1)
			{
				this.vue.afficherUnMessage("Veuillez entrer un caract�re valide.");
				this.seDeplacer();
			}
		}

		String deplacement = this.model.deplacerPersonnage(this.jeu.getJoueur(), choixDeplacement, this.jeu);
		String messageCsq = this.jeu.consequenceAction();
		
		this.verifEtatJeu(deplacement+messageCsq);
	}
	
	/**
	 * Permet au personnage de manger
	 */
	public void manger()
	{
		String message = this.model.manger(this.jeu.getJoueur());
		String messageCsq = this.jeu.consequenceAction();
		this.verifEtatJeu(message+messageCsq);
	}
	
	/**
	 * Permet au personnage de boire une potion
	 */
	public void boirePotion()
	{
		String message = this.model.boirePotion(this.jeu.getJoueur());
		String messageCsq = this.jeu.consequenceAction();
		this.verifEtatJeu(message+messageCsq);
	}
	
	/**
	 * Permet au personnage d'attaquer
	 * Si le personnage est chasseur, propose d'attaquer un monstre d'une case adjacente
	 * Demande a l'utilisateur de choisir le monstre � attaquer et v�rifie que la saisie est correcte
	 */
	public void attaquer()
	{
		int numCase = this.jeu.getJoueur().getPosition();
		// Si le joueur est de la classe chasseur, il peut attaquer � distance
		if(this.jeu.getJoueur() instanceof Chasseur)
		{
			int choix = this.vue.afficherChoixChasseur();
			switch(choix)
			{
				case 0:
					int choixCase = this.vue.afficherChoixCaseChasseur();
					if(choixCase == 0)
					{
						numCase = this.jeu.getJoueur().getPosition()-1;
					}
					else
					{
						numCase = this.jeu.getJoueur().getPosition()+1;
					}
					break;
				case 1:
					numCase = this.jeu.getJoueur().getPosition();
					break;
				default:
					this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions(3);
					break;
			}
		}
		
		// On r�cup�re les monstres en fonction de la case
		ArrayList<Monstre> monstres = this.model.recupererMonstre(numCase, this.jeu);
		int numMonstreAttaque = this.vue.afficherChoixMonstre(monstres);
		if(numMonstreAttaque == -1)
		{
			int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
			actions(choix);
		}
		else
		{
			if(numMonstreAttaque > monstres.size()-1 || numMonstreAttaque < 0)
			{
				this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(3);
			}
			else
			{
				Monstre monstreAttaque = monstres.get(numMonstreAttaque);
				String message = this.model.attaquerMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);

				String messageCsq = this.jeu.consequenceAction();
				this.verifEtatJeu(message+"\n"+messageCsq);
			}
		}
	}
	
	/**
	 * Permet au personnage de lancer un sort
	 * Demande a l'utilisateur de choisir le monstre � attaquer et v�rifie que la saisie est correcte
	 */
	public void lancerSort()
	{
		int numCase = this.jeu.getJoueur().getPosition();
		ArrayList<Monstre> monstres = this.model.recupererMonstre(numCase, this.jeu);
		int numMonstreAttaque = this.vue.afficherChoixMonstre(monstres);
		if(numMonstreAttaque == -1)
		{
			int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
			actions(choix);
		}
		else
		{
			if(numMonstreAttaque > monstres.size()-1 || numMonstreAttaque < 0)
			{
				this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(4);
			}
			else
			{
				Monstre monstreAttaque = monstres.get(numMonstreAttaque);
				String message = this.model.lancerSortSurMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);
				
				String messageCsq = this.jeu.consequenceAction();
				this.verifEtatJeu(message+"\nVous avez perdu 5 pts d'�nergie. Il vous reste "+this.jeu.getJoueur().getEnergie()+" pts d'�nergie."+messageCsq);
			}
		}
	}
	
	/**
	 * Permet au personnage de nettoyer la case
	 */
	public void nettoyerCase()
	{
		Personnage personnage = this.jeu.getJoueur();
		Case laCase = this.jeu.recupererCase(personnage.getPosition()+1);
		String message = this.jeu.getJoueur().nettoyer(laCase);
		String messageCsq = this.jeu.consequenceAction();
		this.verifEtatJeu(message+messageCsq);
	}
	
	/**
	 * Permet au personnage d'examiner une case de son choix
	 */
	public void examinerCase()
	{
		this.jeu.consequenceAction();
		int nbCase = this.jeu.getCases().size();
		int laCase = this.vue.afficherChoixCase(nbCase);
		if(laCase == -1)
		{
			int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
			actions(choix);
		}
		else
		{
			if(laCase > nbCase-1 || laCase < 0)
			{
				this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(5);
			}
			else
			{
				this.jeu.consequenceAction();
				String infos = this.jeu.getCases().get(laCase).toString();
				String messageCsq = this.jeu.consequenceAction();
				this.verifEtatJeu(infos+messageCsq);
			}
		}
	}
	
	/**
	 * Permet d'afficher les informations de la case actuelle
	 */
	public void afficheInfosCaseActuelle()
	{
		Personnage personnage = this.jeu.getJoueur();
		Case laCase = this.jeu.recupererCase(personnage.getPosition());
		String infosCase = this.jeu.getJoueur().examinerCase(laCase);
		
		this.verifEtatJeu(infosCase+"\n");
	}
	
	/**
	 * Permet d'afficher les informations du jeu
	 */
	public void afficheInfoJeu()
	{
		String infos = this.jeu.infosJeu();
		
		this.verifEtatJeu(infos);
	}
	
	/**
	 * Permet au personnage de passer son tour
	 */
	public void passerTour()
	{	
		String message = this.jeu.ChangerTour();
		
		this.verifEtatJeu(message+"\nVous avez pass� votre tour. \nVous vous endormez sous un arbre. La lune appara�t puis se voile, laissant place au Soleil. Un nouveau jour commence.\n");
	}
	
	/**
	 * Si le personnage est toujours vivant, qu'il n'a pas atteind son objectif et qu'il reste du temps, propose a nouveau les actions
	 * Sinon, lance la fin du jeu
	 * @param message
	 */
	public void verifEtatJeu(String message)
	{
		boolean vivant = this.model.personnageEstBienVivant(jeu);
		boolean pasArrive = this.model.personnageNEstPasSurObjectif(jeu);
		boolean resteDuTemps = this.model.tempsNEstPasEcoule(jeu);
		
		if (vivant && pasArrive && resteDuTemps)
		{
			int choix = this.vue.AfficherMenu(message, this.jeu.getJoueur());
			actions(choix);
		}
		else
		{
			this.finDuJeu();
		}
	}
	
	/**
	 * Affiche la fin du jeu
	 */
	private void finDuJeu()
	{
		if (this.jeu.getJoueur().getVie() <= 0)
			this.vue.afficherUnMessage("Vous �tes mort...");
			/*Afficher stats*/
			else
			{
				if(this.jeu.getJourCourant() == this.jeu.getNbJour())
					this.vue.afficherUnMessage("Votre temps est �coul�...");
					/*Afficher stats*/
					else
					{
						this.vue.afficherUnMessage("Vous venez d'atteindre la case "+jeu.getCases().size()+", F�licitation! Vous avez r�ussi!");
						/*Afficher stats*/
					}
			}
	}
}
