
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;

public class SquareGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static CanvasWindow canvas;
    private static Square square;
    private static Map map;
    private Wall wall;
    public static double squareX = 75;
    public static double squareY = 725;
    public static boolean finishBoolean = true;


    public SquareGame() {
        canvas = new CanvasWindow("Squares Game!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.LIGHT_GRAY);

        Map.walls(canvas);
        canvas.add(Map.walls);

        Map.addFinish(canvas);
        canvas.add(Map.finishLine);

        Map.addEndZone(canvas);
        canvas.add(Map.endZone);

        square = new Square(squareX, squareY, 20);
        canvas.add(square.getSquare());
    }

    public static void main(String[] args) {
        new SquareGame();

        canvas.animate(() -> {

            if (finishBoolean) {

                square.move();

                square.testTouchingWall(square, canvas);

                // square.testTouchingSquare();
                square.testFinish(square, canvas);

            }
        });
    }

}