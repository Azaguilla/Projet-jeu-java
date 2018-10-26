package Model;

public class Marais extends Case {
	private int profondeur;
	//private boolean vase;

	public Marais(int numCase, int taille, int pollution, int profondeur) {
		super(numCase, taille, pollution);
		this.profondeur = profondeur;
	}
	
	@Override
	public String toString() {
		return "Marais \n"
				+ "Numéro de la case : " + getNumCase() + "\n"
				+ "Profondeur : " + profondeur + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Les monstres : \n" + getMonstres() + "\n"
				+ "Nombre de monstres maximum : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n";
	}
	
	@Override
	public void degatPersonnage(Personnage personnage) {
		switch (this.getPollution()) {
		case 1 :
			System.out.println("Des tas de boue polluée sont disséminés çà et là. Vous trébuchez sur l'un d'eux et vous perdez 1 pts de vie.");
			personnage.setVie(personnage.getVie()-1);
			break;
		case 2 : 
			System.out.println("La pollution a fait muter les branches des arbres qui tentent de vous attraper. Vous vous débattez mais les épines vous éraflent les bras et le visage. Vous perdez 2 pts de vie.");
			personnage.setVie(personnage.getVie()-2);
			break;
		case 3 : 
			System.out.println("La pollution du marais a ramené des insectes d'une grande férocité. Ils vous vous piquent et tentent de s'infiltrer dans vos oreilles. Vous perdez 3 pts de vie.");
			personnage.setVie(personnage.getVie()-3);
			break;
		default: 
			System.out.println("L'odeur qui s'échappe du marais n'est pas agréable mais vous ne remarquez rien d'anormal.");
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
		if(this.getPollution() == 0)
		{
			System.out.println("La case est déjà propre.");
		}
		else
		{
			System.out.println("Vous entrez en transe et invoquez des esprits purificateurs. La pollution baisse d'un niveau.");
			this.setPollution(this.getPollution()-1);
		}
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
