package Controller;

import java.util.ArrayList;
import java.util.Random;

import View.View;
import Model.Model;
import Model.ModelCase.Case;
import Model.ModelJeu.Jeu;
import Model.ModelMonstre.Monstre;
import Model.ModelPersonnage.Chasseur;
import Model.ModelPersonnage.Personnage;

public class Controller {
	private View vue;
	private Model model;
	private Jeu jeu;
	private Random rand = new Random();
	
	/**
	 * Constructeur permettant d'informer le controller de la vue et du model principal
	 * @param vue La classe qui permettra de générer la vue 
	 * @param model La classe qui permettra de manipuler les données
	 */
	public Controller(View vue, Model model) {
		super();
		this.vue = vue;
		this.model = model;
	}
	
	/**
	 * Lance le début du jeu
	 * Affiche et saisi les informations a entrer par l'utilisateur
	 * Initialise le personnage
	 */
	public void debutJeu()
	{
		boolean continuer = false;
		String classe = this.vue.AfficherDemandeClasse();
		while (continuer == false)
		{
			switch (classe)
			{
				case "0":
					this.vue.afficherUnMessage("Descriptif des classes :\n Le Chasseur est capable d'attaquer à distance,\n Le magicien possède un bonus de dégâts lorsqu'il lance un sort, \n le Guerrier possède un bonus de dégâts au corps-à-corps,\n le Rôdeur a 50% de chance de faire un coup critique et infliger le double de dégâts et 50% de chance d'esquiver une attaque et prendre seulement la moitié des dégâts.\n\n");
					classe = this.vue.AfficherDemandeClasse();
					continuer = false;
					break;
				case "1":
					continuer = true;
					break;
				case "2":
					continuer = true;
					break;
				case "3":
					continuer = true;
					break;
				case "4":
					continuer = true;
					break;
				default:
					this.vue.afficherUnMessage("Saisie incorrecte.");
					classe = this.vue.AfficherDemandeClasse();
					continuer = false;
					break;
			}
		}
		
		String nom = this.vue.AfficherDemandePersonnage();
		
		String sexe = this.vue.AfficherDemandeSexe();
		
		Personnage personnage = this.model.creerPersonnage(classe, sexe, nom);
		
		
		this.initialisation(personnage);
	}
	
