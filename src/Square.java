
import java.awt.Color;
import edu.macalester.graphics.Rectangle;


public class Square {
    private Rectangle square;
    private double speedX;
    private double speedY;
    private static final double gravity = 5; //  gravity acceleration
    private double initialX; // Initial X position
    private double initialY; // Initial Y position
    private double sideLength; // Side length of the square


    public Square(double x, double y, double sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);
        speedX = 1; // Initial speed
        speedY = 5;
        square.setFillColor(Color.RED);
        // Store initial position
        initialX = x;
        initialY = y;
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

    public double getWidth() {
        return sideLength * 2;
    }

    public double getHeight() {
        return sideLength * 2;
    }


    public void setSpeed(double speedX, double speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move(double dt) {
        // Apply's gravity to the vertical speed
        speedY += gravity * dt;
        
        // Update the Squares's position based on current velocity
        square.setCenter(square.getCenter().getX() + speedX, square.getCenter().getY() + speedY);
    }
    
}
