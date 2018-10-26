package Model;

public final class Magicien extends Personnage {
	private static Personnage getInstance;
	
	@Override
	public void attaquer(Monstre monstre, Jeu jeu) {
		System.out.println("Vous sortez votre dague et vous infligez "+this.getForce()+" pts de dégât au monstre.");
		monstre.setVie(this.getForce(), jeu);
		if(monstre.getVie() < 0)
		{
			monstre.mourir(jeu);
		}
	}
	
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		System.out.println("L'air crépite autour de vous et vous infligez "+this.getForce()*3+" pts de dégât au monstre.");
		monstre.setVie(this.getForce()*3, jeu);
		if(monstre.getVie() < 0)
		{
			monstre.mourir(jeu);
		}
	}

	private Magicien(String nom, String sexe, String classe) {
		super(nom, sexe, classe);
	}

	
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Magicien(nom, sexe, classe); 
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
}
