package Model;

import java.util.Random;

public class Ent extends Monstre implements Vivipare {
	private Random rand = new Random();
	
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
		int numCase = this.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		int n = rand.nextInt(2);
		int newNumCase = laCase.getNumCase();
		switch (n)
		{
			/*case 0 = recule*/
			case 0: newNumCase = laCase.getNumCase()-1;
			System.out.println("Le monstre "+this.getNom()+" recule d'une case.");
					break;
			/*case 2 = avance*/
			case 1: newNumCase = laCase.getNumCase()+1;
					break;
		}

		//On emp�che le monstre de sortir du plateau
		int nbCase = jeu.getCases().size();
		if(newNumCase == -1 || newNumCase == nbCase)
		{
			System.out.println("Le monstre "+this.getNom()+"  a tent� de sortir des fronti�res. Heureusement, les gardes de Dar Elnor l'en ont emp�ch�. Le monstre reste sur sa case.");
			return false;
		}
		else
		{
			Case newCase = jeu.recupererCase(newNumCase);
			if (newCase.ajoutMonstre(this))
			{
				laCase.SuppMonstre(this);
				System.out.println("Le monstre "+this.getNom()+"  se tra�ne vers la case "+newNumCase);
				return true;
			}
			return false;
		}
	}

	@Override
	public String son() {
		return "Je s'appelle Grout.";
	}

	@Override
	public void gestation(Jeu jeu) {
		// non concern�
		
	}

}
