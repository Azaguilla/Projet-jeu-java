package Model;

public class Ogre extends Monstre implements Terrestre, Vivipare 
{
	private int tempsGestation = 0;
	private int dureeGestation = 3;
	
	/**
	 * Monstre de l'esp�ce des Ogres
	 * @param String nom Nom de l'Ogre
	 * @param int sexe Sexe de l'Ogre
	 * @param int poids Poids de l'Ogre
	 * @param int taille Taille de l'Ogre
	 * @param double age Age de l'Ogre
	 * @param boolean sommeil Etat de sommeil de l'Ogre, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Ogre(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
     * Permet de r�cup�rer le temps de gestation de l'Ogre
     * @return int tempsGestation Le temps de gestation de l'Ogre
     */
	public int getTempsGestation() 
	{
		return tempsGestation;
	}

	/**
	 * Permet de modifier le temps de gestation de l'Ogre
	 * @param int tempsGestation Le temps de gestation de l'Ogre
	 */
	public void setTempsGestation(int tempsGestation) 
	{
		this.tempsGestation = tempsGestation;
	}

	/**
     * Permet de r�cup�rer la dur�e de gestation de l'Ogre
     * @return int dureeGestation La dur�e de gestation de l'Ogre
     */
	public int getDureeGestation() 
	{
		return dureeGestation;
	}

	/**
	 * Permet de modifier la dur�e de gestation de l'Ogre
	 * @param int dureeGestation La dur�e de gestation de l'Ogre
	 */
	public void setDureeGestation(int dureeGestation) 
	{
		this.dureeGestation = dureeGestation;
	}

	//TODO javadoc
	/**
	 * 
	 */
	public boolean vagabonder(SeDeplacer seDeplacer, Jeu jeu)
	{
		return seDeplacer.vagabonder(this, jeu);
	}
	
	//TODO javadoc
	/**
	 * 
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return this.vagabonder(seDeplacer, jeu);
	}
	
	/**
	 * Cr�e un nouvel Ogre avec des caract�ristiques al�atoires
	 * @return Monstre Ogre Un nouvel Ogre
	 */
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(80+Math.random()*15);
		
		return new Ogre("Ogre", sexe, poids, taille, 0, false);
	}

	/**
	 * Si la gestation arrive a terme (�gale � la dur�e de gestation) 
	 * 		un monstre est ajout� s'il peut etre plac�, sinon il meurt
	 *		le temps de gestation a 0
	 *		l'�tat en chang� en non gestation
	 * Sinon le temps de gestation est incr�ment�
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return String
	 */
	public String gestation(Jeu jeu)
	{
		if(this.tempsGestation == this.dureeGestation)
		{
			System.out.println("sysoUn b�b� "+this.getNom()+" est n� !");
			Monstre monstre = this.naissance();
			int numCase = this.getNumCaseActuelle();
			Case laCase = jeu.recupererCase(numCase);
			String message = "";
			boolean monstrePlace = false;
			while(monstrePlace == false)
			{
				if(laCase.ajoutMonstre(monstre))
				{
					System.out.println("sysoLe jeune monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase());
					monstrePlace = true;
					message = "Un b�b� "+this.getNom()+" est n� !";
				}
				else
				{
					if(numCase == 19)
					{
						System.out.println("sysoUn jeune monstre est mort car aucun terrain ne lui �tait favorable.");
						monstrePlace = true;
						message = "Un jeune monstre est mort car aucun terrain ne lui �tait favorable.";
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
			return "Le monstre "+this.getNom()+" est toujours en gestation";
		}
	}
	
	/**
	 * D�termine le son du monstre
	 * @return String Le son et le nom de l'Ogre
	 */
	public String son()
	{
		return "L'ogre "+this.getNom()+" gronde.";
	}
}
