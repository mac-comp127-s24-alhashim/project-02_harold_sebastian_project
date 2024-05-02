import edu.macalester.graphics.Rectangle;
/**
 * Represents a wall in the game environment.
 * Walls are defined by their starting and ending coordinates.
 * Each wall is represented by a rectangle shape on the canvas.
 * Provides methods to access wall coordinates and the rectangle object.
 */
public class Wall {
    private double xStart; // Starting X coordinate of the wall
    private double yStart; // Starting Y coordinate of the wall
    private double xEnd; // Ending X coordinate of the wall
    private double yEnd; // Ending Y coordinate of the wall
    private Rectangle wall; // Rectangle object representing the wall

    /**
     * Constructs a wall with the specified coordinates and dimensions.
     * @param x The X coordinate of the starting point of the wall.
     * @param y The Y coordinate of the starting point of the wall.
     * @param width The width of the wall.
     * @param height The height of the wall.
     */
    public Wall(double x, double y, double width, double height) {
        this.xStart = x;
        this.yStart = y;
        this.xEnd = x + width; // Calculates end X coordinate
        this.yEnd = y + height; // Calculates end Y coordinate
        this.wall = new Rectangle(x, y, width, height); // Creates the rectangle representing the wall
    }

    /**
     * Gets the starting X coordinate of the wall.
     * @return The starting X coordinate.
     */
    public double getXStart() {
        return xStart;
    }

    /**
     * Gets the starting Y coordinate of the wall.
     * @return The starting Y coordinate.
     */
    public double getYStart() {
        return yStart;
    }

    /**
     * Gets the ending X coordinate of the wall.
     * @return The ending X coordinate.
     */
    public double getXEnd() {
        return xEnd;
    }

    /**
     * Gets the ending Y coordinate of the wall.
     * @return The ending Y coordinate.
     */
    public double getYEnd() {
        return yEnd;
    }

    /**
     * Gets the rectangle object representing the wall.
     * @return The rectangle object representing the wall.
     */
    public Rectangle getWall() {
        return wall;
    }
}
