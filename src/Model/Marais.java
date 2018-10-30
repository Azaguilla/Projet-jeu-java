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
		return "\n\n--------Marais-------- \n"
				+ "Numéro de la case : " + getNumCase() + "\n"
				+ "Profondeur : " + profondeur + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}
	
	@Override
	public String degatPersonnage(Personnage personnage) {
		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			return "Des tas de boue polluée sont disséminés çà et là. Vous trébuchez sur l'un d'eux et vous perdez 1 pts de vie.";
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			return "La pollution a fait muter les branches des arbres qui tentent de vous attraper. Vous vous débattez mais les épines vous éraflent les bras et le visage. Vous perdez 2 pts de vie.";
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			return "La pollution du marais a ramené des insectes d'une grande férocité. Ils vous vous piquent et tentent de s'infiltrer dans vos oreilles. Vous perdez 3 pts de vie.";
		default: 
			personnage.setVie(personnage.getVie());
			return "L'odeur qui s'échappe du marais n'est pas agréable mais vous ne remarquez rien d'anormal.";
		}
		
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	@Override
	public String nettoyerCase() {
		if(this.getPollution() == 0)
		{
			return "\nLa case est déjà propre.\n";
		}
		else
		{
			this.setPollution(this.getPollution()-1);
			return"\nVous entrez en transe et invoquez des esprits purificateurs. La pollution baisse d'un niveau.\n";
		}
		//if(this.vase == true)
		//{this.vase == false; heure --;}
	}
	
	@Override
	public boolean ajoutMonstre(Monstre monstre) {
		if(monstre instanceof Blob || monstre instanceof Basilic)
		{
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
		else
		{
			System.out.println("Vous ne pouvez pas ajouter ce type de monstre sur la case");
			return false;
		}
	}

}
