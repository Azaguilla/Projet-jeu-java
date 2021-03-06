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
	 * Cr�e un nouveau Rodeur
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
	 * Le Rodeur a une chance de faire un coup critique et d'infliger 2 fois plus de d�g�ts
	 * R�veille le monstre
	 * Si la vie du monstre en inf�rieur ou �gale � 0, le monstre meurt
	 * Sinon le monstre attaque a son tour et met jour la vie du personnage selon la force du monstre
	 * Le Rodeur a une chance d'esquiver l'attaque du monstre et ne prend que la moiti� des d�g�ts inflig�
	 * @param monstre Le monstre choisi
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
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
				return "Coup critique! Vous infligez "+this.getForce()*2+" pts de d�g�t au monstre. Le monstre succombe � ses blessures.";
			}
			else
			{
				int m = rand.nextInt(2);
				if(m == 0)
				{
					this.setVie(this.getVie()-degatsMonstre/2);
					return "Coup critique! Vous infligez "+this.getForce()*2+" pts de d�g�t au monstre."
						 + "\nLe monstre r�plique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+degatsMonstre/2+" pts de d�g�t.";
				}
				else
				{
					this.setVie(this.getVie()-degatsMonstre);
					return "Coup critique! Vous infligez "+this.getForce()*2+" pts de d�g�t au monstre."
						 + "Le monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
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
				return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de d�g�t au monstre. Le monstre succombe � ses blessures.";
			}
			else
			{
				int m = rand.nextInt(2);
				if(m == 0)
				{
					this.setVie(this.getVie()-degatsMonstre/2);
					return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de d�g�t au monstre."
						 + "\nLe monstre r�plique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+degatsMonstre/2+" pts de d�g�t.";
				}
				else
				{
					this.setVie(this.getVie()-degatsMonstre);
					return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de d�g�t au monstre."
						 + "Le monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
				}
			}
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
		monstre.seReveiller();
		int degatsMonstre = (monstre.getForce() + monstre.getTaille())/2;
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
			return "\nL'air cr�pite autour de vous et vous infligez "+this.getForce()+" pts de d�g�t au monstre. Il succombe � ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-degatsMonstre);
			return "\nL'air cr�pite autour de vous et vous infligez "+this.getForce()+" pts de d�g�t au monstre. \nLe monstre r�plique et vous inflige "+degatsMonstre+" pts de d�g�t.";
		}
	}
	
	/**
	 * Affiche les information d�taill�es du Rodeur
	 * @return Les informations
	 */
	public String infosPersoDetail()
	{
		String caracPersonnage;
		switch (this.getSexe())
		{
			case "F": 
				caracPersonnage = 
				"R�deuse : \n"
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
				"R�deur : \n"
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
				"R�deur : \n"
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
				"R�deuse : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			case "M": 
				caracPersonnage = 
				"R�deur : \n"
				+ "Energie : " + getEnergie()
				+ " | Vie : " + getVie()
				+ " | Force : " + getForce()
				+ " | Magie : " + getForce()
				+ " | Position : "+ getPosition() + "\n";
				break;
			default: 
				caracPersonnage = 
				"R�deur : \n"
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
