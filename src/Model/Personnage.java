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
	private int force;
	private int vie;
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
	 * @param lacase La case choisie
	 */
	public void examinerCase(Case lacase) {
		System.out.println(lacase.toString());
	}
	
	/**
	 * Avance ou recule le personnage d'une case selon le choix
	 * @param choix Avancer(A) ou Reculer(R)
	 * @param jeu
	 * @return vrai(true) si le d�placement est valide, faux(false) sinon
	 */
	public boolean seDeplacer(String choix, Jeu jeu)
	{
		switch (choix) {
		case "A" :
			if (this.position == Jeu.getMaxCase())
			{
				System.out.println("Vous ne pouvez pas avancer.");
				return false;
			}
			else
			{
				this.position++;
				System.out.println("Vous avancez d'une case.");
				jeu.recupererCase(this.position).degatPersonnage(this);
				return true;
			}
		case "R" : 
			if (this.position == 0)
			{
				System.out.println("Vous ne pouvez pas reculer.");
				return false;
			}
			else
			{
				this.position--;
				System.out.println("Vous reculez d'une case.");
				jeu.recupererCase(this.position).degatPersonnage(this);
				return true;
			}
		default: 
			System.out.println("Je ne comprends pas votre d�placement");
			return false;
		}
	}
	
	/**
	 * Ajoute de la vie au personnage
	 * @return Affichage de la quantit� de vie apr�s ajout
	 */
	public String boirePotion()
	{
		this.vie = this.vie + 2;
		return "Vous r�ccup�rer de la vie. Votre �nergie est actuellement � "+this.vie+" pts.";
	}
	
	/**
	 * Ajoute de l'�nergie au personnage
	 * @return Affichage de la quantit� d'�nergie apr�s ajout
	 */
	public String manger()
	{
		this.energie = this.energie + 2;
		return "Vous r�cup�rer de l'�nergie. Votre �nergie est actuellement � "+this.energie+" pts.";
	}
	
	/**
	 * 
	 * @param laCase La case choisie
	 */
	public void nettoyer(Case laCase)
	{
		laCase.nettoyerCase();
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
