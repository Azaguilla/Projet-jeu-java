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
	public void attaquer(Monstre monstre, Jeu jeu) {
		int n = rand.nextInt(2);
		if(n == 0)
		{
			System.out.println("Coup critique! Vous infligez "+this.getForce()*2+" pts de dégât au monstre.");
			monstre.setVie(this.getForce()*2, jeu);
		}
		else
		{
			System.out.println("Votre poignard attend sa cible et vous infligez "+this.getForce()+" pts de dégât au monstre.");
			monstre.setVie(this.getForce(), jeu);
		}
		if(monstre.getVie() <= 0)
		{
			monstre.mourir(jeu);
		}
		else
		{
			int m = rand.nextInt(2);
			if(m == 0)
			{
				System.out.println("Le monstre réplique mais vous esquivez le gros de l'attaque, le monstre vous inflige "+monstre.getForce()/2+" pts de dégât.");
				this.setVie(this.getVie()-monstre.getForce()/2);
			}
			else
			{
				System.out.println("Le monstre réplique et vous inflige "+monstre.getForce()+" pts de dégât.");
				this.setVie(this.getVie()-monstre.getForce());
			}
		}
	}
	
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		this.setEnergie(this.getEnergie()-5);
		System.out.println("L'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre.");
		monstre.setVie(this.getForce(), jeu);
		if(monstre.getVie() < 0)
		{
			monstre.mourir(jeu);
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
