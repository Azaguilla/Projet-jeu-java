package Model;

public final class Magicien extends Personnage {
	private static Personnage getInstance;
	
	@Override
	public void attaquer(Monstre monstre, Jeu jeu) {
		System.out.println("Vous sortez votre dague et vous infligez "+this.getForce()+" pts de d�g�t au monstre.");
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
	
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		System.out.println("L'air cr�pite autour de vous et vous infligez "+this.getForce()*3+" pts de d�g�t au monstre.");
		this.setEnergie(this.getEnergie()-5);
		monstre.setVie(this.getForce()*3, jeu);
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
