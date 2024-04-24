
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

public class SquareGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static CanvasWindow canvas;
    private static Menu menu;
    private static Menu restart;


    private static Map1 map1;
    private static Map2 map2;
    private static boolean allFinished = true;
    public static List<Square> squares = new ArrayList<>();
    public static GraphicsGroup squareGroup = new GraphicsGroup();
    private static boolean map1Start = false;
    private static boolean map2Start = false;

    public SquareGame() {
        map1 = new Map1();
        map2 = new Map2();
        canvas = new CanvasWindow("Squares Survival!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.LIGHT_GRAY);

        menu = new Menu(); // Create an instance of the Menu class
        canvas.add(menu);

        menu.getRace1Button().onClick(() -> {
            // Instantiate Map1 and set it as the current map
            menu.removeFromCanvas();
            map1.setupMap(canvas);

            Square square1 = new Square(75, 715, 20);
            Square square2 = new Square(75, 680, 20);
            Square square3 = new Square(75, 645, 20);
            Square square4 = new Square(75, 610, 20);

            square1.setSquareColor(Color.BLUE);
            square2.setSquareColor(Color.CYAN);
            square3.setSquareColor(Color.RED);
            square4.setSquareColor(Color.ORANGE);

            squares.add(square1);
            squares.add(square2);
            squares.add(square3);
            squares.add(square4);

            squareGroup.add(square1.getSquare());
            squareGroup.add(square2.getSquare());
            squareGroup.add(square3.getSquare());
            squareGroup.add(square4.getSquare());

            canvas.add(squareGroup);

            map1Start = true;
        });

        // Maps button event
        menu.getDM1Button().onClick(() -> {
            // Instantiate Map2 and set it as the current map
            menu.removeFromCanvas();
            map2.setupMap(canvas);

            Square square1 = new Square(75, 715, 20);
            Square square2 = new Square(75, 680, 20);
            Square square3 = new Square(75, 645, 20);
            Square square4 = new Square(75, 610, 20);

            square1.setSquareColor(Color.GREEN);
            square2.setSquareColor(Color.CYAN);
            square3.setSquareColor(Color.RED);
            square4.setSquareColor(Color.ORANGE);

            squares.add(square1);
            squares.add(square2);
            squares.add(square3);
            squares.add(square4);

            squareGroup.add(square1.getSquare());
            squareGroup.add(square2.getSquare());
            squareGroup.add(square3.getSquare());
            squareGroup.add(square4.getSquare());

            canvas.add(squareGroup);

            map2Start = true;
        });

        canvas.animate(() -> {
            if (map1Start == false && map2Start == false) {
                return;
            }
            System.out.println("Number of squares: " + squares.size());
            if (allFinished) {
                Iterator<Square> iterator = squares.iterator();
                while (iterator.hasNext()) {
                    Square square = iterator.next();
                    if (!square.finished) {
                        square.move();
                        Map currentMap = null;
                        if (map1Start == true) {
                            currentMap = map1;
                        }
                        else if (map2Start == true) {
                            currentMap = map2;
                        }
                        square.testTouchingWall(square, canvas, currentMap);
                        square.testTouchingSquare(squares, canvas);
                        square.testFinish(square, canvas, currentMap);
                        if (square.finished) {
                            iterator.remove();;
                        }
                    }
                }
            }
                // // Check if all squares are finished
                // if (squares.isEmpty()) {
                //     // If all squares have finished, show the restart button
                //     canvas.add(restart);
                // }
        });
        
        //menu.getRestartButton().onClick(() -> restartGame());
    }

    // public static void restartGame() {
    //     // Clear existing squares
    //     squares.clear();
    
    //     // Reset squares
    //     square = new Square(75, 720,12);
    //     square2 = new Square(75, 670, 12);
    //     square3 = new Square(75, 650, 12);
    //     square4 = new Square(75, 630, 12);
    
    //     // Add squares to the list
    //     squares.add(square);
    //     squares.add(square2);
    //     squares.add(square3);
    //     squares.add(square4);
    
    //     // Remove the existing menu and create a new one
    //     canvas.remove(menu);
    //     menu = new Menu();
    //     canvas.add(menu);
    
    //     // Hide square group
    //     setSquareGroupVisibility(false);
    // }

    public static void main(String[] args) {
        new SquareGame();
    }
}
