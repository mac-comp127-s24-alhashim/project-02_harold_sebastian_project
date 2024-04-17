
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;
import java.util.Iterator;


public class Square {
    private Rectangle square;
    private double speedX;
    private double speedY;
    private int sideLength; // Side length of the square


    public Square(double x, double y, int sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);
        speedX = 2; // Initial speed
        speedY = 2;
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

        double top = squareY - 0.25;
        double bottom = squareY + squareSize + .25;
        double left = squareX - .25;
        double right = squareX + squareSize + .25;

        Line leftLine = (Line) Map.walls.getElementAt(left, squareY + squareSize * .5);
        Line rightLine = (Line) Map.walls.getElementAt(right, squareY + squareSize * .5);
        Line topLine = (Line) Map.walls.getElementAt(squareX + squareSize * .5, top);
        Line bottomLine = (Line) Map.walls.getElementAt(squareX + squareSize * .5, bottom);

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