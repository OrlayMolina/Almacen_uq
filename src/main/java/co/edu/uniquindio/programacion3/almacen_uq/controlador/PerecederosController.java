package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoPerecedero;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoRefrigerado;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.EnvasadoSubController;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.PerecederoSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class PerecederosController implements Initializable {

    App app = new App();

    private final ObservableList<ProductoPerecedero> listaProductosPerecederos = FXCollections.observableArrayList();

    private ProductoPerecedero productoPerecedero;
    private PerecederoSubController perecederoSubController;
    private Persistencia persistencia = new Persistencia();

    @FXML
    private TableColumn<ProductoPerecedero, Integer> colExistencias;

    @FXML
    private TableColumn<ProductoPerecedero, String> colCodigo;

    @FXML
    private TableColumn<ProductoPerecedero, LocalDate> colFechaVencimiento;

    @FXML
    private Button btnLimpiarPerecedero;

    @FXML
    private TableView<ProductoPerecedero> tablePerecederos;

    @FXML
    private TableColumn<ProductoPerecedero, String> colNombre;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtValorUnitario;

    @FXML
    private DatePicker dateFechaVencimiento;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<ProductoPerecedero, String> colDescripcion;

    @FXML
    private TextField txtExistencias;

    @FXML
    private Button btnCrearPerecedero;

    @FXML
    private Button btnEliminarPerecedero;

    @FXML
    private TableColumn<ProductoPerecedero, Double> colValor;

    @FXML
    private Button btnSalirPrincipal;

    @FXML
    private Button btnActualizarPerecedero;

    @FXML
    void btnSalirPrincipal(ActionEvent event) {
        cerrarVentana(btnSalirPrincipal);
        app.cargarVentanaProductosInicio();
    }

    @FXML
    void crearPerecedero(ActionEvent event) {
        guardarNuevoPerecedero();
    }

    @FXML
    void actualizarPerecedero(ActionEvent event) {
        actualizarPerecedero();
    }

    @FXML
    void eliminarPerecedero(ActionEvent event) {
        eliminarPerecedero();
    }

    @FXML
    void limpiarCampoPerecedero(ActionEvent event) {
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtDescripcion.setText(null);
        txtValorUnitario.setText(null);
        txtExistencias.setText(null);
        dateFechaVencimiento.setValue(null);

    }

    public void guardarNuevoPerecedero(){
        ProductoPerecedero perecedero = new ProductoPerecedero();

        try {
            String codigo = txtCodigo.getText();
            String nombreProducto = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            Double valorUnitario = Double.valueOf(txtValorUnitario.getText());
            int existencias = Integer.parseInt(txtExistencias.getText());
            LocalDate fechaEvasado = dateFechaVencimiento.getValue();

            perecedero.setCodigo(codigo);
            perecedero.setNombreProducto(nombreProducto);
            perecedero.setDescripcion(descripcion);
            perecedero.setValorUnitario(valorUnitario);
            perecedero.setExistencias(existencias);
            perecedero.setFechaVencimiento(fechaEvasado);

            perecederoSubController.crearProductoPerecedero(perecedero);
            listaProductosPerecederos.add(perecedero);
            tablePerecederos.refresh();
            mostrarMensaje("CREACIÓN", "Creación de Producto Perecedero",
                    "El Producto Perecedero se ha creado correctamente", Alert.AlertType.INFORMATION);
        }catch (Exception e){
            mostrarMensaje("CREACIÓN","Creación de Producto Perecedero.",
                    "El Producto Perecedero no se pudo actualizar.", Alert.AlertType.WARNING);
        }

    }

    public void eliminarPerecedero() {
        boolean bandera = false, mensaje;
        if (productoPerecedero != null) {
            mensaje = mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?.");
            if (mensaje) {
                bandera = perecederoSubController.eliminarPerecedero(productoPerecedero);
                if (bandera) {
                    listaProductosPerecederos.remove(productoPerecedero);
                    productoPerecedero = null;
                    tablePerecederos.getSelectionModel().clearSelection();
                    mostrarMensaje("ELIMINACIÓN", "Eliminación de Producto Perecedero",
                            "El Producto Perecedero se ha eliminado correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("ELIMINACIÓN", "Eliminación de Producto Perecedero.",
                            "El Producto Perecedero no se pudo eliminar.", Alert.AlertType.WARNING);
                }
            }
        }
    }

    public void actualizarPerecedero(){
        ProductoPerecedero perecedero = new ProductoPerecedero();
        boolean bandera = false;

        String codigo = txtCodigo.getText();
        String nombreProducto = txtNombre.getText();
        String descripcion = txtDescripcion.getText();
        Double valorUnitario = Double.valueOf(txtValorUnitario.getText());
        int existencias = Integer.parseInt(txtExistencias.getText());
        LocalDate fechaVencimiento = dateFechaVencimiento.getValue();

        perecedero.setCodigo(codigo);
        perecedero.setNombreProducto(nombreProducto);
        perecedero.setDescripcion(descripcion);
        perecedero.setValorUnitario(valorUnitario);
        perecedero.setExistencias(existencias);
        perecedero.setFechaVencimiento(fechaVencimiento);

        bandera = perecederoSubController.actualizarPerecedero(perecedero);

        if(bandera){

            tablePerecederos.refresh();
            mostrarMensaje("ACTUALIZACIÓN","Actualización de Producto.",
                    "El Producto se actualizó correctamente.", Alert.AlertType.INFORMATION);

        }else {
            mostrarMensaje("ACTUALIZACIÓN","Actualización de Producto.",
                    "El Producto no se pudo actualizar.", Alert.AlertType.WARNING);
        }

    }

    public ObservableList<ProductoPerecedero> getProductoPerecedero() {
        listaProductosPerecederos.addAll(perecederoSubController.obtenerPerecedero());
        return listaProductosPerecederos;
    }

    private void inicializarPerecederosView() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colExistencias.setCellValueFactory(new PropertyValueFactory<>("existencias"));

        tablePerecederos.getItems().clear();
        tablePerecederos.setItems(getProductoPerecedero());

        tablePerecederos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            productoPerecedero = (ProductoPerecedero) newSelection;

            mostrarInformacionSerie(productoPerecedero);

        });

    }
    private void mostrarInformacionSerie(ProductoPerecedero perecedero) {
        if(perecedero != null) {

            txtCodigo.setText(perecedero.getCodigo());
            txtNombre.setText(perecedero.getNombreProducto());
            txtDescripcion.setText(perecedero.getDescripcion());
            txtValorUnitario.setText(String.valueOf(perecedero.getValorUnitario()));
            txtExistencias.setText(String.valueOf(perecedero.getExistencias()));
            dateFechaVencimiento.setValue(perecedero.getFechaVencimiento());

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

    public void datosInicialesPerecederos(){
        Factory factory = Factory.getInstance();
        perecederoSubController = new PerecederoSubController(factory);
        new EnvasadosController();
        inicializarPerecederosView();
    }


    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datosInicialesPerecederos();
    }
}
