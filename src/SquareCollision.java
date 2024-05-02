import java.util.List;

/**
 * Handles collision detection between squares.
 */
public class SquareCollision {
    /**
     * Checks if the square is touching another square and applies repulsion if necessary.
     * @param square The square object to test.
     * @param squares The list of squares to test against.
     */
    public static void handleSquareCollision(Square square, List<Square> squares) {
        double squareX = square.getX();
        double squareY = square.getY();
        double squareWidth = square.getWidth();
        double squareHeight = square.getHeight();

        for (Square otherSquare : squares) {
            if (otherSquare != square) {
                double otherSquareX = otherSquare.getX();
                double otherSquareY = otherSquare.getY();
                double otherSquareWidth = otherSquare.getWidth();
                double otherSquareHeight = otherSquare.getHeight();

                double left = squareX - 7.5;
                double right = squareX + squareWidth + 7.5;
                double top = squareY - 7.5;
                double bottom = squareY + squareHeight + 7.5;

                double otherLeft = otherSquareX - 7.5;
                double otherRight = otherSquareX + otherSquareWidth + 7.5;
                double otherTop = otherSquareY - 7.5;
                double otherBottom = otherSquareY + otherSquareHeight + 7.5;

                if (right >= otherLeft && left <= otherRight && bottom >= otherTop && top <= otherBottom) {
                    double dx = otherSquareX - squareX;
                    double dy = otherSquareY - squareY;
                    double distance = Math.sqrt(dx * dx + dy * dy);

                    double minDistance = squareWidth / 2.0 + otherSquareWidth / 2.0;

                    if (distance < minDistance) {
                        double repulsionAngle = Math.atan2(dy, dx);
                        double repulsionX = Math.cos(repulsionAngle);
                        double repulsionY = Math.sin(repulsionAngle);

                        square.speedX -= repulsionX;
                        square.speedY -= repulsionY;
                        otherSquare.speedX += repulsionX;
                        otherSquare.speedY += repulsionY;
                    }
                }
            }
        }
    }
}
