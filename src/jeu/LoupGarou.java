/**
 * 
 */
package jeu;

/**
 * @author Laurie
 *
 */
public class LoupGarou extends Monstre implements Terrestre, Vivipare {

	
	public LoupGarou(String nom, String sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}

	public void vagabonder()
	{
		
	}
	
	public Monstre naissance()
	{
		return new LoupGarou("Loup Garou", "F", 5, 30, 0, 20, 25, false);
	}
	
	public String son()
	{
		return "Le Loup Garou "+this.getNom()+" hurle à la Lune.";
	}

}
