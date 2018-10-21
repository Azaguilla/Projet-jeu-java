package jeu;

public class Foret extends Case {

	private int hauteur;

	public Foret(int numCase, int taille, int pollution, int hauteur) {
		super(numCase, taille, pollution);
		this.hauteur = hauteur;
	}

	@Override
	public String toString() {
		return "Foret [hauteur=" + hauteur + "]";
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	@Override
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
		// TODO Auto-generated method stub
		
	}

}
