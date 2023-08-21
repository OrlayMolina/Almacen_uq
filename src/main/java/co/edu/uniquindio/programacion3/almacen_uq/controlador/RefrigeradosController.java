package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;

import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoRefrigerado;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;

import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.RefrigeradosSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RefrigeradosController {
    App app = new App();

    private final ObservableList<ProductoRefrigerado> listaProductosRefrigerados = FXCollections.observableArrayList();

    private ProductoRefrigerado productoRefrigerado;
    private RefrigeradosSubController refrigeradosSubController;
    private Persistencia persistencia = new Persistencia();

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
    private TableColumn<ProductoRefrigerado,String> colCodigo;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colCodigoAprobacion;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colDescripcion;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colNombre;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colTemperaturaRefrigeracion;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colValorUnitario;

    @FXML
    private TableView<ProductoRefrigerado> tableProdRefrigerado;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCodigoAprobacion;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtExistencias;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTemperaturaRefrigeracion;

    @FXML
    private TextField txtValorUnitario;

    @FXML
    void actualizarRefrigerado(ActionEvent event) {

    }

    @FXML
    void eliminarRefrigerado(ActionEvent event) {

    }



    public void guardarNuevoProductoRefrigerado(){

        ProductoRefrigerado refrigerado;
        ProductoRefrigerado refrigeradoTemporal = new ProductoRefrigerado();

        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double valorUnitario = Double.parseDouble(txtValorUnitario.getText());
        String codigoHabilitacion = txtCodigoAprobacion.getText();
        String temperaturaRefrigeracion = txtTemperaturaRefrigeracion.getText();
        int existencias = Integer.parseInt(txtExistencias.getText());
        String descripcion = txtDescripcion.getText();

        refrigeradoTemporal.setCodigo(codigo);
        refrigeradoTemporal.setNombreProducto(nombre);
        refrigeradoTemporal.setValorUnitario(valorUnitario);
        refrigeradoTemporal.setCodigoAprobacion(codigoHabilitacion);
        refrigeradoTemporal.setTemRefrigeracion(temperaturaRefrigeracion);
        refrigeradoTemporal.setExistencias(existencias);
        refrigeradoTemporal.setDescripcion(descripcion);

        //refrigerado = RefrigeradosSubController.crearProductoRefrigerado(refrigeradoTemporal);
/*
        if (refrigerado != null){
            listaProductosRefrigerados.add(refrigerado);
            tableProdRefrigerado.refresh();
            // mensaje de confirmacion
            //persistencia.guardarArchivoLog("Se guardado un cliente correctamente", 1, "La acción se ejecuto desde el método guardarClienteNatural de ClientesController.");

        }

 */




    }
    @FXML
    void limpiarCampo(ActionEvent event) {

        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtValorUnitario.setText(null);
        txtCodigoAprobacion.setText(null);
        txtTemperaturaRefrigeracion.setText(null);
        txtExistencias.setText(null);
        txtDescripcion.setText(null);


    }
    /*public ObservableList<ProductoRefrigerado> getProductosRegrigerados(){

        listaProductosRefrigerados.addAll(RefrigeradosSubController.obtenerProductosRefrigerados());
        return  listaProductosRefrigerados;
    }

     */


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
