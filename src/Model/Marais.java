package Model;

public class Marais extends Case {
	private int profondeur;
	//private boolean vase;

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
		//if(this.vase == true)
		//{this.vase == false; heure --;}
	}
	
	@Override
	public boolean ajoutMonstre(Monstre monstre) {
		if(monstre instanceof Blob || monstre instanceof Basilic)
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
