package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;

import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoRefrigerado;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;

import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.EnvasadoSubController;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.RefrigeradosSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class RefrigeradosController implements Initializable {
    App app = new App();

    private final ObservableList<ProductoRefrigerado> listaProductosRefrigerado = FXCollections.observableArrayList();

    private ProductoRefrigerado productoRefrigerado;
    private RefrigeradosSubController refrigeradoSubController;
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
    private TableColumn<ProductoRefrigerado, Integer> colExistencias;

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
    void crearRefrigerado(ActionEvent event) {
        guardarNuevoRefrigerado();
    }

    @FXML
    void actualizarRefrigerado(ActionEvent event) {
        actualizarRefrigerado();
    }

    @FXML
    void eliminarRefrigerado(ActionEvent event) {
        eliminarRefrigerados();
    }

    @FXML
    void limpiarCampo(ActionEvent event) {
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtDescripcion.setText(null);
        txtValorUnitario.setText(null);
        txtExistencias.setText(null);
        txtTemperaturaRefrigeracion.setText(null);
        txtCodigoAprobacion.setText(null);
    }


    public void guardarNuevoRefrigerado(){

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

        refrigerado = refrigeradoSubController.crearRefrigerado(refrigeradoTemporal);

        if (refrigerado != null){
            listaProductosRefrigerado.add(refrigerado);
            tableProdRefrigerado.refresh();
            // mensaje de confirmacion
            //persistencia.guardarArchivoLog("Se guardado un cliente correctamente", 1, "La acción se ejecuto desde el método guardarClienteNatural de ClientesController.");

        }

    }

    public void eliminarRefrigerados() {
        boolean bandera = false, mensaje;
        if (productoRefrigerado != null) {
            mensaje = mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el procesamiento?.");
            if (mensaje) {
                bandera = refrigeradoSubController.eliminarRefrigerado(productoRefrigerado);
                if (bandera) {
                    listaProductosRefrigerado.remove(productoRefrigerado);
                    productoRefrigerado = null;
                    tableProdRefrigerado.getSelectionModel().clearSelection();
                    mostrarMensaje("ELIMINACIÓN", "Eliminación de Producto",
                            "El Producto se ha eliminado correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("ELIMINACIÓN", "Eliminación de Producto.",
                            "El Producto no se pudo eliminar.", Alert.AlertType.WARNING);
                }
            }
        }
    }

    public void actualizarRefrigerado(){
        ProductoRefrigerado refrigerado = new ProductoRefrigerado();
        boolean bandera = false;

        String codigo = txtCodigo.getText();
        String nombreProducto = txtNombre.getText();
        String descripcion = txtDescripcion.getText();
        Double valorUnitario = Double.valueOf(txtValorUnitario.getText());
        int existencias = Integer.parseInt(txtExistencias.getText());
        String codigoHabilitacion = txtCodigoAprobacion.getText();
        String temperatura = txtTemperaturaRefrigeracion.getText();

        refrigerado.setCodigo(codigo);
        refrigerado.setNombreProducto(nombreProducto);
        refrigerado.setDescripcion(descripcion);
        refrigerado.setValorUnitario(valorUnitario);
        refrigerado.setExistencias(existencias);
        refrigerado.setCodigoAprobacion(codigoHabilitacion);
        refrigerado.setTemRefrigeracion(temperatura);


        if(refrigerado != null){
            bandera = refrigeradoSubController.actualizarRefrigerado(refrigerado);

            if(bandera){

                mostrarMensaje("ACTUALIZACIÓN","Actualización de Producto.",
                        "El Producto se actualizó correctamente.", Alert.AlertType.INFORMATION);
                tableProdRefrigerado.refresh();
            }else {
                mostrarMensaje("ACTUALIZACIÓN","Actualización de Producto.",
                        "El Producto no se pudo actualizar.", Alert.AlertType.WARNING);
            }
        }
    }

    public ObservableList<ProductoRefrigerado> getProductoRefrigerado() {
        listaProductosRefrigerado.addAll(refrigeradoSubController.obtenerRefrigerados());
        return listaProductosRefrigerado;
    }

    private void inicializarRefrigeradoView() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colCodigoAprobacion.setCellValueFactory(new PropertyValueFactory<>("codigoAprobacion"));
        colTemperaturaRefrigeracion.setCellValueFactory(new PropertyValueFactory<>("TemRefrigeracion"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colExistencias.setCellValueFactory(new PropertyValueFactory<>("existencias"));

        tableProdRefrigerado.getItems().clear();
        tableProdRefrigerado.setItems(getProductoRefrigerado());

        tableProdRefrigerado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            productoRefrigerado = (ProductoRefrigerado) newSelection;

            mostrarInformacionSerie(productoRefrigerado);

        });

    }
    private void mostrarInformacionSerie(ProductoRefrigerado refrigeradoTemporal) {
        if(refrigeradoTemporal != null) {

            txtCodigo.setText(refrigeradoTemporal.getCodigo());
            txtNombre.setText(refrigeradoTemporal.getNombreProducto());
            txtValorUnitario.setText(String.valueOf(refrigeradoTemporal.getValorUnitario()));
            txtExistencias.setText(String.valueOf(refrigeradoTemporal.getExistencias()));
            txtCodigoAprobacion.setText(refrigeradoTemporal.getCodigoAprobacion());
            txtTemperaturaRefrigeracion.setText(refrigeradoTemporal.getTemRefrigeracion());
            txtDescripcion.setText(refrigeradoTemporal.getDescripcion());

        }
    }

    public boolean mostrarMensajeConfirmacion(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmacion");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void datosInicialesRefrigerados(){
        Factory factory = Factory.getInstance();
        refrigeradoSubController = new RefrigeradosSubController(factory);
        new RefrigeradosController();
        inicializarRefrigeradoView();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datosInicialesRefrigerados();
    }

}
