/**
 * 
 */
package Model;

/**
 * @author Laurie
 *
 */
public class LoupGarou extends Monstre implements Terrestre, Vivipare 
{
	private int tempsGestation = 0;
	private int dureeGestation = 3;
	
	/**
	 * Monstre de l'esp�ce des LoupGarou
	 * @param String nom Nom du LoupGarou
	 * @param int sexe Sexe du LoupGarou
	 * @param int poids Poids du LoupGarou
	 * @param int taille Taille du LoupGarou
	 * @param double age Age du LoupGarou
	 * @param boolean sommeil Etat de sommeil du LoupGarou, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public LoupGarou(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
     * Permet de r�cup�rer le temps de gestation du LoupGarou
     * @return int tempsGestation Le temps de gestation du LoupGarou
     */
	public int getTempsGestation() 
	{
		return tempsGestation;
	}

	/**
	 * Permet de modifier le temps de gestation du LoupGarou
	 * @param int tempsGestation Le temps de gestation du LoupGarou
	 */
	public void setTempsGestation(int tempsGestation) 
	{
		this.tempsGestation = tempsGestation;
	}

	/**
     * Permet de r�cup�rer la dur�e de gestation du LoupGarou
     * @return int dureeGestation La dur�e de gestation du LoupGarou
     */
	public int getDureeGestation() 
	{
		return dureeGestation;
	}

	/**
	 * Permet de modifier la dur�e de gestation du LoupGarou
	 * @param int dureeGestation La dur�e de gestation du LoupGarou
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
	 * Cr�e un nouveau LoupGarou avec des caract�ristiques al�atoires
	 * @return LoupGarou Un Nouveau LoupGarou
	 */
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		return new LoupGarou("Loup Garou", sexe, poids, taille, 0, false);
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
	 * @return String Le son et le nom du LoupGarou
	 */
	public String son()
	{
		return "Le Loup Garou "+this.getNom()+" hurle � la Lune.";
	}

}
