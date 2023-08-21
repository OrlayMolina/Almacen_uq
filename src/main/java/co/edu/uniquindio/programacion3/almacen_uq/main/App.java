package co.edu.uniquindio.programacion3.almacen_uq.main;

import co.edu.uniquindio.programacion3.almacen_uq.constantes.MensajeExcepcion;
import co.edu.uniquindio.programacion3.almacen_uq.constantes.MensajeInformativo;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class App extends Application {

    public Persistencia persistencia = new Persistencia();
    public MensajeExcepcion mensajeExcepcion = new MensajeExcepcion();
    public MensajeInformativo mensajeInformativo = new MensajeInformativo();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
        stage.getIcons().add(iconImage);
        stage.setTitle("Almacen UQ | Inicio");
        stage.setScene(scene);
        stage.show();
    }

    public void cargarVentanaInicio() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Inicio");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public void cargarVentanaClientes() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("clientes-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Gestor de Clientes Naturales");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public void cargarVentanaClientesJuridicos() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("clientes-juridicos-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Gestor de Clientes Juridicos");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public void cargarVentanaProductosInicio() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio-productos-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Menú Productos");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public void cargarVentanaProductosEnvasados() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("envasados-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Menú Productos Envasados");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }
    //metodo para la carga de la ventana de productos refrigerados modificado por ramirodeveloper
    public void cargarVentanaProductosRefrigerados() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("refrigerados-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Menú Productos Refrigerados");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana refrigerados-view");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public void cargarVentanaVentas() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ventas-detalles-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Menú Ventas");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public void cargarVentanaPerecederos() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("perecederos-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            Image iconImage = new Image("file:///C:/Users/Orlay.molina/programacion3/almacen/src/main/resources/co/edu/uniquindio/programacion3/almacen_uq/main/img/logo.PNG");
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Almacen UQ | Menú Productos Perecederos");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            //persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            /*persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());*/
        }
    }

    public static void main(String[] args) {
        launch();
    }
}