
import edu.macalester.graphics.CanvasWindow;

public class SquareGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private CanvasWindow canvas;
    private Square square;
    private Map map;
    private Wall wall;


    public SquareGame() {
        canvas = new CanvasWindow("Squares Game!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        square = new Square(80, 80, 20);
        wall = new Wall(50, 50, 600, 800);

        canvas.add(square.getSquare());
        canvas.add(wall.getWall());

    }
    public static void main(String[] args) {
        new SquareGame();
    }
}
