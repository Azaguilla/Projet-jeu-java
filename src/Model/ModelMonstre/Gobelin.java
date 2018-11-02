package Model.ModelMonstre;

import Model.ModelJeu.Jeu;
import Model.ModelCase.Case;

public class Gobelin extends Monstre implements Terrestre, Vivipare 
{
	private int tempsGestation = 0;
	private int dureeGestation = 2;
	
	/**
	 * Monstre de l'esp�ce des Gobelins
	 * @param nom Nom du Gobelin
	 * @param sexe Sexe du Gobelin
	 * @param poids Poids du Gobelin
	 * @param taille Taille du Gobelin
	 * @param age Age du Gobelin
	 * @param sommeil Etat de sommeil du Gobelin, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Gobelin(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
     * Permet de r�cup�rer le temps de gestation du Gobelin
     * @return Le temps de gestation du Gobelin
     */
	public int getTempsGestation() 
	{
		return tempsGestation;
	}

	/**
	 * Permet de modifier le temps de gestation du Gobelin
	 * @param tempsGestation Le temps de gestation du Gobelin
	 */
	public void setTempsGestation(int tempsGestation) 
	{
		this.tempsGestation = tempsGestation;
	}

	/**
     * Permet de r�cup�rer la dur�e de gestation du Gobelin
     * @return La dur�e de gestation du Gobelin
     */
	public int getDureeGestation() 
	{
		return dureeGestation;
	}

	/**
	 * Permet de modifier la dur�e de gestation du Gobelin
	 * @param dureeGestation La dur�e de gestation du Gobelin
	 */
	public void setDureeGestation(int dureeGestation) 
	{
		this.dureeGestation = dureeGestation;
	}

	/**
	 * M�thode de d�placement des monstres qui vagabondant
	 *  
	 * @param seDeplacer 
	 * @param jeu 
	 * 
	 * @return Si le monstre s'est bien d�plac�, true, sinon, false
	 */
	public boolean vagabonder(SeDeplacer seDeplacer, Jeu jeu)
	{
		return seDeplacer.vagabonder(this, jeu);
	}
	
	/**
	 * M�thode commune � tous les monstres. Permet � celui-ci de se d�placer
	 * 
	 * @param seDeplacer 
	 * @param jeu 
	 * 
	 * @return Si le monstre s'est bien d�plac�, true, sinon, false
	 * 
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return this.vagabonder(seDeplacer, jeu);
	}
	
	/**
	 * Cr�e un nouveau Gobelin avec des caract�ristiques al�atoires
	 * @return Un Nouveau Gobelin
	 */
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(15+Math.random()*5);
		
		return new Gobelin("Gobelin", sexe, poids, taille, 0, false);
	}
	
	/**
	 * Si la gestation arrive a terme (�gale � la dur�e de gestation) 
	 * 		un monstre est ajout� s'il peut etre plac�, sinon il meurt
	 *		le temps de gestation a 0
	 *		l'�tat en chang� en non gestation
	 * Sinon le temps de gestation est incr�ment�
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return Un message d'information
	 */
	public String gestation(Jeu jeu)
	{
		if(this.tempsGestation == this.dureeGestation)
		{
			//System.out.println("sysoUn b�b� "+this.getNom()+" est n� !");
			Monstre monstre = this.naissance();
			int numCase = this.getNumCaseActuelle();
			Case laCase = jeu.recupererCase(numCase);
			String message = "";
			boolean monstrePlace = false;
			while(monstrePlace == false)
			{
				if(laCase.ajoutMonstre(monstre))
				{
					//System.out.println("sysoLe jeune monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase());
					monstrePlace = true;
					message = "\nUn b�b� "+this.getNom()+" est n� ! Le jeune monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase()+"\n";
				}
				else
				{
					if(numCase == 19)
					{
						//System.out.println("sysoUn jeune monstre est mort car aucun terrain ne lui �tait favorable.");
						monstrePlace = true;
						message = "\nUn jeune monstre "+this.getNom()+" est mort car aucun terrain ne lui �tait favorable.\n";
					}
					else
					{
						numCase = numCase +1;
						laCase = jeu.recupererCase(numCase);
					}
				}
			}
			this.tempsGestation = 0;
			this.setEnGestation(false);
			return message;
		}
		else
		{
			this.tempsGestation++;
			this.setEnGestation(true);
			return "\nLe monstre "+this.getNom()+" est en gestation.\n";
		}
	}
	
	/**
	 * D�termine le son du monstre
	 * @return Le son et le nom du Gobelin
	 */
	public String son()
	{
		return "Le "+this.getNom()+" ricane dans les profondeurs.";
	}

}
