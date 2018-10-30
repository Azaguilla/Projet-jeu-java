package Model;

public class Guerrier extends Personnage 
{
	private static Personnage getInstance;

	/**
	 * Personnage Guerrier
	 * @param nom Le nom du Guerrier
	 * @param sexe Le sexe du Guerrier
	 * @param classe La classe du Guerrier
	 */
	private Guerrier(String nom, String sexe, String classe) 
	{
		super(nom, sexe, classe);
	}
	
	//TODO v�rifier doc
	/**
	 * Cr�e un nouveau Guerrier
	 * @param nom Le nom du Guerrier
	 * @param sexe Le sexe du Guerrier
	 * @param classe La classe du Guerrier
	 * @return
	 */
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Guerrier(nom, sexe, classe); 
	    }
	        return getInstance; 
	}

	/**
	 * Attaque un monstre et met a jour la vie du monstre selon la force du personnage
	 * R�veille le monstre
	 * Si la vie du monstre en inf�rieur ou �gale � 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param Monstre monstre Le monstre choisi
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	@Override
	public void attaquer(Monstre monstre, Jeu jeu) 
	{
		System.out.println("Votre �p�e fend l'air et vous infligez "+this.getForce()*2+" pts de d�g�t au monstre.");
		monstre.setVie(this.getForce()*3, jeu);
		monstre.setSommeil(false);
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
		}
		else
		{
			System.out.println("Le monstre r�plique et vous inflige "+monstre.getForce()+" pts de d�g�t.");
			this.setVie(this.getVie()-monstre.getForce());
		}
	}
	
	/**
	 * Lance un sort au monstre et met a jour la vie du monstre selon la force du personnage et l'�nergie d�pens�e
	 * R�veille le monstre
	 * Si la vie du monstre en inf�rieur ou �gale � 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param Monstre monstre Le monstre choisi
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		System.out.println("L'air cr�pite autour de vous et vous infligez "+this.getForce()+" pts de d�g�t au monstre.");
		this.setEnergie(this.getEnergie()-5);
		monstre.setVie(this.getForce(), jeu);
		monstre.setSommeil(false);
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
		}
		else
		{
			System.out.println("Le monstre r�plique et vous inflige "+monstre.getForce()+" pts de d�g�t.");
			this.setVie(this.getVie()-monstre.getForce());
		}
	}
	
	/**
	 * Affiche les information d�taill�es du guerrier
	 * @return String caracPersonnage Les informations
	 */
	@Override
	public String toString() 
	{
		String caracPersonnage;
		switch (this.getSexe())
		{
			case "F": 
				caracPersonnage = 
				"Guerri�re : \n"
				+ "Nom : " + getNom() + "\n"
				+ "Sexe : " + getSexe() + "\n"
				+ "Age : " + getAge() + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Poids : " + getPoids() + "\n"
				+ "Energie : " + getEnergie() + "\n"
				+ "Force : " + getForce() + "\n"
				+ "Vie : " + getVie() + "\n"
				+ "Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"Guerrier : \n"
				+ "Nom : " + getNom() + "\n"
				+ "Sexe : " + getSexe() + "\n"
				+ "Age : " + getAge() + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Poids : " + getPoids() + "\n"
				+ "Energie : " + getEnergie() + "\n"
				+ "Force : " + getForce() + "\n"
				+ "Vie : " + getVie() + "\n"
				+ "Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"Guerrier : \n"
				+ "Nom : " + getNom() + "\n"
				+ "Sexe : " + getSexe() + "\n"
				+ "Age : " + getAge() + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Poids : " + getPoids() + "\n"
				+ "Energie : " + getEnergie() + "\n"
				+ "Force : " + getForce() + "\n"
				+ "Vie : " + getVie() + "\n"
				+ "Position : "+ getPosition() + "\n";
				break;
		}
		
		return caracPersonnage;
	}

}
