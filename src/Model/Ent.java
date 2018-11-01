package Model;

public class Ent extends Monstre implements Vivipare 
{
	/**
	 * Monstre de l'esp�ce des Ents
	 * @param String nom Nom de l'Ent
	 * @param int sexe Sexe de l'Ent
	 * @param int poids Poids de l'Ent
	 * @param int taille Taille de l'Ent
	 * @param double age Age de l'Ent
	 * @param boolean sommeil Etat de sommeil de l'Ent, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Ent(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
	 * Cr�e un nouvel Ent
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
	 * Permet au monstre de se d�placer. Les Ents ne se d�placent pas.
	 * @params Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @params SeDeplacer seDeplacer La mani�re dont le monstre va se d�placer. Ici il n'est pas utile.
	 * @return   boolean true
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		System.out.println("Les Ent ne se d�placent pas !");
		return true;
	}

	/**
	 * D�termine le son du monstre
	 * @return String Le son et le nom de l'Ent
	 */
	@Override
	public String son() 
	{
		return "Je s'appelle Grout.";
	}

	//TODO v�rifier la doc
	/**
	 * Cr�e un nouvel Ent
	 * Si le monstre peut etre plac� dans son terrain, le monstre est plac�
	 * Sinon il meurt
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	@Override
	public String gestation(Jeu jeu) 
	{
		Monstre monstre = this.naissance();		
		int numCase = this.getNumCaseActuelle();
		//System.out.println("Case de la m�re : "+numCase);
		Case laCase = jeu.recupererCase(numCase);
		if(laCase.ajoutMonstre(monstre))
		{
			System.out.println("Le monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase());
			return "Une pousse d'Ent est apparue !";
		}
		else
		{
			return "La vie peut �tre difficile, dans les sous-bois, pour les jeunes Ent. L'un d'entre eux n'a pas surv�cu � cause du manque de place.";
		}
	}

}
