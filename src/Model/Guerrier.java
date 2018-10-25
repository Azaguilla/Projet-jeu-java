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
		monstre.setVie(monstre.getVie()-this.getForce()*3, jeu);
	}

}
