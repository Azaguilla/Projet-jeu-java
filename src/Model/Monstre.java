/**
 * 
 */
package Model;

/**
 * @author Laurie
 *
 */
public abstract class Monstre {
	private String nom;
	private int sexe;
	private int poids;
	private int taille;
	private double age;
	private int force = 2;
	private int vie = 10;
	private boolean sommeil =  false;
	private int numCaseActuelle;
	private boolean enGestation = false;

	public Monstre(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.taille = taille;
		this.age = age;
		this.sommeil = sommeil;
	}


	@Override
	public String toString() {
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


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public int getForce() {
		return this.force;
	}
	public void setForce(int force) {
		this.force = this.force + force;
	}
	public int getVie() {
		return vie;
	}
	
	/**
	 * Fais mourir le monstre si sa vie est inférieure ou égale à 0, soustrait le nombre de dégats à sa vie sinon
	 * @param degat Dégats infligés
	 * @param jeu
	 */
	public void setVie(int degat, Jeu jeu) {
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
	 * @return Etat de sommeil
	 */
	public boolean isSommeil() {
		return sommeil;
	}
	
	/**
	 * 
	 * @param sommeil
	 */
	public void setSommeil(boolean sommeil) {
		this.sommeil = sommeil;
	}
	
	/**
	 * Ajoute 2 de force
	 */
	public void ajouterForce()
	{
		this.setForce(this.force+2);
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
	public int getNumCaseActuelle() {
		return numCaseActuelle;
	}
	
	/**
	 * 
	 * @param numCaseActuelle
	 */
	public void setNumCaseActuelle(int numCaseActuelle) {
		this.numCaseActuelle = numCaseActuelle;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEnGestation() {
		return enGestation;
	}
	
	/**
	 * 
	 * @param enGestation
	 */
	public void setEnGestation(boolean enGestation) {
		this.enGestation = enGestation;
	}
	
	/**
	 * 
	 * @param jeu
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
	 * Récupère la case actuelle du monstre 
	 * Supprime le monstre
	 * Affiche le nom du monstre mort
	 * @param jeu
	 */
	public void mourir(Jeu jeu)
	{
		Case laCase = jeu.cases.get(this.numCaseActuelle);
		laCase.SuppMonstre(this);
		System.out.println("Le monstre "+this.nom+" est mort.");
	}
	
	/**
	 * Soustrait la force du monstre à la vie du personnage
	 * Affiche le nom du monstre et les points de vie perdus
	 * @param personnage Le personnage du joueur
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
	public abstract void gestation();
	public abstract boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu);
}
