import java.util.*;
import java.lang.*;

public class Case {

	protected Integer abs;
	protected Integer ord;
	protected Loft loft;
	protected List<Neuneu> population;
	protected List<Nourriture> nourriture;
	protected List<Case> casesAdjacentes;
	protected int pixelAbs;
	protected int pixelOrd;
	
	public Case(int x, int y)
	{
		int size = 40;
		this.abs = x;
		this.ord = y;
		this.population = new LinkedList<Neuneu>();
		this.nourriture = new LinkedList<Nourriture>();
		this.casesAdjacentes = new ArrayList<Case>(8);
		
		this.casesAdjacentes.add(0, this.loft.cases[this.abs][this.ord -1]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs][this.ord +1]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs -1][this.ord -1]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs -1][this.ord ]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs -1][this.ord +1]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs +1][this.ord -1]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs +1][this.ord ]);
		this.casesAdjacentes.add(0, this.loft.cases[this.abs +1][this.ord +1]);
		
		this.pixelAbs = this.abs*size + (size/2);
	}
	
	public int CalculDistance(Case autreCase)
	{
		return Math.abs(this.abs - autreCase.abs) + Math.abs(this.ord - autreCase.ord);
	}
	
	public void Affiche()
	{
		for (int i = 0; i < this.population.size(); i++)
		{
			this.population.get(i).Affiche();
		}
	}


}
	
