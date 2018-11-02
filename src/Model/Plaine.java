package Model;

public class Plaine extends Case 
{
	
	/**
	 * Le type de biome de la case
	 * @param numCase Le num�ro de la case plaine
	 * @param taille La taille de la case plaine
	 * @param pollution La pollution de la case plaine
	 * @param hauteur La hauteur de la case plaine
	 */
	public Plaine(int numCase, int taille, int pollution) 
	{
		super(numCase, taille, pollution);
	}
	
	/**
	 * Affiche les information de la case plaine
	 * @return Les informations
	 */
	@Override
	public String toString() 
	{
		return "\n\n--------Plaine-------- \n"
				+ "Num�ro de la case : " + getNumCase() + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}

	/**
	 * Inflige des d�gats au personnage selon de niveau de pollution de la case plaine
	 * @param personnage Le personnage du joueur
	 */
	//Inflige des degats au personnage selon le niveau de pollution
	public String degatPersonnage(Personnage personnage) 
	{
		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			return "Pollution niveau 1 : vous perdez 1 pts de vie.";
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			return "Pollution niveau 2 : vous perdez 2 pts de vie.";
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			return "Pollution niveau 3 : vous perdez 3 pts de vie.";
		default: 
			personnage.setVie(personnage.getVie());
			return "Le vent frais souffle sur votre visage, le soleil illumine la plaine luxuriante.";
		}
	}

	/**
	 * Permet de nettoyer la case plaine si la case n'est pas d�j� propre
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
	 * Ajoute un monstres
	 * @param monstre Le monstre a ajouter
	 * @return vrai(true) si le monstre peut �tre ajout�
	 * 		   faux(false) si le monstre ne peut pas �tre ajout�
	 */
	@Override
	public boolean ajoutMonstre(Monstre monstre) 
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
			//System.out.println("Il y a trop de monstre sur la case");
			return false;
		}
	}


}
