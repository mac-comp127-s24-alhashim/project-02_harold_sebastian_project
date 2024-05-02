import edu.macalester.graphics.Rectangle;

/**
 * Handles collision detection between squares and walls.
 */
public class WallCollision {
    /**
     * Checks if the square is touching a wall and adjusts its velocity accordingly.
     * @param square The square object to test.
     * @param map The map containing walls.
     */
    public static void handleWallCollision(Square square, Map map) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();

        double top = squareY - 10;
        double bottom = squareY + squareSize + 10;
        double left = squareX - 10;
        double right = squareX + squareSize + 10;

        Rectangle leftLine = (Rectangle) map.walls.getElementAt(left, squareY + squareSize * .5);
        Rectangle rightLine = (Rectangle) map.walls.getElementAt(right, squareY + squareSize * .5);
        Rectangle topLine = (Rectangle) map.walls.getElementAt(squareX + squareSize * .5, top);
        Rectangle bottomLine = (Rectangle) map.walls.getElementAt(squareX + squareSize * .5, bottom);

        if (leftLine != null || rightLine != null || topLine != null || bottomLine != null) {
            if (leftLine != null || rightLine != null) {
                square.speedX = -1.01 * square.speedX;
            }
            if (topLine != null || bottomLine != null) {
                square.speedY = -1.01 * square.speedY;
            }
        }
    }
}
