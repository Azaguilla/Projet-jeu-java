package jeu;

public class Chasseur extends Personnage {
	private static Personnage getInstance;
	
	private Chasseur(String nom, String sexe, String classe) {
		super(nom, sexe, classe);
	}

	@Override
	public void attaquer(Monstre monstre, Jeu jeu) {
		monstre.setVie(monstre.getVie()-this.getForce(), jeu);
	}
	
	public static Personnage getInstance(String nom, String sexe, String classe) 
	{ 
	    if (getInstance == null) 
	    {
	         getInstance = new Chasseur(nom, sexe, classe); 
	    }
	        return getInstance; 
	}
	
}
