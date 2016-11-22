import java.rmi.server.UID;
import java.util.Random;


/**
 * Contiene la logica del juego
 * */
public class Tablero {
	
	private String[] casillas;
	private boolean fin;
	public static final String LETRA_TORTUGA = "[T]";
	public static final String LETRA_LIEBRE = "[L]";
	public static final String LETRA_IGUALES = "[X]";
	public static final int AVANCE_RAPIDO_TORTUGA = 3;
	public static final int RESBALA_TORTUGA = -6;
	public static final int AVANCE_LENTO_TORTUGA = 1;
	public static final int DUERME_LIEBRE = 0;
	public static final int GRAN_SALTO_LIEBRE = 9;
	public static final int PEQUEÑO_SALTO_LIEBRE = 1;
	public static final int RESBALON_GRANDE_LIEBRE = -12;
	public static final int RESBALON_PEQUEÑO_LIEBRE = -2;
	private int posTortuga;
	private int posLiebre;
	
	
	public synchronized boolean getFin(){
		
		return fin;		
	}
	
	public Tablero(){
		
		iniciarTablero();
		fin = false;
	}
	
	

	private void iniciarTablero(){
		
		casillas = new String[70];
		
		for (int i = 0; i < casillas.length; i++) {
			
			casillas[i] = "["+String.valueOf(i+1)+"]";
			
		}
	}
	
	//Contiene la logica de los movimientos de la tortuga
	public synchronized void moverTortuga(){
		
		Random random = new Random();
		int alea =random.nextInt(101);
		
		if(alea <= 20){
			
			posTortuga += RESBALA_TORTUGA;
			
			if(posTortuga < 1){
				
				posTortuga = 1;
			}
					
		}else if(alea >= 30 && alea <= 50){
			
			posTortuga += AVANCE_LENTO_TORTUGA;
			
			
		}else{
			
			posTortuga += AVANCE_LENTO_TORTUGA;
			
		}
		
		if(posTortuga >= 70){
			
			posTortuga = 70;
		}	
		
		casillas[posTortuga] = LETRA_TORTUGA;
		actualizar();
				
	}
	
	//Contiene la logica de los movimientos de la liebre
	public synchronized void moverLiebre(){
		
		Random random = new Random();
		int alea = random.nextInt(101);
		
		if(alea <= 20){
			
			posLiebre += DUERME_LIEBRE;
			
			if(posLiebre < 1){
				
				posLiebre = 1;
			}
					
		}else if(alea >20 && alea <= 40){
			
			posLiebre += GRAN_SALTO_LIEBRE;
			
			
		}else if(alea > 40 && alea <= 50){
			
			posLiebre += RESBALON_GRANDE_LIEBRE;
			
		}else if(alea > 50 && alea <= 80)
			
			posLiebre += PEQUEÑO_SALTO_LIEBRE;
		
		else if (alea > 80 && alea <= 100) {
			
			posLiebre += RESBALON_PEQUEÑO_LIEBRE;
		}
		
		if(posLiebre >= 69){
			
			posLiebre = 69;
			
		}else if(posLiebre < 0){
			
			posLiebre = 0;
		}
		
		casillas[posLiebre] = LETRA_LIEBRE;
		actualizar();
	}
	
	private void actualizar(){
		
		for (int i = 0; i < casillas.length; i++) {
			
			if(i == posTortuga){
				
				casillas[i] = LETRA_TORTUGA;
				
			}if(i == posLiebre){
				
				casillas[i] = LETRA_LIEBRE;
				
			}else if(i == posLiebre && i == posTortuga){
				
				casillas[i] = LETRA_IGUALES;
				
			}else{
				
				casillas[i] = "["+String.valueOf(i+1)+"]";
			}	
			
			System.out.print(casillas[i]);
		}
		
		System.out.println();
		
		System.out.println("La posicion de la liebre es: "+(posLiebre+1));
		System.out.println("La posicion de la tortuga es: "+(posTortuga+1));
		
		if(posLiebre == 69 && posTortuga == 69){
			
			fin = true;
			System.out.println("Han empatado");
			
		}else if(posLiebre == 69){
			
			
			fin = true;
			System.out.println("Ha ganado la liebre");
			
		}else if (posTortuga == 69) {
			
			fin = true;
			System.out.println("Ha ganado la tortuga");
		}
	}

}
