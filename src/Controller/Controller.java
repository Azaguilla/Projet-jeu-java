package Controller;

import java.util.ArrayList;

import Model.Case;
import Model.Chasseur;
import Model.Jeu;
import Model.Model;
import Model.Monstre;
import Model.Personnage;
import Model.Rodeur;
import View.View;

public class Controller {
	private View vue;
	private Model model;
	private Jeu jeu;
	
	public Controller(View vue, Model model) {
		super();
		this.vue = vue;
		this.model = model;
	}
	
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
		while(!(nom instanceof String))
		{
			this.vue.afficherUnMessage("Veuillez entrer une cha�ne de caract�re.");
			nom = this.vue.AfficherDemandePersonnage();
		}
		
		String sexe = this.vue.AfficherDemandeSexe();
		while(!(sexe instanceof String))
		{
			this.vue.afficherUnMessage("Veuillez entrer une cha�ne de caract�re.");
			sexe = this.vue.AfficherDemandeSexe();
		}
		
		Personnage personnage = this.model.creerPersonnage(classe, sexe, nom);
		
		
		this.initialisation(personnage);
	}
	
	public void initialisation(Personnage personnage)
	{
		Monstre[] monstres = this.model.creerMonstres();
		Case[] cases = this.model.creerCases(monstres);
		this.jeu = this.model.creerJeu(cases, personnage);
		
		this.vue.AfficheInfoJeu(this.jeu);
		int choix = this.vue.AfficherMenu("Bienvenue dans le Royaume de Dar Elnor, " + personnage.getNom() + ".\n", personnage);
		int n = rand.nextInt(4);
		switch (n)
		{
			case 0: System.out.println("Le roi est tr�s malade, le Mestre de votre village � trouv� une plante m�dicinale capable de soigner la maladie du roi, il vous charge d�apporter cette plante au ch�teau qui se trouve � *max cases* lieux du village�");
					break;
			case 1: System.out.println("Vous vous r�veillez seul dans les bois sans aucuns souvenirs, vous croisez un chasseur qui vous indique la direction du village le plus proche, se trouvant � *max cases* lieux, ce village est peut-�tre le v�tre ?");
					break;
			case 2: System.out.println("Apr�s une chasse dans les bois, vous rentrez vers votre village, mais lorsque vous vous en approchez vous entendez du bruit et des cris de plus en plus fort, une bande de brigands est en train de ravager le village, volant et pillant les villageois. L�attaque �tait bien organis�e et personne n�a rien vu venir mais les gardes du village ont tout de m�me r�ussi a captur� un des brigands qui vous indique leur campement qui se trouve � *max cases* lieux du village. Vous d�cidez de partir en chasse�");
					break;
			case 3: System.out.println("Dans les bois vous rencontrez un vieil homme qui poss�de une carte qui indiquerai un tr�sor enfuit dans les ruines se trouvant � *max cases* lieux. C�est un voyage bien trop dangereux pour un vieil homme comme lui, il vous propose donc d�aller chercher ce tr�sor pour lui en �change de la moiti� du butin.");
					break;
		}
		actions(choix);
	}
	
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
				this.manger();
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
				System.out.println("Veuillez recommencer");
				choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
				break;
		}
	}
	
	public void seDeplacer()
	{
		this.jeu.consequenceAction();
		String choixDeplacement = this.vue.choixDeplacement();
		this.model.deplacerPersonnage(this.jeu.getJoueur(), choixDeplacement, this.jeu);
		
		this.verifEtatJeu("\n");
	}
	
	public void manger()
	{
		this.jeu.consequenceAction();
		String message = this.model.manger(this.jeu.getJoueur());
		
		this.verifEtatJeu(message);
	}
	
	public void boirePotion()
	{
		this.jeu.consequenceAction();
		String message = this.model.boirePotion(this.jeu.getJoueur());
		
		this.verifEtatJeu(message);
	}
	
	public void attaquer()
	{
		int numCase = this.jeu.getJoueur().getPosition();
		// Si le joueur est de la classe rodeur, il peut attaquer � distance
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
					System.out.println("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions(2);
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
				System.out.println("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(2);
			}
			else
			{
				this.jeu.consequenceAction();
				Monstre monstreAttaque = monstres.get(numMonstreAttaque);
				this.model.attaquerMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);
				
				this.verifEtatJeu("\n");
			}
		}
	}
	
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
				System.out.println("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(2);
			}
			else
			{
				this.jeu.consequenceAction();
				Monstre monstreAttaque = monstres.get(numMonstreAttaque);
				this.model.lancerSortSurMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);

				this.verifEtatJeu("Vous avez perdu 5 pts d'�nergie. Il vous reste "+this.jeu.getJoueur().getEnergie()+" pts d'�nergie.");
			}
		}
	}
	
	public void nettoyerCase()
	{
		this.jeu.consequenceAction();
		Personnage personnage = this.jeu.getJoueur();
		Case laCase = this.jeu.recupererCase(personnage.getPosition()+1);
		this.jeu.getJoueur().nettoyer(laCase);
		
		this.verifEtatJeu("\n");
	}
	
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
				System.out.println("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(5);
			}
			else
			{
				this.jeu.consequenceAction();
				String infos = this.jeu.getCases().get(laCase).toString();
				
				this.verifEtatJeu(infos);
			}
		}
	}
	
	public void afficheInfosCaseActuelle()
	{
		Personnage personnage = this.jeu.getJoueur();
		Case laCase = this.jeu.recupererCase(personnage.getPosition());
		this.jeu.getJoueur().examinerCase(laCase);
		
		this.verifEtatJeu("\n");
	}
	
	public void afficheInfoJeu()
	{
		String infos = this.jeu.infosJeu();
		
		this.verifEtatJeu(infos);
	}
	
	public void passerTour()
	{	
		this.jeu.ChangerTour();
		
		boolean vivant = this.model.personnageEstBienVivant(jeu);
		boolean pasArrive = this.model.personnageEstSurObjectif(jeu);
		boolean resteDuTemps = this.model.tempsNEstPasEcoule(jeu);
		
		if (vivant && pasArrive && resteDuTemps)
		{
			int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
			actions(choix);
		}
	}
	
	public void verifEtatJeu(String message)
	{
		boolean vivant = this.model.personnageEstBienVivant(jeu);
		boolean pasArrive = this.model.personnageEstSurObjectif(jeu);
		boolean resteDuTemps = this.model.tempsNEstPasEcoule(jeu);
		
		if (vivant && pasArrive && resteDuTemps)
		{
			int choix = this.vue.AfficherMenu(message, this.jeu.getJoueur());
			actions(choix);
		}
		else
		{
			this.jeu.ChangerTour();
		}
	}
}
