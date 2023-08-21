package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoPerecedero;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoRefrigerado;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PerecederosController {

    App app = new App();

    private final ObservableList<ProductoEnvasado> listaProductosRefrigerado = FXCollections.observableArrayList();

    private ProductoRefrigerado productoRefrigerado;
    private ProductoRefrigerado subController;
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
    private TableView<ProductoRefrigerado> tablePerecederos;

    @FXML
    private TableColumn<ProductoPerecedero, String> colNombre;

    @FXML
    private TextField txtCodigo;

    @FXML
    private GridPane txtValorUnitario;

    @FXML
    private DatePicker dateFechaVencimiento;

    @FXML
    private TextArea txtDEscripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<?, ?> colDescripcion;

    @FXML
    private TextField txtExistencias;

    @FXML
    private Button btnCrearPerecedero;

    @FXML
    private Button btnEliminarPerecedero;

    @FXML
    private TableColumn<?, ?> colValor;

    @FXML
    private Button btnSalirPrincipal;

    @FXML
    private Button btnActualizarPerecedero;


    @FXML
    void crearPerecedero(ActionEvent event) {

    }

    @FXML
    void actualizarPerecedero(ActionEvent event) {

    }

    @FXML
    void eliminarPerecedero(ActionEvent event) {

    }

    @FXML
    void limpiarCampoPerecedero(ActionEvent event) {

    }

    @FXML
    void btnSalirPrincipal(ActionEvent event) {
        cerrarVentana(btnSalirPrincipal);
        app.cargarVentanaProductosInicio();
    }

    @FXML
    void menuInicioProductos(ActionEvent event) {
        cerrarVentana(btnSalirPrincipal);
        app.cargarVentanaProductosInicio();

    }
    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
}
