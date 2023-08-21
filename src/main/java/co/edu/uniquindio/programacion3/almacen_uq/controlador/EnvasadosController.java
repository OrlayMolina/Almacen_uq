package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.ClienteSubController;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.EnvasadoSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.Optional;
import java.util.ResourceBundle;

public class EnvasadosController implements Initializable {


    private App app = new App();
    private ProductoEnvasado envasado;
    private EnvasadoSubController envasadoSubController  = new EnvasadoSubController();
    private final ObservableList<ProductoEnvasado> listaProductosEnvasados = FXCollections.observableArrayList();
    private final ObservableList<Pais> listaPaises = FXCollections.observableArrayList();

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
    private TableColumn<ProductoEnvasado, Integer> colExistencias;

    @FXML
    private TableView<ProductoEnvasado> tableEnvasados;

    @FXML
    private TableColumn<ProductoEnvasado, String> colCodigo;

    @FXML
    private TableColumn<ProductoEnvasado, String> colDescripcion;

    @FXML
    private TableColumn<ProductoEnvasado, LocalDate> colFechaEnvase;

    @FXML
    private TableColumn<ProductoEnvasado, String> colNombre;

    @FXML
    private TableColumn<ProductoEnvasado, Pais> colPaisEnvase;

    @FXML
    private TableColumn<ProductoEnvasado, String> colPesoEnvase;

