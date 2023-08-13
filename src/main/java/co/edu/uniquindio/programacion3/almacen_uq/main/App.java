package co.edu.uniquindio.programacion3.almacen_uq.main;

import co.edu.uniquindio.programacion3.almacen_uq.constantes.MensajeExcepcion;
import co.edu.uniquindio.programacion3.almacen_uq.constantes.MensajeInformativo;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public Persistencia persistencia = new Persistencia();
    public MensajeExcepcion mensajeExcepcion = new MensajeExcepcion();
    public MensajeInformativo mensajeInformativo = new MensajeInformativo();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
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
            newStage.setTitle("Almacen UQ | Inicio");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());
        }
    }

    public void cargarVentanaClientes() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("clientes-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            newStage.setTitle("Almacen UQ | Gestor de Clientes");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            persistencia.guardarArchivoLog(mensajeInformativo.INFORMACION_CARGAR_VENTANA, 1, "Cargar Ventana Login");

        } catch (Exception e) {
            e.printStackTrace();
            persistencia.guardarArchivoLog(mensajeExcepcion.ERROR_CARGAR_VENTANA, 3,
                    "Cargar Ventana Login" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}