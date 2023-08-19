package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.EnvasadoSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EnvasadosController {


    App app = new App();
    EnvasadoSubController envasadoSubController  = new EnvasadoSubController();
    private final ObservableList<ProductoEnvasado> listaProductosEnvasados = FXCollections.observableArrayList();

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
    private TextField txtExistencias;

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
        //
    }

    public void guardarNuevoEnvasado(){
        ProductoEnvasado envasado;
        ProductoEnvasado envasadoTemporal = new ProductoEnvasado();

        String codigo = txtCodigo.getText();
        String nombreProducto = txtNombreProducto.getText();
        String descripcion = txaDescripcion.getText();
        Double valorUnitario = Double.valueOf(txtValorUnitario.getText());
        int existencias = Integer.parseInt(txtExistencias.getText());
        LocalDate fechaEvasado = dataFechaEnvase.getValue();
        String pesoEnvase = txtPesoEnvase.getText();
        Pais pais = cmbPais.getSelectionModel().getSelectedItem();

        envasadoTemporal.setCodigo(codigo);
        envasadoTemporal.setNombreProducto(nombreProducto);
        envasadoTemporal.setDescripcion(descripcion);
        envasadoTemporal.setValorUnitario(valorUnitario);
        envasadoTemporal.setExistencias(existencias);
        envasadoTemporal.setFechaEnvasado(fechaEvasado);
        envasadoTemporal.setPesoEnvase(pesoEnvase);
        envasadoTemporal.setPais(pais);

        envasado = envasadoSubController.crearProductoEnvasado(envasadoTemporal);

        if(envasado != null){
            listaProductosEnvasados .add(envasado);
            //tableClientes.refresh();
            // mensaje de confirmacion
            //persistencia.guardarArchivoLog("Se guardado un cliente correctamente", 1, "La acción se ejecuto desde el método guardarClienteNatural de ClientesController.");

        }

    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
