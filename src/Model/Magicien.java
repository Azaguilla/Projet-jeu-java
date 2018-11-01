package Model;

public final class Magicien extends Personnage 
{
	
	private static Personnage getInstance;
	
	/**
	 * Attaque un monstre et met a jour la vie du monstre selon la force du personnage
	 * R�veille le monstre
	 * Si la vie du monstre en inf�rieur ou �gale � 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param Monstre monstre Le monstre choisi
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return String
	 */
	@Override
	public String attaquer(Monstre monstre, Jeu jeu) 
	{
		monstre.setVie(this.getForce(), jeu);
		monstre.setSommeil(false);
		int degatsMonstre = monstre.getForce() + monstre.getTaille();
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
			return "Vous sortez votre dague et vous infligez "+this.getForce()+" pts de d�g�t au monstre. Le monstre succombe � ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "Vous sortez votre dague et vous infligez "+this.getForce()+" pts de d�g�t au monstre. \nLe monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
		}
	}
	
	/**
	 * Lance un sort au monstre et met a jour la vie du monstre selon la force du personnage et l'�nergie d�pens�e
	 * R�veille le monstre
	 * Si la vie du monstre en inf�rieur ou �gale � 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param Monstre monstre Le monstre choisi
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return String
	 */
	public String lancerSort(Monstre monstre, Jeu jeu)
	{
		monstre.setVie(this.getForce(), jeu);
		this.setEnergie(this.getEnergie()-5);
		monstre.setSommeil(false);
		int degatsMonstre = monstre.getForce() + monstre.getTaille();
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
			return "L'air cr�pite autour de vous et vous infligez "+this.getForce()*3+" pts de d�g�t au monstre. Il succombe � ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "L'air cr�pite autour de vous et vous infligez "+this.getForce()*3+" pts de d�g�t au monstre. \nLe monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
		}
	}

	/**
	 * Personnage Magicien
	 * @param nom Le nom du Magicien
	 * @param sexe Le sexe du Magicien
	 * @param classe La classe du Magicien
	 */
	private Magicien(String nom, String sexe, String classe) 
	{
		super(nom, sexe, classe);
	}

	//TODO v�rifier doc
	/**
	 * Cr�e un nouveau Magicien
	 * @param nom Le nom du Magicien
	 * @param sexe Le sexe du Magicien
	 * @param classe La classe du Magicien
	 * @return
	 */
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Magicien(nom, sexe, classe); 
	    }
	    return getInstance; 
	}
	
	/**
	 * Affiche les information d�taill�es du Magicien
	 * @return String caracPersonnage Les informations
	 */
	public String infosPersoDetail()
	{
		String caracPersonnage;
		switch (this.getSexe())
		{
			case "F": 
				caracPersonnage = 
				"Magicienne : \n"
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
				"Magicien : \n"
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
				"Magicien : \n"
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
	
	/**
	 * Affiche les information les plus importantes du chasseur
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
				"Magicienne : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()*3
				+ " | Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"Magicien : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()*3
				+ " | Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"Magicien : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()*3
				+ " | Position : "+ getPosition() + "\n";
				break;
		}
		
		return caracPersonnage;
	}
}
