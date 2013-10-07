import java.util.*;
	import java.awt.* ;
	import javax.swing.* ;
	import java.awt.event.* ;

/**
 * On cree une zone d'affichage des objets dessines.
 *
 */
	
 public class Affichage extends JFrame {
 

	private LinkedList<ObjetDessinable> lesObjetsD; // les objets a dessiner
	   
	   public Affichage() {
		   //titre
	      super("LE LOFT");
	      //creation de la liste d'objet
	      lesObjetsD = new LinkedList<ObjetDessinable>();
	      //taille par defaut
	      setSize(600,600);
	   }
	   
	   public void paint(Graphics g) {
	       super.paint(g);
	      for( ObjetDessinable oD : lesObjetsD) {
	         oD.dessinerObjet(g);
	      }
	   }
	   
	   public void ajoutObjet(ObjetDessinable objet) {
	      lesObjetsD.add(objet);
	   }
	   
	}
