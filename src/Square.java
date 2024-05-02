import java.awt.Color;
import java.util.Random;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a square object in the game.
 * Handles movement, collision detection, and finishing the race.
 * Provides methods to interact with the square.
 * Contains graphical elements such as rectangles and text.
 */
public class Square {
    private Rectangle square;
    private double totalSpeed = 5;
    double speedX;
    double speedY;
    private int sideLength; // Side length of the square
    boolean finished = false;
    public GraphicsText squareText;
    public Integer finishPlace;

    /**
     * Constructs a Square object with the specified position and side length.
     * @param x The x-coordinate of the square's center.
     * @param y The y-coordinate of the square's center.
     * @param sideLength The side length of the square.
     */
    public Square(double x, double y, int sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);

        Random rand = new Random();
        speedX = 1 + (rand.nextDouble() * totalSpeed) / 2;
        speedY = 1 + (Math.sqrt(totalSpeed * totalSpeed - speedX * speedX)) / 2;

        finished = false;
    }
    
    /**
     * Retrieves the square's graphical representation (Rectangle).
     * @return The rectangle representing the square.
     */
    public Rectangle getSquare() {
        return square;
    }

    /**
     * Retrieves the x-coordinate of the square's center.
     * @return The x-coordinate of the square's center.
     */
    public double getX() {
        return square.getCenter().getX();
    }

    /**
     * Retrieves the y-coordinate of the square's center.
     * @return The y-coordinate of the square's center.
     */
    public double getY() {
        return square.getCenter().getY();
    }

    /**
     * Retrieves the side length of the square.
     * @return The side length of the square.
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Retrieves the height of the square.
     * @return The height of the square.
     */
    double getHeight() {
        return square.getHeight();
    }

    /**
     * Retrieves the width of the square.
     * @return The width of the square.
     */
    double getWidth() {
        return square.getHeight();
    }

    /**
     * Moves the square based on its current velocity.
     */
    public void move() {
        // Update the square's position based on current velocity
        square.setPosition(square.getX() + speedX, square.getY() + speedY);
    }

    /**
     * Sets the color of the square.
     * @param color The color to set.
     */
    public void setSquareColor(Color color) {
        square.setFillColor(color);
    }
    
    /**
     * Retrieves the color of the square.
     * @return The color of the square.
     */
    public Color getSquareColor() {
        return (Color) square.getFillColor();
    }

    /**
     * Sets the stroke color of the square.
     * @param color The stroke color to set.
     */
    public void setStrokeColor(Color color) {
        square.setStrokeColor(color);
    }

    /**
     * Sets the stroke width of the square.
     * @param size The stroke width to set.
     */
    public void setStrokeWidth(double size) {
        square.setStrokeWidth(size);
    }

    /**
     * Retrieves the center point of the square.
     * @return The center point of the square.
     */
    public Point getCenter() {
        return square.getCenter();
    }

}