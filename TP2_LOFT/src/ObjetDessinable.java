
import java.awt.*;


public abstract class ObjetDessinable {
	    public ObjetDessinable() 
	    {
	    	//aucune action	    
	    }

	    abstract public void dessinerObjet(Graphics g);
	    
	    /**public void colorerObjet(Graphics g)
	    {
	         g.setColor(Color.black);
	    }

	    public void ligne(Graphics g,int x1,int y1,int x2,int y2) {
			g.drawLine(x1,y1,x2,y2);
	    }
	    */
	}
