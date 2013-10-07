import java.util.*;
import java.lang.Math;
import java.util.Random;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ArrayList;

public class Erratique extends Neuneu {
	
	//Constructeurs
	public Erratique(String nom, String prenom)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.energie=100;
		this.caseCourante= this.loft.cases[0][0];
		this.graph="erratique";
		this.id = this.loft.population.get(this.loft.population.size() - 1).id + 1;
		this.loft.population.add(this);
		this.caseCourante.population.add(this);
		
	}
	public Erratique(String nom, String prenom, int abscisse, int ordonnee)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.energie=100;
		this.caseCourante= this.loft.cases[abscisse][ordonnee];
		this.graph="erratique";
		this.id = this.loft.population.get(this.loft.population.size() - 1).id + 1;
		this.loft.population.add(this);
		this.caseCourante.population.add(this);
	}
	
	/*public void setnom(String nom){
		this.nom=nom;
	}
	public String getnom()
	{
		return nom;
	}
	public void setprenom(String prenom)
	{
		this.prenom=prenom;
	}
	public String getprenom()
	{
		return prenom;
	}
	public void setenergie(int energ)
	{
		this.energie=energ;
	}
	public int getenergie()
	{
		return energie;
	}
	public void setCaseCourante()
	{
		this.
	}*/
	
	//seDeplacer : l'erratique se deplace aleatoirement, il erre.
	//Si les cases autour de lui sont deja utilisees par un autre neuneu, il reste ou il est,
	//sinon il va sur l'une des cases adjacentes.
	public void seDeplacer()
	{
		for(int i=0; i<8; i++)
		{
			if (caseCourante.casesAdjacentes.get(i).population.isEmpty()==true)
			{
				this.caseCourante.population.remove(this);
				this.caseCourante = caseCourante.casesAdjacentes.get(i);
				this.caseCourante.population.add(this);
				break;
				//System.out.println("Le neuneu " + this.nom + " est desormais sur la case (" + this.caseCourante.abs.toString() + " , " + this.caseCourante.ord.toString() + ")");
			}else
			{
				 
			}
		}
	}

	public void representer()
	{
	}
	//manger(): l'Erratique mange la nourriture sur la case, si besoin en energie
	//Il mange ce qu'il y a comme nourriture listee en commencant par le premier element de la liste jusqu'a ce que son energie soit maximale.
	public void manger()
	{
		if (caseCourante.nourriture.isEmpty()==false)
		{
			int a = 100-this.energie;	
			for(int j=0;j<caseCourante.nourriture.size(); j++)
			{
				if (a>(caseCourante.nourriture.get(j).valeurNRJ)*(caseCourante.nourriture.get(j).quantite))
				{
					this.energie = this.energie + (caseCourante.nourriture.get(j).valeurNRJ) * (caseCourante.nourriture.get(j).quantite); 
					this.caseCourante.nourriture.remove(j);
				}else
				{
					this.energie = 100;
					caseCourante.nourriture.get(j).quantite = caseCourante.nourriture.get(j).quantite - (int)Math.floor(a / caseCourante.nourriture.get(j).valeurNRJ) ;
					//il mange jusqu'a atteindre 100 d'energie et on diminue la quantite de nourriture sur la case.
				}
					System.out.println(this.prenom+" a mange " + this.caseCourante.nourriture.get(j).type + " et son energie est de " + this.energie);
			}
		}else
		{
			System.out.println("pas de nourriture a cet emplacement");
		}
	}

	
	
	//seReproduire :il peut se reproduire
	
	// on lui donne un nom de neuneu, si ce neuneu est sur une case à côté, il se reproduit, on crée un nouveau neuneu sur la même case que lui
	public void  seReproduire()
	{
		for (int i = 0; i < this.caseCourante.casesAdjacentes.size(); i++)
		{
			if (this.caseCourante.casesAdjacentes.get(i).population.isEmpty() == false)
			{
				Random random = new Random();
				int decision = random.nextInt(4);
				if (decision == 0)
				{
					this.seReproduire(this.caseCourante.casesAdjacentes.get(i).population.get(0));
					break;
				}
			}
		}
	}

	public void Affiche()
	{
	}
}
