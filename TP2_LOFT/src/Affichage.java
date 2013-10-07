import java.util.*;
	import java.awt.* ;
	import javax.swing.* ;
	import java.awt.event.* ;

public class Affichage extends JFrame {

	private Vector<ObjetGraphique> lesObjetsG; // les objets à tracer
	   
	   public Affichage() {
	      super("LE LOFT");
	      lesObjetsG = new Vector<ObjetGraphique>();
	      setSize(600,600);
	   }
	   
	   public void paint(Graphics g) {
	       super.paint(g);
	      for( ObjetGraphique oG : lesObjetsG) {
	         //oG.drawImage(g); // chaque objet graphique a une image	
	         oG.dessinerObjet(g);
	         oG.colorerObjet(g);
	      }
	   }
	   
	   public void ajoutObjet(ObjetGraphique objet) {
	      lesObjetsG.add(objet);
	   }
	   
	}
