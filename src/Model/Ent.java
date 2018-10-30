package Model;

public class Ent extends Monstre implements Vivipare {
	
	public Ent(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	@Override
	public Monstre naissance() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		return new Ent("Ent", sexe, poids, taille, 0, false);
	}
	
	/* Permet au monstre de se d�placer. L'ent poss�de sa propre mani�re de se d�placer. 
	 * Il avance ou recule de mani�re al�atoire. Il ne peut pas sortir du plateau ou �tre d�truit � cause de �a.
	 * 
	 * @params   Jeu          jeu          Le jeu contient les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @params   SeDeplacer   seDeplacer   La mani�re dont le monstre va se d�placer. Ici il n'est pas utile.
	 * 
	 * @return   boolean 
	 */
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		System.out.println("Les Ent ne se d�placent pas !");
		return true;
	}

	@Override
	public String son() {
		return "Je s'appelle Grout.";
	}

	@Override
	public void gestation(Jeu jeu) {
		System.out.println("Une pousse d'Ent est apparue !");
		Monstre monstre = this.naissance();		
		int numCase = this.getNumCaseActuelle();
		System.out.println("Case de la m�re : "+numCase);
		Case laCase = jeu.recupererCase(numCase);
		if(laCase.ajoutMonstre(monstre))
		{
			System.out.println("Le monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase());
		}
		else
		{
			System.out.println("La vie peut �tre difficile, dans les sous-bois, pour les jeunes Ent. L'un d'entre eux n'a pas surv�cu � cause du manque de place.");
		}
	}

}
