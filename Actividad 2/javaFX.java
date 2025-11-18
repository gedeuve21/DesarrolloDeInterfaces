import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ActividadJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField("TuNombre");

        Label apellidosLabel = new Label("Apellidos:");
        TextField apellidosField = new TextField("TusApellidos");

        VBox layout = new VBox(12);
        layout.getChildren().addAll(nombreLabel, nombreField, apellidosLabel, apellidosField);
        layout.setStyle("-fx-background-color: #ADD8E6; -fx-padding: 20;");

        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Actividad 1.2 JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}