import java.lang.String;


abstract class Neuneu {
	protected int id;
	protected String nom;
	protected String prenom;
	protected int energie;
	protected String graph;
	protected Loft loft;
	protected Case caseCourante;
	
	public abstract void seDeplacer();
	
	public abstract void manger();
	
	public void exclusion()
	{
		this.loft.population.remove(this);
		this.caseCourante.population.remove(this);
	}
	
	
	public abstract void seReproduire();
	
	public void seReproduire(Neuneu partenaire)
	{
		String type1 = this.getClass().toString();
		String type2 = partenaire.getClass().toString();
		int nouvelAbs = -1;
		int nouvelOrd = -1;
		for (int i = 0; i< this.loft.largeur; i++)
		{
			for(int j = 0; j < this.loft.hauteur; j++)
			{
				if (this.loft.cases[i][j].population.isEmpty() == true)
				{
					nouvelAbs = i;
					nouvelOrd = j;
				}
			}
		}
		if (type1 == "Erratique" && type2 == "Erratique")
		{
			Erratique nouveauNe = new Erratique ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Lapin" && type2 == "Lapin")
		{
			Lapin nouveauNe = new Lapin ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Vorace" && type2 == "Vorace")
		{
			Vorace nouveauNe = new Vorace ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Cannibale" && type2 == "Cannibale")
		{
			Cannibale nouveauNe = new Cannibale ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Erratique" && type2 == "Lapin")
		{
			Erratique nouveauNe = new Erratique ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);

		}
		
		if (type1 == "Erratique" && type2 == "Vorace")
		{
			Vorace nouveauNe = new Vorace ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Erratique" && type2 == "Cannibale")
		{
			Cannibale nouveauNe = new Cannibale ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Lapin" && type2 == "Vorace")
		{
			Vorace nouveauNe = new Vorace ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Lapin" && type2 == "Cannibale")
		{
			Cannibale nouveauNe = new Cannibale ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
		
		if (type1 == "Vorace" && type2 == "Cannibale")
		{
			Vorace nouveauNe = new Vorace ((this.nom + partenaire.nom), "Kevin", this.loft, nouvelAbs, nouvelOrd);
		}
	}

	public void Affiche()
	{
		System.out.println("Neuneu de type + " + this.graph + ", NRJ : " + this.energie);
	}
}
