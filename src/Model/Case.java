/**
 * 
 */
package Model;

import java.util.ArrayList;


/**
 * @author Laurie
 *
 */
public abstract class Case {
	private int numCase;
	private int taille;
	private int nbMaxMonstre = 0;
	protected final static int MAX_MONSTRES = 3;
	protected ArrayList<Monstre> monstres = new ArrayList<>(MAX_MONSTRES);
	private int pollution;
	
	
	public Case(int numCase, int taille, int pollution) {
		super();
		this.numCase = numCase;
		this.taille = taille;
		this.pollution = pollution;
	}
	
	public void setMonstres(ArrayList<Monstre> monstres) {
		this.monstres = monstres;
	}

    public void SuppMonstre(Monstre monstre){
        this.monstres.remove(monstre);
        this.nbMaxMonstre--;
    }

    public ArrayList<Monstre> getMonstres() {
        return this.monstres;
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
