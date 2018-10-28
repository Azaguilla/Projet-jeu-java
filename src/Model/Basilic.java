package Model;

public class Basilic extends Monstre implements Rampant, Ovipare {

	public Basilic(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}
	
	@Override
	public Oeuf pondreOeuf() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Monstre bebe = new Basilic("Basilic", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	@Override
	public boolean ramper(SeDeplacer seDeplacer, Jeu jeu) {
		return seDeplacer.ramper(this, jeu);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.ramper(seDeplacer, jeu);
	}

	@Override
	public String son() {
		return "Le Basilic "+this.getNom()+" siffle au fond du Marais.";
	}

	@Override
	public void gestation() {
		// non concerné
		
	}

}
