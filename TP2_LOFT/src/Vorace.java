
public class Vorace extends Erratique {

	public Vorace(String nom, String prenom, Loft leLoft) {
		super(nom, prenom, leLoft);
		this.graph = "Vorace";
	}

	public Vorace(String nom, String prenom, Loft leLoft, int abscisse, int ordonnee) {
		super(nom, prenom, leLoft, abscisse, ordonnee);
		this.graph = "Vorace";
	}
	
	public void seDeplacer()
	{
		int distMin = this.loft.largeur + this.loft.hauteur + 1;
		Case caseMin = new Case(0,0);
		for(int i = 0; i < this.loft.largeur; i++)
		{
			for (int j = 0; j< this.loft.hauteur; j++)
			{
				if (this.loft.cases[i][j].nourriture.isEmpty() == false)
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

}
