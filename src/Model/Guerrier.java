package Model;

public class Guerrier extends Personnage {
	private static Personnage getInstance;

	private Guerrier(String nom, String sexe, String classe) {
		super(nom, sexe, classe);
	}
	
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Guerrier(nom, sexe, classe); 
	    }
	        return getInstance; 
	}

	@Override
	public void attaquer(Monstre monstre, Jeu jeu) {
		System.out.println("Votre �p�e fend l'air et vous infligez "+this.getForce()*3+" pts de d�g�t au monstre.");
		monstre.setVie(this.getForce()*3, jeu);
		if(monstre.getVie() < 0)
		{
			monstre.mourir(jeu);
		}
	}
	
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		System.out.println("L'air cr�pite autour de vous et vous infligez "+this.getForce()+" pts de d�g�t au monstre.");
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

}
