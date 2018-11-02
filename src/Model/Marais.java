package Model;

public class Marais extends Case 
{
	private int profondeur;

	/**
	 * Le type de biome de la case
	 * @param numCase Le num�ro de la case marais
	 * @param taille La taille de la case marais
	 * @param pollution La pollution de la case marais
	 * @param profondeur La profondeur de la case marais
	 */
	public Marais(int numCase, int taille, int pollution, int profondeur) 
	{
		super(numCase, taille, pollution);
		this.profondeur = profondeur;
	}
	
	/**
	 * Affiche les information de la case marais
	 * @return Les informations
	 */
	@Override
	public String toString() 
	{
		return "\n\n--------Marais-------- \n"
				+ "Num�ro de la case : " + getNumCase() + "\n"
				+ "Profondeur : " + profondeur + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}
	
	/**
	 * Inflige des d�gats au personnage selon de niveau de pollution de la case marais
	 * @param personnage Le personnage du joueur
	 */
	@Override
	public String degatPersonnage(Personnage personnage) 
	{
		switch (this.getPollution()) 
		{
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			return "Des tas de boue pollu�e sont diss�min�s �� et l�. Vous tr�buchez sur l'un d'eux et vous perdez 1 pts de vie.";
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			return "La pollution a fait muter les branches des arbres qui tentent de vous attraper. Vous vous d�battez mais les �pines vous �raflent les bras et le visage. Vous perdez 2 pts de vie.";
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			return "La pollution du marais a ramen� des insectes d'une grande f�rocit�. Ils vous vous piquent et tentent de s'infiltrer dans vos oreilles. Vous perdez 3 pts de vie.";
		default: 
			personnage.setVie(personnage.getVie());
			return "L'odeur qui s'�chappe du marais n'est pas agr�able mais vous ne remarquez rien d'anormal.";
		}
		
	}

	/**
     * Permet de r�cup�rer la profondeur de la case marais
     * @return La profondeur de la case marais
     */
	public int getProfondeur() 
	{
		return profondeur;
	}

	/**
     * Permet de modifier la profondeur de la case marais
     * @param profondeur La profondeur de la case marais
     */
	public void setProfondeur(int profondeur) 
	{
		this.profondeur = profondeur;
	}

	/**
	 * Permet de nettoyer la case marais si la case n'est pas d�j� propre
	 * @return Un message d'information
	 */
	@Override
	public String nettoyerCase() 
	{
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
	
	/**
	 * Ajoute un monstres qui ne peut se trouver que dans les marais (Blobs et Basilics)
	 * @param monstre Le monstre a ajouter
	 * @return vrai(true) si le monste est un Blob ou un Basilic et si le monstre peut �tre ajout�
	 * 		   faux(false) si le monstre ne peut pas �tre ajout� ou si ce n'est pas un Blob ou un Basilic
	 */
	@Override
	public boolean ajoutMonstre(Monstre monstre) {
		if(monstre instanceof Blob || monstre instanceof Basilic)
		{
			if(this.monstres.size()<this.getTaille())
			{
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
