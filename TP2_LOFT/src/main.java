import java.util.Timer;
import java.util.TimerTask;


public class main {

	/**
	 * @param args
	 */
	public static void main (String[] args) 
	{
		Timer time = new Timer();
		Loft leLoft = new Loft(20, 20);
		leLoft.PopulateDefault();
		leLoft.PopulateNourriture();
		ConcreteTimerTask tourDeVie = new ConcreteTimerTask(leLoft);
		while (leLoft.jeuTermine == false)
		{
			time.scheduleAtFixedRate(tourDeVie, 3000, 10000);
		}
		
		
		
		
	}

}
