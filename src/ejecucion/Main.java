package ejecucion;

import java.io.FileNotFoundException;
/**
 * 
 *  @author Alvaro Garcia
 *  @author Daniel Hernando
 *
 */
public class Main {

	static ModoTexto mtext;
	static ModoGrafico mgraf;
	
	public static void main(String[] args) throws FileNotFoundException {
		//mtext=new ModoTexto();
		mgraf=new ModoGrafico();
		mgraf.main(args);
		
	}
}
