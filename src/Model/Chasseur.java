package Model;

public class Chasseur extends Personnage {
	private static Personnage getInstance;
	
	private Chasseur(String nom, String sexe, String classe) {
		super(nom, sexe, classe);
	}

	@Override
	public void attaquer(Monstre monstre, Jeu jeu) {
		System.out.println("Vous tirez et votre flèche inflige "+this.getForce()+" pts de dégât au monstre.");
		monstre.setVie(this.getForce(), jeu);
		if(monstre.getVie() < 0)
		{
			monstre.mourir(jeu);
		}
		else
		{
			System.out.println("Le monstre réplique et vous inflige "+monstre.getForce()+" pts de dégât.");
			this.setVie(this.getVie()-monstre.getForce());
		}
	}
	
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		System.out.println("L'air crépite autour de vous et vous infligez "+this.getForce()+" pts de dégât au monstre.");
		monstre.setVie(this.getForce(), jeu);
		this.setEnergie(this.getEnergie()-5);
		if(monstre.getVie() < 0)
		{
			monstre.mourir(jeu);
		}
		else
		{
			System.out.println("Le monstre réplique et vous inflige "+monstre.getForce()+" pts de dégât.");
			this.setVie(this.getVie()-monstre.getForce());
		}
	}
	
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Chasseur(nom, sexe, classe); 
	    }
	        return getInstance; 
	}

	@Override
	public String toString() {
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
	
}
