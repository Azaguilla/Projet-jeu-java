package Model;

public class Plaine extends Case {
	
	public Plaine(int numCase, int taille, int pollution) {
		super(numCase, taille, pollution);
	}
	
	@Override
	public String toString() {
		return "\n\n--------Plaine-------- \n"
				+ "Num�ro de la case : " + getNumCase() + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}


	//Inflige des degats au personnage selon le niveau de pollution
	public String degatPersonnage(Personnage personnage) {
		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			return "Pollution niveau 1 : vous perdez 1 pts de vie.";
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			return "Pollution niveau 2 : vous perdez 2 pts de vie.";
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			return "Pollution niveau 1 : vous perdez 3 pts de vie.";
		default: 
			personnage.setVie(personnage.getVie());
			return "Le vent frais souffle sur votre visage, le soleil illumine la plaine luxuriante.";
		}
	}

	@Override
	public String nettoyerCase() {
		if(this.getPollution() == 0)
		{
			return "\nLa case est d�j� propre.\n";
		}
		else
		{
			this.setPollution(this.getPollution()-1);
			return"\nVous entrez en transe et invoquez des esprits purificateurs. La pollution baisse d'un niveau.\n";
		}
	}
	
	@Override
	public boolean ajoutMonstre(Monstre monstre) {
		if(this.monstres.size()<this.getTaille()){
			monstre.setNumCaseActuelle(this.getNumCase());
			this.monstres.add(monstre);
			this.setNbMaxMonstre(this.getNbMaxMonstre()+1); 
			return true;
		}
		else
		{
			System.out.println("Il y a trop de monstre sur la case");
			return false;
		}
	}


}
