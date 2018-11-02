/**
 * 
 */
package Model.ModelPersonnage;

import Model.ModelJeu.Jeu;
import Model.ModelMonstre.Monstre;
import Model.ModelCase.Case;

/**
 * @author Laurie
 *
 */
public abstract class Personnage 
{
	private String nom;
	private String sexe;
	private int age;
	private String classe;
	private int taille;
	private int poids;
	private int energie;
	protected final static int MAX_ENERGIE = 20;
	private int force;
	private int vie;
	protected final static int MAX_VIE = 10;
	private int position;
	
	/**
	 * Le personnage du joueur
	 * @param nom Le nom du personnage
	 * @param sexe Le sexe du personnage
	 * @param classe La classe du personnage
	 */
	 public Personnage(String nom, String sexe, String classe) 
	 {
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.age = 25;
		this.classe = classe;
		this.taille = 170;
		this.poids = 70;
		this.energie = 20;
		this.force = 4;
		this.vie = 10;
		this.position = 0;
	}
	/**
	 * Affiche les informations d'une case choisie
	 * @param laCase La case choisie
	 * @return Les informations de la case
	 */
	public String examinerCase(Case laCase) 
	{
		return laCase.toString();
	}
	
	/**
	 * Avance ou recule le personnage d'une case selon le choix
	 * @param choix Avancer ou Reculer
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return vrai(true) si le déplacement est valide, faux(false) sinon
	 */
	public boolean seDeplacer(int choix, Jeu jeu)
	{
		switch (choix) {
		case 0 :
			if (this.position == Jeu.getMaxCase())
			{
				return false;
			}
			else
			{
				this.position++;
				return true;
			}
		case 1 : 
			if (this.position == 0)
			{
				return false;
			}
			else
			{
				this.position--;
				return true;
			}
		default: 
			return false;
		}
	}
	
	/**
	 * Ajoute de la vie au personnage si elle n'est pas au maximum
	 * Sinon affiche un message d'erreur
	 * @return Un message d'information sur la vie
	 */
	public String boirePotion()
	{
		if(this.vie < MAX_VIE)
		{
			this.vie = this.vie + 2;
			return "Vous réccupérer de la vie. Votre vie est actuellement à "+this.vie+" pts.";
		}
		else
		{
			return "Vous ne pouvez pas récupérer plus de points de vie. Votre vie est actuellement à "+this.vie+" pts.";
		}
	}
	
	/**
	 * Ajoute de l'énergie au personnage si elle n'est pas au maximum
	 * Sinon affiche un message d'erreur
	 * @return Un message
	 */
	public String manger()
	{
		if(this.energie < MAX_ENERGIE)
		{
			this.energie = this.energie + 2;
			return "Vous récupérer de l'énergie. Votre énergie est actuellement à "+this.energie+" pts.";
		}
		else
		{
			return "Vous ne pouvez pas récupérer plus de points d'énergie. Votre énergie est actuellement à "+this.energie+" pts.";
		}
		
	}

	/**
	 * Permet de nettoyer la case
	 * @param laCase La case choisie
	 * @return laCase.nettoyerCase()
	 */
	public String nettoyer(Case laCase)
	{
		return laCase.nettoyerCase();
	}
	
	
	/**
	 * Permet de changer de tour
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 */
	public void finDeTour(Jeu jeu)
	{
		jeu.ChangerTour();
	}
	
	/**
     * Permet de récupérer le nom du personnage
     * @return Le nom du personnage
     */
	public String getNom() 
	{
		return nom;
	}
	
	/**
	 * Permet de modifier le nom du personnage
	 * @param nom Le nom du personnage
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
     * Permet de récupérer le sexe du personnage
     * @return Le sexe du personnage
     */
	public String getSexe() 
	{
		return sexe;
	}
	
	/**
	 * Permet de modifier le sexe du personnage
	 * @param sexe Le sexe du personnage
	 */
	public void setSexe(String sexe) 
	{
		this.sexe = sexe;
	}
	
	/**
     * Permet de récupérer l'age du personnage
     * @return L'age du personnage
     */
	public int getAge() 
	{
		return age;
	}
	
	/**
	 * Permet de modifier l'age du personnage
	 * @param age L'age du personnage
	 */
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	/**
     * Permet de récupérer la classe du personnage
     * @return La classe du personnage
     */
	public String getClasse() 
	{
		return classe;
	}
	
	/**
	 * Permet de modifier la classe du personnage
	 * @param classe La classe du personnage
	 */
	public void setClasse(String classe) 
	{
		this.classe = classe;
	}
	
	/**
     * Permet de récupérer la taille du personnage
     * @return La taille du personnage
     */
	public int getTaille() 
	{
		return taille;
	}
	
	/**
	 * Permet de modifier la taille du personnage
	 * @param taille La taille du personnage
	 */
	public void setTaille(int taille) 
	{
		this.taille = taille;
	}
	
	/**
     * Permet de récupérer le poids du personnage
     * @return Le poids du personnage
     */
	public int getPoids() 
	{
		return poids;
	}
	
	/**
	 * Permet de modifier le poids du personnage
	 * @param poids Le poids du personnage
	 */
	public void setPoids(int poids) 
	{
		this.poids = poids;
	}
	
	/**
     * Permet de récupérer l'energie du personnage
     * @return L'energie du personnage
     */
	public int getEnergie() 
	{
		return energie;
	}
	
	/**
	 * Permet de modifier l'energie du personnage
	 * @param energie L'energie du personnage
	 */
	public void setEnergie(int energie) 
	{
		this.energie = energie;
	}
	
	/**
     * Permet de récupérer la force du personnage
     * @return La force du personnage
     */
	public int getForce() 
	{
		return force;
	}
	
	/**
	 * Permet de modifier la force du personnage
	 * @param force La force du personnage
	 */
	public void setForce(int force) 
	{
		this.force = force;
	}
	
	/**
     * Permet de récupérer la vie du personnage
     * @return La vie du personnage
     */
	public int getVie() 
	{
		return vie;
	}
	
	/**
	 * Permet de modifier la vie du personnage
	 * @param vie La vie du personnage
	 */
	public void setVie(int vie) 
	{
		this.vie = vie;
	}
	
	/**
     * Permet de récupérer la position du personnage
     * @return La position du personnage
     */
	public int getPosition() 
	{
		return position;
	}
	
	/**
	 * Permet de modifier la position du personnage
	 * @param position La position du personnage
	 */
	public void setPosition(int position) 
	{
		this.position = position;
	}

	public abstract String attaquer(Monstre monstre, Jeu jeu);
	public abstract String lancerSort(Monstre monstre, Jeu jeu);
	//public abstract String infosPersoSimple();
}
