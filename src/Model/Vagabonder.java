package Model;

public class Vagabonder implements SeDeplacer {
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	public boolean vagabonder(Monstre monstre, Jeu jeu)
	{
		int numCase = monstre.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		int n = rand.nextInt(3);
		int newNumCase;
		
		switch (n)
		{
			/*case 0 = recule*/
			case 0: newNumCase = laCase.getNumCase()-1;
					break;
			/*case 1 = reste*/
			case 1: newNumCase = laCase.getNumCase();
					break;
			/*case 2 = avance*/
			case 2: newNumCase = laCase.getNumCase()+1;
					break;
		}
		Case newCase = jeu.recupererCase(newNumCase);
		newCase.ajoutMonstre(monstre);
		laCase.SuppMonstre(monstre);
		System.out.println("Le monstre vagabonde vers la case "+newNumCase);
		return true;
	}
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		return false;
	}
}
