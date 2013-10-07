
public class Sucre extends Nourriture {

	public Sucre(int qtt)
	{
		this.type = "Sucre";
		this.valeurNRJ = 5;
		this.graph = "Sucre.png";
		this.quantite = qtt;
	}
	
	public void Affiche()
	{
		System.out.println("Nourriture Salee : Quantite : " + this.quantite.toString() + "\n\n");
	}
}
