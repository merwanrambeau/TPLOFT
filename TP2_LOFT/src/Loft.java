import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Loft {
	
	protected int hauteur;
	protected int largeur;
	protected List<Neuneu> population;
	protected Case[][] cases;
	protected List<Nourriture> nourriture;
	
	public Loft (int h, int l)
	{
		this.hauteur = h;
		this.largeur = l;
		this.cases = new Case[h][l];
		this.population = new LinkedList<Neuneu>();
		this.PopulateDefault();
		// place 10 neuneus sur des cases fonction de h et l
		this.nourriture = new LinkedList<Nourriture>();
		this.PopulateNourriture();
	}
	
	public void PopulateDefault()
	{
	}
	
	public void PopulateNourriture()
	{
	}
	
	public void Affiche()
	{
		for (int i = 0; i < this.hauteur; i++)
		{
			for (int j = 0; j < this.largeur; j++)
			{
				this.cases[i][j].Affiche();
			}
		}
	}
	
	

}
