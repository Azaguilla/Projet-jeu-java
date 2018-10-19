package jeu;

public class Plaine extends Case {
	
	public Plaine(int numCase, int taille, int pollution) {
		super(numCase, taille, pollution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Plaine [Case n° " + getNumCase() + ", de taille " + getTaille() + ". Cette case est occupée par"
				+ getNbMaxMonstre() + " monstres. Sa pollution est au niveau " + getPollution() + ".";
	}

	@Override
	public void degatPersonnage(Personnage personnage) {
		
		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
		default: 
			personnage.setVie(personnage.getVie());
		}
	}

	@Override
	public void netoyerCase() {
		this.setPollution(0);
	}


}
