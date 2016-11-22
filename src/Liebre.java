/**
 * Representa a la liebre y termina cuando el tablero avisa mediante el boleano
 * */
public class Liebre extends Thread {

	private Tablero elTablero;
	
	public Liebre(Tablero elTablero){
		
		this.elTablero = elTablero;
	}
	
	@Override
	public void run() {
		
		   while (!elTablero.getFin()) {
			   
			   elTablero.moverLiebre();
			   try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
