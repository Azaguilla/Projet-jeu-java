/**
 * 
 */
package jeu;

/**
 * @author Laurie
 *
 */
public class LoupGarou extends Monstre implements Terrestre, Vivipare {

	
	public LoupGarou(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}

	public void vagabonder(SeDeplacer seDeplacer)
	{
		seDeplacer.seDeplacer(this);
	}
	
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		int force = 2;
		int vie = 10;
		
		return new LoupGarou("Loup Garou", sexe, poids, taille, 0, force, vie, false);
	}
	
	public String son()
	{
		return "Le Loup Garou "+this.getNom()+" hurle à la Lune.";
	}

}
