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
	private Monstre[] monstres = new Monstre[MAX_MONSTRES];
	private int pollution;
	
	
	public Case(int numCase, int taille, int pollution) {
		super();
		this.numCase = numCase;
		this.taille = taille;
		this.pollution = pollution;
	}


	public void ajoutMonsre(Monstre monstre)
	{
		this.monstres[this.nbMaxMonstre] = monstre;
		this.nbMaxMonstre += 1; 
	}
	
	public void afficheCarac()
	{
		for (int i = 0; i < this.nbMaxMonstre; i++)
		{
			System.out.println("Monstre"+i+": "+this.monstres[i]);
		}
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
	public abstract void netoyerCase();
	
}
