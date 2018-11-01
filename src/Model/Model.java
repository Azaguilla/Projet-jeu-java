package Model;

import java.util.ArrayList;
import java.util.Random;

public class Model 
{
	
	private Random rand = new Random();
	
	/**
	 * Permet de créer un personnage
	 * @param classe La classe du personnage
	 * @param sexe Le sexe du personnage
	 * @param nom Le nom du personnage
	 * @return Le personnage créé
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
	
	//TODO vérifier doc (type) + faire en sorte que le jeu ne plante pas si les monstres ne peuvent pas être placés
	/**
	 * Permet de créer les cases du jeu et de placer les monstres qu'elles contiennent
	 * @param monstres Les monstres du jeu
	 * @return Les cases du jeu
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
				else
				{
					// On place les monstres jusqu'à la fin. Pour ne pas faire des tours à l'infini, si on a fait 3 tours, on stoppe, le monstre est détruit
					if(tour < 3)
					{
						if(f == 19)
						{
							f = 0;
							tour++;
						}
					}
					else
					{
						placement = true;
					}
				}
				f++;
			}
		}
		return tabCase;
	}
	
	//TODO vérifier doc (type)
	/**
	 * Permet de créer les monstres du jeu avec des caractéristiques et une espèce au hasard
	 * @return Les monstres du jeu
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
			int taille = rand.nextInt(3);
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
	

	/**
	 * Permet de créer le jeu avec les cases qu'il contient et le personnage du joueur
	 * @param cases Les cases du jeu
	 * @param personnage Le personnage du joueur
	 * @return Les informations concernant l'anvancée du jeu, les monstres, les cases...
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
	 * @param personnage Le personnage du joueur
	 * @param choixDeplacement Le déplacement chosi par le joueur (avancer ou reculer)
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return message
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
	
	/**
	 * Appel la méthode manger() du personnage. Permet de récupérer de l'énergie.
	 * @param personnage Le personnage du joueur
	 * @return le message indiquant si le personnage a pu récupérer de l'énergie ou non.
	 */
	public String manger(Personnage personnage)
	{
		return personnage.manger();
	}
	
	/**
	 * Appel la méthode boirePotion() du personnage. Permet de récupérer de la vie.
	 * @param personnage Le personnage du joueur
	 * @return le message indiquant si le personnage a pu récupérer de la vie ou non.
	 */
	public String boirePotion(Personnage personnage)
	{
		return personnage.boirePotion();
	}
	
	/**
	 * Récupère les monstres de la case
	 * @param numCase Le numéro de la case
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return Les monstres présents sur la case
	 */
	public ArrayList<Monstre> recupererMonstre(int numCase, Jeu jeu)
	{
		Case laCase = jeu.recupererCase(numCase);
		ArrayList<Monstre> monstres = laCase.getMonstres();

		return monstres;
	}
	
	/**
	 * Permet au personnage d'attaquer un monstre et d'infliger des dégâts au monstre
	 * @param personnage Le personnage du joueur
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @param monstre Le monstre à attaquer
	 * @return Le message d'information sur les effets de la méthode attaquer()
	 */
	public String attaquerMonstre(Personnage personnage, Jeu jeu, Monstre monstre)
	{
		return personnage.attaquer(monstre, jeu);
	}
	
	//TODO vérifier return type
	/**
	 * Permet au personnage de lancer un sort et d'infliger des dégâts au monstre
	 * @param personnage Le personnage du joueur
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @param monstre Le monstre à attaquer
	 * @return Le message d'information sur les effets de la méthode lancerSort()
	 */
	public String lancerSortSurMonstre(Personnage personnage, Jeu jeu, Monstre monstre)
	{
		return personnage.lancerSort(monstre, jeu);
	}
	
	/**
	 * Vérifie que le personnage est vivant
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return faux(false) si la vie du joueur est inférieure ou égale à 0, vrai(true) sinon
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
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return faux(false) si le joueur se trouve sur la dernière case, vrai(true) sinon
	 */
	public boolean personnageNEstPasSurObjectif(Jeu jeu)
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
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return faux(false) si le nombre de jours est égale au jour courant, vrai(true) sinon
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
