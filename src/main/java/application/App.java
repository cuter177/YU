package application;

import controllers.RegistroEstudianteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Paths;



public class App  extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Paths.ESTUDIANTES));
        AnchorPane pane  = fxmlLoader.load();

        //RegistroEstudianteController restudiante = fxmlLoader.getController();


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

            launch();

        //launch();
    }
}
