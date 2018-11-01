package Model;

public class Ent extends Monstre implements Vivipare 
{
	/**
	 * Monstre de l'espèce des Ents
	 * @param String nom Nom de l'Ent
	 * @param int sexe Sexe de l'Ent
	 * @param int poids Poids de l'Ent
	 * @param int taille Taille de l'Ent
	 * @param double age Age de l'Ent
	 * @param boolean sommeil Etat de sommeil de l'Ent, vrai(true) s'il est endormis,  faux(false) s'il est réveillé
	 */
	public Ent(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
	 * Crée un nouvel Ent
	 * @return Monstre Ent Un nouvel Ent
	 */
	@Override
	public Monstre naissance() 
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		return new Ent("Ent", sexe, poids, taille, 0, false);
	}
	
	/** 
	 * Permet au monstre de se déplacer. Les Ents ne se déplacent pas.
	 * @params Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @params SeDeplacer seDeplacer La manière dont le monstre va se déplacer. Ici il n'est pas utile.
	 * @return   boolean true
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		System.out.println("Les Ent ne se déplacent pas !");
		return true;
	}

	/**
	 * Détermine le son du monstre
	 * @return String Le son et le nom de l'Ent
	 */
	@Override
	public String son() 
	{
		return "Je s'appelle Grout.";
	}

	//TODO vérifier la doc
	/**
	 * Crée un nouvel Ent
	 * Si le monstre peut etre placé dans son terrain, le monstre est placé
	 * Sinon il meurt
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	@Override
	public String gestation(Jeu jeu) 
	{
		Monstre monstre = this.naissance();		
		int numCase = this.getNumCaseActuelle();
		//System.out.println("Case de la mère : "+numCase);
		Case laCase = jeu.recupererCase(numCase);
		if(laCase.ajoutMonstre(monstre))
		{
			System.out.println("Le monstre "+monstre.getNom()+" s'est placé à la case "+laCase.getNumCase());
			return "Une pousse d'Ent est apparue !";
		}
		else
		{
			return "La vie peut être difficile, dans les sous-bois, pour les jeunes Ent. L'un d'entre eux n'a pas survécu à cause du manque de place.";
		}
	}

}
