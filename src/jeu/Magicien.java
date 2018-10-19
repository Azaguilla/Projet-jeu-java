package jeu;

public final class Magicien extends Personnage {
	private static Personnage getInstance;
	
	@Override
	public void attaquer() {
		// TODO Auto-generated method stub
		
	}
	
	public void lancerSort()
	{
		
	}

	private Magicien(String nom, String sexe, String classe) {
		super(nom, sexe, classe);
		// TODO Auto-generated constructor stub
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
