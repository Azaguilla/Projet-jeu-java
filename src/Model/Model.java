package Model;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	private Random rand = new Random();
	
	public Personnage creerPersonnage(int classe, String sexe, String nom)
	{
		Personnage personnage = null;
		switch(classe)
		{
			case 1:	if(sexe == "M") System.out.println("Agile chasseur, ");
					if(sexe == "F") System.out.println("Agile chasseresse, ");
					personnage = Chasseur.getInstance(nom, sexe, "Chasseur");
					break;
			case 2:	if(sexe == "M") System.out.println("Grand guerrier, ");
					if(sexe == "F") System.out.println("Grande guerriere, ");
					personnage = Guerrier.getInstance(nom, sexe, "Guerrier");
					break;
			case 3: if(sexe == "M") System.out.println("Puissant magicien, ");
					if(sexe == "F") System.out.println("Puissante magicienne, ");
					personnage = Magicien.getInstance(nom, sexe, "Magicien");
					break;
			case 4:	if(sexe == "M") System.out.println("Sournois rôdeur, ");
					if(sexe == "F") System.out.println("Sournoise rôdeuse, ");
					personnage = Rodeur.getInstance(nom, sexe, "Rôdeur");
					break;
		}
		return personnage;
	}
	
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
						}
					}
					else
					{
						placement = true;
					}
				}
				tour++;
				f++;
			}
		}
		return tabCase;
	}
	
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
			switch (n)
			{
				case 0: 
					Basilic basilic = new Basilic("Basilic", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = basilic;
						break;
				case 1: 
					Blob blob = new Blob("Blob", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = blob;
						break;
				case 2: 
					Ent ent = new Ent("Ent", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = ent;
						break;
				case 3: 
					Gobelin gobelin = new Gobelin("Gobelin", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = gobelin;
						break;
				case 4: 
					Griffon griffon = new Griffon("Griffon", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = griffon;
						break;
				case 5: 
					LoupGarou loupGarou = new LoupGarou("LoupGarou", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = loupGarou;
						break;
				case 6: 
					Ogre ogre = new Ogre("Ogre", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = ogre;
						break;
				case 7: 
					Wyverne wyverne = new Wyverne("Wyverne", sexe, poids, taille, (double) 5, false);
					tabMonstre[i] = wyverne;
						break;
			}
		}
		return tabMonstre;
	}
	
	public Jeu creerJeu(Case[] cases, Personnage personnage)
	{
		Jeu jeu = new Jeu(personnage.getNom()+"'s world", personnage, 7, 10);
		for(int i=0; i<20;i++)
		{
			jeu.ajoutCase(cases[i]);
		}
		return jeu;
	}
	
	public void deplacerPersonnage(Personnage personnage, String choixDeplacement, Jeu jeu)
	{
		personnage.seDeplacer(choixDeplacement, jeu);
	}
	
	public String manger(Personnage personnage)
	{
		return personnage.manger();
	}
	
	public String boirePotion(Personnage personnage)
	{
		return personnage.boirePotion();
	}
	
	public ArrayList<Monstre> recupererMonstre(int numCase, Jeu jeu)
	{
		Case laCase = jeu.recupererCase(numCase);
		ArrayList<Monstre> monstres = laCase.getMonstres();


		return monstres;
	}
	
	public void attaquerMonstre(Personnage personnage, Jeu jeu, Monstre monstre)
	{
		personnage.attaquer(monstre, jeu);
	}
	
	public void lancerSortSurMonstre(Personnage personnage, Jeu jeu, Monstre monstre)
	{
		personnage.lancerSort(monstre, jeu);
	}
	
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
