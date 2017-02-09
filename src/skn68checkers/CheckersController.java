/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skn68checkers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Sai Kovuri
 */
public class CheckersController implements Initializable {

    @FXML
    VBox vbox = new VBox();
    @FXML
    MenuBar menu = new MenuBar();

    Checkerboard board;

    //This is the first method executed to generate view  
    public void begin(int rows, int cols) {

        ChangeListener<Number> listener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                clearBoard();
                renderChange(board.getNumRows(), board.getNumcols(), board.getLightColor(), board.getDarkColor());
            }
        };
        vbox.widthProperty().addListener(listener);
        vbox.heightProperty().addListener(listener);

        render(rows, cols);

    }

    //This method is called when the checkers board is executed for the first time.
    public void render(int rows, int cols) {
        board = new Checkerboard(rows, cols, vbox.getWidth(), vbox.getHeight());
        board.build();
        AnchorPane anchorpane = board.getBoard();
        vbox.getChildren().add(anchorpane);

    }

    //This method is executed everytime when the menu item is clicked or stage size is changed.
    public void renderChange(int rows, int cols, Color light, Color dark) {
        board = new Checkerboard(rows, cols, vbox.getWidth(), vbox.getHeight(), light, dark);
        board.build();
        AnchorPane anchorpane = board.getBoard();
        vbox.getChildren().add(anchorpane);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //This method clears the board
    public void clearBoard() {
        board.getBoard().getChildren().clear();
    }

    @FXML
    private void handle16(ActionEvent event) {

        clearBoard();
        renderChange(16, 16, board.getLightColor(), board.getDarkColor());
    }

    @FXML
    private void handle10(ActionEvent event) {
        clearBoard();
        renderChange(10, 10, board.getLightColor(), board.getDarkColor());
    }

    @FXML
    private void handle8(ActionEvent event) {
        clearBoard();
        renderChange(8, 8, board.getLightColor(), board.getDarkColor());

    }

    @FXML
    private void handle3(ActionEvent event) {
        clearBoard();
        renderChange(3, 3, board.getLightColor(), board.getDarkColor());

    }

    @FXML
    private void handleDefault(ActionEvent event) {
        clearBoard();
        renderChange(board.getNumRows(), board.getNumcols(), Color.RED, Color.BLACK);
    }

    @FXML
    private void handleBlue(ActionEvent event) {
        clearBoard();
        renderChange(board.getNumRows(), board.getNumcols(), Color.SKYBLUE, Color.DARKBLUE);
    }

}
