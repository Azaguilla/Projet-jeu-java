package jeu;

public class Gobelin extends Monstre implements Terrestre, Vivipare {
	
	public Gobelin(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
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
		int poids = (int) Math.round(15+Math.random()*5);
		int force = 1;
		int vie = 6;
		
		return new Gobelin("Gobelin", sexe, poids, taille, 0, force, vie, false);
	}
	
	public String son()
	{
		return "Le gobelin"+this.getNom()+" ricane dans les profondeurs.";
	}

}
