import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Representa a la tortuga y termina cuando el tablero avisa mediante el boleano
 * */
public class Tortuga extends Thread {

	
	private Tablero elTablero;
	
	public Tortuga(Tablero eTablero){
		
		this.elTablero = eTablero;
	}

	
	@Override
	public void run() {
		
	   while (!elTablero.getFin()) {
		   
		   elTablero.moverTortuga();
		   try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
	
}
