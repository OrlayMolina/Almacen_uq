package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.*;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.ClienteSubController;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.EnvasadoSubController;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.VentaDetallesSubController;
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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

public class VentasController implements Initializable {

    private final ObservableList<VentaDetalle> listaDetalles = FXCollections.observableArrayList();
    private final ObservableList<Venta> listaVentas = FXCollections.observableArrayList();
    private final ObservableList<ProductoEnvasado> listaEnvasadosProductos = FXCollections.observableArrayList();
    private final ObservableList<ClienteNatural> listaClientes = FXCollections.observableArrayList();

    private App app = new App();
    private Venta ventas = new Venta();
    private VentaDetallesSubController detallesSubController;
    private ClienteSubController clienteSubController;
    private EnvasadoSubController envasadoSubController;

    @FXML
    private Button btnActualizarVenta;

    @FXML
    private Button btnAgregarDetalles;

    @FXML
    private Button btnCrearVenta;

    @FXML
    private Button btnEliminarVenta;

    @FXML
    private Button btnAtras;

    @FXML
    private TableView<Venta> tableVentas;

    @FXML
    private TableView<VentaDetalle> tableDetalles;

    @FXML
    private ComboBox<ClienteNatural> cmbCliente;

    @FXML
    private ComboBox<ProductoEnvasado> cmbProducto;

    @FXML
    private TableColumn<VentaDetalle, Integer> colCantidad;

    @FXML
    private TableColumn<Venta, String> colClienteVenta;

    @FXML
    private TableColumn<Venta, LocalDate> colFechaVenta;

    @FXML
    private TableColumn<Venta, Double> colIvaVenta;

    @FXML
    private TableColumn<VentaDetalle, String> colProducto;

    @FXML
    private TableColumn<VentaDetalle, Double> colSubtotal;

    @FXML
    private TableColumn<Venta, Double> colTotal;

    @FXML
    private DatePicker dateFecha;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtIva;

    @FXML
    private TextField txtCodVenta;

    @FXML
    private TextField txtSubtotal;

    @FXML
    private TextField txtTotal;

    /**
     * Función para agregar los detalles de la venta
     */
    @FXML
    public void agregarDetalles() {

        try {
            VentaDetalle ventaDetalle = new VentaDetalle(
                    txtCodVenta.getText(),
                    Integer.parseInt(txtCantidad.getText()),
                    Double.parseDouble(txtSubtotal.getText()),
                    cmbProducto.getValue()
            );
            listaDetalles.add(ventaDetalle);
            clearDetails();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void crearVenta() {
        if (!listaEnvasadosProductos.isEmpty()) {
            ArrayList<VentaDetalle> listaVentaDetalles = new ArrayList<>(listaDetalles);
            Venta venta = new Venta(txtCodVenta.getText(),
                    dateFecha.getValue(),
                    cmbCliente.getValue(),
                    Double.parseDouble(txtTotal.getText()),
                    Double.parseDouble(txtIva.getText()),
                    listaVentaDetalles
            );
        }

    }

    public ObservableList<VentaDetalle> getVentasDetalles() {
        listaDetalles.addAll(detallesSubController.obtenerDetalles());
        return listaDetalles;
    }

    public ObservableList<ClienteNatural> getListaClientes() {
        listaClientes.addAll(clienteSubController.obtenerClientes());
        return listaClientes;
    }

    public ObservableList<ProductoEnvasado> getListaProductos() {
        listaEnvasadosProductos.addAll(envasadoSubController.obtenerEnvasados());
        return listaEnvasadosProductos;
    }

    public void inicializarDetalles() {


        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        tableDetalles.getItems().clear();
        tableDetalles.setItems(listaDetalles);

    }

    private void inicializarVenta() {

        colFechaVenta.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colClienteVenta.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colIvaVenta.setCellValueFactory(new PropertyValueFactory<>("iva"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        tableVentas.getItems().clear();
        tableVentas.setItems(listaVentas);

        tableVentas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            ventas = (Venta) newSelection;

           // mostrarInformacionSerie(ventas);

        });

    }

    /*
    private void mostrarInformacionSerie(Venta ventas) {
        if(ventas != null) {

            txtCodVenta.setText(ventas.getCodigo());
            dateFecha.setValue(ventas.getFecha());
            cmbCliente.setValue(ventas.getCliente());
            txtTotal.setText(ventas.getTotal());
            txtIva.setText(ventas.getIva());

        }
    }

     */

    private void clearDetails() {

        txtCantidad.setText("");
        txtSubtotal.setText("");
        cmbProducto.setValue(null);
    }

    public void datosInicialesVentas() {
        Factory factory = Factory.getInstance();
        clienteSubController = new ClienteSubController(factory);
        envasadoSubController = new EnvasadoSubController(factory);
        getListaClientes();
        getListaProductos();
        cmbCliente.setItems(listaClientes);
        cmbProducto.setItems(listaEnvasadosProductos);
        inicializarDetalles();
    }


    @FXML
    void menuInicio(ActionEvent event) {
        cerrarVentana(btnAtras);
        app.cargarVentanaInicio();
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCodVenta.setText(UUID.randomUUID().toString());
        datosInicialesVentas();
        btnActualizarVenta.setVisible(false);
        btnEliminarVenta.setVisible(false);
    }
}
