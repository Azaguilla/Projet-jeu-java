package Model;

public class Oeuf {
	@Override
	public String toString() {
		return "Oeuf [tempsIncub=" + tempsIncub + ", numCaseMere=" + numCaseMere + ", monstre=" + monstre + "]";
	}

	private int tempsIncub;
	private int numCaseMere;
	private Monstre monstre;
	
	public Oeuf(int tempsIncub, Monstre monstre) {
		super();
		this.tempsIncub = tempsIncub;
		this.monstre = monstre;
	}

	public Monstre eclore()
	{
		return this.monstre;
	}

	public int getTempsIncub() {
		return tempsIncub;
	}

	public void setTempsIncub(int tempsIncub) {
		this.tempsIncub = tempsIncub;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public int getNumCaseMere() {
		return numCaseMere;
	}

	public void setNumCaseMere(int numCaseMere) {
		this.numCaseMere = numCaseMere;
	}
}
