/**
 * 
 */
package persistencia;

import java.util.ArrayList;

import compras.Producto;

/**
 *  @author Alvaro Garcia
 *  @author Daniel Hernando
 *
 */
public interface Persistencia {
	public void abrir();
	public void leerProductos(ArrayList<Producto> listaProd);
	public void addALista(Producto p,ArrayList<Producto> listaProd);
	public void actualizaLista(ArrayList<Producto> listaProd);
	public void cerrar();

}
