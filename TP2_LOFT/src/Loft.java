import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loft implements ObjetDessinable {
	
	protected int hauteur;
	protected int largeur;
	protected List<Neuneu> population;
	protected Case[][] cases;
	protected List<Nourriture> nourriture;
	protected Boolean jeuTermine;
	
	public Loft (int h, int l)
	{
		this.hauteur = h;
		this.largeur = l;
		this.cases = new Case[h][l];
		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < l; j++)
			{
				this.cases[i][j] = new Case(i,j);
			}
		}
		this.population = new LinkedList<Neuneu>();
		// place 10 neuneus sur des cases fonction de h et l
		this.nourriture = new LinkedList<Nourriture>();
		this.jeuTermine = false;
	}
	
	public void PopulateDefault()
	{
		Erratique erratique1 = new Erratique("Jean", "Bon", this, 3, 3);
		Vorace vorace1 = new Vorace("Pierre", "Paul", this, 14, 5);
		Lapin lapin1 = new Lapin("Jeannot", "Carrotte", this, 9, 13);
		Cannibale cannibale1 = new Cannibale("Don", "Choa", this, 17, 8);
	}
	
	public void PopulateNourriture()
	{	
		Sale sale1 = new Sale(10);
		Sucre sucre1 = new Sucre(6);
		Sale sale2 = new Sale(8);
		Sucre sucre2 = new Sucre(11);
		Sale sale3 = new Sale(5);
		Sucre sucre3 = new Sucre(5);
		Sale sale4 = new Sale(2);
		Sucre sucre4 = new Sucre(7);
		this.cases[3][4].nourriture.add(sale1);
		this.cases[15][15].nourriture.add(sale2);
		this.cases[10][8].nourriture.add(sucre1);
		this.cases[2][15].nourriture.add(sucre2);
		this.cases[7][9].nourriture.add(sucre3);
		this.cases[17][10].nourriture.add(sale3);
		this.cases[2][8].nourriture.add(sale4);
		this.cases[20][1].nourriture.add(sucre4);
		
	}
	
	/**public void Affiche()
	{
		for (int i = 0; i < this.hauteur; i++)
		{
			for (int j = 0; j < this.largeur; j++)
			{
				this.cases[i][j].Affiche();
			}
		}
	}
	*/
	
	public void dessinerObjet(Graphics g) {
        int size = 600; //size in pixels
                
        BufferedImage bufImg = new BufferedImage(size, size, BufferedImage.TYPE_4BYTE_ABGR);

        BufferedImage solo;

        try {
                solo        = ImageIO.read(new File("carrenoir.jpeg"));

                Graphics horsEcran = bufImg.getGraphics();

                for(int i = 0; i < this.largeur; i++)
                {
                        for(int j = 0; j < this.hauteur; j++)
                        {
                                horsEcran.drawImage(solo, i * 20, j * 20, null);
                        }
                }
                
                //pour dessiner des nourritures
                for(Nourriture nou : this.nourriture){
                        BufferedImage bufImgNourriture = ImageIO.read(new File(nou.graph));
                        for(int i = 0; i < this.largeur; i++)
                        {
                            for(int j = 0; j < this.hauteur; j++)
                            {
                            	horsEcran.drawImage(bufImgNourriture, i*20, j*20, null);        
                            }
                        }
                }
                
                //pour dessiner des neuneus
                for(Neuneu ne : this.population){
                        BufferedImage imgNeuneu = ImageIO.read(new File(ne.graph));
                        for(int i = 0; i < this.largeur; i++)
                        {
                            for(int j = 0; j < this.hauteur; j++)
                            {
                            	horsEcran.drawImage(imgNeuneu, i * 20, j * 20, null);
                            }
                        }
                }

                g.drawImage(bufImg, 0, 0, null);

        } catch (IOException e) {
                System.out.println("Exception:(image!!) " + e.getMessage());
                e.printStackTrace();
        }


	}
}	
