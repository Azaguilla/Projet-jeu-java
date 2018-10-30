package Model;

public class Foret extends Case 
{

	private int hauteur;
	//private boolean toiles;

	/**
	 * Le type de biome de la case
	 * @param int numCase Le num�ro de la case foret
	 * @param int taille La taille de la case foret
	 * @param int pollution La pollution de la case foret
	 * @param int hauteur La hauteur de la case foret
	 */
	public Foret(int numCase, int taille, int pollution, int hauteur) 
	{
		super(numCase, taille, pollution);
		this.hauteur = hauteur;
	}

	/**
	 * Affiche les information de la case foret
	 * @return Les informations
	 */
	@Override
	public String toString() 
	{
		return "\n\n--------Foret--------  \n"
				+ "Num�ro de la case : " + getNumCase() + "\n"
				+ "Hauteur : " + hauteur + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}

	/**
     * Permet de r�cup�rer la hauteur de la case foret
     * @return int hauteur La hauteur de la case foret
     */
	public int getHauteur() 
	{
		return hauteur;
	}

	/**
     * Permet de modifier la hauteur de la case foret
     * @param int hauteur La hauteur de la case foret
     */
	public void setHauteur(int hauteur) 
	{
		this.hauteur = hauteur;
	}

	/**
	 * Inflige des d�gats au personnage selon de niveau de pollution de la case foret
	 * @param Personnage personnage Le personnage du joueur
	 */
	@Override
	public void degatPersonnage(Personnage personnage) 
	{
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

	/**
	 * Permet de nettoyer la case foret si la case n'est pas d�j� propre
	 */
	@Override
	public void nettoyerCase() 
	{
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

	/**
	 * Ajoute un monstres qui ne peut se trouver que dans les forets (Ent et LoupGarou)
	 * @param Monstre monstre Le monstre a ajouter
	 * @return boolean vrai(true) si le monste est un Ent ou un LoupGarou et si le monstre peut �tre ajout�
	 * 				   faux(false) si le monstre ne peut pas �tre ajouter ou si ce n'est pas un Ent ou un LoupGarou
	 */
	@Override
	public boolean ajoutMonstre(Monstre monstre) 
	{
		if(monstre instanceof Ent || monstre instanceof LoupGarou)
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
