/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skn68checkers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sai Kovuri
 */
public class Skn68Checkers extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkers.fxml"));
        Parent root = loader.load();
        CheckersController controller = loader.getController();
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Checkerboard");
        stage.setScene(scene);
        stage.show();
        controller.begin(8, 8);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
