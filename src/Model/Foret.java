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
				+ "Num�ro de la case : " + getNumCase() + "\n"
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
			System.out.println("Vous entrez une odeur �trange et d�sagr�able. Le poison s'inflitre dans vos poumons et vous perdez 1 pts de vie.");
			personnage.setVie(personnage.getVie()-1);
			break;
		case 2 : 
			System.out.println("L'air est naus�abond et des miasmes s'accrochent aux branches des arbres. Vous pouvez � peine respirez et vous perdez 2 pts de vie.");
			personnage.setVie(personnage.getVie()-2);
			break;
		case 3 : 
			System.out.println("L'atmosph�re est �paisse et vous voyez � peine devant vous � cause de la pollution. Vous suffoquez et vous perdez 3 pts de vie.");
			personnage.setVie(personnage.getVie()-3);
			break;
		default: 
			System.out.println("L'air de la for�t est pure.");
			personnage.setVie(personnage.getVie());
		}
	}

	@Override
	public void nettoyerCase() {
		if(this.getPollution() == 0)
		{
			System.out.println("La case est d�j� propre.");
		}
		else
		{
			System.out.println("Vous entrez en transe et invoquez des esprits purificateurs. La pollution baisse d'un niveau.");
			this.setPollution(this.getPollution()-1);
		}
		//heure -- >le faire au moment de l'appel � la m�thode ?
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
