package Model;

public class Oeuf {
	
	/**
	 * Affiche les informations de l'oeuf
	 * @return String Les informations de l'oeuf
	 */
	@Override
	public String toString() {
		return "Oeuf [tempsIncub=" + tempsIncub + ", numCaseMere=" + numCaseMere + ", monstre=" + monstre + "]";
	}

	private int tempsIncub;
	private int numCaseMere;
	private Monstre monstre;
	
	/**
	 * Un oeuf en incubation
	 * @param int tempsIncub Le temps d'incubation de l'oeuf
	 * @param Monstre monstre Le monstre parent de l'oeuf
	 */
	public Oeuf(int tempsIncub, Monstre monstre) {
		super();
		this.tempsIncub = tempsIncub;
		this.monstre = monstre;
	}

	/**
	 * Fait éclore l'oeuf
	 * @return Monstre monstre Le monstre de l'oeuf
	 */
	public Monstre eclore()
	{
		return this.monstre;
	}

	/**
     * Permet de récupérer le temps d'incubation de l'oeuf
     * @return int tempsIncub Le temps d'incubation de l'oeuf
     */
	public int getTempsIncub() {
		return tempsIncub;
	}

	/**
	 * Permet de modifier le temps d'incubation de l'oeuf
	 * @param int tempsIncub Le temps d'incubation de l'oeuf
	 */
	public void setTempsIncub(int tempsIncub) {
		this.tempsIncub = tempsIncub;
	}

	/**
     * Permet de récupérer le monstre de l'oeuf
     * @return Monstre monstre Le monstre de l'oeuf
     */
	public Monstre getMonstre() {
		return monstre;
	}

	/**
	 * Permet de modifier le monstre de l'oeuf
	 * @param Monstre monstre Le monstre de l'oeuf
	 */
	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	/**
     * Permet de récupérer le numéro de la case de la mère
     * @return int numCaseMere Le numéro de la case de la mère
     */
	public int getNumCaseMere() {
		return numCaseMere;
	}

	/**
	 * Permet de modifier le numéro de la case de la mère
	 * @param int numCaseMere Le numéro de la case de la mère
	 */
	public void setNumCaseMere(int numCaseMere) {
		this.numCaseMere = numCaseMere;
	}
}
