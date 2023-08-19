package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteJuridico;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.ClienteJuridicoSubController;
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

public class ClientesJuridicosController implements Initializable {

    public App app = new App();

    private final ObservableList<ClienteJuridico> listaClientesJuridicos = FXCollections.observableArrayList();

    private ClienteJuridico clienteJuridico;
    private ClienteJuridicoSubController juridicoSubController;
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
    private TableView<ClienteJuridico> tableClientes;

    @FXML
    private TableColumn<ClienteJuridico, String> colApellidos;

    @FXML
    private TableColumn<ClienteJuridico, String> colDireccion;

    @FXML
    private TableColumn<ClienteJuridico, String> colEmail;

    @FXML
    private TableColumn<ClienteJuridico, LocalDate> colFechaNacimiento;

    @FXML
    private TableColumn<ClienteJuridico, String> colIdentificacion;

    @FXML
    private TableColumn<ClienteJuridico, String> colNit;

    @FXML
    private TableColumn<ClienteJuridico, String> colNombres;

    @FXML
    private TableColumn<ClienteJuridico, String> colTelefono;

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
        ClienteJuridico cliente;
        ClienteJuridico clienteTemporal = new ClienteJuridico();

        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String identificacion = txtIdentificacion.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String nit = txtNit.getText();

        clienteTemporal.setNombres(nombres);
        clienteTemporal.setApellidos(apellidos);
        clienteTemporal.setIdentificacion(identificacion);
        clienteTemporal.setDireccion(direccion);
        clienteTemporal.setTelefono(telefono);
        clienteTemporal.setNit(nit);

        cliente = juridicoSubController.crearClienteJuridico(clienteTemporal);

        if(cliente != null){
            listaClientesJuridicos.add(cliente);
            tableClientes.refresh();
            // mensaje de confirmacion
            //persistencia.guardarArchivoLogJuridico("Se guardado un cliente correctamente", 1, "La acción se ejecuto desde el método guardarClienteNatural de ClientesController.");

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

    public ObservableList<ClienteJuridico> getClientesJuridicos() {
        listaClientesJuridicos.addAll(juridicoSubController.obtenerClientesJuridicos());
        return listaClientesJuridicos;
    }

    private void inicializarJuridicosView() {

        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colNit.setCellValueFactory(new PropertyValueFactory<>("nit"));

        tableClientes.getItems().clear();
        tableClientes.setItems(getClientesJuridicos());

        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            clienteJuridico = (ClienteJuridico) newSelection;

            mostrarInformacionSerie(clienteJuridico);

        });

    }


    private void mostrarInformacionSerie(ClienteJuridico clienteTemporal) {
        if(clienteTemporal != null) {

            txtNombres.setText(clienteTemporal.getNombres());
            txtApellidos.setText(clienteTemporal.getApellidos());
            txtIdentificacion.setText(clienteTemporal.getIdentificacion());
            txtDireccion.setText(clienteTemporal.getDireccion());
            txtTelefono.setText(clienteTemporal.getTelefono());
            txtNit.setText(clienteTemporal.getNit());
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

    public void datosInicialesJuridico(){
        Factory factory = Factory.getInstance();
        juridicoSubController = new ClienteJuridicoSubController(factory);
        new ClientesJuridicosController();
        inicializarJuridicosView();
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datosInicialesJuridico();
    }

}
