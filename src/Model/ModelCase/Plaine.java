package Model.ModelCase;

import Model.ModelMonstre.Monstre;
import Model.ModelPersonnage.Personnage;

public class Plaine extends Case 
{
	
	/**
	 * Le type de biome de la case
	 * @param numCase Le numéro de la case plaine
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
				+ "Numéro de la case : " + getNumCase() + "\n"
				+ "Taille : " + getTaille() + "\n"
				+ "Nombre de monstres : " + getNbMaxMonstre() + "\n"
				+ "Niveau de pollution : "+ getPollution() + "\n"
				+ "LES MONSTRES : \n" + getMonstres() + "\n";
	}

	/**
	 * Inflige des dégats au personnage selon de niveau de pollution de la case plaine
	 * @param personnage Le personnage du joueur
	 */
	//Inflige des degats au personnage selon le niveau de pollution
	public String degatPersonnage(Personnage personnage) 
	{
		switch (this.getPollution()) {
		case 1 :
			personnage.setVie(personnage.getVie()-1);
			return "L'herbe autrefois grasse et d'un vert majestueux est maintenant spongieuse et jaunâtre. Vous glissez et perdez 1 pts de vie.\n";
		case 2 : 
			personnage.setVie(personnage.getVie()-2);
			return "Avec le sol glissant et l'atmosfère étouffante, votre tête tourne et vous tombez plusieurs fois. Vous vous blessez et perdez 2 pts de vie.\n";
		case 3 : 
			personnage.setVie(personnage.getVie()-3);
			return "Des roses ont muté sur la plaine ! Elles tentent de vous dévorer ! Vous perdez 3 pts de vie.\n";
		default: 
			personnage.setVie(personnage.getVie());
			return "Le vent frais souffle sur votre visage, le soleil illumine la plaine luxuriante.\n";
		}
	}

	/**
	 * Permet de nettoyer la case plaine si la case n'est pas déjà propre
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
	}
	
	/**
	 * Ajoute un monstres
	 * @param monstre Le monstre a ajouter
	 * @return vrai(true) si le monstre peut être ajouté
	 * 		   faux(false) si le monstre ne peut pas être ajouté
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
