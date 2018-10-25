package Model;

public final class Magicien extends Personnage {
	private static Personnage getInstance;
	
	@Override
	public void attaquer(Monstre monstre, Jeu jeu) {
		monstre.setVie(monstre.getVie()-this.getForce(), jeu);
	}
	
	public void lancerSort(Monstre monstre, Jeu jeu)
	{
		monstre.setVie(monstre.getVie()-this.getForce()*3, jeu);
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
}
