package Model;

import java.util.ArrayList;
import java.util.Random;

public class Model 
{
	
	private Random rand = new Random();
	
	/**
	 * Permet de créer un personnage
	 * @param int classe La classe du personnage
	 * @param String sexe Le sexe du personnage
	 * @param String nom Le nom du personnage
	 * @return Personnage personnage Le personnage créé
	 */
	public Personnage creerPersonnage(int classe, String sexe, String nom)
	{
		Personnage personnage = null;
		switch(classe)
		{
			case 1:personnage = Chasseur.getInstance(nom, sexe, "Chasseur");
					break;
			case 2:personnage = Guerrier.getInstance(nom, sexe, "Guerrier");
					break;
			case 3:personnage = Magicien.getInstance(nom, sexe, "Magicien");
					break;
			case 4:personnage = Rodeur.getInstance(nom, sexe, "Rôdeur");
					break;
		}
		return personnage;
	}
	
	//TODO vérifier doc (type)
	/**
	 * Permet de créer les cases du jeu et de placer les monstres qu'elles contiennent
	 * @param Monstre[] monstres Les monstres du jeu
	 * @return Case[] tabCase Les cases du jeu
	 */
	public Case[] creerCases(Monstre[] monstres)
	{
		Case[] tabCase;
		tabCase = new Case[20];
		for(int i = 0; i<20; i++)
		{
			int n = rand.nextInt(3);
			int taille = rand.nextInt(3)+1;
			int pollution = rand.nextInt(3);
			switch (n)
			{
				case 0: 
					Plaine plaine = new Plaine(i, taille, pollution);
					tabCase[i] = plaine;
						break;
				case 1: 
					Marais marais = new Marais(i, taille, pollution, 2);
					tabCase[i] = marais;
						break;
				case 2: 
					Foret foret = new Foret(i, taille, pollution, 2);
					tabCase[i] = foret;
						break;
			}
		}
		
		// On place les monstres
		for(int i = 0; i<8; i++)
		{
			boolean placement = false;
			int f = 1;
			int tour = 0;
			while(placement == false)
			{
				if(tabCase[f].ajoutMonstre(monstres[i]))
				{
					placement = true;
				}
				f++;
			}
		}
		return tabCase;
	}
	
