package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioProductosController {

    App app = new App();

    @FXML
    private Button btnEnvasados;

    @FXML
    private Button btnPerecederos;

    @FXML
    private Button btnRefrigerados;

    @FXML
    private Button btnSalir;

    @FXML
    void menuEnvasados(ActionEvent event) {
        cerrarVentana(btnEnvasados);
        app.cargarVentanaProductosEnvasados();
    }

    @FXML
    void menuPerecederos(ActionEvent event) {
        cerrarVentana(btnPerecederos);
        app.cargarVentanaPerecederos();

    }
    @FXML
    void menuRefrigerados(ActionEvent event) {
        cerrarVentana(btnRefrigerados);
        app.cargarVentanaProductosRefrigerados();

    }

    @FXML
    void clickSalir(ActionEvent event) {
        cerrarVentana(btnSalir);
        app.cargarVentanaInicio();
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
