package Model.ModelPersonnage;

import java.util.Random;

import Model.ModelJeu.Jeu;
import Model.ModelMonstre.Monstre;

public class Rodeur extends Personnage 
{
	
	private static Personnage getInstance;
	private Random rand = new Random();
	
	/**
	 * Personnage Rodeur
	 * @param nom Le nom du Rodeur
	 * @param sexe Le sexe du Rodeur
	 * @param classe La classe du Rodeur
	 */
	private Rodeur(String nom, String sexe, String classe) 
	{
		super(nom, sexe, classe);
	}
	
	/**
	 * Crée un nouveau Rodeur
	 * @param nom Le nom du Rodeur
	 * @param sexe Le sexe du Rodeur
	 * @param classe La classe du Rodeur
	 * @return Une instance de Rodeur
	 */
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Rodeur(nom, sexe, classe); 
	    }
	        return getInstance; 
	}

	/**
	 * Attaque un monstre et met a jour la vie du monstre selon la force du personnage
	 * Le Rodeur a une chance de faire un coup critique et d'infliger 2 fois plus de dégâts
	 * Réveille le monstre
	 * Si la vie du monstre en inférieur ou égale à 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * Le Rodeur a une chance d'esquiver l'attaque du monstre et ne prend que la moitié des dégâts infligé
	 * @param monstre Le monstre choisi
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return Un message d'information
	 */
	@Override
	public String attaquer(Monstre monstre, Jeu jeu) 
	{
		int n = rand.nextInt(2);
		int degatsMonstre = monstre.getForce() + monstre.getTaille();
		if(n == 0)
		{
			monstre.setVie(this.getForce()*2, jeu);
			monstre.setSommeil(false);

			if(monstre.getVie() <= 0)
			{
				monstre.mourir(jeu);
				return "Coup critique! Vous infligez "+this.getForce()*2+" pts de dégât au monstre. Le monstre succombe à ses blessures.";
			}
			else
			{
				int m = rand.nextInt(2);
				if(m == 0)
				{
					this.setVie(this.getVie()-degatsMonstre/2);
					return "Coup critique! Vous infligez "+this.getForce()*2+" pts de dégât au monstre."
						 + "\nLe monstre réplique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+degatsMonstre/2+" pts de dégât.";
				}
				else
				{
					this.setVie(this.getVie()-degatsMonstre);
					return "Coup critique! Vous infligez "+this.getForce()*2+" pts de dégât au monstre."
						 + "Le monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
				}
			}
		}
		else
		{
			monstre.setVie(this.getForce(), jeu);
			monstre.setSommeil(false);
			if(monstre.getVie() <= 0)
			{
				monstre.mourir(jeu);
				return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de dégât au monstre. Le monstre succombe à ses blessures.";
			}
			else
			{
				int m = rand.nextInt(2);
				if(m == 0)
				{
					this.setVie(this.getVie()-degatsMonstre/2);
					return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de dégât au monstre."
						 + "\nLe monstre réplique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+degatsMonstre/2+" pts de dégât.";
				}
				else
				{
					this.setVie(this.getVie()-degatsMonstre);
					return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de dégât au monstre."
						 + "Le monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
				}
			}
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
			return "\nL'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. Il succombe à ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-degatsMonstre);
			return "\nL'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. \nLe monstre réplique et vous inflige "+degatsMonstre+" pts de dégât.";
		}
	}
	
	/**
	 * Affiche les information détaillées du Rodeur
	 * @return Les informations
	 */
	public String infosPersoDetail()
	{
		String caracPersonnage;
		switch (this.getSexe())
		{
			case "F": 
				caracPersonnage = 
				"Rôdeuse : \n"
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
				"Rôdeur : \n"
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
				"Rôdeur : \n"
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
				"Rôdeuse : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"Rôdeur : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"Rôdeur : \n"
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