    @FXML
    private TableColumn<ProductoEnvasado, Double> colValorUnitario;

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
        actualizarEnvados();
    }

    @FXML
    void crearCliente(ActionEvent event) {
        guardarNuevoEnvasado();
    }

    @FXML
    void eliminarCliente(ActionEvent event) {
        eliminarEnvasados();
    }

    @FXML
    void limpiarCampo(ActionEvent event) {
        txtCodigo.setText(null);
        txtNombreProducto.setText(null);
        txaDescripcion.setText(null);
        txtValorUnitario.setText(null);
        txtExistencias.setText(null);
        dataFechaEnvase.setValue(null);
        txtPesoEnvase.setText(null);
        cmbPais.setValue(null);
    }

    public void guardarNuevoEnvasado(){
        ProductoEnvasado envasado = new ProductoEnvasado();

        try {
            String codigo = txtCodigo.getText();
            String nombreProducto = txtNombreProducto.getText();
            String descripcion = txaDescripcion.getText();
            Double valorUnitario = Double.valueOf(txtValorUnitario.getText());
            int existencias = Integer.parseInt(txtExistencias.getText());
            LocalDate fechaEvasado = dataFechaEnvase.getValue();
            String pesoEnvase = txtPesoEnvase.getText();
            Pais pais = cmbPais.getSelectionModel().getSelectedItem();

            envasado.setCodigo(codigo);
            envasado.setNombreProducto(nombreProducto);
            envasado.setDescripcion(descripcion);
            envasado.setValorUnitario(valorUnitario);
            envasado.setExistencias(existencias);
            envasado.setFechaEnvasado(fechaEvasado);
            envasado.setPesoEnvase(pesoEnvase);
            envasado.setPais(pais);

            envasadoSubController.crearProductoEnvasado(envasado);
            listaProductosEnvasados.add(envasado);
            tableEnvasados.refresh();
            mostrarMensaje("CREACIÓN", "Creación de Producto Envasado",
                    "El Producto Envasado se ha creado correctamente", Alert.AlertType.INFORMATION);
        }catch (Exception e){
            mostrarMensaje("CREACIÓN","Creación de Producto Envasado.",
                    "El Producto Envasado no se pudo actualizar.", Alert.AlertType.WARNING);
        }

    }

    public void eliminarEnvasados() {
        boolean bandera = false, mensaje;
        if (envasado != null) {
            mensaje = mostrarMensajeConfirmacion("¿Está seguro que desea eliminar el producto?.");
            if (mensaje) {
                bandera = envasadoSubController.eliminarEnvasado(envasado);
                if (bandera) {
                    listaProductosEnvasados.remove(envasado);
                    envasado = null;
                    tableEnvasados.getSelectionModel().clearSelection();
                    mostrarMensaje("ELIMINACIÓN", "Eliminación de Producto",
                            "El Producto se ha eliminado correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("ELIMINACIÓN", "Eliminación de Producto.",
                            "El Producto no se pudo eliminar.", Alert.AlertType.WARNING);
                }
            }
        }
    }

    public void actualizarEnvados(){
        ProductoEnvasado envasado = new ProductoEnvasado();
        boolean bandera = false;

        String codigo = txtCodigo.getText();
        String nombreProducto = txtNombreProducto.getText();
        String descripcion = txaDescripcion.getText();
        Double valorUnitario = Double.valueOf(txtValorUnitario.getText());
        int existencias = Integer.parseInt(txtExistencias.getText());
        LocalDate fechaEvasado = dataFechaEnvase.getValue();
        String pesoEnvase = txtPesoEnvase.getText();
        Pais pais = cmbPais.getSelectionModel().getSelectedItem();

        envasado.setCodigo(codigo);
        envasado.setNombreProducto(nombreProducto);
        envasado.setDescripcion(descripcion);
        envasado.setValorUnitario(valorUnitario);
        envasado.setExistencias(existencias);
        envasado.setFechaEnvasado(fechaEvasado);
        envasado.setPesoEnvase(pesoEnvase);
        envasado.setPais(pais);

        bandera = envasadoSubController.actualizarEnvasado(envasado);

        if(bandera){

            tableEnvasados.refresh();
            mostrarMensaje("ACTUALIZACIÓN","Actualización de Producto.",
                    "El Producto se actualizó correctamente.", Alert.AlertType.INFORMATION);

        }else {
            mostrarMensaje("ACTUALIZACIÓN","Actualización de Producto.",
                    "El Producto no se pudo actualizar.", Alert.AlertType.WARNING);
        }

    }


    public void mostrarPais(){
        listaPaises.add(Pais.ARGENTINA);
        listaPaises.add(Pais.CHILE);
        listaPaises.add(Pais.COLOMBIA);
        listaPaises.add(Pais.ECUADOR);
        listaPaises.add(Pais.PERU);

        cmbPais.setItems(listaPaises);
    }

    public ObservableList<ProductoEnvasado> getProductoEnvasado() {
        listaProductosEnvasados.addAll(envasadoSubController.obtenerEnvasados());
        return listaProductosEnvasados;
    }

    private void inicializarEnvasadosView() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colFechaEnvase.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));
        colPesoEnvase.setCellValueFactory(new PropertyValueFactory<>("pesoEnvase"));
        colPaisEnvase.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colExistencias.setCellValueFactory(new PropertyValueFactory<>("existencias"));

        tableEnvasados.getItems().clear();
        tableEnvasados.setItems(getProductoEnvasado());

        tableEnvasados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            envasado = (ProductoEnvasado) newSelection;

            mostrarInformacionSerie(envasado);

        });

    }
    private void mostrarInformacionSerie(ProductoEnvasado envasadoTemporal) {
        if(envasadoTemporal != null) {

            txtCodigo.setText(envasadoTemporal.getCodigo());
            txtNombreProducto.setText(envasadoTemporal.getNombreProducto());
            txaDescripcion.setText(envasadoTemporal.getDescripcion());
            txtValorUnitario.setText(String.valueOf(envasadoTemporal.getValorUnitario()));
            txtExistencias.setText(String.valueOf(envasadoTemporal.getExistencias()));
            dataFechaEnvase.setValue(envasadoTemporal.getFechaEnvasado());
            txtPesoEnvase.setText(envasadoTemporal.getPesoEnvase());
            cmbPais.setValue(envasadoTemporal.getPais());
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

    public void datosInicialesEnvasados(){
        Factory factory = Factory.getInstance();
        envasadoSubController = new EnvasadoSubController(factory);
        new EnvasadosController();
        inicializarEnvasadosView();
        mostrarPais();
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datosInicialesEnvasados();
    }

}
