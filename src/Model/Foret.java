package Model;

public class Foret extends Case 
{

	private int hauteur;

	/**
	 * Le type de biome de la case
	 * @param int numCase Le numéro de la case foret
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
				+ "Numéro de la case : " + getNumCase() + "\n"
				+ "Hauteur : " + hauteur + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}

	/**
     * Permet de récupérer la hauteur de la case foret
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
	 * Inflige des dégats au personnage selon de niveau de pollution de la case foret
	 * @param Personnage personnage Le personnage du joueur
	 */
	@Override
	public String degatPersonnage(Personnage personnage) 
	{
		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			return "Vous sentez une odeur étrange et désagréable. Le poison s'inflitre dans vos poumons et vous perdez 1 pts de vie.";
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			return "L'air est nauséabond et des miasmes s'accrochent aux branches des arbres. Vous pouvez à peine respirez et vous perdez 2 pts de vie.";
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			return "L'atmosphère est épaisse et vous voyez à peine devant vous à cause de la pollution. Vous suffoquez et vous perdez 3 pts de vie.";
		default: 
			personnage.setVie(personnage.getVie());
			return "L'air de la forêt est pure.";
		}
	}

	/**
	 * Permet de nettoyer la case foret si la case n'est pas déjà propre
	 */
	@Override
	public String nettoyerCase() 
	{
		if(this.getPollution() == 0)
		{
			return "\nLa case est déjà propre.\n";
		}
		else
		{
			this.setPollution(this.getPollution()-1);
			return"\nVous entrez en transe et invoquez des esprits purificateurs. La pollution baisse d'un niveau.\n";
		}
		//heure -- >le faire au moment de l'appel à la méthode ?
	}

	/**
	 * Ajoute un monstres qui ne peut se trouver que dans les forets (Ent et LoupGarou)
	 * @param Monstre monstre Le monstre a ajouter
	 * @return boolean vrai(true) si le monste est un Ent ou un LoupGarou et si le monstre peut être ajouté
	 * 				   faux(false) si le monstre ne peut pas être ajouté ou si ce n'est pas un Ent ou un LoupGarou
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
