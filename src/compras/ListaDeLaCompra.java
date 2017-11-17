
/**
 * 
 */
package compras;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Álvaro García
 * @author Daniel Hernando
 *
 */

public class ListaDeLaCompra {
	/**
	 * Fichero que contiene la Lista
	 */
	private File fichero;
	/**
	 * Array de Productos 
	 */
	private ArrayList<Producto> listaProd;

	/**
	 * Constructor Lista Compra
	 * @param nombreLista
	 */
	public ListaDeLaCompra(String nombreLista) {
		//Crea objeto FILE para la lista de la compra
		fichero = new File(nombreLista);
		listaProd=new ArrayList<Producto>();
		leeProductos(); 
	}//constructor
	
	/**
	 * Añade un prosucto nuevo a la lista
	 * @param nombreProd
	 * @param cantidad
	 */
	public void addProducto(String nombreProd, int cantidad) {
		//Comprobar si producto existe
		if(listaProd.isEmpty()){
			Producto p=new Producto(nombreProd,cantidad,false);
			listaProd.add(p);
			addALista(p);
		}else{
			Producto pr=getProducto(nombreProd);
			if(pr!=null) {
				int cantN=pr.getCantidad()+cantidad;
				listaProd.get(listaProd.indexOf(pr)).setCantidad(cantN);
				actualizaLista();
			}else {
				Producto p=new Producto(nombreProd,cantidad,false);
				listaProd.add(p);
				addALista(p);
			}
		}
	}

	/**
	 * Borra un producto de la lista pasado un nombre
	 * @param nombreProd
	 */
	public void delProducto(String nombreProd) {
		Producto pr=getProducto(nombreProd);
		if(pr!=null) {
			listaProd.remove(pr);
			actualizaLista();
		}else {
			System.out.println("El producto elegido no existe");
			System.out.println("No se harán modificaciones en la lista");
		}
	}

	/**
	 * Busca el producto en la lista por nombre
	 * @param nombreProd
	 * @return producto encontrado o null
	 */
	public Producto getProducto(String nombreProd) {
		Producto pr = null;
		for (Producto i : listaProd) {
			if(i.getNombre().equals(nombreProd)) {
				pr = i;
			}
		}
		return pr;
	}
	
	/**
	 * Cambiar el nombre de un producto
	 * @param nombreProdA actual
	 * @param nombreProdN nuevo
	 */
	public void cambiaNombreProd(String nombreProdA,String nombreProdN) {
		Producto pr=getProducto(nombreProdA);
		if(pr!=null) {
			listaProd.get(listaProd.indexOf(pr)).setNombre(nombreProdN);
			actualizaLista();
		}else {
			System.out.println("El producto elegido no existe");
			System.out.println("No se harán modificaciones en la lista");
		}
	}
	
	/**
	 * Modifica la cantidad del producto 
	 * @param nombreProd
	 * @param c
	 */
	public void cambiaCantidadProducto(String nombreProd, int c) {
		Producto pr=getProducto(nombreProd);
		if(pr!=null) {
			listaProd.get(listaProd.indexOf(pr)).setCantidad(c);
			actualizaLista();
		}else {
			System.out.println("El producto elegido no existe");
			System.out.println("No se harán modificaciones en la lista");
		}
	}
	
	/**
	 * Borra los productos marcados como comprados
	 */
	public void limpiaLista() {
		for (Producto p : listaProd) {
			if(p.getComprado()) {
				listaProd.remove(p);
			}
		}
		actualizaLista();
	}
/*
	


	public void setNombreProducto(Producto p, String n) {
		if (listaProd.contains(p))
			p.setNombre(n);

	}
*/
	public void comprarProducto(String nombreProd) {
		Producto pr=getProducto(nombreProd);
		if(pr!=null) {
			listaProd.get(listaProd.indexOf(pr)).setComprado(true);
			//listaProd.remove(pr); 
			actualizaLista();
		}else {
			System.out.println("El producto elegido no existe");
			System.out.println("No se harán modificaciones en la lista");
		}
	}

	public void muestraLista() {
		for (Producto i : listaProd) {
			i.muestraProducto();
		}

	}

	/**
	 * Recoger los productos de la lista y añadirlos a un array de Productos
	 * 
	 */
	public void leeProductos(){
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
				Producto product=new Producto(prodatr[0],Integer.parseInt(prodatr[1]),Boolean.valueOf(prodatr[2]));
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
	}//leeproductos
	/*
	public void leeFichero(){

		//File fichero = new File(nombreFichero);

		Scanner s = null;
		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				//split
				System.out.println(linea);      // Imprimimos la linea
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
	}//leerfichero
	*/
	/**
	 * Añade un producto a la lista
	 */
	public void addALista(Producto p){
		FileWriter fich = null;
		try {
			fich= new FileWriter(fichero,true);
			//Escribir liena del fichero
			fich.write(p.getNombre() + ";" + p.getCantidad() + ";" + p.getComprado() + "\n");
			//cerrarfichero
			fich.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}//addALista
	
	/**
	 * Actualiza el fichero con la lista de productos
	 */
	public void actualizaLista(){
		FileWriter fich = null;
		try {
			fich= new FileWriter(fichero);
			// Escribimos linea a linea en el fichero
			for (Producto p : listaProd) {
				fich.write(p.getNombre() + ";" + p.getCantidad() + ";" + p.getComprado() + "\n");
			}
			//cerrarfichero
			fich.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}//actualizaLista

}

