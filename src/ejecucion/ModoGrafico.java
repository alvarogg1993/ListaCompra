/**
 * 
 */
package ejecucion;
import java.io.File;

import compras.ListaDeLaCompra;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * @author Álvaro García
 * @author Daniel Hernando
 *
 */
public class ModoGrafico extends Application{

	private Stage primaryStage = null;
	private Stage secondaryStage = null;
	private ListaDeLaCompra listaFinal;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle ("Lista de la Compra");
		this.primaryStage.setScene (setupMainScene ());//crea ventana principal
		this.primaryStage.show ();
	}//start

	/**
	 * Crea la ventana principal
	 * @return mainScene
	 */
	private Scene setupMainScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (10.0);
		HBox espacio2= new HBox ();
		HBox espacio3= new HBox ();
			
		Label titulo = new Label (" Lista de la Compra  ");
		Label textoNombList = new Label ("Nombre Lista  ");
		TextField nombreLista=new TextField("Lista");
		nombreLista.setPrefWidth (120.0);
		nombreLista.setAlignment(Pos.CENTER);
		Button comprar = new Button ("Comprar");
		comprar.setAlignment(Pos.CENTER);
		comprar.setPrefWidth(100.0);
		//accion de cada boton
		comprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	listaFinal = new ListaDeLaCompra(nombreLista.getText());
            	//nueva ventana
            	secondaryStage = new Stage();
            	secondaryStage.setScene (setupSubScene ());//crea ventana principal
        		secondaryStage.show ();
            }
        });
		
		Button borrar = new Button ("Borrar");
		borrar.setAlignment(Pos.CENTER);
		borrar.setPrefWidth(100.0);
		//accion de cada boton
		borrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	File fichero = new File(nombreLista.getText());
                if (fichero.delete()){
                    System.out.println("El fichero ha sido borrado satisfactoriamente");
                }else {
                    System.out.println("El fichero no puede ser borrado");
                }
            }
        });
		
		Button salir = new Button ("Salir");
		salir.setAlignment(Pos.CENTER);
		//accion de cada boton
		salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.close();
            	if(secondaryStage!=null) {
            		secondaryStage.close();
            	}
            }
        });
		 
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (textoNombList,nombreLista);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (comprar,borrar);
		espacio2.setPadding(new Insets(0,0,0,15));
		espacio3.getChildren ().addAll (salir);
		espacio3.setPadding(new Insets(0,0,0,170));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3);
		Scene scene = new Scene (root, 250, 170);
		return scene;
	}//mainscene
	
	/**
	 * Crea ventana secudaria de compra
	 * @return secondaryScene
	 */
	private Scene setupSubScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (17.0);
		HBox espacio2= new HBox ();
		espacio2.setSpacing (12.0);
		HBox espacio3= new HBox ();
		espacio3.setSpacing (30.0);
		HBox espacio4 = new HBox ();
		espacio4.setSpacing (47.0);
		HBox espacio5= new HBox ();
		espacio5.setSpacing (45.0);
		HBox espacio6= new HBox ();
		espacio6.setSpacing (90.0);
		
		Label titulo = new Label (" Menú Compra  ");
		Label agregarT = new Label (" -. Agregar Producto ");
		Button agregar = new Button ("Agregar");
		agregar.setAlignment(Pos.CENTER);
		agregar.setPrefWidth(100.0);
		//accion de cada boton
		agregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//nueva ventana
            }
        });
		Label actualizarT = new Label (" -. Actualizar Producto");
		Button actualizar = new Button ("Actualizar");
		actualizar.setAlignment(Pos.CENTER);
		actualizar.setPrefWidth(100.0);
		//accion de cada boton
		actualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//nueva ventana
            }
        });
		Label borrarT = new Label (" -. Borrar Producto");
		Button borrar = new Button ("Borrar");
		borrar.setAlignment(Pos.CENTER);
		borrar.setPrefWidth(100.0);
		//accion de cada boton
		borrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//nueva ventana
            }
        });
		Label limpiarT = new Label (" -. Limpiar Lista");
		Button limpiar = new Button ("Limpiar");
		limpiar.setAlignment(Pos.CENTER);
		limpiar.setPrefWidth(100.0);
		//accion de cada boton
		limpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//listaFinal.limpiaLista();
            	//aviso de borrado
            }
        });
		Label mostrarT = new Label (" -. Mostrar Lista");
		Button mostrar = new Button ("Mostrar");
		mostrar.setAlignment(Pos.CENTER);
		mostrar.setPrefWidth(100.0);
		//accion de cada boton
		mostrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//nueva ventana
            }
        });
		Label salirT = new Label (" -. Salir");
		Button salir = new Button ("Salir");
		salir.setAlignment(Pos.CENTER);
		salir.setPrefWidth(100.0);
		//accion de cada boton
		salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	secondaryStage.close();
            }
        });
		 
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (agregarT,agregar);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (actualizarT,actualizar);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (borrarT,borrar);
		espacio3.setPadding(new Insets(0,0,0,10));
		espacio4.getChildren ().addAll (limpiarT,limpiar);
		espacio4.setPadding(new Insets(0,0,0,10));
		espacio5.getChildren ().addAll (mostrarT,mostrar);
		espacio5.setPadding(new Insets(0,0,0,10));
		espacio6.getChildren ().addAll (salirT,salir);
		espacio6.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3,espacio4,espacio5,espacio6);
		Scene scene = new Scene (root, 280, 270);
		return scene;
	}//subscene
	
	public static void main (String[] args) {
		launch (args);
	}
}
