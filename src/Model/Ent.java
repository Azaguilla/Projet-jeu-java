package Model;

public class Ent extends Monstre implements Vivipare {

	public Ent(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	@Override
	public Monstre naissance() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		return new Ent("Ent", sexe, poids, taille, 0, false);
	}

	@Override
	public String son() {
		return "Les branches de l'Ent "+this.getNom()+" craquent sous la forêt profonde.";
	}

	@Override
	public void gestation() {
		// non concerné
		
	}

}
