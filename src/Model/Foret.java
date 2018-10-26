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
		return "Foret  \n"
				+ "Numéro de la case : " + getNumCase() + "\n"
				+ "Hauteur : " + hauteur + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Les monstres : \n" + getMonstres() + "\n"
				+ "Nombre de monstres maximum : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n";
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
			System.out.println("Vous entrez une odeur étrange et désagréable. Le poison s'inflitre dans vos poumons et vous perdez 1 pts de vie.");
			personnage.setVie(personnage.getVie()-1);
			break;
		case 2 : 
			System.out.println("L'air est nauséabond et des miasmes s'accrochent aux branches des arbres. Vous pouvez à peine respirez et vous perdez 2 pts de vie.");
			personnage.setVie(personnage.getVie()-2);
			break;
		case 3 : 
			System.out.println("L'atmosphère est épaisse et vous voyez à peine devant vous à cause de la pollution. Vous suffoquez et vous perdez 3 pts de vie.");
			personnage.setVie(personnage.getVie()-3);
			break;
		default: 
			System.out.println("L'air de la forêt est pure.");
			personnage.setVie(personnage.getVie());
		}
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
