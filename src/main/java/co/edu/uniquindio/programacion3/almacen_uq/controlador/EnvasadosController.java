package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EnvasadosController {

    App app = new App();

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<Pais> cmbPais;

    @FXML
    private DatePicker dataFechaEnvase;

    @FXML
    private TextArea txaDescripcion;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPesoEnvase;

    @FXML
    private TextField txtValorUnitario;


    @FXML
    void menuInicioProductos(ActionEvent event) {
        cerrarVentana(btnAtras);
        app.cargarVentanaProductosInicio();
    }

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

    public void guardarNuevoEnvasado(){
        ProductoEnvasado envasado;
        ProductoEnvasado envasadoTemporal;

        String codigo = txtCodigo.getText();
        String nombreProducto = txtNombreProducto.getText();
        String descripcion = txaDescripcion.getText();
        int valorUnitario = Integer.parseInt(txtValorUnitario.getText());

    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
