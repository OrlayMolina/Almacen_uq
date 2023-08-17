package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class InicioController {

    public App app = new App();

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnClientesJuridicos;

    @FXML
    private Button btnProductos;

    @FXML
    private Button btnVentas;

    @FXML
    private Button btnSalir;

    @FXML
    void menuClientes(ActionEvent event) throws IOException {
        app.cargarVentanaClientes();
        cerrarVentana(btnClientes);
    }

    @FXML
    void menuClienteJuridico(ActionEvent event) {
        cerrarVentana(btnClientesJuridicos);
        app.cargarVentanaClientesJuridicos();
    }

    @FXML
    void menuProductos(ActionEvent event) {

    }

    @FXML
    void menuVentas(ActionEvent event) {

    }

    @FXML
    void salirAplicacion(ActionEvent event) {
        System.exit(0);
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
