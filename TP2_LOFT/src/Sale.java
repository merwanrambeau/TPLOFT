
public class Sale extends Nourriture {

	public Sale(int qtt) 
	{
		this.type = "Sale";
		this.graph = "Sale";
		this.valeurNRJ = 7;
		this.quantite = qtt;
	}

	public void Affiche() 
	{
		System.out.println("Nourriture Salee : Quantite : " + this.quantite.toString() + "\n\n");
	}

}
