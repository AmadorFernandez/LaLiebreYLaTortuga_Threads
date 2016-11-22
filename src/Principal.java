
public class Principal {

	public static void main(String[] args) {
		
		Tablero elTablero = new Tablero();
		Liebre laLiebre = new Liebre(elTablero);
		Tortuga laTortuga = new Tortuga(elTablero);
		
		laLiebre.start();
		laTortuga.start();

	}

}