	//TODO vérifier doc (type)
	/**
	 * Permet de créer les monstres du jeu avec des caractéristiques et une espèce au hasard
	 * @return Monstre[] tabMonstre Les monstres du jeu
	 */
	public Monstre[] creerMonstres()
	{
		Monstre[] tabMonstre;
		tabMonstre = new Monstre[8];
		for(int i = 0; i<8; i++)
		{
			int n = rand.nextInt(8);
			int sexe = rand.nextInt(2);
			int poids = rand.nextInt(20);
			int taille = rand.nextInt(20);
			int tmp_sommeil = rand.nextInt(2);
			boolean sommeil;
			if(tmp_sommeil == 0) 
				sommeil = true;
			else 
				sommeil = false;
			
			switch (n)
			{
				case 0: 
					Basilic basilic = new Basilic("Basilic", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = basilic;
						break;
				case 1: 
					Blob blob = new Blob("Blob", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = blob;
						break;
				case 2: 
					Ent ent = new Ent("Ent", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = ent;
						break;
				case 3: 
					Gobelin gobelin = new Gobelin("Gobelin", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = gobelin;
						break;
				case 4: 
					Griffon griffon = new Griffon("Griffon", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = griffon;
						break;
				case 5: 
					LoupGarou loupGarou = new LoupGarou("LoupGarou", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = loupGarou;
						break;
				case 6: 
					Ogre ogre = new Ogre("Ogre", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = ogre;
						break;
				case 7: 
					Wyverne wyverne = new Wyverne("Wyverne", sexe, poids, taille, (double) 5, sommeil);
					tabMonstre[i] = wyverne;
						break;
			}
		}
		return tabMonstre;
	}
	
	//TODO vérifier doc (type)
	/**
	 * Permet de créer le jeu avec les cases qu'il contient et le personnage du joueur
	 * @param Case[] cases Les cases du jeu
	 * @param Personnage personnage Le personnage du joueur
	 * @return Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public Jeu creerJeu(Case[] cases, Personnage personnage)
	{
		Jeu jeu = new Jeu(personnage.getNom()+"'s world", personnage, 7, 10);
		for(int i=0; i<20;i++)
		{
			jeu.ajoutCase(cases[i]);
		}
		return jeu;
	}
	
	/**
	 * Permet au personnage de se déplacer
	 * @param Personnage personnage Le personnage du joueur
	 * @param int choixDeplacement Le déplacement chosi par le joueur (avancer ou reculer)
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return String message
	 */
	public String deplacerPersonnage(Personnage personnage, int choixDeplacement, Jeu jeu)
	{
		boolean deplacement = personnage.seDeplacer(choixDeplacement, jeu);
		
		if (deplacement == true)
		{
			String message = jeu.recupererCase(personnage.getPosition()).degatPersonnage(personnage);
			return "Vous marchez difficilement à travers le lieu hostile, mais vous réussissez à avancer.\n"+message;
		}
		else
		{
			return "Vous essayez d'avancer, mais quelque chose vous en empêche. La fatigue, peut-être ?";
		}
	}
	
	//TODO vérifier le return
	/**
	 * Appel la méthode manger() du personnage
	 * @param Personnage personnage Le personnage du joueur
	 * @return String personnage.manger()
	 */
	public String manger(Personnage personnage)
	{
		return personnage.manger();
	}
	
	//TODO vérifier le return
	/**
	 * Appel la méthode boirePotion() du personnage
	 * @param Personnage personnage Le personnage du joueur
	 * @return String personnage.boirePotion()
	 */
	public String boirePotion(Personnage personnage)
	{
		return personnage.boirePotion();
	}
	
	//TODO vérifier return type
	/**
	 * Récupère les monstres de la case
	 * @param int numCase Le numéro de la case
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return ArrayList<Monstre> monstres
	 */
	public ArrayList<Monstre> recupererMonstre(int numCase, Jeu jeu)
	{
		Case laCase = jeu.recupererCase(numCase);
		ArrayList<Monstre> monstres = laCase.getMonstres();

		return monstres;
	}
	
	//TODO vérifier return type
	/**
	 * Permet au personnage d'attaquer un monstre
	 * @param Personnage personnage Le personnage du joueur
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @param Monstre monstre Le monstre à attaquer
	 * @return String personnage.attaquer(monstre, jeu)
	 */
	public String attaquerMonstre(Personnage personnage, Jeu jeu, Monstre monstre)
	{
		return personnage.attaquer(monstre, jeu);
	}
	
	//TODO vérifier return type
	/**
	 * Permet au personnage de lancer un sort
	 * @param Personnage personnage Le personnage du joueur
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @param Monstre monstre Le monstre à attaquer
	 * @return String personnage.lancerSort(monstre, jeu)
	 */
	public String lancerSortSurMonstre(Personnage personnage, Jeu jeu, Monstre monstre)
	{
		return personnage.lancerSort(monstre, jeu);
	}
	
	/**
	 * Vérifie que le personnage est vivant
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return boolean faux(false) si la vie du joueur est inférieure ou égale à 0, vrai(true) sinon
	 */
	public boolean personnageEstBienVivant(Jeu jeu)
	{
		if (jeu.getJoueur().getVie() <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Vérifie si le joueur a atteind son objectif
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return boolean faux(false) si le joueur se trouve sur la dernière case, vrai(true) sinon
	 */
	public boolean personnageEstSurObjectif(Jeu jeu)
	{
		if (jeu.getJoueur().getPosition() == jeu.cases.size()-1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Vérifie si le temps n'est pas écoulé
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return boolean faux(false) si le nombre de jours est égale au jour courant, vrai(true) sinon
	 */
	public boolean tempsNEstPasEcoule(Jeu jeu)
	{
		if (jeu.getNbJour() == jeu.getJourCourant())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
