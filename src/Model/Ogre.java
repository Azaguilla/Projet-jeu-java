package Model;

public class Ogre extends Monstre implements Terrestre, Vivipare 
{
	private int tempsGestation = 0;
	private int dureeGestation = 3;
	
	/**
	 * Monstre de l'espèce des Ogres
	 * @param String nom Nom de l'Ogre
	 * @param int sexe Sexe de l'Ogre
	 * @param int poids Poids de l'Ogre
	 * @param int taille Taille de l'Ogre
	 * @param double age Age de l'Ogre
	 * @param boolean sommeil Etat de sommeil de l'Ogre, vrai(true) s'il est endormis,  faux(false) s'il est réveillé
	 */
	public Ogre(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
     * Permet de récupérer le temps de gestation de l'Ogre
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
     * Permet de récupérer la durée de gestation de l'Ogre
     * @return int dureeGestation La durée de gestation de l'Ogre
     */
	public int getDureeGestation() 
	{
		return dureeGestation;
	}

	/**
	 * Permet de modifier la durée de gestation de l'Ogre
	 * @param int dureeGestation La durée de gestation de l'Ogre
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
	 * Crée un nouvel Ogre avec des caractéristiques aléatoires
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
	 * Si la gestation arrive a terme (égale à la durée de gestation) 
	 * 		un monstre est ajouté s'il peut etre placé, sinon il meurt
	 *		le temps de gestation a 0
	 *		l'état en changé en non gestation
	 * Sinon le temps de gestation est incrémenté
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return String
	 */
	public String gestation(Jeu jeu)
	{
		if(this.tempsGestation == this.dureeGestation)
		{
			System.out.println("sysoUn bébé "+this.getNom()+" est né !");
			Monstre monstre = this.naissance();
			int numCase = this.getNumCaseActuelle();
			Case laCase = jeu.recupererCase(numCase);
			String message = "";
			boolean monstrePlace = false;
			while(monstrePlace == false)
			{
				if(laCase.ajoutMonstre(monstre))
				{
					System.out.println("sysoLe jeune monstre "+monstre.getNom()+" s'est placé à la case "+laCase.getNumCase());
					monstrePlace = true;
					message = "Un bébé "+this.getNom()+" est né !";
				}
				else
				{
					if(numCase == 19)
					{
						System.out.println("sysoUn jeune monstre est mort car aucun terrain ne lui était favorable.");
						monstrePlace = true;
						message = "Un jeune monstre est mort car aucun terrain ne lui était favorable.";
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
	 * Détermine le son du monstre
	 * @return String Le son et le nom de l'Ogre
	 */
	public String son()
	{
		return "L'ogre "+this.getNom()+" gronde.";
	}
}
