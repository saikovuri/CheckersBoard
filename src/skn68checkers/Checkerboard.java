/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skn68checkers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sai Kovuri
 */
public class Checkerboard {

    //private variables of this class
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private double rectWidth;
    private double rectHeight;
    private Color lightColor;
    private Color darkColor;
    AnchorPane board = new AnchorPane();

    //First constructor
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        rectWidth = boardWidth / numCols;
        rectHeight = boardHeight / numRows;
    }

    //Second constructor
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }

    //build method generates rectangles and add them into anchorpane
    public AnchorPane build() {

        Rectangle rect;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
               if(row % 2 == 0) {
                    if(col % 2 == 0) { 
                        rect = new Rectangle(rectWidth, rectHeight, lightColor);
                    }
                    else {
                        rect = new Rectangle(rectWidth, rectHeight, darkColor);
                    }
                    
                    rect.setX(col * rectWidth);
                    rect.setY(row * rectHeight);
                } else {
                    if (col % 2 == 1) {
                   rect = new Rectangle(rectWidth, rectHeight, lightColor);
                    }
                    else {
                        rect = new Rectangle(rectWidth, rectHeight, darkColor);
                    }
                    rect.setX(col * rectWidth);
                    rect.setY(row * rectHeight);
                }
                board.getChildren().add(rect);
            }
        }

        return board;
    }

    // getBoard method returns the anchorpane to the controller 
    public AnchorPane getBoard() {
        if (board == null) {
            return null;
        }
        return board;
    }

    // Getter methods to access private variables of Checkerboard class in another class
    public int getNumRows() {
        return numRows;
    }

    public int getNumcols() {
        return numCols;
    }

    public double getWidth() {
        return boardWidth;
    }

    public double getheight() {
        return boardHeight;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public double getRectangleWidth() {
        return rectWidth;
    }

    public double getRectangleHeight() {
        return rectHeight;
    }

}
