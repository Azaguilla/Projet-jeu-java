package jeu;

public class Ogre extends Monstre implements Terrestre, Vivipare {

	public Ogre(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}

	public void vagabonder(SeDeplacer seDeplacer, Jeu jeu)
	{
		seDeplacer.vagabonder(this, jeu);
	}
	
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(80+Math.random()*15);
		int force = 3;
		int vie = 15;
		
		return new Ogre("Ogre", sexe, poids, taille, 0, force, vie, false);
	}
	
	public String son()
	{
		return "L'ogre "+this.getNom()+" gronde.";
	}
}
