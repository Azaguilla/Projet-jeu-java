package jeu;

import java.util.Arrays;
import java.util.Random;

public class Jeu {
	private String nom;
	private Personnage joueur;
	private int nbJour;
	private final static int MAX_JOUR = 15;
	private int jourCourant;
	private int nbHeure;
	private final static int MAX_HEURE = 15;
	private int nbCaseMax = 0;
	private final static int MAX_CASE = 50;
	private Case[] cases = new Case[MAX_CASE];
	private int nbOeufMax = 0;
	private final static int MAX_OEUF = 50;
	private Oeuf[] oeufs = new Oeuf[MAX_OEUF];
	private Random rand = new Random();
	
	public Jeu(String nom, Personnage joueur) {
		super();
		this.nom = nom;
		this.joueur = joueur;
	}
	
	public void ajoutCase(Case lacase)
	{
		this.cases[this.nbCaseMax] = lacase;
		this.nbCaseMax += 1; 
	}
	
	@Override
	public String toString() {
		return "Jeu [nom=" + nom + ", joueur=" + joueur + ", nbJour=" + nbJour + ", nbCaseMax=" + nbCaseMax + ", cases="
				+ Arrays.toString(cases) + "]";
	}

	public void afficheCases()
	{
		for (int i = 0; i < this.nbCaseMax; i++)
		{
			System.out.println("Case "+i+": "+this.cases[i].getClass());
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Personnage getJoueur() {
		return joueur;
	}

	public void setJoueur(Personnage joueur) {
		this.joueur = joueur;
	}

	public int getNbJour() {
		return nbJour;
	}

	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
	}

	public int getNbHeure() {
		return nbHeure;
	}

	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}

	public int getNbCaseMax() {
		return nbCaseMax;
	}

	public void setNbCaseMax(int nbCaseMax) {
		this.nbCaseMax = nbCaseMax;
	}

	public Case[] getCases() {
		return cases;
	}

	public void setCases(Case[] cases) {
		this.cases = cases;
	}

	public static int getMaxCase() {
		return MAX_CASE;
	}

	public void AfficheInfoJeu()
	{
		// affiche le nom du jeu, le nb d'heure restante
	}
	
	private void modifierEtatMonstre()
	{
		//sommeil
		int n;
		for (int i = 0; i < this.nbCaseMax; i++)
		{
			for (int j = 0; j < this.cases[i].nbMaxMonstre; j++)
			{
				n = rand.nextInt(2);
				switch (n)
				{
					/*case 0 = dormir si réveillé*/
					case 0: if(this.cases[i].monstres[j].isSommeil == false)
								this.cases[i].monstres[j].dormir();
							break;
					/*case 1 = se reveiller si endormi*/
					case 1: if(this.cases[i].monstres[j].isSommeil == true)
								this.cases[i].monstres[j].seReveiller();
							break;
				}
			}
		}
		//penser a changer l'état de sommeil si combat engagé
	}
	
	private void modifierEtatCase()
	{
		//pollutions
		int n;
		for (int i = 0; i < this.nbCaseMax; i++)
		{
			n = rand.nextInt(3);
			this.cases[i].setPollution(n);
		}
	}
	
	private void verifNaissances()
	{
		//TODO OPTIMISATION !!!
		for (int i = 0; i < this.nbOeufMax; i++)
		{
			if(this.oeufs[i].getTempsIncub() != 0)
			{
				int newTempsIncub = this.oeufs[i].getTempsIncub() - 1;
				this.oeufs[i].setTempsIncub(newTempsIncub);
			}
			else
			{
				int numCase = (int) Math.round(1+Math.random()*this.nbCaseMax);
				Monstre monstre = this.oeufs[i].eclore();
				Case laCase = this.recupererCase(numCase);
				while(laCase.ajoutMonstre(monstre) == false)
				{
					numCase = (int) Math.round(1+Math.random()*this.nbCaseMax);
					monstre = this.oeufs[i].eclore();
					laCase = this.recupererCase(numCase);
				}
			}
		}
	}

	public void ChangerTour()
	{
		// On vérifie que ce n'est pas la fin du jeu
		if (this.jourCourant != MAX_JOUR) {
			this.jourCourant++;
			this.modifierEtatMonstre();
			this.modifierEtatCase();
			this.verifNaissances();
		}
		else
		{
			this.FinDuJeu();
		}
	}
	
	private void FinDuJeu()
	{
		
	}
	
	public Case recupererCase(int numCase)
	{
		Case lacase = null;
		for (int i = 0; i < this.nbCaseMax; i++)
		{
			if(this.cases[i].getNumCase() == numCase)
			{
				lacase = this.cases[i];
			}
		}
		return lacase;
	}
}
