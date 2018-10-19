/**
 * 
 */
package jeu;

/**
 * @author Laurie
 *
 */
public abstract class Monstre {
	private String nom;
	private String sexe;
	private int poids;
	private int taille;
	private double age;
	private int force = 100;
	private int vie = 100;
	private boolean sommeil =  false;

	public Monstre(String nom, String sexe, int poids, int taille, double age, int force, int vie, boolean sommeil) {
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.taille = taille;
		this.age = age;
		this.force = force;
		this.vie = vie;
		this.sommeil = sommeil;
	}

	@Override
	public String toString() {
		return "Animal [nom=" + nom + ", sexe=" + sexe + ", poids=" + poids + ", taille=" + taille + ", age=" + age
				+ ", force=" + force + ", vie=" + vie + ", sommeil=" + sommeil + ", posX=" + "]";
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
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
	public void setVie(int degat) {
		this.vie = this.vie - degat;
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

	public void seSoigner()
	{
		this.setVie(100);
	}
	
	public void dormir()
	{
		this.setSommeil(true);
	}
	
	public void seReveiller()
	{
		this.setSommeil(false);
	}
	
	public abstract String son();
}
