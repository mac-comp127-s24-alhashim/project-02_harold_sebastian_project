
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
    private static Square square;
    private static Square square2;
    private static Square square3;
    private static Square square4;


    private static Map map;
    private static boolean allFinished = true;
    public static List<Square> squares = new ArrayList<>();
    public static GraphicsGroup squareGroup = new GraphicsGroup();

    public SquareGame() {
        canvas = new CanvasWindow("Squares Game!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.LIGHT_GRAY);

        Map.walls(canvas);
        canvas.add(Map.walls);

        Map.addFinish(canvas);
        canvas.add(Map.finishLine);

        Map.addEndZone(canvas);
        canvas.add(Map.endZone);

        square = new Square(75, 720,12);
        square2 = new Square(75, 670, 12);
        square3 = new Square(75, 650, 12);
        square4 = new Square(75, 630, 12);

        square.setSquareColor(Color.BLUE);
        square2.setSquareColor(Color.CYAN);
        square3.setSquareColor(Color.RED);
        square4.setSquareColor(Color.ORANGE);

        squareGroup.add(square.getSquare());
        squareGroup.add(square2.getSquare());
        squareGroup.add(square3.getSquare());
        squareGroup.add(square4.getSquare());

        canvas.add(squareGroup);

        squares.add(square);
        squares.add(square2);
        squares.add(square3);
        squares.add(square4);

    }

    public static void main(String[] args) {
        new SquareGame();

        canvas.animate(() -> {
            if (allFinished) {    
                Iterator<Square> iterator = squares.iterator();
                while (iterator.hasNext()) {
                    Square square = iterator.next();
                    if (square.finished == false) {
                        square.move();
                        square.testTouchingWall(square, canvas);
                        square.testTouchingSquare(squares, canvas);
                        square.testFinish(square, canvas);
                        if (square.finished == true) {
                            iterator.remove();
                        }
                    }
                }
            }
        });
    }
}