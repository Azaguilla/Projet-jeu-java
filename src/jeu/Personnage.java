/**
 * 
 */
package jeu;

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
	}

	@Override
	public String toString() {
		return "Un grand "+this.classe+" était apparu dans la contrée, âgé de "+this.age+". Voici ses caractéristiques : "
				+ "énergie "+this.energie+", force "+this.force+" et vie "+this.vie;
	}

	public void examinerCase(Case lacase) {
		lacase.afficheCarac();
	}
	
	public void seDeplacer()
	{
		
	}
	
	public void boirePotion()
	{
		
	}
	
	public String manger()
	{
		this.energie = this.energie + 2;
		return "Vous réccupérer de l'énergie. Votre énergie est actuellement à "+this.energie+" pts.";
	}
	
	public void nettoyer(Case lacase)
	{
		lacase.netoyerCase();
	}
	public abstract void attaquer();
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
}
