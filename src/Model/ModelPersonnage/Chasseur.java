package Model.ModelPersonnage;

import Model.ModelJeu.Jeu;
import Model.ModelMonstre.Monstre;

public class Chasseur extends Personnage 
{
	private static Personnage getInstance;
	
	/**
	 * Personnage Chasseur
	 * @param nom Le nom du Chasseur
	 * @param sexe Le sexe du Chasseur
	 * @param classe La classe du Chasseur
	 */
	private Chasseur(String nom, String sexe, String classe)
	{
		super(nom, sexe, classe);
	}

	/**
	 * Attaque un monstre et met a jour la vie du monstre selon la force du personnage
	 * Réveille le monstre
	 * Si la vie du monstre en inférieur ou égale à 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param Monstre monstre Le monstre choisi
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	@Override
	public String attaquer(Monstre monstre, Jeu jeu) 
	{
		monstre.setVie(this.getForce(), jeu);
		monstre.seReveiller();
		int degatsMonstre = (monstre.getForce() + monstre.getTaille())/2;
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
			return "Vous tirez et votre flèche inflige "+this.getForce()+" pts de dégât au monstre. Le monstre succombe à ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-degatsMonstre);
			return "Vous tirez et votre flèche inflige "+this.getForce()+" pts de dégât au monstre. \nLe monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
		}
	}
	
	/**
	 * Lance un sort au monstre et met a jour la vie du monstre selon la force du personnage et l'énergie dépensée
	 * Réveille le monstre
	 * Si la vie du monstre en inférieur ou égale à 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * @param Monstre monstre Le monstre choisi
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return String
	 */
	public String lancerSort(Monstre monstre, Jeu jeu)
	{
		monstre.setVie(this.getForce(), jeu);
		this.setEnergie(this.getEnergie()-5);
		monstre.setSommeil(false);
		int degatsMonstre = (monstre.getForce() + monstre.getTaille())/2;
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
			return "\nL'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. Il succombe à ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-degatsMonstre);
			return "\nL'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. \nLe monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
		}
	}
	
	/**
	 * Crée un nouveau Chasseur
	 * @param nom Le nom du chasseur
	 * @param sexe Le sexe du chasseur
	 * @param classe La classe du chasseur
	 * @return une instance du Chasseur
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
	 * Affiche les information détaillées du chasseur
	 * @return caracPersonnage Les informations
	 */
	
	public String infosPersoDetail()
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
	 * @return caracPersonnage Les informations
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
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"Chasseur : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"Chasseur : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
		}
		
		return caracPersonnage;
	}
	
}
