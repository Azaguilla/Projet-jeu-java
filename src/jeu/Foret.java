package jeu;

public class Foret extends Case {

	private int hauteur;

	public Foret(int numCase, int taille, int nbMaxMonstre, int nbMonstre, int pollution, int hauteur) {
		super(numCase, taille, nbMaxMonstre, nbMonstre, pollution);
		this.hauteur = hauteur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	@Override
	public void degatPersonnage(Personnage personnage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void netoyerCase() {
		// TODO Auto-generated method stub
		
	}

}
