package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Cliente;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.ClienteSubController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClientesController implements Initializable {

    public App app = new App();

    private final ObservableList<ClienteNatural> listaClientesNaturales = FXCollections.observableArrayList();

    private ClienteNatural clienteNatural;
    private ClienteSubController subController;
    private Persistencia persistencia = new Persistencia();


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
    private TableView<ClienteNatural> tableClientes;

    @FXML
    private TableColumn<ClienteNatural, String> colApellidos;

    @FXML
    private TableColumn<ClienteNatural, String> colDireccion;

    @FXML
    private TableColumn<ClienteNatural, String> colEmail;

    @FXML
    private TableColumn<ClienteNatural, LocalDate> colFechaNacimiento;

    @FXML
    private TableColumn<ClienteNatural, String> colIdentificacion;

    @FXML
    private TableColumn<ClienteNatural, String> colNit;

    @FXML
    private TableColumn<ClienteNatural, String> colNombres;

    @FXML
    private TableColumn<ClienteNatural, String> colTelefono;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private DatePicker dateFechaNacimiento;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNit;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtTelefono;

    @FXML
    void actualizarCliente(ActionEvent event) {

    }

    @FXML
    void crearCliente(ActionEvent event) {
        guardarNuevoCliente();
    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }


    @FXML
    void salirClientes(ActionEvent event) throws IOException {
        cerrarVentana(btnSalir);
        app.cargarVentanaInicio();
    }

    public void guardarNuevoCliente(){
        ClienteNatural cliente;
        ClienteNatural clienteTemporal = new ClienteNatural();

        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String identificacion = txtIdentificacion.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        LocalDate fechaNacimiento = dateFechaNacimiento.getValue();
        String email = txtEmail.getText();
        String nit = txtNit.getText();

        clienteTemporal.setNombres(nombres);
        clienteTemporal.setApellidos(apellidos);
        clienteTemporal.setIdentificacion(identificacion);
        clienteTemporal.setDireccion(direccion);
        clienteTemporal.setTelefono(telefono);
        clienteTemporal.setFechaNacimiento(fechaNacimiento);
        clienteTemporal.setEmail(email);

        cliente = subController.crearCliente(clienteTemporal);

        if(cliente != null){
            listaClientesNaturales.add(cliente);
            tableClientes.refresh();
            // mensaje de confirmacion
            persistencia.guardarArchivoLog("Se guardado un cliente correctamente", 1, "La acción se ejecuto desde el método guardarClienteNatural de ClientesController.");

        }

    }


    @FXML
    void limpiarCampo(ActionEvent event) {
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtIdentificacion.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        dateFechaNacimiento.setValue(null);
        txtEmail.setText(null);
    }

    public ObservableList<ClienteNatural> getClientesNaturales() {
        listaClientesNaturales.addAll(subController.obtenerClientes());
        return listaClientesNaturales;
    }

    private void inicializarProcesamientosView() {

        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableClientes.getItems().clear();
        tableClientes.setItems(getClientesNaturales());

        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            clienteNatural = (ClienteNatural) newSelection;

            mostrarInformacionSerie(clienteNatural);

        });

    }


    private void mostrarInformacionSerie(ClienteNatural clienteTemporal) {
        if(clienteTemporal != null) {

            txtNombres.setText(clienteTemporal.getNombres());
            txtApellidos.setText(clienteTemporal.getApellidos());
            txtIdentificacion.setText(clienteTemporal.getIdentificacion());
            txtDireccion.setText(clienteTemporal.getDireccion());
            txtTelefono.setText(clienteTemporal.getTelefono());
            dateFechaNacimiento.setValue(clienteTemporal.getFechaNacimiento());
            txtEmail.setText(clienteTemporal.getEmail());
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

    public void datosIniciales(){
        Factory factory = Factory.getInstance();
        subController = new ClienteSubController(factory);
        new ClientesController();
        inicializarProcesamientosView();
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datosIniciales();
    }


}