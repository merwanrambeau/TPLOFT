
public class Cannibale extends Vorace {

	public Cannibale(String nom, String prenom) 
	{
		super(nom, prenom);
		this.graph = "Cannibale";
	}

	public Cannibale(String nom, String prenom, int abscisse, int ordonnee) {
		super(nom, prenom, abscisse, ordonnee);
		this.graph = "Cannibale";
	}
	
	public void seDeplacer()
	{
		int distMin = this.loft.largeur + this.loft.hauteur + 1;
		Case caseMin = new Case(0,0);
		for(int i = 0; i < this.loft.largeur; i++)
		{
			for (int j = 0; j< this.loft.hauteur; j++)
			{
				if (this.loft.cases[i][j].nourriture.isEmpty() == false || this.loft.cases[i][j].population.isEmpty() == false)
				{
					if (this.caseCourante.CalculDistance(this.loft.cases[i][j]) < distMin)
					{
						distMin = this.caseCourante.CalculDistance(this.loft.cases[i][j]);
						caseMin = this.loft.cases[i][j];
					}
				}
			}
		}
		int sensHorizontal = 0;
		if (caseMin.abs > this.caseCourante.abs)
		{
			sensHorizontal = +1;
		}
		
		if (caseMin.abs < this.caseCourante.abs)
		{
			sensHorizontal = -1;
		}
		
		if (caseMin.abs == this.caseCourante.abs)
		{
			sensHorizontal = 0;
		}
		
		int sensVertical = 0;
		if (caseMin.ord > this.caseCourante.ord)
		{
			sensVertical = +1;
		}
		
		if (caseMin.ord < this.caseCourante.ord)
		{
			sensVertical = -1;
		}
		
		if (caseMin.ord == this.caseCourante.ord)
		{
			sensVertical = 0;
		}
		
		if (this.loft.cases[this.caseCourante.abs + sensHorizontal][this.caseCourante.ord + sensVertical].population.isEmpty() == true)
		{
			this.caseCourante.population.remove(this);
			this.caseCourante = this.loft.cases[this.caseCourante.abs + sensHorizontal][this.caseCourante.ord + sensVertical];
			this.caseCourante.population.add(this);
		}
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
					//il mange jusqu'a atteindre 100 d'energie et on diminue la quantite de nourriture sur la case.
				}
					System.out.println(this.prenom+" a mange " + this.caseCourante.nourriture.get(j).type + " et son energie est de " + this.energie);
			}
		}else
		{
			System.out.println("pas de nourriture a cet emplacement");
		}
	}
}