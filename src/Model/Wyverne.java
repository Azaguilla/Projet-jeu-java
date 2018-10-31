package Model;

public class Wyverne extends Monstre implements Volant, Ovipare
{

	/**
	 * Monstre de l'espèce des Wyvernes
	 * @param String nom Nom de la Wyverne
	 * @param int sexe Sexe de la Wyverne
	 * @param int poids Poids de la Wyverne
	 * @param int taille Taille de la Wyverne
	 * @param double age Age de la Wyverne
	 * @param boolean sommeil Etat de sommeil de la Wyverne, vrai(true) s'il est endormis,  faux(false) s'il est réveillé
	 */
	public Wyverne(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
	 * Initialise au hasard les caracteristiques du bébé
	 * Crée un nouveau monstre bebe
	 * @return Oeuf Un nouvel oeuf avec son temps d'incubation et le bebe qu'in contient
	 */
	@Override
	public Oeuf pondreOeuf() 
	{
		System.out.println("Un oeuf est en cours de préparation.");
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Monstre bebe = new Wyverne("Wyverne", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	//TODO javadoc
	/**
	 * 
	 * 
	 */
	@Override
	public boolean voler(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return seDeplacer.voler(this, jeu);
	}
	
	//TODO javadoc
	/**
	 * 
	 * 
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return this.voler(seDeplacer, jeu);
	}

	/**
	 * Détermine le son du monstre
	 * @return String Le son et le nom de la Wyverne
	 */
	@Override
	public String son() 
	{
		return "La Wyverne "+this.getNom()+" pousse un cri strident en tournoyant dans le ciel.";
	}

	/**
	 * Le monstre entre en gestation d'un oeuf
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return String
	 */
	@Override
	public String gestation(Jeu jeu) 
	{
		Oeuf oeuf = this.pondreOeuf();
		jeu.ajoutOeuf(oeuf);
		return "Un oeuf de "+this.getNom()+" est en cours d'incubation.";
	}

}
