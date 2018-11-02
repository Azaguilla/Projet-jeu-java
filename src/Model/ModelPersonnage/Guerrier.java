package Model.ModelPersonnage;

import Model.ModelJeu.Jeu;
import Model.ModelMonstre.Monstre;

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
	 * @return Une instance de Guerrier
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
	 * @param monstre Le monstre choisi
	 * @param eu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return Un message d'information
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
			return "Votre �p�e fend l'air et vous infligez "+this.getForce()*2+" pts de d�g�t au monstre. Le monstre succombe � ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "Votre �p�e fend l'air et vous infligez "+this.getForce()*2+" pts de d�g�t au monstre. \nLe monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
		}
	}
	
	/**
	 * Lance un sort au monstre et met a jour la vie du monstre selon la force du personnage et l'�nergie d�pens�e
	 * R�veille le monstre
	 * Si la vie du monstre en inf�rieur ou �gale � 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param monstre Le monstre choisi
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return Un message d'information
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
			return "L'air cr�pite autour de vous et vous infligez "+this.getForce()+" pts de d�g�t au monstre. Il succombe � ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "L'air cr�pite autour de vous et vous infligez "+this.getForce()+" pts de d�g�t au monstre. \nLe monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
		}
	}
	
	/**
	 * Affiche les information d�taill�es du guerrier
	 * @return Les informations
	 */
	public String infosPersoDetail() 
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
	
	/**
	 * Affiche les information les plus importantes du chasseur
	 * @return Les informations
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
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()*2
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"Guerrier : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()*2
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"Guerrier : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()*2
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
		}
		
		return caracPersonnage;
	}
	
}


