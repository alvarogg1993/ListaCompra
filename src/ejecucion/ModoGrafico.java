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
import javafx.scene.Scene;
import javafx.scene.control.*;
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
	private Stage addProdStage = null;
	private Stage modProdStage = null;
	private Stage delProdStage = null;
	private Stage cleanListStage = null;
	private Stage showListStage = null;
	private Stage chgNameStage = null;
	private Stage chgNumbStage = null;
	private Stage chgBuyStage = null;
	private Stage chgFavStage = null;
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
		espacio2.setSpacing (6.0);
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
		salir.setPrefWidth(100.0);
		salir.setAlignment(Pos.CENTER);
		//accion de cada boton
		salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.close();
            }
        });
		 
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (textoNombList,nombreLista);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (comprar,borrar);
		espacio2.setPadding(new Insets(0,0,0,15));
		espacio3.getChildren ().addAll (salir);
		espacio3.setPadding(new Insets(0,0,0,120));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3);
		Scene scene = new Scene (root, 250, 150);
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
            	addProdStage=new Stage();
            	addProdStage.setScene(setupAddProdScene());
            	addProdStage.show();
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
            	modProdStage=new Stage();
            	modProdStage.setScene(setupModProdScene());
            	modProdStage.show();
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
            	delProdStage=new Stage();
            	delProdStage.setScene(setupDelProdScene());
            	delProdStage.show();
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
            	cleanListStage=new Stage();
            	cleanListStage.setScene(setupCleanListScene());
            	cleanListStage.show();
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
            	showListStage=new Stage();
            	showListStage.setScene(setupShowListScene());
            	showListStage.show();
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
            	primaryStage.close();
            	secondaryStage.close();
            	if(addProdStage!=null) {
            		addProdStage.close();
            	}
            	if(delProdStage!=null) {
            		delProdStage.close();
            	}
            	if(modProdStage!=null) {
            		modProdStage.close();
            	}
            	if(cleanListStage!=null) {
            		cleanListStage.close();
            	}
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
	
	/**
	 * Crea ventana agregar producto
	 * @return addProdScene
	 */
	private Scene setupAddProdScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (55.0);
		HBox espacio2= new HBox ();
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setSpacing (10.0);
		
		Label titulo = new Label (" Agragar Producto  ");
		Label nombreT = new Label ("Nombre Producto ");
		Label cantidadT = new Label ("Cantidad ");
		TextField nombre=new TextField("Producto");
		nombre.setPrefWidth (140.0);
		nombre.setAlignment(Pos.CENTER);
		TextField cantidad=new TextField();
		cantidad.setPrefWidth (60.0);
		cantidad.setAlignment(Pos.CENTER);
		Button agregar = new Button ("Agregar");
		agregar.setAlignment(Pos.CENTER);
		agregar.setPrefWidth(100.0);
		//accion de cada boton
		agregar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
				listaFinal.addProducto(nombre.getText(), Integer.parseInt(cantidad.getText()));
				if(addProdStage!=null) {
            		addProdStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(addProdStage!=null) {
            		addProdStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT,cantidadT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (nombre,cantidad);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (agregar,cancelar);
		espacio3.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3);
		Scene scene = new Scene (root, 250, 150);
		return scene;
	}//addProdScene
	
	/**
	 * Crea ventana actualizar producto
	 * @return modProdScene
	 */
	private Scene setupModProdScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (46.0);
		HBox espacio2= new HBox ();
		espacio2.setSpacing (44.0);
		HBox espacio3= new HBox ();
		espacio3.setSpacing (34.0);
		HBox espacio4= new HBox ();
		espacio4.setSpacing (47.0);
		HBox espacio5= new HBox ();
		espacio5.setSpacing (10.0);
		
		Label titulo = new Label (" Actualizar Producto  ");
		Label nombreT = new Label ("Nombre ");
		Button nombreB = new Button ("Cambiar");
		nombreB.setAlignment(Pos.CENTER);
		nombreB.setPrefWidth(100.0);
		//accion de cada boton
		nombreB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	chgNameStage=new Stage();
            	chgNameStage.setScene(setupChgNameScene());
            	chgNameStage.show();
            }
        });
		Label cantidadT = new Label ("Cantidad ");
		Button cantidadB = new Button ("Cambiar");
		cantidadB.setAlignment(Pos.CENTER);
		cantidadB.setPrefWidth(100.0);
		//accion de cada boton
		cantidadB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Ventana cambiar cantidad
            	chgNumbStage=new Stage();
            	chgNumbStage.setScene(setupChgNumbScene());
            	chgNumbStage.show();
            }
        });
		Label comprarT = new Label ("Comprado ");
		Button comprarB = new Button ("Cambiar");
		comprarB.setAlignment(Pos.CENTER);
		comprarB.setPrefWidth(100.0);
		//accion de cada boton
		comprarB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Ventana cambiar comprado
            	chgBuyStage=new Stage();
            	chgBuyStage.setScene(setupChgBuyScene());
            	chgBuyStage.show();
            }
        });
		Label favoritoT = new Label ("Favorito ");
		//
		Button favoritoB = new Button ("Cambiar");
		favoritoB.setAlignment(Pos.CENTER);
		favoritoB.setPrefWidth(100.0);
		//accion de cada boton
		favoritoB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Ventana cambiar nombre
            	chgFavStage=new Stage();
            	chgFavStage.setScene(setupChgFavScene());
            	chgFavStage.show();
            }
        });
		
		Button cerrar = new Button ("Cerrar");
		cerrar.setAlignment(Pos.CENTER);
		cerrar.setPrefWidth(100.0);
		//accion de cada boton
		cerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(modProdStage!=null) {
            		modProdStage.close();
            	}
            }
        });
		
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT,nombreB);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (cantidadT,cantidadB);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (comprarT,comprarB);
		espacio3.setPadding(new Insets(0,0,0,10));
		espacio4.getChildren ().addAll (favoritoT,favoritoB);
		espacio4.setPadding(new Insets(0,0,0,10));
		espacio5.getChildren ().addAll (cerrar);
		espacio5.setPadding(new Insets(0,0,0,105));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3,espacio4,espacio5);
		Scene scene = new Scene (root, 250, 220);
		return scene;
	}//modProdScene
	
	/**
	 * Crea ventana cambiar nombre
	 * @return chgNameScene
	 */
	private Scene setupChgNameScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (10.0);
		espacio1.setAlignment(Pos.CENTER);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setAlignment(Pos.CENTER);
		espacio3.setSpacing (10.0);
		HBox espacio4= new HBox ();
		espacio4.setAlignment(Pos.CENTER);
		espacio4.setSpacing (10.0);
		HBox espacio5= new HBox ();
		espacio5.setAlignment(Pos.CENTER);
		espacio5.setSpacing (10.0);
		
		Label titulo = new Label (" Modificar Nombre  ");
		Label nombreAT = new Label ("Nombre Producto Actual");
		TextField nombreA=new TextField();
		nombreA.setPrefWidth (140.0);
		nombreA.setAlignment(Pos.CENTER);
		Label nombreNT = new Label ("Nombre Producto Nuevo ");	
		TextField nombreN=new TextField();
		nombreN.setPrefWidth (140.0);
		nombreN.setAlignment(Pos.CENTER);
		Button cambiar = new Button ("Cambiar");
		cambiar.setAlignment(Pos.CENTER);
		cambiar.setPrefWidth(100.0);
		//accion de cada boton
		cambiar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
                listaFinal.cambiaNombreProd(nombreA.getText(), nombreN.getText());
				if(chgNameStage!=null) {
					chgNameStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(chgNameStage!=null) {
            		chgNameStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreAT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (nombreA);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (nombreNT);
		espacio3.setPadding(new Insets(0,0,0,10));
		espacio4.getChildren ().addAll (nombreN);
		espacio4.setPadding(new Insets(0,0,0,10));
		espacio5.getChildren ().addAll (cambiar,cancelar);
		espacio5.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3,espacio4,espacio5);
		Scene scene = new Scene (root, 220, 230);
		return scene;
	}//chgNameScene
	
	/**
	 * Crea ventana cambiar cantidad
	 * @return chgNumbScene
	 */
	private Scene setupChgNumbScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (10.0);
		espacio1.setAlignment(Pos.CENTER);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setAlignment(Pos.CENTER);
		espacio3.setSpacing (10.0);
		HBox espacio4= new HBox ();
		espacio4.setAlignment(Pos.CENTER);
		espacio4.setSpacing (10.0);
		HBox espacio5= new HBox ();
		espacio5.setAlignment(Pos.CENTER);
		espacio5.setSpacing (10.0);
		
		Label titulo = new Label (" Modificar Cantidad  ");
		Label nombreT = new Label ("Nombre Producto");
		TextField nombre=new TextField();
		nombre.setPrefWidth (140.0);
		nombre.setAlignment(Pos.CENTER);
		Label cantidadT = new Label ("Cantidad Nueva ");	
		TextField cantidad=new TextField();
		cantidad.setPrefWidth (140.0);
		cantidad.setAlignment(Pos.CENTER);
		Button cambiar = new Button ("Cambiar");
		cambiar.setAlignment(Pos.CENTER);
		cambiar.setPrefWidth(100.0);
		//accion de cada boton
		cambiar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
                listaFinal.cambiaCantidadProducto(nombre.getText(), Integer.parseInt(cantidad.getText()));
				if(chgNumbStage!=null) {
					chgNumbStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(chgNumbStage!=null) {
            		chgNumbStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (nombre);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (cantidadT);
		espacio3.setPadding(new Insets(0,0,0,10));
		espacio4.getChildren ().addAll (cantidad);
		espacio4.setPadding(new Insets(0,0,0,10));
		espacio5.getChildren ().addAll (cambiar,cancelar);
		espacio5.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3,espacio4,espacio5);
		Scene scene = new Scene (root, 220, 200);
		return scene;
	}//chgNumbScene
	
	/**
	 * Crea ventana cambiar comprado
	 * @return chgBuyScene
	 */
	private Scene setupChgBuyScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (10.0);
		espacio1.setAlignment(Pos.CENTER);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setAlignment(Pos.CENTER);
		espacio3.setSpacing (10.0);
		HBox espacio4= new HBox ();
		espacio4.setAlignment(Pos.CENTER);
		espacio4.setSpacing (10.0);
		
		Label titulo = new Label (" Modificar Comprado  ");
		Label nombreT = new Label ("Nombre Producto");
		TextField nombre=new TextField();
		nombre.setPrefWidth (140.0);
		nombre.setAlignment(Pos.CENTER);
		Label avisoT = new Label ("Si está marcado comprado,\n se desmarcará ");	
		Button cambiar = new Button ("Cambiar");
		cambiar.setAlignment(Pos.CENTER);
		cambiar.setPrefWidth(100.0);
		//accion de cada boton
		cambiar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
                listaFinal.comprarProducto(nombre.getText());
				if(chgBuyStage!=null) {
					chgBuyStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(chgBuyStage!=null) {
            		chgBuyStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (nombre);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (avisoT);
		espacio3.setPadding(new Insets(0,0,0,10));
		espacio4.getChildren ().addAll (cambiar,cancelar);
		espacio4.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3,espacio4);
		Scene scene = new Scene (root, 220, 180);
		return scene;
	}//chgBuyScene

	/**
	 * Crea ventana cambiar favorito 
	 * @return chgFavScene
	 */
	private Scene setupChgFavScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setSpacing (10.0);
		espacio1.setAlignment(Pos.CENTER);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setAlignment(Pos.CENTER);
		espacio3.setSpacing (10.0);
		HBox espacio4= new HBox ();
		espacio4.setAlignment(Pos.CENTER);
		espacio4.setSpacing (10.0);
		
		Label titulo = new Label (" Modificar Favorito  ");
		Label nombreT = new Label ("Nombre Producto");
		TextField nombre=new TextField();
		nombre.setPrefWidth (140.0);
		nombre.setAlignment(Pos.CENTER);
		Label avisoT = new Label ("Si está marcado comprado,\n se desmarcará ");
		Button cambiar = new Button ("Cambiar");
		cambiar.setAlignment(Pos.CENTER);
		cambiar.setPrefWidth(100.0);
		//accion de cada boton
		cambiar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
                listaFinal.marcarFavorito(nombre.getText());
				if(chgFavStage!=null) {
					chgFavStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(chgFavStage!=null) {
            		chgFavStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (nombre);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (avisoT);
		espacio3.setPadding(new Insets(0,0,0,10));
		espacio4.getChildren ().addAll (cambiar,cancelar);
		espacio4.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3,espacio4);
		Scene scene = new Scene (root, 220, 180);
		return scene;
	}//chgFavScene
	
	
	/**
	 * Crea ventana borrar producto
	 * @return delProdScene
	 */
	private Scene setupDelProdScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setAlignment(Pos.CENTER);
		espacio1.setSpacing (55.0);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setSpacing (10.0);
		
		Label titulo = new Label (" Borrar Producto  ");
		Label nombreT = new Label ("Nombre Producto");
		TextField nombre=new TextField("Producto");
		nombre.setPrefWidth (140.0);
		nombre.setAlignment(Pos.CENTER);
		Button borrar = new Button ("Borrar");
		borrar.setAlignment(Pos.CENTER);
		borrar.setPrefWidth(100.0);
		//accion de cada boton
		borrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
				listaFinal.delProducto(nombre.getText());
				if(delProdStage!=null) {
            		delProdStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(delProdStage!=null) {
            		delProdStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (nombre);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (borrar,cancelar);
		espacio3.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3);
		Scene scene = new Scene (root, 250, 150);
		return scene;
	}//delProdScene
	
	/**
	 * Crea ventana limpiar lista
	 * @return cleanListScene
	 */
	private Scene setupShowListScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setAlignment(Pos.CENTER);
		espacio1.setSpacing (5.0);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setSpacing (10.0);
		
		Label titulo = new Label (" Mostrar Lista  ");
		//mostrar elementos lista
		Label nombreT = new Label (" Nombre ");
		nombreT.setAlignment(Pos.CENTER);
		Label cantidadT = new Label (" Cantidad ");
		cantidadT.setAlignment(Pos.CENTER);
		Label compradoT = new Label (" Comprado ");
		compradoT.setAlignment(Pos.CENTER);
		Label favT = new Label (" Favorito ");
		favT.setAlignment(Pos.CENTER);
		Label listaT = new Label (listaFinal.toString());
		
		String[] prod=listaFinal.toString().split("\n");
		/*
		for(String lp : prod) {
			Label listaT = new Label (lp);
			espacio2.getChildren ().addAll (listaT);
		}
		*/
		Button cerrar = new Button ("Cerrar");
		cerrar.setAlignment(Pos.CENTER);
		cerrar.setPrefWidth(100.0);
		//accion de cada boton
		cerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(showListStage!=null) {
            		showListStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (nombreT,cantidadT,compradoT,favT);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (listaT);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (cerrar);
		espacio3.setPadding(new Insets(0,0,0,150));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3);
		Scene scene = new Scene (root, 270, (100+30*prod.length));
		return scene;
	}//showListScene
	
	/**
	 * Crea ventana limpiar lista
	 * @return cleanListScene
	 */
	private Scene setupCleanListScene(){
		VBox root = new VBox ();
		root.setSpacing (10.0);
		root.setPadding (new Insets (10.0, 10.0, 10.0, 10.0));
		HBox espTitulo = new HBox ();
		espTitulo.setAlignment(Pos.CENTER);
		HBox espacio1 = new HBox ();
		espacio1.setAlignment(Pos.CENTER);
		espacio1.setSpacing (10.0);
		HBox espacio2= new HBox ();
		espacio2.setAlignment(Pos.CENTER);
		espacio2.setSpacing (10.0);
		HBox espacio3= new HBox ();
		espacio3.setSpacing (10.0);
		
		Label titulo = new Label (" Limpiar Lista  ");
		Label aviso1T = new Label ("Se van a borrar los productos comprados");
		aviso1T.setAlignment(Pos.CENTER);
		Label aviso2T = new Label ("Los productos favoritos no se borran");
		aviso2T.setAlignment(Pos.CENTER);
		Button limpiar = new Button ("Limpiar");
		limpiar.setAlignment(Pos.CENTER);
		limpiar.setPrefWidth(100.0);
		//accion de cada boton
		limpiar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent event) {
				listaFinal.limpiaLista();
				if(cleanListStage!=null) {
            		cleanListStage.close();
            	}
		    }
		});
		Button cancelar = new Button ("Cancelar");
		cancelar.setAlignment(Pos.CENTER);
		cancelar.setPrefWidth(100.0);
		//accion de cada boton
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(cleanListStage!=null) {
            		cleanListStage.close();
            	}
            }
        });
		espTitulo.getChildren ().addAll (titulo);
		espacio1.getChildren ().addAll (aviso1T);
		espacio1.setPadding(new Insets(0,0,0,10));
		espacio2.getChildren ().addAll (aviso2T);
		espacio2.setPadding(new Insets(0,0,0,10));
		espacio3.getChildren ().addAll (limpiar,cancelar);
		espacio3.setPadding(new Insets(0,0,0,10));
		root.getChildren ().addAll (espTitulo,espacio1,espacio2,espacio3);
		Scene scene = new Scene (root, 250, 150);
		return scene;
	}//cleanListScene
	
	public static void main (String[] args) {
		launch (args);
	}
	
}//ModoGrafico
