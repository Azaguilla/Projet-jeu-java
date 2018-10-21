package jeu;

public class Marais extends Case {
	private int profondeur;

	@Override
	public String toString() {
		return "Marais [profondeur=" + profondeur + "]";
	}

	public Marais(int numCase, int taille, int pollution, int profondeur) {
		super(numCase, taille, pollution);
		this.profondeur = profondeur;
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

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	@Override
	public void nettoyerCase() {
		// TODO Auto-generated method stub
		
	}

}
