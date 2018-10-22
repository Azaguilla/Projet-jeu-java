/**
 * 
 */
package jeu;


/**
 * @author Laurie
 *
 */
public abstract class Case {
	private int numCase;
	private int taille;
	private int nbMaxMonstre = 0;
	private final static int MAX_MONSTRES = 3;
	protected Monstre[] monstres = new Monstre[MAX_MONSTRES];
	private int pollution;
	
	
	public Case(int numCase, int taille, int pollution) {
		super();
		this.numCase = numCase;
		this.taille = taille;
		this.pollution = pollution;
	}


	public String infosCase() {
		return "Plaine [Case n° " + getNumCase() + ", de taille " + getTaille() + ". Cette case est occupée par"
				+ getNbMaxMonstre() + " monstres. Sa pollution est au niveau " + getPollution() + ".";
	}
	
	public void afficheMonstres()
	{
		for (int i = 0; i < this.nbMaxMonstre; i++)
		{
			System.out.println("Monstre"+i+": "+this.monstres[i]);
		}
	}
	
	public Monstre[] getMonstres() {
		return monstres;
	}


	public void setMonstres(Monstre[] monstres) {
		this.monstres = monstres;
	}


	public void suppMonstre()
	{
		
	}
	
	public int getNumCase() {
		return numCase;
	}
	public void setNumCase(int numCase) {
		this.numCase = numCase;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getNbMaxMonstre() {
		return nbMaxMonstre;
	}
	public void setNbMaxMonstre(int nbMaxMonstre) {
		this.nbMaxMonstre = nbMaxMonstre;
	}
	public int getPollution() {
		return pollution;
	}
	public void setPollution(int pollution) {
		this.pollution = pollution;
	}
	public abstract void degatPersonnage(Personnage personnage);
	public abstract void nettoyerCase();
	public abstract boolean ajoutMonstre(Monstre monstre);
	
}
