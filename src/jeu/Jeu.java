package jeu;

import java.util.Arrays;

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
	}
	
	private void modifierEtatCase()
	{
		//pollutions
	}

	public void ChangerTour()
	{
		// On vérifie que ce n'est pas la fin du jeu
		if (this.jourCourant != MAX_JOUR) {
			this.jourCourant++;
			this.modifierEtatMonstre();
			this.modifierEtatCase();
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
