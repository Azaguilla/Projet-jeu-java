package Model;

import java.util.ArrayList;
import java.util.Random;

public class Jeu 
{
	private String nom;
	private Personnage joueur;
	private int nbJour;
	private int jourCourant;
	private int nbHeure;
	private final static int MAX_CASE = 50;
	protected ArrayList<Case> cases = new ArrayList<>(MAX_CASE);
	private final static int MAX_OEUF = 50;
	protected ArrayList<Oeuf> oeufs = new ArrayList<>(MAX_OEUF);
	private Random rand = new Random();
	
	/**
	 * Le jeu
	 * @param String nom Le nom du personnage
	 * @param Personnage joueur Le personnage du joueur
	 * @param int nbJour Le nombre de jours
	 * @param int nbHeure Le nombre d'heures
	 */
	public Jeu(String nom, Personnage joueur, int nbJour, int nbHeure) 
	{
		super();
		this.nom = nom;
		this.joueur = joueur;
		this.nbHeure = nbHeure;
		this.nbJour = nbJour;
	}
	
	/**
	 * Affiche les informations du jeu
	 * @return String Les informations
	 */
	@Override
	public String toString() 
	{
		return "Jeu \n"
				+ "Nom : " + nom + "\n"
				+ "Joueur : " + joueur + "\n"
				+ "Nombre de jour : " + nbJour + "\n"
				+ "Jour actuel : " + jourCourant + "\n"
				+ "Nombre d'heure � d�penser : " + nbHeure + "\n"
				+ "Nombre de case dans le jeu : " + cases.size() + "\n"
				+ "Les cases : " + cases + "\n";
	}
	
	/**
	 * Ajoute une case si le nombre maximal de case n'est pas atteind
	 * Sinon affiche un message d'erreur
	 * @param laCase La case � ajouter
	 */
	public void ajoutCase(Case laCase)
	{
		if(this.cases.size()<MAX_CASE){
			this.cases.add(laCase);
        }
		else{
            System.out.println("Il y a trop de cases.");
        }

	}
	
	/**
	 * Supprime une case s'il y a encore des cases
	 * Sinon affiche un message d'erreur
	 * @param laCase La case � supprimer
	 */
    public void SuppCase(Case laCase)
    {
    	if(this.cases.size() > 0)
    	{
    		this.cases.remove(laCase);
        }
    	else
    	{
            System.out.println("Il n'y a plus de cases.");
        } 
    }
    
    /**
     * 
     * @return
     */
    public ArrayList<Case> getCases() 
    {
        return this.cases;
    }
    
    /**
     * 
     * @param cases
     */
	public void setCases(ArrayList<Case> cases) 
	{
		this.cases = cases;
	}

	/**
	 * Ajoute un oeuf si le nombre de case maximal n'est pas atteint
	 * Sinon affiche un message d'erreur
	 * @param laCase La case d'ajout de l'oeuf
	 */
	public void ajoutOeuf(Oeuf oeuf)
	{
		if(this.oeufs.size()<MAX_OEUF)
		{
			this.oeufs.add(oeuf);
        }
		else
		{
            System.out.println("Il y a trop d'oeuf.");
        }
	}
	
	/**
	 * Supprime un oeuf
	 * @param oeuf L'oeuf � supprimer
	 */
    public void SuppOeuf(Oeuf oeuf)
    {
    	if(this.oeufs.size() > 0)
    	{
    		this.oeufs.remove(oeuf);
        }
		else
		{
            System.out.println("Il n'y a plus d'oeuf.");
        }
        
    }
     
    /**
     * 
     * @return
     */
    public ArrayList<Oeuf> getOeufs() 
    {
        return this.oeufs;
    }
    
