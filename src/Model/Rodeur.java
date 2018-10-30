package Model;

import java.util.Random;

public class Rodeur extends Personnage {
	private static Personnage getInstance;
	private Random rand = new Random();
	
	private Rodeur(String nom, String sexe, String classe) {
		super(nom, sexe, classe);
	}
	
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Rodeur(nom, sexe, classe); 
	    }
	        return getInstance; 
	}

	@Override
	public String attaquer(Monstre monstre, Jeu jeu) {
		int n = rand.nextInt(2);
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
					this.setVie(this.getVie()-monstre.getForce()/2);
					return "Coup critique! Vous infligez "+this.getForce()*2+" pts de dégât au monstre."
						 + "\nLe monstre réplique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+monstre.getForce()/2+" pts de dégât.";
				}
				else
				{
					this.setVie(this.getVie()-monstre.getForce());
					return "Coup critique! Vous infligez "+this.getForce()*2+" pts de dégât au monstre."
						 + "Le monstre réplique et vous inflige "+monstre.getForce()+" pts de dégât.";
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
					this.setVie(this.getVie()-monstre.getForce()/2);
					return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de dégât au monstre."
						 + "\nLe monstre réplique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+monstre.getForce()/2+" pts de dégât.";
				}
				else
				{
					this.setVie(this.getVie()-monstre.getForce());
					return "Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de dégât au monstre."
						 + "Le monstre réplique et vous inflige "+monstre.getForce()+" pts de dégât.";
				}
			}
		}
	}
	
	public String lancerSort(Monstre monstre, Jeu jeu)
	{
		monstre.setVie(this.getForce(), jeu);
		this.setEnergie(this.getEnergie()-5);
		monstre.setSommeil(false);
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
			return "L'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. Il succombe à ses blessures.";
		}
		else
		{
			this.setVie(this.getVie()-monstre.getForce());
			return "L'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre. \nLe monstre réplique et vous inflige "+monstre.getForce()+" pts de dégât.";
		}
	}
	
	@Override
	public String toString() {
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
}
