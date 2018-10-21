package jeu;

public final class Magicien extends Personnage {
	private static Personnage getInstance;
	
	@Override
	public void attaquer(Monstre monstre) {
		monstre.setVie(monstre.getVie()-this.getForce());
	}
	
	public void lancerSort(Monstre monstre)
	{
		monstre.setVie(monstre.getVie()-this.getForce()*3);
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