    /**
     * 
     * @param oeufs
     */
	public void setOeufs(ArrayList<Oeuf> oeufs) 
	{
		this.oeufs = oeufs;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNom() 
	{
		return nom;
	}
	
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return
	 */
	public Personnage getJoueur() 
	{
		return joueur;
	}
	
	/**
	 * 
	 * @param joueur
	 */
	public void setJoueur(Personnage joueur) 
	{
		this.joueur = joueur;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNbJour() 
	{
		return nbJour;
	}
	
	/**
	 * 
	 * @param nbJour
	 */
	public void setNbJour(int nbJour) 
	{
		this.nbJour = nbJour;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNbHeure() 
	{
		return nbHeure;
	}
	
	/**
	 * 
	 * @param nbHeure
	 */
	public void setNbHeure(int nbHeure) 
	{
		this.nbHeure = nbHeure;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int getMaxCase() 
	{
		return MAX_CASE;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getJourCourant() 
	{
		return jourCourant;
	}
	
	/**
	 * 
	 * @param jourCourant
	 */
	public void setJourCourant(int jourCourant) 
	{
		this.jourCourant = jourCourant;
	}
	
	/**
	 * Modifie au hasard l'�tat de sommeil de tous les monstres sur toutes les cases
	 * V�rifie que le monstre est r�veill� pour endormir
	 * V�rifie que le monstre est endormi pour r�veiller
	 */
	private void modifierEtatMonstre()
	{
		//sommeil
		int n;
		for (int i = 0; i < this.cases.size(); i++)
		{
			for (int j = 0; j < this.cases.get(i).getNbMaxMonstre()-1; j++)
			{
				n = rand.nextInt(2);
				switch (n)
				{
					/*case 0 = dormir (si r�veill�)*/
					case 0: if(this.cases.get(i).monstres.get(j).isSommeil() == false)
						this.cases.get(i).monstres.get(j).dormir();
							break;
					/*case 1 = se reveiller (si endormi)*/
					case 1: if(this.cases.get(i).monstres.get(j).isSommeil() == true)
						this.cases.get(i).monstres.get(j).seReveiller();
							break;
				}
			}
		}
		//TODO changer �tat sommeil monstre si personnage attaque
	}
	
	/**
	 * Modifie au hasard d'�tat de pollution de toutes les cases
	 */
	private void modifierEtatCase()
	{
		//pollutions
		int n;
		for (int i = 0; i < this.cases.size(); i++)
		{
			n = rand.nextInt(3);
			this.cases.get(i).setPollution(n);
		}
	}
	
	/**
	 * 
	 */
	private void lesMonstresSeDeplacent()
	{
		//TODO
		//??Ajout de monstre sur chaque case??
		ArrayList<Monstre> monstres = new ArrayList<Monstre>();
		for (int i = 0; i < this.cases.size(); i++)
		{
			for (int j = 0; j < this.cases.get(i).getNbMaxMonstre(); j++)
			{
				monstres.add(this.cases.get(i).monstres.get(j));
			}
		}
		
		for(int l = 0; l < monstres.size(); l++)
		{
			Monstre monstre = monstres.get(l);
			if(!monstre.isSommeil())
			{
				System.out.println("Case "+monstre.getNumCaseActuelle()+" : "+monstre.getNom());
				if (!monstre.seDeplacer(new Vagabonder(), this))
				{
					if (!monstre.seDeplacer(new Ramper(), this))
					{
						if (!monstre.seDeplacer(new Voler(), this))
						{
								System.out.println("Le monstre "+monstre.getNom()+" tourne en rond et pi�tine. Il n'a pas pu se d�placer.");	
						}
					}
				}
			}
			else
			{
				System.out.println("Case "+monstre.getNumCaseActuelle()+" : "+monstre.getNom()+". Ce monstre dort, il ne peut pas se d�placer.");
			}
		}
	}
	
	/**
	 * R�cup�re tous les monstres, en choisi 4 et les fait se reproduire
	 * 
	 * @return void
	 */
	private void nouvellesNaissances()
	{
		//??Ajout de monstre sur chaque case??
		ArrayList<Monstre> monstres = new ArrayList<Monstre>();
		for (int i = 0; i < this.cases.size()-1; i++)
		{
			for (int j = 0; j < this.cases.get(i).getNbMaxMonstre(); j++)
			{
				monstres.add(this.cases.get(i).monstres.get(j));
			}
		}
		
		int i = 1;
		while(i != 4)
		{
			int n = rand.nextInt(monstres.size());

			Monstre monstre = monstres.get(n);
			if(!monstre.isEnGestation() && monstre.getSexe() != 1)
			{
				System.out.println("Le monstre "+monstres.get(n).getNom()+" est maintenant en gestation.");
				monstre.gestation(this);
			}
			i++;
		}
	}
	
	/**
	 * V�rifie pour chaque oeuf l'incubation
	 * Si l'incubation n'est pas finie, d�cr�mente l'incubation
	 * Sinon, ajoute un nouveau monstre sur la case m�re
	 * ??
	 * 
	 * V�rifie pour chaque monstre la gestation de toutes les cases
	 */
	private void verifNaissances()
	{
		//TODO OPTIMISATION !!!
		//On v�rifie les oeufs

		for (int i = 0; i < this.oeufs.size(); i++)
		{
			if(this.oeufs.get(i).getTempsIncub() >= 0)		//chang� en > pour �viter les erreurs (-1...)
			{
				int newTempsIncub = this.oeufs.get(i).getTempsIncub() - 1;
				this.oeufs.get(i).setTempsIncub(newTempsIncub);
			}
			else
			{
				System.out.println("Un oeuf a �clot !");
				Monstre monstre = this.oeufs.get(i).eclore();
				int numCase = oeufs.get(i).getNumCaseMere();
				Case laCase = this.recupererCase(numCase);
				this.oeufs.remove(i);
				boolean monstrePlace = false;
				while(monstrePlace == false)
				{
					if(laCase.ajoutMonstre(monstre))
					{
						System.out.println("Le jeune monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase());
						monstrePlace = true;
					}
					else
					{
						if(numCase == 19)
						{
							System.out.println("Un jeune monstre est mort car aucun terrain ne lui �tait favorable.");
							monstrePlace = true;
						}
						else
						{
							numCase = numCase +1;
							laCase = this.recupererCase(numCase);
						}
					}
				}
			}
		}
		
		//On v�rifie la gestation des vivipares
		for (int i = 0; i < this.cases.size(); i++)
		{
			Case laCase = this.cases.get(i);
			for (int j = 0; j < laCase.monstres.size(); j++)
			{
				Monstre monstre = this.cases.get(i).monstres.get(j);
				if (monstre.isEnGestation())
				{
					monstre.gestation(this);
				}
			}
		}
	}
	
	/**
	 * V�rifie que ce n'est pas la fin du jeu
	 * Si le nombre de jour maximal est atteind ou si le joueur est mort, le jeu prend fin
	 * Sinon le jour passe et le jeu continue
	 * @return vrai(true) si le jeu est fini, faux(false) sinon
	 */
	public boolean ChangerTour()
	{
		// On v�rifie que ce n'est pas la fin du jeu
		if (this.jourCourant == this.nbJour || this.joueur.getVie() <= 0) 
		{
			return true;
		}
		else
		{
			this.jourCourant++;
			this.nbHeure = 10;
			this.modifierEtatMonstre();
			this.modifierEtatCase();
			this.verifNaissances();
			this.lesMonstresAttaquent();
			this.lesMonstresSeDeplacent();
			this.nouvellesNaissances();
			return false;
		}
	}
	
	
	
	/**
	 * R�cup�re la case
	 * @param numCase La case � r�cup�rer
	 * @return La case r�cup�r�e
	 */
	public Case recupererCase(int numCase)
	{
		return this.cases.get(numCase);
	}
	
	/**
	 * D�cr�ment le nombre d'heures
	 * Si le nombre d'heure est � 0, le tour change
	 */
	public String consequenceAction()
	{
		this.nbHeure --;
		String tourChange = "";
		if(this.nbHeure == 0)
		{
			this.ChangerTour();
			tourChange = "\nVous vous endormez sous un arbre. La lune appara�t puis se voile, laissant place au Soleil. Un nouveau jour commence.\n";
		}
		return tourChange+"\nLes heures tournent. Vous perdez une heure de temps � faire votre action. Il vous reste "+this.nbHeure+" heures.";
	}
	
	/**
	 * Affiche les informations du jeu
	 * @return L'affichage du jeu
	 */
	public String infosJeu()
	{
		return "Jeu \n"
				+ "Nom : " + nom + "\n"
				+ "Joueur : " + joueur + "\n"
				+ "Nombre de jour : " + nbJour + "\n"
				+ "Jour actuel : " + jourCourant + "\n"
				+ "Nombre d'heure � d�penser : " + nbHeure + "\n"
				+ "Nombre de case dans le jeu : " + this.cases.size() + "\n";
	}
	
	/**
	 * Les monstres attaquent le personnage
	 * Si la vie du joueur est � 0, le jeu prend fin
	 */
	public void lesMonstresAttaquent()
	{
		int numCase = this.joueur.getPosition();
		ArrayList<Monstre> monstres = this.cases.get(numCase).monstres;
		for(int i=0; i<monstres.size();i++)
		{
			monstres.get(i).attaquerPersonnage(this.joueur);
		}
	}
}
