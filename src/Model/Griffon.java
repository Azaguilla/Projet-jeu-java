package Model;

public class Griffon extends Monstre implements Volant, Ovipare {

	/**
	 * Monstre de l'espèce des Griffons
	 * @param String nom Nom du Griffon
	 * @param int sexe Sexe du Griffon
	 * @param int poids Poids du Griffon
	 * @param int taille Taille du Griffon
	 * @param double age Age du Griffon
	 * @param boolean sommeil Etat de sommeil du Griffon, vrai(true) s'il est endormis,  faux(false) s'il est réveillé
	 */
	public Griffon(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
	 * Initialise au hasard les caracteristiques du bébé
	 * Crée un nouveau monstre bebe
	 * @return Oeuf Un nouvel oeuf avec son temps d'incubation et le bebe qu'in contient
	 */
	@Override
	public Oeuf pondreOeuf() {
		System.out.println("Un oeuf est en cours de préparation.");
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Griffon bebe = new Griffon("Griffon", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	//TODO javadoc
	/**
	 * 
	 */
	@Override
	public boolean voler(SeDeplacer seDeplacer, Jeu jeu) {
		return seDeplacer.voler(this, jeu);
	}
	
	//TODO javadoc
	/**
	 * 
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.voler(seDeplacer, jeu);
	}

	/**
	 * Détermine le son du monstre
	 * @return String Le son et le nom du Griffon
	 */
	@Override
	public String son() {
		return "Le Griffon "+this.getNom()+" glatit dans le ciel.";
	}

	//TODO vérifier doc
	/**
	 * Le monstre entre en gestation d'un oeuf
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public void gestation(Jeu jeu) {
		Oeuf oeuf = this.pondreOeuf();
		jeu.ajoutOeuf(oeuf);
	}

}
