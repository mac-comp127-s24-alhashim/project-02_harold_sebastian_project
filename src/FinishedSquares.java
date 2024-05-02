import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

/**
 * Contains methods to handle finishing squares in the game.
 * This class provides functionality to test if a square has reached the finish line
 * and to display the finishing place of the square on the canvas.
 */
public class FinishedSquares {

    /**
     * Checks if the specified square has reached the finish line and updates its status if necessary.
     * @param square The square object to test.
     * @param canvas The canvas window.
     * @param map The map containing the finish line.
     */
    public static void testFinish(Square square, CanvasWindow canvas, Map map) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();
        double left = squareX - 15;
        double right = squareX + squareSize + 15;
        Rectangle leftZone = (Rectangle) map.endZone.getElementAt(left, squareY + squareSize * .5);
        Rectangle rightZone = (Rectangle) map.endZone.getElementAt(right, squareY + squareSize * .5);

        if (rightZone != null && leftZone != null) {
            square.finished = true;
            showFinishPlace(square, canvas);
        }
    }

    /**
     * Displays the finishing place of the specified square on the canvas.
     * @param square The square object to display the finish place for.
     * @param canvas The canvas window.
     */
    public static void showFinishPlace(Square square, CanvasWindow canvas) {
        square.squareText = new GraphicsText();
        SquareGame.finishedSquares.add(square);
        square.finishPlace = SquareGame.finishedSquares.indexOf(square) + 1;
        square.squareText.setText(square.finishPlace.toString());
        square.squareText.setFont(FontStyle.BOLD, square.getWidth() * 0.6);
        square.squareText.setCenter(square.getCenter());
        canvas.add(square.squareText);
    }
}
