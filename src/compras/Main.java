/**
 * 
 */
package compras;

import java.io.File;

/**
 * @author Álvaro García
 * @author Daniel Hernando
 *
 */

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Álvaro García
 * @author Daniel Hernando
 *
 */
public class Main {

    private static Scanner sn;

    public static void main(String[] args) throws FileNotFoundException {

        int entradaTeclado = 0;
        boolean salir = false;
        sn = new Scanner(System.in);

        while (!salir) {
        	
            System.out.println("        Lista De La Compra        ");
            System.out.println("1_Hacer la compra     ");
            System.out.println("2_Borrar lista de la compra    ");
            System.out.println("3_Salir        ");

            try {

                System.out.println("        Escribe una de las opciones        ");
                entradaTeclado = sn.nextInt();

                switch (entradaTeclado) {
                case 1:
                    System.out.println("Hacer la compra");
                    System.out.println("Por favor introduzca nombre fichero (ejemplo o ejemlpo.txt):");
                    System.out.println("Si el fichero no exixte, se creará uno nuevo");
                    
                    //Declaracion de Variables
                    String nombreFichero = "";
                    nombreFichero = sn.next();
                    ListaDeLaCompra listaFinal = new ListaDeLaCompra(nombreFichero);// listaFinal.muestraLista();
                    int entradaTeclado2 = 0;
                    boolean salir2 = false;

                    while (!salir2) {

                        System.out.println("        Menu de la Lista        ");
                        System.out.println("1_Agregar un producto     ");
                        System.out.println("2_Actualizar un producto    ");
                        System.out.println("3_Borrar un producto    ");
                        System.out.println("4_Limpiar lista (Quitar los productos comprados)    ");
                        System.out.println("5_Ver lista    ");
                        System.out.println("6_Salir        ");
                        //Declaración de Variables
                        String nombreProd = "";
                        int cantidad=0;
                        
                        try {

                            System.out.println("        Escribe una de las opciones        ");
                            entradaTeclado2 = sn.nextInt();

                            switch (entradaTeclado2) {
                            case 1:
                                System.out.println("Agregar un producto");
                                System.out.println("Para agregar producto debes poner la unidad de media (u,kg,bolsa,etc)");
                                System.out.println("Si el nombre del producto ya existe, se sumará la cantidad que añadas a continuación");
                                System.out.println("        Escribe el nombre del producto (Ej: Naranjas-u- || Naranjas-kg- )        ");
                                nombreProd = sn.next();
                                System.out.println("		Para continuar añade la cantidad que necesita");
                                System.out.println("        Escribe la cantidad        ");
                                cantidad = sn.nextInt();
                                listaFinal.addProducto(nombreProd, cantidad);
                                //mostrar la lista con el producto añadido
                                listaFinal.muestraLista();
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Actualizar un producto");
                                //Declaración de Variables
                                int entradaTeclado3 = 0;
                                boolean salir3 = false;
                                
                                while (!salir3) {

                                    System.out.println("        Menu para modificar productos        ");
                                    System.out.println("1_Modificar nombre     ");
                                    System.out.println("2_Modificar cantidad    ");
                                    System.out.println("3_Marcar producto como comprado    ");
                                    System.out.println("4_Salir        ");

                                    try {

                                        System.out.println("        Escribe una de las opciones        ");
                                        entradaTeclado3 = sn.nextInt();
                                        //Declaración de variables
                                        String nombreProdA = "";
                                        String nombreProdN = "";
                                        switch (entradaTeclado3) {
                                        case 1:
                                            System.out.println("Modificar Nombre");
                                            System.out.println("Para modificar el nombre de un producto debes escribir primero el nombre antiguo y a continuación el nuevo");
                                            System.out.println("Si el nombre del producto existe, se cambiará el nomre");
                                            // mostrar lista
                                            System.out.println("Su Lista:");
                                            listaFinal.muestraLista();
                                            System.out.println("");
                                            System.out.println("        Escribe el nombre actual producto        ");
                                            nombreProdA = sn.next();
                                            System.out.println("		Ahora el nombre que desea dar al producto		");
                                            nombreProdN = sn.next();
                                            //Cambiar nombre
                                            listaFinal.cambiaNombreProd(nombreProdA, nombreProdN);
                                            break;
                                        case 2:
                                            System.out.println("Modificar cantidad");
                                            System.out.println("Para modificar la cantidad indique el nombre del producto");
                                            //System.out.println("Si el producto no existe"); ¿Crear nuevo producto?
                                            //mostrar lista
                                            System.out.println("Su Lista:");
                                            listaFinal.muestraLista();
                                            System.out.println("");
                                            System.out.println("        Escribe el nombre actual producto        ");
                                            nombreProd = sn.next();
                                            System.out.println("		Para continuar añade la cantidad que necesita");
                                            System.out.println("        Escribe la cantidad        ");
                                            cantidad = sn.nextInt();
                                            listaFinal.cambiaCantidadProducto(nombreProd, cantidad);
                                            break;
                                        case 3:
                                            System.out.println("Comprar");
                                            System.out.println("Su Lista:");
                                            listaFinal.muestraLista();
                                            System.out.println("");
                                            System.out.println("Indique el nombre del producto que desa comprar");
                                            nombreProd = sn.next();
                                            listaFinal.comprarProducto(nombreProd);
                                            break;
                                        case 4:
                                            salir3 = true;
                                            break;
                                        default:
                                            System.out.println("Solo números entre 1 y 4");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out
                                                .println("Debes insertar un número");
                                        sn.next();
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("Borrar un producto");
                                System.out.println("Para borrar un producto debes poner el nombre correcto del producto");
                                //mostrar lista
                                System.out.println("Su Lista:");
                                listaFinal.muestraLista();
                                System.out.println("");
                                System.out.println("        Escribe el nombre del producto sin espacios (Ej: Naranjas-u- || Naranjas-kg- )        ");
                                nombreProd = sn.next();
                                listaFinal.delProducto(nombreProd);
                                break;
                            case 4:
                            	System.out.println("Limpiar Lista");
                            	System.out.println("Se borrarán de la lista los productos que estén marcados como comprados");
                            	listaFinal.limpiaLista();
                            	System.out.println("La lista ha sido limpiada");
                                break;
                            case 5:
                            	System.out.println("Su Lista:");
                                listaFinal.muestraLista();
                                System.out.println("");
                                break;    
                            case 6:
                                salir2 = true;
                                break;
                            default:
                                System.out.println("Solo números entre 1 y 6");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            sn.next();
                        }
                    }

                    break;
                case 2:
                    System.out.println("Borrar Lista de la Compra");
                    System.out.println("Por favor introduzca nombre fichero (ejemplo o ejemlpo.txt):");                    
                    nombreFichero = sn.next(); 
                    File fichero = new File(nombreFichero);
                    if (fichero.delete())
                        System.out.println("El fichero ha sido borrado satisfactoriamente");
                     else
                        System.out.println("El fichero no puede ser borrado");
                    break;

                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

	}//main
}//class

