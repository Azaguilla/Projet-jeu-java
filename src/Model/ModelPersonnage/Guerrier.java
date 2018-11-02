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
	
	//TODO vérifier doc
	/**
	 * Crée un nouveau Guerrier
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
	 * Réveille le monstre
	 * Si la vie du monstre en inférieur ou égale à 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param monstre Le monstre choisi
	 * @param eu Les informations concernant l'anvancée du jeu, les monstres, les cases...
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
			return "Votre épée fend l'air et vous infligez "+this.getForce()*2+" pts de dégât au monstre. Le monstre succombe à ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "Votre épée fend l'air et vous infligez "+this.getForce()*2+" pts de dégât au monstre. \nLe monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
		}
	}
	
	/**
	 * Lance un sort au monstre et met a jour la vie du monstre selon la force du personnage et l'énergie dépensée
	 * Réveille le monstre
	 * Si la vie du monstre en inférieur ou égale à 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param monstre Le monstre choisi
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
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
			return "L'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. Il succombe à ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "L'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. \nLe monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
		}
	}
	
	/**
	 * Affiche les information détaillées du guerrier
	 * @return Les informations
	 */
	public String infosPersoDetail() 
	{
		String caracPersonnage;
		switch (this.getSexe())
		{
			case "F": 
				caracPersonnage = 
				"Guerrière : \n"
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
				"Guerrière : \n"
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


