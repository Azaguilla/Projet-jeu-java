package Model;

public class Gobelin extends Monstre implements Terrestre, Vivipare 
{
	private int tempsGestation = 0;
	private int dureeGestation = 2;
	
	/**
	 * Monstre de l'espèce des Gobelins
	 * @param String nom Nom du Gobelin
	 * @param int sexe Sexe du Gobelin
	 * @param int poids Poids du Gobelin
	 * @param int taille Taille du Gobelin
	 * @param double age Age du Gobelin
	 * @param boolean sommeil Etat de sommeil du Gobelin, vrai(true) s'il est endormis,  faux(false) s'il est réveillé
	 */
	public Gobelin(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
     * Permet de récupérer le temps de gestation du Goblelin
     * @return int tempsGestation Le temps de gestation du Goblelin
     */
	public int getTempsGestation() 
	{
		return tempsGestation;
	}

	/**
	 * Permet de modifier le temps de gestation du Goblelin
	 * @param int tempsGestation Le temps de gestation du Goblelin
	 */
	public void setTempsGestation(int tempsGestation) 
	{
		this.tempsGestation = tempsGestation;
	}

	/**
     * Permet de récupérer la durée de gestation du Goblelin
     * @return int dureeGestation La durée de gestation du Goblelin
     */
	public int getDureeGestation() 
	{
		return dureeGestation;
	}

	/**
	 * Permet de modifier la durée de gestation du Goblelin
	 * @param int dureeGestation La durée de gestation du Goblelin
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
	 * Crée un nouveau Gobelin avec des caractéristiques aléatoires
	 * @return Gobelin Un Nouveau Gobelin
	 */
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(15+Math.random()*5);
		
		return new Gobelin("Gobelin", sexe, poids, taille, 0, false);
	}
	
	/**
	 * Si la gestation arrive a terme (égale à la durée de gestation) 
	 * 		un monstre est ajouté s'il peut etre placé, sinon il meurt
	 *		le temps de gestation a 0
	 *		l'état en changé en non gestation
	 * Sinon le temps de gestation est incrémenté
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public void gestation(Jeu jeu)
	{
		if(this.tempsGestation == this.dureeGestation)
		{
			System.out.println("Un bébé "+this.getNom()+" est né !");
			Monstre monstre = this.naissance();
			int numCase = this.getNumCaseActuelle();
			Case laCase = jeu.recupererCase(numCase);
			boolean monstrePlace = false;
			while(monstrePlace == false)
			{
				if(laCase.ajoutMonstre(monstre))
				{
					System.out.println("Le jeune monstre "+monstre.getNom()+" s'est placé à la case "+laCase.getNumCase());
					monstrePlace = true;
				}
				else
				{
					if(numCase == 19)
					{
						System.out.println("Un jeune monstre est mort car aucun terrain ne lui était favorable.");
						monstrePlace = true;
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
		}
		else
		{
			this.tempsGestation++;
			this.setEnGestation(true);
		}
	}
	
	/**
	 * Détermine le son du monstre
	 * @return String Le son et le nom du Gobelin
	 */
	public String son()
	{
		return "Le gobelin"+this.getNom()+" ricane dans les profondeurs.";
	}

}
