import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * On cree un panneau pour dessiner le loft
 * 
 */
public class Panneau extends JPanel {

	private LinkedList<ObjetDessinable> listeObjets;


	public void LoftPanel(LinkedList<ObjetDessinable> listeObjets) {
		this.listeObjets = listeObjets;
	}

	/**
	 * paint(): elle appelle les methodes
	 * dessinerObjet() de la liste d'objets dessinables
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// on redessine tous les objets
		for (ObjetDessinable oD : listeObjets) {
			oD.dessinerObjet(g);
		}
	}
        

}

