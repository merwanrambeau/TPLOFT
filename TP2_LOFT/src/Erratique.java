import java.util.*;
import java.lang.Math;
import java.util.Random;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ArrayList;

public class Erratique extends Neuneu {
	
	public Erratique(String nom, String prenom, Loft leLoft)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.energie=100;
		this.loft = leLoft;
		this.caseCourante= this.loft.cases[0][0];
		this.graph="Erratique.png";
		this.id = this.loft.population.get(this.loft.population.size() - 1).id + 1;
		this.loft.population.add(this);
		this.caseCourante.population.add(this);
		
	}
	public Erratique(String nom, String prenom, Loft leLoft, int abscisse, int ordonnee)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.energie=100;
		this.loft = leLoft;
		this.caseCourante = this.loft.cases[abscisse][ordonnee];
		this.graph="Erratique.png";
		if (this.loft.population.size() == 0)
		{
			this.id = 0;
		}
		else
		{
			this.id = this.loft.population.get(this.loft.population.size() - 1).id + 1;
		}
		this.loft.population.add(this);
		this.caseCourante.population.add(this);
	}
	
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
			}else
			{
				 
			}
		}
	}

	public void representer()
	{
	}
	
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
				}
					System.out.println(this.prenom+" a mange " + this.caseCourante.nourriture.get(j).type + " et son energie est de " + this.energie);
			}
		}else
		{
			System.out.println("pas de nourriture a cet emplacement");
		}
	}
	
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

}