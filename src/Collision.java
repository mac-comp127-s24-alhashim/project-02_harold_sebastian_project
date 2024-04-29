import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Collision {
    private Rectangle square;
    private double totalSpeed = 2;
    private double speedX;
    private double speedY;
    private int sideLength; // Side length of the square
    private boolean finished = false;
    private List<Rectangle> finishedSquares;
    private GraphicsText squareText;
    private int finishPlace;

    public Collision(double x, double y, int sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);

        Random rand = new Random();
        speedX = 1 + (rand.nextDouble() * totalSpeed) / 2;
        speedY = 1 + (Math.sqrt(totalSpeed * totalSpeed - speedX * speedX)) / 2;

        finishedSquares = new ArrayList<>();
    }

    public void testTouchingSquare(List<Collision> collisions, CanvasWindow canvas) {
        double squareX = square.getX();
        double squareY = square.getY();
        double squareWidth = square.getWidth();
        double squareHeight = square.getHeight();

        double top = squareY - 7.5;
        double bottom = squareY + squareHeight + 7.5;
        double left = squareX - 7.5;
        double right = squareX + squareWidth + 7.5;

        for (Collision otherCollision : collisions) {
            if (otherCollision != this) {
                double otherSquareX = otherCollision.getX();
                double otherSquareY = otherCollision.getY();
                double otherSquareWidth = otherCollision.getWidth();
                double otherSquareHeight = otherCollision.getHeight();

                double otherSquareTop = otherSquareY - otherSquareHeight / 4;
                double otherSquareBottom = otherSquareY + otherSquareHeight / 4;
                double otherSquareLeft = otherSquareX - otherSquareWidth / 4;
                double otherSquareRight = otherSquareX + otherSquareWidth / 4;

                if (right >= otherSquareLeft && left <= otherSquareRight && bottom >= otherSquareTop && top <= otherSquareBottom) {
                    double dx = otherSquareX - squareX;
                    double dy = otherSquareY - squareY;

                    double overlapX = (squareWidth + otherSquareWidth) / .1 - Math.abs(dx);
                    double overlapY = (squareHeight + otherSquareHeight) / .1 - Math.abs(dy);

                    if (overlapX < overlapY) {
                        speedX = -speedX;
                        otherCollision.setSpeedX(-otherCollision.getSpeedX());
                    } else {
                        speedY = -speedY;
                        otherCollision.setSpeedY(-otherCollision.getSpeedY());
                    }
                    break;
                }
            }
        }
    }

    public void setSquareColor(Color color) {
        square.setFillColor(color);
    }

    public Point getCenter() {
        return square.getCenter();
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

    public double getHeight() {
        return square.getHeight();
    }

    public double getWidth() {
        return square.getWidth();
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void move() {
        square.setPosition(square.getX() + speedX, square.getY() + speedY);
    }
}
