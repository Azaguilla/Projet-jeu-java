package Model;

public class Blob extends Monstre implements Rampant {

	public Blob(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	@Override
	public boolean ramper(SeDeplacer seDeplacer, Jeu jeu) {
		return seDeplacer.ramper(this, jeu);
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
		
		return new Blob("Blob", sexe, poids, taille, 0, false);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.ramper(seDeplacer, jeu);
	}

	@Override
	public void gestation() {
		// non concerné
		
	}

}
