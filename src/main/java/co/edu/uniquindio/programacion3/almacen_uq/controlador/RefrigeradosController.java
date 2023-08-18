package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RefrigeradosController {

    App app = new App();

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAtras;

    @FXML
    private AnchorPane btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    void actualizarRefrigerado(ActionEvent event) {

    }

    @FXML
    void eliminarRefrigerado(ActionEvent event) {

    }

    @FXML
    void limpiarCampo(ActionEvent event) {

    }

    @FXML
    void menuInicioProductos(ActionEvent event) {
        cerrarVentana(btnAtras);
        app.cargarVentanaProductosInicio();

    }
    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
