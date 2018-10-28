package Model;

public class Griffon extends Monstre implements Volant, Ovipare {

	public Griffon(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	@Override
	public Oeuf pondreOeuf() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Griffon bebe = new Griffon("Griffon", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	@Override
	public boolean voler(SeDeplacer seDeplacer, Jeu jeu) {
		return seDeplacer.voler(this, jeu);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.voler(seDeplacer, jeu);
	}

	@Override
	public String son() {
		return "Le Griffon "+this.getNom()+" glatit dans le ciel.";
	}

	@Override
	public void gestation() {
		this.pondreOeuf();
	}

}