	/**
	 * Initialise le jeu
	 * Crée les cases, les monstres et les assemble dans le jeu
	 * Affiche une quête au hasard et un message de bienvenue
	 * Appel la méthode d'actions
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
			case 0: quete = "Le roi est très malade. Le Mestre de votre village a trouvé une plante médicinale capable de soigner la maladie du roi. Il vous charge d’apporter cette plante au château qui se trouve à "+this.jeu.getCases().size()+" lieux du village. L'avenir du Royaume repose entre vos main, héros !";
					break;
			case 1: quete = "Vous vous réveillez seul dans les bois sans aucun souvenir. Vous croisez un chasseur qui vous indique la direction du village le plus proche, se trouvant à "+this.jeu.getCases().size()+" lieux d'ici. \nRien n'est sûr mais peut-être ce village est-il le vôtre ?";
					break;
			case 2: quete = "Après une chasse dans les bois, vous rentrez vers votre village, mais lorsque vous vous en approchez vous entendez du bruit et des cris de plus en plus fort. Une bande de brigands \nest en train de ravager le village, volant et pillant les villageois. L’attaque était bien organisée et personne n’a rien vu venir mais les gardes ont tout de même réussi à capturer un des brigands \nqui vous indique l'emplacement de leur campement qui se trouve à "+this.jeu.getCases().size()+" lieux du village. Vous décidez de partir en chasse…";
					break;
			case 3: quete = "Dans les bois vous rencontrez un vieil homme qui possède une carte indiquant un trésor enfoui dans des ruines se trouvant à "+this.jeu.getCases().size()+" lieux. C’est un voyage bien trop dangereux \npour un vieil homme comme lui, il vous propose donc d’aller chercher ce trésor pour lui en échange de la moitié du butin. Comment refuser une telle proposition ?";
					break;
		}
		String choix = this.vue.AfficherMenu("Bienvenue dans le Royaume de Dar Elnor, " + personnage.getNom() + ".\n\n"+quete+"\n\n", personnage);
		actions(choix);
	}
	
	/**
	 * Permet de choisir une action à effectuer
	 * Vérifie que l'entrée est correct
	 * @param action L'action choisie
	 */
	public void actions(String action)
	{
		String choix;
		switch (action)
		{
			case "0": 
				this.seDeplacer();
				break;
			case "1": 
				this.manger();
				break;
			case "2": 
				this.boirePotion();
				break;
			case "3": 
				this.attaquer();
				break;
			case "4": 
				this.lancerSort();
				break;
			case "5": 
				this.nettoyerCase();
				break;
			case "6": 
				this.examinerCase();
				break;
			case "7": 
				this.afficheInfosCaseActuelle();
				break;
			case "8":
				this.afficheInfoJeu();
				break;
			case "9":
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
	 * Permet au personnage de se déplacer selon son choix
	 * Vérifie que l'entrée du choix est correcte
	 */
	public void seDeplacer()
	{
		String choixDeplacement = this.vue.choixDeplacement();

		switch(choixDeplacement)
		{
			case "0":
				//On continue
				break;
			case "1":
				//On continue
				break;
			default:
				this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions("0");
				break;
		}

		String deplacement = this.model.deplacerPersonnage(this.jeu.getJoueur(), choixDeplacement, this.jeu);
		String messageCsq = this.jeu.consequenceAction(1);
		
		this.verifEtatJeu(deplacement+messageCsq);
	}
	
	/**
	 * Permet au personnage de manger
	 */
	public void manger()
	{
		String message = this.model.manger(this.jeu.getJoueur());
		String messageCsq = this.jeu.consequenceAction(1);
		this.verifEtatJeu(message+messageCsq);
	}
	
	/**
	 * Permet au personnage de boire une potion
	 */
	public void boirePotion()
	{
		String message = this.model.boirePotion(this.jeu.getJoueur());
		String messageCsq = this.jeu.consequenceAction(1);
		this.verifEtatJeu(message+messageCsq);
	}
	
	/**
	 * Permet au personnage d'attaquer
	 * Si le personnage est chasseur, propose d'attaquer un monstre d'une case adjacente
	 * Demande a l'utilisateur de choisir le monstre à attaquer et vérifie que la saisie est correcte
	 */
	public void attaquer()
	{
		int numCase = this.jeu.getJoueur().getPosition();
		// Si le joueur est de la classe chasseur, il peut attaquer à distance
		if(this.jeu.getJoueur() instanceof Chasseur)
		{
			String choix = this.vue.afficherChoixChasseur();
			switch(choix)
			{
				case "0":
					boolean continuer = false;
					while(continuer == false)
					{
						String choixCase = this.vue.afficherChoixCaseChasseur();
						switch (choixCase)
						{
							case "0":
								continuer = true;
								numCase = this.jeu.getJoueur().getPosition()-1;
								if (numCase == -1)
								{
									this.vue.afficherUnMessage("\n\nVous ne pouvez pas attaquer au-delà des frontières !\n");
									continuer =  false;
								}
								break;
							case "1":
								continuer = true;
								numCase = this.jeu.getJoueur().getPosition()+1;
								if (numCase == 20)
								{
									this.vue.afficherUnMessage("\n\nVous ne pouvez pas attaquer au-delà des frontières !\n");
									continuer =  false;
								}
								break;
							default:
								this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
								break;
						}
					}
					break;
				case "1":
					numCase = this.jeu.getJoueur().getPosition();
					break;
				default:
					this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions("3");
					break;
			}
		}
		
		// On récupère les monstres en fonction de la case
		ArrayList<Monstre> monstres = this.model.recupererMonstre(numCase, this.jeu);
		String numMonstreAttaque = this.vue.afficherChoixMonstre(monstres);
		try 
		{
			int numMonstre = Integer.parseInt(numMonstreAttaque);
			if(numMonstre == -1)
			{
				String choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
			}
			else
			{
				if(numMonstre > monstres.size()-1 || numMonstre < 0)
				{
					this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions("3");
				}
				else
				{
					Monstre monstreAttaque = monstres.get(numMonstre);
					String message = this.model.attaquerMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);

					String messageCsq = this.jeu.consequenceAction(1);
					this.verifEtatJeu(message+"\n"+messageCsq);
				}
			}
			
		}
		catch(Exception e)
		{
			this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
			actions("3");
		}
	}
	
	/**
	 * Permet au personnage de lancer un sort
	 * Demande a l'utilisateur de choisir le monstre à attaquer et vérifie que la saisie est correcte
	 */
	public void lancerSort()
	{
		int numCase = this.jeu.getJoueur().getPosition();
		ArrayList<Monstre> monstres = this.model.recupererMonstre(numCase, this.jeu);
		
		String numMonstreAttaque = this.vue.afficherChoixMonstre(monstres);
		try 
		{
			int numMonstre = Integer.parseInt(numMonstreAttaque);
			if(numMonstre == -1)
			{
				String choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
			}
			else
			{
				if(numMonstre > monstres.size()-1 || numMonstre < 0)
				{
					this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions("4");
				}
				else
				{
					Monstre monstreAttaque = monstres.get(numMonstre);
					String message = this.model.lancerSortSurMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);
					
					String messageCsq = this.jeu.consequenceAction(1);
					this.verifEtatJeu(message+"\nVous avez perdu 5 pts d'énergie. Il vous reste "+this.jeu.getJoueur().getEnergie()+" pts d'énergie."+messageCsq);
				}
			}
			
		}
		catch(Exception e)
		{
			this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
			actions("4");
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
		String messageCsq = this.jeu.consequenceAction(2);
		this.verifEtatJeu(message+messageCsq);
	}
	
	/**
	 * Permet au personnage d'examiner une case de son choix
	 */
	public void examinerCase()
	{
		int nbCase = this.jeu.getCases().size();
		String laCase = this.vue.afficherChoixCase(nbCase);
		try 
		{
			int numCase = Integer.parseInt(laCase);
			if(numCase == -1)
			{
				String choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
			}
			else
			{
				if(numCase > nbCase-1 || numCase < 0)
				{
					this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions("6");
				}
				else
				{
					String infos = this.jeu.getCases().get(numCase).toString();
					String messageCsq = this.jeu.consequenceAction(1);
					this.verifEtatJeu(infos+messageCsq);
				}
			}
			
		}
		catch(Exception e)
		{
			this.vue.afficherUnMessage("\n\nSaisie incorrecte, veuillez recommencer.\n");
			actions("6");
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
		
		this.verifEtatJeu("\nVous avez passé votre tour. \nVous vous endormez sous un arbre. La lune apparaît puis se voile, laissant place au Soleil. Un nouveau jour commence.\n\n"+message);
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
			String choix = this.vue.AfficherMenu(message, this.jeu.getJoueur());
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
			this.vue.afficherUnMessage("\n------ VOUS ETES MORT ----- \nMalheureusement, les blessures et l'épuisement aura eu raison de vous. Au loin, vous voyez votre objectif. \nVous n'étiez pas si loin, mais vous rencontrez la mort avant d'y parvenir.");
			/*Afficher stats*/
			else
			{
				if(this.jeu.getJourCourant() == this.jeu.getNbJour())
					this.vue.afficherUnMessage("\n------ VOTRE TEMPS EST ECOULE ------ \nVous avez tenté par tous les moyens d'arriver à temps. Malheureusement, lorsque vous arriverez, vous savez qu'il sera trop tard.");
					/*Afficher stats*/
					else
					{
						this.vue.afficherUnMessage("\n------ FELICITATION ------ \nVous venez d'atteindre la case "+jeu.getCases().size()+", c'est ici que se termine votre histoire ! Et elle se terminera bien, pour cette fois.");
						/*Afficher stats*/
					}
			}
	}
}
