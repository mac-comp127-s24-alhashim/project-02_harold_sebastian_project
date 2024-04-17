
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;

public class Square {
    private Rectangle square;
    private double speedX;
    private double speedY;
    private int sideLength; // Side length of the square


    public Square(double x, double y, int sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);
        speedX = 3; // Initial speed
        speedY = 3;
        square.setFillColor(Color.RED);
    }
    
    public Rectangle getSquare() {
        return square;
    }

    public double getX() {
        return square.getCenter().getX();
    }

    public double getY() {
        return square.getCenter().getY();
    }

    public int getSideLength() {
        return sideLength;
    }

    public void move() {
        // Update the Squares's position based on current velocity
        square.setPosition(square.getX() + speedX, square.getY() + speedY);
    }

    public void testTouchingWall(Square square, CanvasWindow canvas) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();

        double top = squareY - 5;
        double bottom = squareY + squareSize + 5;
        double left = squareX - 5;
        double right = squareX + squareSize + 5;

        Rectangle leftLine = (Rectangle) Map.walls.getElementAt(left, squareY + squareSize * .5);
        Rectangle rightLine = (Rectangle) Map.walls.getElementAt(right, squareY + squareSize * .5);
        Rectangle topLine = (Rectangle) Map.walls.getElementAt(squareX + squareSize * .5, top);
        Rectangle bottomLine = (Rectangle) Map.walls.getElementAt(squareX + squareSize * .5, bottom);

        if (leftLine != null || rightLine != null || topLine != null || bottomLine != null) {
            if (leftLine != null || rightLine != null) {
                square.speedX = -1 * square.speedX;
            }
            if (topLine != null || bottomLine != null) {
                square.speedY = -1 * square.speedY;
            }
        }
    }

}