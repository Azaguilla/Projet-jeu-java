package jeu;

public class Griffon extends Monstre implements Volant, Ovipare {

	public Griffon(String nom, int sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super(nom, sexe, poids, taille, age, force, vie, sommeil);
	}

	@Override
	public Monstre pondreOeuf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void voler(SeDeplacer seDeplacer) {
		seDeplacer.seDeplacer(this);
	}

	@Override
	public String son() {
		return "Le Griffon "+this.getNom()+" glatit dans le ciel.";
	}

}
