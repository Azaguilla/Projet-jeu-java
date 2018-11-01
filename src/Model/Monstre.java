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
	 * @param String nom Nom du monstre
	 * @param int sexe
	 * @param int poids
	 * @param int taille
	 * @param double age
	 * @param boolean sommeil
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
	 * Affiche les informations détaillées du monstre
	 * @return String Les information
	 */
	public String infosMonstreDetail() 
	{
		return " \n\nMonstre \n"
				+ " Espèce : " + nom + "\n"
				+ " Sexe : " + sexe + "\n"
				+ " Poids : " + poids + "\n"
				+ " Taille : " + taille + "\n"
				+ " Age : " + age + "\n"
				+ " Force : " + force + "\n"
				+ " Vie : " + vie + "\n"
				+ " Sommeil : " + sommeil + "\n"
				+ " Numéro de case : " + numCaseActuelle + "\n"
				+ " En gestation : " + enGestation;
	}
	
	/**
	 * Affiche les information les plus importantes du monstre
	 * @return String Les informations
	 */
	@Override
	public String toString()
	{
		return " \n\nMonstre \n"
				+ " Espèce : " + nom + "\n"
				+ " Force : " + force
				+ " | Vie : " + vie
				+ " | Sommeil : " + sommeil
				+ " | Numéro de case : " + numCaseActuelle + "\n";
	}

	/**
     * Permet de récupérer le nom du monstre
     * @return String nom Le nom du monstre
     */
	public String getNom() 
	{
		return nom;
	}
	
	/**
	 * Permet de modifier le nom du monstre
	 * @param String nom Le nom du monstre
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
     * Permet de récupérer le sexe du monstre
     * @return int sexe Le sexe du monstre
     */
	public int getSexe() 
	{
		return sexe;
	}
	
	/**
	 * Permet de modifier le sexe du monstre
	 * @param int sexe Le sexe du monstre
	 */
	public void setSexe(int sexe) 
	{
		this.sexe = sexe;
	}
	
	/**
     * Permet de récupérer la taille du monstre
     * @return int taille La taille du monstre
     */
	public int getTaille() 
	{
		return taille;
	}
	
	/**
	 * Permet de modifier la taille du monstre
	 * @param int taille La taille du monstre
	 */
	public void setTaille(int taille) 
	{
		this.taille = taille;
	}
	
	/**
     * Permet de récupérer l'age du monstre
     * @return double age l'age du monstre
     */
	public double getAge() 
	{
		return age;
	}

	/**
	 * Permet de modifier l'age du monstre
	 * @param double age l'age du monstre
	 */
	public void setAge(double age) 
	{
		this.age = age;
	}

	/**
     * Permet de récupérer la force du monstre
     * @return int force La force du monstre
     */
	public int getForce() 
	{
		return this.force;
	}
	
	/**
	 * Permet de modifier la force du monstre
	 * @param int force La force du monstre
	 */
	public void setForce(int force) 
	{
		this.force = this.force + force;
	}
	
	/**
     * Permet de récupérer la vie du monstre
     * @return int vie La vie du monstre
     */
	public int getVie() 
	{
		return vie;
	}
	
	/**
	 * Permet de modifier la vie du monstre
	 * Fais mourir le monstre si sa vie est inférieure ou égale à 0, soustrait le nombre de dégats à sa vie sinon
	 * @param int degat Dégats infligés
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
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
	 * Vérifie l'état de sommeil du monstre
	 * @return boolean sommeil L'état de sommeil du monstre
	 */
	public boolean isSommeil() 
	{
		return sommeil;
	}
	
	/**
	 * Permet de modifier le sommeil du monstre
	 * @param boolean sommeil L'état de sommeil du monstre
	 */
	public void setSommeil(boolean sommeil) 
	{
		this.sommeil = sommeil;
	}
	
	/**
	 * Ajoute 2 à la force
	 */
	public void ajouterForce()
	{
		this.setForce(this.force+2);
	}
	
	/**
     * Permet de récupérer le poids du monstre
     * @return int poids Le poids du monstre
     */
	public int getPoids() 
	{
		return poids;
	}
	
	/**
	 * Permet de modifier le poids du monstre
	 * @param int poids Le poids du monstre
	 */
	public void setPoids(int poids) 
	{
		this.poids = poids;
	}
	
	/**
     * Permet de récupérer le numéro de la case actuelle
     * @return int numCaseActuelle Le numéro de la case actuelle
     */
	public int getNumCaseActuelle() 
	{
		return numCaseActuelle;
	}
	
	/**
	 * Permet de modifier le numéro de la case actuelle
	 * @param int numCaseActuelle Le numéro de la case actuelle
	 */
	public void setNumCaseActuelle(int numCaseActuelle) 
	{
		this.numCaseActuelle = numCaseActuelle;
	}
	
	/**
     * Permet de récupérer l'état de gestation du monstre
     * @return boolean enGestation L'état de gestation du monstre
     */
	public boolean isEnGestation() 
	{
		return enGestation;
	}
	
	/**
	 * Permet de modifier l'état de gestation du monstre
	 * @param boolean enGestation L'état de gestation du monstre
	 */
	public void setEnGestation(boolean enGestation) 
	{
		this.enGestation = enGestation;
	}
	
	/**
	 * Ajoute 2 à la vie
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public void seSoigner(Jeu jeu)
	{
		this.setVie(this.getVie()+2, jeu);
	}
	
	/**
	 * Endors un monstre
	 */
	public void dormir()
	{
		this.setSommeil(true);
	}
	
	/**
	 * Réveille un monstre
	 */
	public void seReveiller()
	{
		this.setSommeil(false);
	}
	
	//TODO changer taille max des monstres
	/**
	 * Si le monstre n'a pas encore la taille maximale(2), ajoute 1 à la taille
	 */
	public void grandir()
	{
		if(this.getTaille() < 2)
		{
			this.setTaille(this.getTaille()+1);
		}
	}
	
	/**
	 * Permet de supprimer un monstre de la case actuelle
	 * @param Jeu jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public void mourir(Jeu jeu)
	{
		Case laCase = jeu.cases.get(this.numCaseActuelle);
		laCase.SuppMonstre(this);
	}
	
	/**
	 * Permet d'attaquer le personnage
	 * Si le monstre est réveillé, sa force est soustraite à la vie du personnage
	 * Sinon il ne fait rien
	 * @param Personnage personnage Le personnage du joueur
	 */
	public void attaquerPersonnage(Personnage personnage)
	{
		if(this.isSommeil() == false)
		{
			personnage.setVie(personnage.getVie()-this.force);
			System.out.println("Le monstre "+this.nom+" attaque férocement. Vous perdez "+this.force+" pts de vie.");
		}
		else
			System.out.println("Le monstre "+this.nom+" est endormis.");
	}
	
	public abstract String son();
	public abstract String gestation(Jeu jeu);
	public abstract boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu);
}
