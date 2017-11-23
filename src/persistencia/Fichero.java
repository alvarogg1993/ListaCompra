/**
 * 
 */
package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import compras.Producto;

/**
 *  @author Alvaro Garcia
 *  @author Daniel Hernando
 *
 */
public class Fichero implements Persistencia {
	
	/**
	 * Fichero que contiene la Lista
	 */
	private File fichero;
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public Fichero(String nombre){
		fichero = new File(nombre);
	}

	/**
	 * Get Fichero
	 * @return fichero File
	 */
	public File getFichero() {return fichero;}
	
	/**
	 * Abrir Persistencia
	 */
	@Override
	public void abrir() {}

	/**
	 * lee productos de la lista
	 * @param lista Producto
	 */
	@Override
	public void leerProductos(ArrayList<Producto> listaProd) {
		Scanner s = null;
		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);
			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				//separar los atributos de cada producto
				String[] prodatr=linea.split(";");
				//Crear nuevo producto y añadirlo al array
				Producto product=new Producto(prodatr[0],Integer.parseInt(prodatr[1]),Boolean.valueOf(prodatr[2]),Boolean.valueOf(prodatr[3]));
				listaProd.add(product);
			//	System.out.println(linea);      // Imprimimos la linea
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}

	}//leeProductos

	/**
	 * añadir a la lista
	 * @param lista Producto
	 */
	@Override
	public void addALista(Producto p,ArrayList<Producto> listaProd) {
		FileWriter fich = null;
		try {
			fich= new FileWriter(fichero,true);
			//Escribir liena del fichero
			fich.write(p.getNombre() + ";" + p.getCantidad() + ";" + p.getComprado()+ ";" + p.getFavorito() + "\n");
			//cerrarfichero
			fich.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}

	}//addALista

	
	/**
	 * Actualiza la lista
	 * @param lista Producto
	 */
	@Override
	public void actualizaLista(ArrayList<Producto> listaProd) {
		FileWriter fich = null;
		try {
			fich= new FileWriter(fichero);
			// Escribimos linea a linea en el fichero
			for (Producto p : listaProd) {
				fich.write(p.getNombre() + ";" + p.getCantidad() + ";" + p.getComprado()+ ";" + p.getFavorito() + "\n");
			}
			//cerrarfichero
			fich.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}

	}

	/**
	 * Cerrar conexión
	 */
	@Override
	public void cerrar() {
	}

}
