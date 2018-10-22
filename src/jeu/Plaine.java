package jeu;

public class Plaine extends Case {
	
	public Plaine(int numCase, int taille, int pollution) {
		super(numCase, taille, pollution);
	}
	
	@Override
	public String toString() {
		return "Plaine [infosCase()=" + infosCase() + ", getNumCase()=" + getNumCase() + ", getTaille()=" + getTaille()
				+ ", getNbMaxMonstre()=" + getNbMaxMonstre() + ", getPollution()=" + getPollution() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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
	
	@Override
	public boolean ajoutMonstre(Monstre monstre) {
		monstre.setNumCaseActuelle(this.getNumCase());
		this.monstres[this.getNbMaxMonstre()] = monstre;
		this.setNbMaxMonstre(this.getNbMaxMonstre()+1); 
		return true;
	}


}
