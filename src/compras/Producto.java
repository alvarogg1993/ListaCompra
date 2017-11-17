/**
 * 
 */
package compras;


/**
 * @author Alvaro Garcia
 * @author Daniel Hernando
 *
 */
public class Producto{
	
	//private int id;
	/**
	 * Nombre con el que se identifica el producto
	 */
	private String nombre;
	/**
	 * Cantidad que se va a comprar de dicho producto
	 */
	private int cantidad;
	/**
	 * Si el producto ha sido comprado o no
	 */
	private boolean comprado;
	
	/**
	 * Constructor de producto
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param comprado
	 */
	public Producto(String nombre,int cantidad,boolean comprado){
		//this.id = id;
		this.nombre = nombre;
		this.cantidad=cantidad;
		this.comprado = comprado;
	}
	
	/**
	 * Set Cantidad
	 * @param c
	 */
	public void setCantidad(int c){
		this.cantidad = c;
	}

	/**
	 * Set nombre
	 * @param n
	 */
	public void setNombre(String n){
		this.nombre = n;
	}
	
	/**
	 * Set comprado
	 * @param c
	 */
	public void setComprado(Boolean c){
		this.comprado = c;
	}

	/**
	 * Get cantidad
	 * @return cantidad
	 */
	public int getCantidad(){
		return this.cantidad;
	}
	
	/**
	 * Get nombre
	 * @return nombre
	 */
	public String getNombre(){
		return this.nombre ;
	}
	
	/**
	 * Gent comprado
	 * @return comprado
	 */
	public boolean getComprado(){
		return this.comprado;
	}
	
	/**
	 * Mostrar producto
	 */
	public void muestraProducto(){
		System.out.println(".  Producto: " +this.nombre+ ".  Cantidad: " + this.cantidad+  ".  Comprado: "+this.comprado  );
	}
}
//clase Producto
