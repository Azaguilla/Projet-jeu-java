/**
 * 
 */
package Model;

import java.util.ArrayList;


/**
 * @author Laurie
 *
 */
public abstract class Case 
{
	private int numCase;
	private int taille;
	private int nbMaxMonstre = 0;
	protected final static int MAX_MONSTRES = 3;
	protected ArrayList<Monstre> monstres = new ArrayList<>(MAX_MONSTRES);
	private int pollution;
	
	/**
	 * Une case du plateau de jeu
	 * @param numCase Num�ro de la case, indiquant sa position sur le plateau
	 * @param taille Tailler de la case
	 * @param pollution Etat de pollution de la case
	 */
	public Case(int numCase, int taille, int pollution) 
	{
		super();
		this.numCase = numCase;
		this.taille = taille;
		this.pollution = pollution;
	}
	
	/**
	 * Permet de modifier les informations des monstres de la case
	 * @param monstres Les monstres de la case
	 */
	public void setMonstres(ArrayList<Monstre> monstres) 
	{
		this.monstres = monstres;
	}

	/**
	 * Supprime un monstre de la case et d�cr�mente le nombre de monstres sur la case
	 * @param monstre Le monstre a supprimer sur la case
	 */
    public void SuppMonstre(Monstre monstre)
    {
        this.monstres.remove(monstre);
        this.nbMaxMonstre--;
    }

  	/**
  	 * Permet de r�cup�rer les information des monstres de la case
  	 * @param monstres Les monstres de la case
  	 * @return Les monstres de la case
  	 */
    public ArrayList<Monstre> getMonstres() 
    {
        return this.monstres;
    }
	
    /**
     * Permet de r�cup�rer le num�ro de la case
     * @return Le num�ro de la case
     */
	public int getNumCase() 
	{
		return numCase;
	}
	
	/**
	 * Permet de modifier le num�ro de la case
	 * @param numCase Le num�ro de la case
	 */
	public void setNumCase(int numCase) 
	{
		this.numCase = numCase;
	}
	
	/**
     * Permet de r�cup�rer la taille de la case
     * @return La taille de la case
     */
	public int getTaille() 
	{
		return taille;
	}
	
	/**
	 * Permet de modifier la taille de la case
	 * @param taille La taille de la case
	 */
	public void setTaille(int taille) 
	{
		this.taille = taille;
	}
	
	/**
     * Permet de r�cup�rer le nombre maximal de monstres sur la case
     * @return Le nombre maximal de monstres sur la case
     */
	public int getNbMaxMonstre() 
	{
		return nbMaxMonstre;
	}
	
	/**
	 * Permet de modifier le nombre maximal de monstres sur la case
	 * @param nbMaxMonstre Le nombre maximal de monstres sur la case
	 */
	public void setNbMaxMonstre(int nbMaxMonstre) 
	{
		this.nbMaxMonstre = nbMaxMonstre;
	}
	
	/**
     * Permet de r�cup�rer l'�tat de pollution de la case
     * @return L'�tat de pollution de la case
     */
	public int getPollution() 
	{
		return pollution;
	}
	
	/**
	 * Permet de modifier l'�tat de pollution de la case
	 * @param pollution L'�tat de pollution de la case
	 */
	public void setPollution(int pollution) 
	{
		this.pollution = pollution;
	}
	
	public abstract String degatPersonnage(Personnage personnage);
	public abstract String nettoyerCase();
	public abstract boolean ajoutMonstre(Monstre monstre);
	
}
