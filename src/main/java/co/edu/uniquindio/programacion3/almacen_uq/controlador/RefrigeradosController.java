package co.edu.uniquindio.programacion3.almacen_uq.controlador;

import co.edu.uniquindio.programacion3.almacen_uq.main.App;

import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoRefrigerado;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RefrigeradosController {
    App app = new App();

    private final ObservableList<ProductoRefrigerado> listaProductosRefrigerado = FXCollections.observableArrayList();

    private ProductoRefrigerado productoRefrigerado;
    private ProductoRefrigerado subController;
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
    void actualizarRefrigerado(ActionEvent event) {

    }

    @FXML
    void eliminarRefrigerado(ActionEvent event) {

    }

    @FXML
    void limpiarCampo(ActionEvent event) {

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

}
