
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class ObjetGraphique {
	    public ObjetGraphique() {
		// do nothing
	    }

	    abstract public void dessinerObjet(Graphics g);
	    public void colorerObjet(Graphics g){
	         g.setColor(Color.black);
	    }

	    public void ligne(Graphics g,int x1,int y1,int x2,int y2) {
			g.drawLine(x1,y1,x2,y2);
	    }
	    
	    /**public void image(Graphics g, Image img)
	    {
	    	g.drawImage(img);
	    }*/
	}
