
import java.awt.Color;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Square {
    private Rectangle square;
    private double totalSpeed = 2;
    private double speedX;
    private double speedY;
    private int sideLength; // Side length of the square
    boolean finished = false;
    public Square(double x, double y, int sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);

        Random rand = new Random();
        speedX = 1 + (rand.nextDouble() * totalSpeed) / 2;
        speedY = 1 + (Math.sqrt(totalSpeed * totalSpeed - speedX * speedX)) / 2;

        finished = false;
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

    private double getHeight() {
        return square.getHeight();
    }

    private double getWidth() {
        return square.getHeight();
    }

    public void move() {
        // Update the Squares's position based on current velocity
        square.setPosition(square.getX() + speedX, square.getY() + speedY);
    }

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
                square.speedX = -1 * square.speedX;
            }
            if (topLine != null || bottomLine != null) {
                square.speedY = -1 * square.speedY;
            }
        }

        }
        
        public void testTouchingSquare(List<Square> squares, CanvasWindow canvas) {
            double squareX = square.getX();
            double squareY = square.getY();
            double squareWidth = square.getWidth();
            double squareHeight = square.getHeight();
        
            double top = squareY - 7.5;
            double bottom = squareY + squareHeight + 7.5;
            double left = squareX - 7.5;
            double right = squareX + squareWidth + 7.5;
        
            for (Square otherSquare : squares) {
                if (otherSquare != this) {
                    double otherSquareX = otherSquare.getX();
                    double otherSquareY = otherSquare.getY();
                    double otherSquareWidth = otherSquare.getWidth();
                    double otherSquareHeight = otherSquare.getHeight();
        
                    // Calculate boundaries of the other squares
                    double otherSquareTop = otherSquareY - otherSquareHeight / 4;
                    double otherSquareBottom = otherSquareY + otherSquareHeight / 4;
                    double otherSquareLeft = otherSquareX - otherSquareWidth / 4;
                    double otherSquareRight = otherSquareX + otherSquareWidth / 4;
        
                    // System.out.println("Square: " + squareX + ", " + squareY + ", " + squareWidth + ", " + squareHeight);
                    // System.out.println("Other Square: " + otherSquareX + ", " + otherSquareY + ", " + otherSquareWidth + ", " + otherSquareHeight);
                    // System.out.println("Boundaries: left=" + left + ", right=" + right + ", top=" + top + ", bottom=" + bottom);
                    // System.out.println("Other Boundaries: left=" + otherSquareLeft + ", right=" + otherSquareRight + ", top=" + otherSquareTop + ", bottom=" + otherSquareBottom);
        
                    if (right >= otherSquareLeft && left <= otherSquareRight && bottom >= otherSquareTop && top <= otherSquareBottom) {
                        double dx = otherSquareX - squareX;
                        double dy = otherSquareY - squareY;
        
                        // Calculate the overlap distance between two squares
                        double overlapX = (squareWidth + otherSquareWidth) / .1 - Math.abs(dx);
                        double overlapY = (squareHeight + otherSquareHeight) / .1 - Math.abs(dy);
        
                        // If the overlap along X is larger than along Y, bounce along X-axis
                        if (overlapX < overlapY) {
                            // Change the direction of both squares along X-axis
                            speedX = -speedX;
                            otherSquare.speedX = -otherSquare.speedX;
                        } else { // Otherwise, bounce along Y-axis
                            // Change the direction of both squares along Y-axis
                            speedY = -speedY;
                            otherSquare.speedY = -otherSquare.speedY;
                        }
                        break; // Exit the loop after detecting one collision
                    }
                }
            }
        }

    public void testFinish(Square square, CanvasWindow canvas, Map map) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();

        double left = squareX - 15;

        Rectangle zone = (Rectangle) map.endZone.getElementAt(left, squareY + squareSize * .5);

        if (zone != null) {
            finished = true;
        }
    }

    public void setSquareColor(Color color) {
        square.setFillColor(color);
    }
}