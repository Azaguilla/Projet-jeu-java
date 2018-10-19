package jeu;

public class Plaine extends Case {
	
	public Plaine(int numCase, int taille, int pollution) {
		super(numCase, taille, pollution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Plaine [Case n� " + getNumCase() + ", de taille " + getTaille() + ". Cette case est occup�e par"
				+ getNbMaxMonstre() + " monstres. Sa pollution est au niveau " + getPollution() + ".";
	}

	//Inflige des degats au personnage selon le niveau de pollution
	public void degatPersonnage(Personnage personnage) {

		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			break;
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			break;
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			break;
		default: 
			personnage.setVie(personnage.getVie());
		}
	}

	@Override
	public void nettoyerCase() {
		this.setPollution(0);
	}


}
