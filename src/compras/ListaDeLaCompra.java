
/**
 * 
 */
package compras;

import java.util.ArrayList;

import persistencia.Fichero;
/**
 * @author Álvaro García
 * @author Daniel Hernando
 *
 */

public class ListaDeLaCompra implements Compra{
	/**
	 * Fichero que contiene la Lista
	 */
	private Fichero fichero;
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
		fichero = new Fichero(nombreLista);
		listaProd=new ArrayList<Producto>();
		if(fichero.getFichero().exists()) {
			fichero.leerProductos(listaProd);
		}
	}//constructor
	
	/**
	 * Añade un prosucto nuevo a la lista
	 * @param nombreProd
	 * @param cantidad
	 */
	public void addProducto(String nombreProd, int cantidad) {
		//Comprobar si producto existe
		if(listaProd.isEmpty()){
			Producto p=new Producto(nombreProd,cantidad,false,false);
			listaProd.add(p);
			fichero.addALista(p,listaProd);
		}else{
			Producto pr=getProducto(nombreProd);
			if(pr!=null) {
				int cantN=pr.getCantidad()+cantidad;
				listaProd.get(listaProd.indexOf(pr)).setCantidad(cantN);
				fichero.actualizaLista(listaProd);
			}else {
				Producto p=new Producto(nombreProd,cantidad,false,false);
				listaProd.add(p);
				fichero.addALista(p, listaProd);
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
			fichero.actualizaLista(listaProd);
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
			fichero.actualizaLista(listaProd);
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
			fichero.actualizaLista(listaProd);
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
				if(p.getFavorito()){
					p.setCantidad(0);
				}else {
					listaProd.remove(p);
				}
			}
		}
		fichero.actualizaLista(listaProd);
	}

	/**
	 * Marca el producto pasado como comprado
	 * @param nombreProd
	 */
	public void comprarProducto(String nombreProd) {
		Producto pr=getProducto(nombreProd);
		if(pr!=null) {
			listaProd.get(listaProd.indexOf(pr)).setComprado(true);
			//listaProd.remove(pr); 
			fichero.actualizaLista(listaProd);
		}else {
			System.out.println("El producto elegido no existe");
			System.out.println("No se harán modificaciones en la lista");
		}
	}

	/**
	 * Marca el producto como favorito
	 * @param nombreProd
	 */
	public void marcarFavorito(String nombreProd) {
		Producto pr=getProducto(nombreProd);
		if(pr!=null) {
			listaProd.get(listaProd.indexOf(pr)).setFavorito(true);
			//listaProd.remove(pr); 
			fichero.actualizaLista(listaProd);
		}else {
			System.out.println("El producto elegido no existe");
			System.out.println("No se harán modificaciones en la lista");
		}
	}
	
	/**
	 * Mustra el contenio de la lista
	 */
	public void muestraLista() {
		for (Producto i : listaProd) {
			i.muestraProducto();
		}

	}//muestraLista

}

