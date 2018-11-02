/**
 * 
 */
package Model;

/**
 * @author Laurie
 *
 */
public abstract class Monstre 
{
	private String nom;
	private int sexe;
	private int poids;
	private int taille;
	private double age;
	private int force = 2;
	private int vie = 10;
	private boolean sommeil;
	private int numCaseActuelle;
	private boolean enGestation = false;

	/**
	 * Un monstre du jeu
	 * @param nom Nom du monstre
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 * @param sommeil
	 */
	public Monstre(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.taille = taille;
		this.age = age;
		this.sommeil = sommeil;
	}

	/**
	 * Affiche les informations d�taill�es du monstre
	 * @return Les informations du monstre 
	 */
	public String infosMonstreDetail() 
	{
		return " \n\nMonstre \n"
				+ " Esp�ce : " + nom + "\n"
				+ " Sexe : " + sexe + "\n"
				+ " Poids : " + poids + "\n"
				+ " Taille : " + taille + "\n"
				+ " Age : " + age + "\n"
				+ " Force : " + force + "\n"
				+ " Vie : " + vie + "\n"
				+ " Sommeil : " + sommeil + "\n"
				+ " Num�ro de case : " + numCaseActuelle + "\n"
				+ " En gestation : " + enGestation;
	}
	
	/**
	 * Affiche les information les plus importantes du monstre
	 * @return String Les informations du monstre
	 */
	@Override
	public String toString()
	{
		return " \n\nMonstre \n"
				+ " Esp�ce : " + nom + "\n"
				+ " Force : " + (force+taille)
				+ " | Vie : " + vie
				+ " | Taille : " + taille
				+ " | Sommeil : " + sommeil
				+ " | Num�ro de case : " + numCaseActuelle + "\n";
	}

	/**
     * Permet de r�cup�rer le nom du monstre
     * @return nom Le nom du monstre
     */
	public String getNom() 
	{
		return nom;
	}
	
	/**
	 * Permet de modifier le nom du monstre
	 * @param nom Le nom du monstre
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
     * Permet de r�cup�rer le sexe du monstre
     * @return Le sexe du monstre
     */
	public int getSexe() 
	{
		return sexe;
	}
	
	/**
	 * Permet de modifier le sexe du monstre
	 * @param sexe Le sexe du monstre
	 */
	public void setSexe(int sexe) 
	{
		this.sexe = sexe;
	}
	
	/**
     * Permet de r�cup�rer la taille du monstre
     * @return La taille du monstre
     */
	public int getTaille() 
	{
		return taille;
	}
	
	/**
	 * Permet de modifier la taille du monstre
	 * @param taille La taille du monstre
	 */
	public void setTaille(int taille) 
	{
		this.taille = taille;
	}
	
	/**
     * Permet de r�cup�rer l'age du monstre
     * @return L'age du monstre
     */
	public double getAge() 
	{
		return age;
	}

	/**
	 * Permet de modifier l'age du monstre
	 * @param age L'age du monstre
	 */
	public void setAge(double age) 
	{
		this.age = age;
	}

	/**
     * Permet de r�cup�rer la force du monstre
     * @return La force du monstre
     */
	public int getForce() 
	{
		return this.force;
	}
	
	/**
	 * Permet de modifier la force du monstre
	 * @param force La force du monstre
	 */
	public void setForce(int force) 
	{
		this.force = this.force + force;
	}
	
	/**
     * Permet de r�cup�rer la vie du monstre
     * @return La vie du monstre
     */
	public int getVie() 
	{
		return vie;
	}
	
	/**
	 * Permet de modifier la vie du monstre
	 * Fais mourir le monstre si sa vie est inf�rieure ou �gale � 0, soustrait le nombre de d�gats � sa vie sinon
	 * @param degat D�gats inflig�s
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	public void setVie(int degat, Jeu jeu) 
	{
		if(this.vie <= 0)
		{
			this.mourir(jeu);
		}
		else
		{
			this.vie = this.vie - degat;
		}
	}
	
	/**
	 * V�rifie l'�tat de sommeil du monstre
	 * @return L'�tat de sommeil du monstre
	 */
	public boolean isSommeil() 
	{
		return sommeil;
	}
	
	/**
	 * Permet de modifier le sommeil du monstre
	 * @param sommeil L'�tat de sommeil du monstre
	 */
	public void setSommeil(boolean sommeil) 
	{
		this.sommeil = sommeil;
	}
	
	/**
	 * Ajoute 2 � la force
	 */
	public void ajouterForce()
	{
		this.setForce(this.force+2);
	}
	
	/**
     * Permet de r�cup�rer le poids du monstre
     * @return Le poids du monstre
     */
	public int getPoids() 
	{
		return poids;
	}
	
	/**
	 * Permet de modifier le poids du monstre
	 * @param poids Le poids du monstre
	 */
	public void setPoids(int poids) 
	{
		this.poids = poids;
	}
	
	/**
     * Permet de r�cup�rer le num�ro de la case actuelle
     * @return Le num�ro de la case actuelle
     */
	public int getNumCaseActuelle() 
	{
		return numCaseActuelle;
	}
	
	/**
	 * Permet de modifier le num�ro de la case actuelle
	 * @param numCaseActuelle Le num�ro de la case actuelle
	 */
	public void setNumCaseActuelle(int numCaseActuelle) 
	{
		this.numCaseActuelle = numCaseActuelle;
	}
	
	/**
     * Permet de r�cup�rer l'�tat de gestation du monstre
     * @return L'�tat de gestation du monstre
     */
	public boolean isEnGestation() 
	{
		return enGestation;
	}
	
	/**
	 * Permet de modifier l'�tat de gestation du monstre
	 * @param enGestation L'�tat de gestation du monstre
	 */
	public void setEnGestation(boolean enGestation) 
	{
		this.enGestation = enGestation;
	}
	
	/**
	 * Ajoute 2 � la vie
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	public void seSoigner(Jeu jeu)
	{
		this.setVie(this.getVie()+2, jeu);
	}
	
	/**
	 * Endort un monstre
	 */
	public void dormir()
	{
		this.setSommeil(true);
	}
	
	/**
	 * R�veille un monstre
	 */
	public void seReveiller()
	{
		this.setSommeil(false);
	}
	
	/**
	 * Si le monstre n'a pas encore la taille maximale(2), ajoute 1 � la taille
	 */
	public void grandir()
	{
		//System.out.println("taille augmente pour "+this.getNom());
		if(this.getTaille() < 2)
		{
			this.setTaille(this.getTaille()+1);
		}
	}
	
	/**
	 * Permet de supprimer un monstre de la case actuelle
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	public void mourir(Jeu jeu)
	{
		Case laCase = jeu.cases.get(this.numCaseActuelle);
		laCase.SuppMonstre(this);
	}
	
	/**
	 * Permet d'attaquer le personnage
	 * Si le monstre est r�veill�, sa force est soustraite � la vie du personnage
	 * Sinon il ne fait rien
	 * @param personnage Le personnage du joueur
	 */
	public void attaquerPersonnage(Personnage personnage)
	{
		int degats = this.force+this.taille;
		if(this.isSommeil() == false)
		{
			personnage.setVie(personnage.getVie()-degats);
			System.out.println("Le monstre "+this.nom+" attaque f�rocement. Vous perdez "+degats+" pts de vie.");
		}
		else
			System.out.println("Le monstre "+this.nom+" est endormis.");
	}
	
	public abstract String son();
	public abstract String gestation(Jeu jeu);
	public abstract boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu);
}
