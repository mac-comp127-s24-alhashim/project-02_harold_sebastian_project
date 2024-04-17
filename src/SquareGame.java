
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
    public static double squareY = 75;


    public SquareGame() {
        canvas = new CanvasWindow("Squares Game!!!", CANVAS_WIDTH, CANVAS_HEIGHT);

        square = new Square(squareX, squareY, 20);
        canvas.add(square.getSquare());

        Map.walls(canvas);
        canvas.add(Map.walls);

    }

    public static void main(String[] args) {
        new SquareGame();

        canvas.animate(() -> {

            //if (testFinish) {

                square.move();

                square.testTouchingWall(square, canvas);

                // square.testTouchingSquare();
                //square.testFinish();

            //}
        });
    }

}