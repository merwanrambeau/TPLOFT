
public class Cannibale extends Vorace {

	public Cannibale(String nom, String prenom, Loft leLoft) 
	{
		super(nom, prenom, leLoft);
		this.graph = "Cannibale.png";
	}

	public Cannibale(String nom, String prenom, Loft leLoft, int abscisse, int ordonnee) {
		super(nom, prenom, leLoft, abscisse, ordonnee);
		this.graph = "Cannibale.png";
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
			
			if (this.energie < 100)
			{
				for (int j = 0; j <8; j++)
				{
					if (this.caseCourante.casesAdjacentes.get(j).population.isEmpty() == false)
					{
						this.mangerAutrui(this.caseCourante.casesAdjacentes.get(j).population.get(0));
					}
				}
			}
		}
}
	
	public void mangerAutrui(Neuneu proie)
	{
		this.energie = Math.min(100, this.energie + proie.energie);
		proie.exclusion();
	}

}
