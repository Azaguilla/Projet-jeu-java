package jeu;

public class Blob extends Monstre implements Rampant {

	public Blob(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}

	@Override
	public void ramper(SeDeplacer seDeplacer, Jeu jeu) {
		seDeplacer.ramper(this, jeu);
	}

	@Override
	public String son() {
		return "Le Blob "+this.getNom()+" gargouille de manière écoeurante.";
	}
	
	public Blob seDiviser()
	{
		int sexe = this.getSexe();
		int taille = this.getTaille();
		int poids = this.getPoids();
		int force = this.getForce();
		int vie = this.getVie();
		
		return new Blob("Blob", sexe, poids, taille, 0, force, vie, false);
	}

}
