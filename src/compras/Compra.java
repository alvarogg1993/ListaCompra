/**
 * 
 */
package compras;

/**
 *  @author Alvaro Garcia
 *  @author Daniel Hernando
 *
 */
public interface Compra {

	public void addProducto(String nombreProd, int cantidad);
	public void delProducto(String nombreProd);
	public Producto getProducto(String nombreProd);
	public void cambiaNombreProd(String nombreProdA,String nombreProdN);
	public void cambiaCantidadProducto(String nombreProd, int c);
	public void limpiaLista();
	public void comprarProducto(String nombreProd);
	public void marcarFavorito(String nombreProd);
	
}
