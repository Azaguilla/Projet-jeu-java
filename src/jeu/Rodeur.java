package jeu;

public class Rodeur extends Personnage {
	private static Personnage getInstance;
	public boolean ignorerMonstre(Monstre monstre, String choix, int max_case, Jeu jeu)
	{
		if(monstre.isSommeil())
		{
			return this.seDeplacer(choix, max_case, jeu);
		}
		else
		{
			System.out.println("Vous ne pouvez pas vous déplacer.");
			return false;
		}
	}

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
	public void attaquer(Monstre monstre) {
		monstre.setVie(monstre.getVie()-this.getForce());
		
	}
}
