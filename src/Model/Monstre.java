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
		return " \n\n  Monstre \n "
				+ "Espèce : " + nom + "\n"
				+ "Sexe : " + sexe + "\n"
				+ "Poids : " + poids + "\n"
				+ "Taille : " + taille + "\n"
				+ "Age : " + age + "\n"
				+ "Force : " + force + "\n"
				+ "Vie : " + vie + "\n"
				+ "Sommeil : " + sommeil + "\n"
				+ "Numéro de case : " + numCaseActuelle + "\n"
				+ "En gestation : " + enGestation;
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
	public void setVie(int degat, Jeu jeu) {
		if(this.vie < 0)
		{
			this.mourir(jeu);
		}
		else
		{
			this.vie = this.vie - degat;
		}
	}
	public boolean isSommeil() {
		return sommeil;
	}
	
	public void setSommeil(boolean sommeil) {
		this.sommeil = sommeil;
	}
	
	public void ajouterForce()
	{
		this.setForce(this.force+2);
	}
	
	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getNumCaseActuelle() {
		return numCaseActuelle;
	}

	public void setNumCaseActuelle(int numCaseActuelle) {
		this.numCaseActuelle = numCaseActuelle;
	}

	public boolean isEnGestation() {
		return enGestation;
	}

	public void setEnGestation(boolean enGestation) {
		this.enGestation = enGestation;
	}

	public void seSoigner(Jeu jeu)
	{
		this.setVie(this.getVie()+2, jeu);
	}
	
	public void dormir()
	{
		this.setSommeil(true);
	}
	
	public void seReveiller()
	{
		this.setSommeil(false);
	}
	
	public void grandir()
	{
		if(this.getTaille() < 2)
		{
			this.setTaille(this.getTaille()+1);
		}
	}
	
	public void mourir(Jeu jeu)
	{
		Case laCase = jeu.cases.get(this.numCaseActuelle);
		laCase.SuppMonstre(this);
		System.out.println("Le monstre "+this.nom+" est mort.");
	}
	
	public void attaquerPersonnage(Personnage personnage)
	{
		personnage.setVie(personnage.getVie()-this.force);
		System.out.println("Le monstre "+this.nom+" attaque férocement. Vous perdez "+this.force+" pts de vie.");
	}
	
	public abstract String son();
	public abstract void gestation();
}
