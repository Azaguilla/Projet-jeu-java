package Model;

public class Wyverne extends Monstre implements Volant, Ovipare{

	public Wyverne(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
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
	public boolean voler(SeDeplacer seDeplacer, Jeu jeu) {
		return seDeplacer.voler(this, jeu);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.voler(seDeplacer, jeu);
	}

	@Override
	public String son() {
		return "La Wyverne "+this.getNom()+" pousse un cri strident en tournoyant dans le ciel.";
	}

	@Override
	public void gestation() {
		// non concerné
		
	}

}
