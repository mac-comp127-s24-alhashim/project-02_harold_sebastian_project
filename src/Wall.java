import edu.macalester.graphics.Rectangle;

public class Wall {
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;
    private Rectangle wall;

    public Wall(double x, double y, double width, double height) {
        this.xStart = x;
        this.yStart = y;
        this.xEnd = x + width; // Calculate end X coordinate
        this.yEnd = y + height; // Calculate end Y coordinate
        this.wall = new Rectangle(x, y, width, height);
    }

    public double getXStart() { // getter methods for the Wall
        return xStart;
    }

    
    public double getYStart() {
        return yStart;
    }

    public double getXEnd() {
        return xEnd;
    }

    public double getYEnd() {
        return yEnd;
    }

    public Rectangle getWall() {
        return wall;
    }
}