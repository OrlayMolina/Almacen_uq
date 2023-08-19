package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VentasController {

    App app = new App();

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnSalir;

    @FXML
    void actualizarCliente(ActionEvent event) {

    }

    @FXML
    void crearCliente(ActionEvent event) {

    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }

    @FXML
    void limpiarCampo(ActionEvent event) {

    }

    @FXML
    void menuInicio(ActionEvent event) {
        cerrarVentana(btnSalir);
        app.cargarVentanaInicio();
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
