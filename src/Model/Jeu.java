package Model;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	private String nom;
	private Personnage joueur;
	private int nbJour;
	private final static int MAX_JOUR = 15;
	private int jourCourant;
	private int nbHeure;
	private final static int MAX_HEURE = 15;
	private final static int MAX_CASE = 50;
	protected ArrayList<Case> cases = new ArrayList<>(MAX_CASE);
	private int nbOeufMax = 0;
	private final static int MAX_OEUF = 50;
	protected ArrayList<Oeuf> oeufs = new ArrayList<>(MAX_OEUF);
	private Random rand = new Random();
	
	public Jeu(String nom, Personnage joueur, int nbJour, int nbHeure) {
		super();
		this.nom = nom;
		this.joueur = joueur;
		this.nbHeure = nbHeure;
		this.nbJour = nbJour;
	}
	
	@Override
	public String toString() {
		return "Jeu \n"
				+ "Nom : " + nom + "\n"
				+ "Joueur : " + joueur + "\n"
				+ "Nombre de jour : " + nbJour + "\n"
				+ "Jour actuel : " + jourCourant + "\n"
				+ "Nombre d'heure à dépenser : " + nbHeure + "\n"
				+ "Nombre de case dans le jeu : " + cases.size() + "\n"
				+ "Les cases : " + cases + "\n";
	}

	public void ajoutCase(Case laCase)
	{
		if(this.cases.size()<MAX_CASE){
			this.cases.add(laCase);
        }else{
            System.out.println("Il y a trop de cases.");
        }

	}

    public void SuppCase(Case laCase){
        this.cases.remove(laCase);
    }

    public ArrayList<Case> getCases() {
        return this.cases;
    }
    
	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}


	public void ajoutOeuf(Case laCase)
	{
		if(this.cases.size()<MAX_CASE){
			this.cases.add(laCase);
        }else{
            System.out.println("Il y a trop d'oeuf.");
        }

	}

    public void SuppOeuf(Oeuf oeuf){
        this.oeufs.remove(oeuf);
    }

    public ArrayList<Oeuf> getOeufs() {
        return this.oeufs;
    }
    
	public void setOeufs(ArrayList<Oeuf> oeufs) {
		this.oeufs = oeufs;
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

	public static int getMaxCase() {
		return MAX_CASE;
	}
	
	private void modifierEtatMonstre()
	{
		//sommeil
		int n;
		for (int i = 0; i < this.cases.size()-1; i++)
		{
			for (int j = 0; j < this.cases.get(i).getNbMaxMonstre(); j++)
			{
				n = rand.nextInt(2);
				switch (n)
				{
					/*case 0 = dormir si réveillé*/
					case 0: if(this.cases.get(i).monstres.get(j).isSommeil() == false)
						this.cases.get(i).monstres.get(j).dormir();
							break;
					/*case 1 = se reveiller si endormi*/
					case 1: if(this.cases.get(i).monstres.get(j).isSommeil() == true)
						this.cases.get(i).monstres.get(j).seReveiller();
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
		for (int i = 0; i < this.cases.size(); i++)
		{
			n = rand.nextInt(3);
			this.cases.get(i).setPollution(n);
		}
	}
	
	private void verifNaissances()
	{
		//TODO OPTIMISATION !!!
		//On vérifie les oeufs
		for (int i = 0; i < this.nbOeufMax; i++)
		{
			if(this.oeufs.get(i).getTempsIncub() != 0)
			{
				int newTempsIncub = this.oeufs.get(i).getTempsIncub() - 1;
				this.oeufs.get(i).setTempsIncub(newTempsIncub);
			}
			else
			{
				Monstre monstre = this.oeufs.get(i).eclore();
				int numCase = oeufs.get(i).getNumCaseMere();
				Case laCase = this.recupererCase(numCase);
				laCase.ajoutMonstre(monstre);
			}
		}
		
		//On vérifie la gestation des vivipares
		for (int i = 0; i < this.cases.size(); i++)
		{
			Case laCase = this.cases.get(i);
			for (int j = 0; j < laCase.getNbMaxMonstre(); j++)
			{
				Monstre monstre = this.cases.get(i).monstres.get(j);
				if (monstre.isEnGestation())
				{
					monstre.gestation();
				}
			}
		}
	}

	public boolean ChangerTour()
	{
		// On vérifie que ce n'est pas la fin du jeu
		if (this.jourCourant == this.nbJour || this.joueur.getVie() == 0) 
		{
			this.FinDuJeu();
			return true;
		}
		else
		{
			System.out.println("Vous vous endormez sous un arbre. La lune se lève puis redescend, laissant place au Soleil. Un nouveau jour commence.");
			this.jourCourant++;
			this.nbHeure = 10;
			this.modifierEtatMonstre();
			this.modifierEtatCase();
			this.verifNaissances();
			return false;
		}
	}
	
	private void FinDuJeu()
	{
		if (this.joueur.getVie() == 0)
			System.out.println("Vous êtes mort...");
			/*Afficher stats*/
			else
			{
				if(this.jourCourant == this.nbJour)
					System.out.println("Votre temps est écoulé...");
					/*Afficher stats*/
					else
					{
						System.out.println("Félicitation! Vous avez réussi!");
						/*Afficher stats*/
					}
			}
	}
	
	public Case recupererCase(int numCase)
	{
		return this.cases.get(numCase);
	}
	
	public void consequenceAction()
	{
		System.out.println("Les heures tournent. Vous perdez une heure de temps à faire votre action.");
		this.nbHeure --;
		if(this.nbHeure == 0)
		{
			this.ChangerTour();
		}
	}
	
	public String infosJeu()
	{
		return "Jeu \n"
				+ "Nom : " + nom + "\n"
				+ "Joueur : " + joueur + "\n"
				+ "Nombre de jour : " + nbJour + "\n"
				+ "Jour actuel : " + jourCourant + "\n"
				+ "Nombre d'heure à dépenser : " + nbHeure + "\n"
				+ "Nombre de case dans le jeu : " + this.cases.size() + "\n";
	}
}
