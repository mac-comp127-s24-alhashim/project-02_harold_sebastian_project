
import java.awt.Color;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Fillable;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.Point;

public class Square {
    private Rectangle square;
    private double totalSpeed = 2;
    private double speedX;
    private double speedY;
    private int sideLength; // Side length of the square
    boolean finished = false;
    private boolean hasCollided = false;


    public Square (double x, double y, int sideLength) {
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

    public Point getCenter() {
        return square.getCenter();
    }

    public Point getPosition() {
        return square.getPosition();
    }

    public void move() {
        // Update the Squares's position based on current velocity
        square.setPosition(square.getX() + speedX, square.getY() + speedY);
    }

    public void testTouchingWall(Square square, CanvasWindow canvas) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();

        double top = squareY - 10;
        double bottom = squareY + squareSize + 10;
        double left = squareX - 10;
        double right = squareX + squareSize + 10;

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

    public void testTouchingSquare(Square square, GraphicsGroup squareGroup, CanvasWindow canvas) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();

        double top = squareY - 7.5;
        double bottom = squareY + squareSize + 7.5;
        double left = squareX - 7.5;
        double right = squareX + squareSize + 7.5;

        Rectangle leftLine = (Rectangle) squareGroup.getElementAt(left, squareY + squareSize * .5);
        Rectangle rightLine = (Rectangle) squareGroup.getElementAt(right, squareY + squareSize * .5);
        Rectangle topLine = (Rectangle) squareGroup.getElementAt(squareX + squareSize * .5, top);
        Rectangle bottomLine = (Rectangle) squareGroup.getElementAt(squareX + squareSize * .5, bottom);
        
        //if (hasCollided == false) {
            if ((leftLine != null && leftLine.getX() + 10 != squareX) || (rightLine != null && rightLine.getX() + 10 != squareX) || (topLine != null && topLine.getX() + 10 != squareX) || (bottomLine != null && bottomLine.getX() + 10 != squareX)) {
                
                //if(leftLine.getX() + 10 != squareX && rightLine.getX() + 10 != squareX && topLine.getX() + 10 != squareX && bottomLine.getX() + 10 != squareX){
                    if ((leftLine != null && leftLine.getX() + 10 != squareX) || (rightLine != null && rightLine.getX() + 10 != squareX)) {
                        System.out.println(square + " x");
                        square.speedX = -1 * square.speedX;
                    }
                    if ((topLine != null && topLine.getX() + 10 != squareX) || (bottomLine != null && bottomLine.getX() + 10 != squareX)) {
                        System.out.println(square + " y");
                        square.speedY = -1 * square.speedY;
                    }
                //}
            }
            //hasCollided = true;
        }
    //}

    public void testFinish(Square square, CanvasWindow canvas) {
        double squareX = square.getX();
        double squareY = square.getY();
        int squareSize = square.getSideLength();

        double left = squareX - 15;

        Rectangle zone = (Rectangle) Map.endZone.getElementAt(left, squareY + squareSize * .5);

        if (zone != null) {
            finished = true;
        }
    }

    public void setSquareColor(Color color) {
        square.setFillColor(color);
    }
}