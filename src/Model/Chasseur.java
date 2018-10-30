package Model;

public class Chasseur extends Personnage 
{
	private static Personnage getInstance;
	
	/**
	 * Personnage Chasseur
	 * @param nom Le nom du chasseur
	 * @param sexe Le sexe du chasseur
	 * @param classe La classe du chasseur
	 */
	private Chasseur(String nom, String sexe, String classe)
	{
		super(nom, sexe, classe);
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
		System.out.println("Vous tirez et votre fl�che inflige "+this.getForce()+" pts de d�g�t au monstre.");
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
		monstre.setVie(this.getForce(), jeu);
		this.setEnergie(this.getEnergie()-5);
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
	
	//TODO v�rifier doc
	/**
	 * Cr�e un nouveau Chasseur
	 * @param nom Le nom du chasseur
	 * @param sexe Le sexe du chasseur
	 * @param classe La classe du chasseur
	 * @return
	 */
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Chasseur(nom, sexe, classe); 
	    }
	        return getInstance; 
	}

	/**
	 * Affiche les information d�taill�es du chasseur
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
				"Chasseresse : \n"
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
				"Chasseur : \n"
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
				"Chasseur : \n"
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
	public String infosPersoSimple()
	{
		String caracPersonnage;
		switch (this.getSexe())
		{
			case "F": 
				caracPersonnage = 
				"Chasseresse : \n"
				+ "Energie : " + getEnergie() + "\n"
				+ "Force : " + getForce() + "\n"
				+ "Vie : " + getVie() + "\n"
				+ "Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"Chasseur : \n"
				+ "Energie : " + getEnergie() + "\n"
				+ "Force : " + getForce() + "\n"
				+ "Vie : " + getVie() + "\n"
				+ "Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"Chasseur : \n"
				+ "Energie : " + getEnergie() + "\n"
				+ "Force : " + getForce() + "\n"
				+ "Vie : " + getVie() + "\n"
				+ "Position : "+ getPosition() + "\n";
				break;
		}
		
		return caracPersonnage;
	}
	
}
