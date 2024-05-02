import java.awt.Color;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
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
    private double speedX;
    private double speedY;
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
     * Checks if the square is touching a wall and adjusts its velocity accordingly.
     * @param square The square object to test.
     * @param canvas The canvas window.
     * @param map The map containing walls.
     */
    public void testTouchingWall(Square square, CanvasWindow canvas, Map map) {
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

    /**
     * Checks if the square is touching another square and applies repulsion if necessary.
     * @param squares The list of squares to test against.
     * @param canvas The canvas window.
     */
    public void testTouchingSquare(List<Square> squares, CanvasWindow canvas) {
        double squareX = square.getX();
        double squareY = square.getY();
        double squareWidth = square.getWidth();
        double squareHeight = square.getHeight();

        for (Square otherSquare : squares) {
            if (otherSquare != this) {
                double otherSquareX = otherSquare.getX();
                double otherSquareY = otherSquare.getY();
                double otherSquareWidth = otherSquare.getWidth();
                double otherSquareHeight = otherSquare.getHeight();

                // Calculate boundaries of the squares
                double left = squareX - 7.5;
                double right = squareX + squareWidth + 7.5;
                double top = squareY - 7.5;
                double bottom = squareY + squareHeight + 7.5;

                double otherLeft = otherSquareX - 7.5;
                double otherRight = otherSquareX + otherSquareWidth + 7.5;
                double otherTop = otherSquareY - 7.5;
                double otherBottom = otherSquareY + otherSquareHeight + 7.5;

                // Check for collision
                if (right >= otherLeft && left <= otherRight && bottom >= otherTop && top <= otherBottom) {
                    // Calculate the distance between the centers of the squares
                    double dx = otherSquareX - squareX;
                    double dy = otherSquareY - squareY;
                    double distance = Math.sqrt(dx * dx + dy * dy);

                    // Calculate the minimum distance for collision
                    double minDistance = squareWidth / 2.0 + otherSquareWidth / 2.0;

                    // If the squares are colliding, calculate and apply repulsion
                    if (distance < minDistance) {
                        // Calculate the direction of repulsion
                        double repulsionAngle = Math.atan2(dy, dx);
                        double repulsionX = Math.cos(repulsionAngle);
                        double repulsionY = Math.sin(repulsionAngle);

                        // Apply repulsion to both squares
                        speedX -= repulsionX ;
                        speedY -= repulsionY ;
                        otherSquare.speedX += repulsionX;
                        otherSquare.speedY += repulsionY;
                    }
                }
            }
        }
    }

    /**
     * Checks if the square has reached the finish line and updates its status if necessary.
     * @param square The square object to test.
     * @param canvas The canvas window.
     * @param map The map containing the finish line.
     */
    public void testFinish(Square square, CanvasWindow canvas, Map map) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();
        double left = squareX - 15;
        double right = squareX + squareSize + 15;
        Rectangle leftZone = (Rectangle) map.endZone.getElementAt(left, squareY + squareSize * .5);
        Rectangle rightZone = (Rectangle) map.endZone.getElementAt(right, squareY + squareSize * .5);

        if (rightZone != null && leftZone != null) {
            finished = true;
            square.showFinishPlace(square, canvas);
        }
    }

    /**
     * Displays the finishing place of the square on the canvas.
     * @param square The square object to display the finish place for.
     * @param canvas The canvas window.
     */
    public void showFinishPlace(Square square, CanvasWindow canvas) {
        squareText = new GraphicsText();
        SquareGame.finishedSquares.add(square);
        finishPlace = SquareGame.finishedSquares.indexOf(square) + 1;
        squareText.setText(finishPlace.toString());
        squareText.setFont(FontStyle.BOLD, square.getWidth() * 0.6);
        squareText.setCenter(square.getCenter());
        canvas.add(squareText);
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