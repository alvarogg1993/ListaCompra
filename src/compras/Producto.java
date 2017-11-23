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
	 * Si el producto ha sido comprado o no
	 */
	private boolean favorito;
	
	/**
	 * Constructor de producto
	 * 
	 * @param nombre
	 * @param cantidad
	 * @param comprado
	 */
	public Producto(String nombre,int cantidad,boolean comprado,boolean favorito){
		//this.id = id;
		this.nombre = nombre;
		this.cantidad=cantidad;
		this.comprado = comprado;
		this.favorito = favorito;
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
	 * Set favorito
	 * @param f
	 */
	public void setFavorito(Boolean f){
		this.favorito = f;
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
	 * Get comprado
	 * @return comprado
	 */
	public boolean getComprado(){
		return this.comprado;
	}
	
	/**
	 * Get favorito
	 * @return favorito
	 */
	public boolean getFavorito(){
		return this.favorito;
	}
	
	/**
	 * Mostrar producto
	 */
	public void muestraProducto(){
		System.out.println(" .  Producto: " +this.nombre+ " .  Cantidad: " + this.cantidad+  " .  Comprado: "+this.comprado+  " .  Favorito: "+this.favorito  );
	}
}
//clase Producto
