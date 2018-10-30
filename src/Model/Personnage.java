/**
 * 
 */
package Model;

/**
 * @author Laurie
 *
 */
public abstract class Personnage {
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
	
	 public Personnage(String nom, String sexe, String classe) {
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
	 * @return String Les informations de la case
	 */
	public String examinerCase(Case laCase) {
		return laCase.toString();
	}
	
	/**
	 * Avance ou recule le personnage d'une case selon le choix
	 * @param choix Avancer(A) ou Reculer(R)
	 * @param jeu
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
				jeu.recupererCase(this.position).degatPersonnage(this);
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
				jeu.recupererCase(this.position).degatPersonnage(this);
				return true;
			}
		default: 
			return false;
		}
	}
	
	/**
	 * Ajoute de la vie au personnage si elle n'est pas au maximum
	 * Sinon affiche un message d'erreur
	 * @return Affichage de la quantité de vie après ajout
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
	 * @return Affichage de la quantité d'énergie après ajout
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
	 * 
	 * @param laCase La case choisie
	 */
	public String nettoyer(Case laCase)
	{
		return laCase.nettoyerCase();
	}
	
	/**
	 * 
	 * @param jeu
	 */
	public void finDeTour(Jeu jeu)
	{
		jeu.ChangerTour();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSexe() {
		return sexe;
	}
	
	/**
	 * 
	 * @param sexe
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getClasse() {
		return classe;
	}
	
	/**
	 * 
	 * @param classe
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTaille() {
		return taille;
	}
	
	/**
	 * 
	 * @param taille
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPoids() {
		return poids;
	}
	
	/**
	 * 
	 * @param poids
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getEnergie() {
		return energie;
	}
	
	/**
	 * 
	 * @param energie
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getForce() {
		return force;
	}
	
	/**
	 * 
	 * @param force
	 */
	public void setForce(int force) {
		this.force = force;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getVie() {
		return vie;
	}
	
	/**
	 * 
	 * @param vie
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	public abstract void attaquer(Monstre monstre, Jeu jeu);
	public abstract void lancerSort(Monstre monstre, Jeu jeu);
}
