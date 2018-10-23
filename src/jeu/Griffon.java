package jeu;

public class Griffon extends Monstre implements Volant, Ovipare {

	public Griffon(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}

	@Override
	public Oeuf pondreOeuf() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		int force = 2;
		int vie = 10;
		
		Monstre bebe = new Griffon("Griffon", sexe, poids, taille, 0, force, vie, false);
		
		return new Oeuf(2, bebe);
	}

	@Override
	public void voler(SeDeplacer seDeplacer, Jeu jeu) {
		seDeplacer.voler(this, jeu);
	}

	@Override
	public String son() {
		return "Le Griffon "+this.getNom()+" glatit dans le ciel.";
	}

	@Override
	public void gestation() {
		// TODO Auto-generated method stub
	}

}
