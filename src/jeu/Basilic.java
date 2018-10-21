package jeu;

public class Basilic extends Monstre implements Rampant, Vivipare {

	public Basilic(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}
	
	@Override
	public Monstre naissance() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		int force = 2;
		int vie = 10;
		
		return new LoupGarou("Loup Garou", sexe, poids, taille, 0, force, vie, false);
	}

	@Override
	public void ramper(SeDeplacer seDeplacer) {
		seDeplacer.seDeplacer(this);
	}

	@Override
	public String son() {
		return "Le Basilic "+this.getNom()+" siffle au fond du Marais.";
	}

}
