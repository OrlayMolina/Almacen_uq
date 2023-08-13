module co.edu.uniquindio.programacion3.almacen_uq.main {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.logging;

    opens co.edu.uniquindio.programacion3.almacen_uq.main to javafx.fxml;
    exports co.edu.uniquindio.programacion3.almacen_uq.main;
    exports co.edu.uniquindio.programacion3.almacen_uq.controlador;
    opens co.edu.uniquindio.programacion3.almacen_uq.controlador to javafx.fxml;
    opens co.edu.uniquindio.programacion3.almacen_uq.modelo to javafx.fxml;
    exports co.edu.uniquindio.programacion3.almacen_uq.modelo;
}