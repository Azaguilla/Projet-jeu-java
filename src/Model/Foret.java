package Model;

public class Foret extends Case {

	private int hauteur;
	//private boolean toiles;

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
		this.setPollution(0);
		//heure -- >le faire au moment de l'appel à la méthode ?
		//if(this.toiles == true)
		//{this.toiles == false; heure --;}
	}

	@Override
	public boolean ajoutMonstre(Monstre monstre) {
		if(monstre instanceof Ent || monstre instanceof LoupGarou)
		{
			if(this.monstres.size()<MAX_MONSTRES){
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
		else
		{
			System.out.println("Vous ne pouvez pas ajouter ce type de monstre sur la case");
			return false;
		}
	}
}
