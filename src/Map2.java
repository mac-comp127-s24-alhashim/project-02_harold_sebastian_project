import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
/**
 * Represents Map 2 in the Square Survival game.
 * Extends the Map class and provides specific setup for Map 2 elements.
 */
public class Map2 extends Map {

    /**
     * Constructs a new Map2 object.
     * Initializes the map elements by calling the superclass constructor.
     */
    public Map2() {
        super();
    }

    /**
     * Sets up the graphical elements for Map 2 on the given canvas.
     * @param canvas The CanvasWindow on which to set up the map.
     */
    public void setupMap(CanvasWindow canvas) {
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        
        Rectangle wall = new Rectangle(0, 0, 600, 52.5);
        wall.setStrokeColor(Color.GRAY);
        wall.setFillColor(Color.GRAY);
        walls.add(wall);
        // Add more walls...

        Rectangle zone = new Rectangle(250, 325, 100, 150);
        zone.setStrokeColor(Color.red);
        zone.setFillColor(Color.red);
        endZone.add(zone);

        canvas.add(walls);
        canvas.add(finishLine);
        canvas.add(endZone);
        
        restartButton.setCenter(canvasWidth / 3, canvasHeight * 0.03);
        canvas.add(restartButton);
        
        quitButton.setCenter(canvasWidth / 3 * 2, canvasHeight * 0.03);
        canvas.add(quitButton);
    }

    // Methods inherited from the Map class can be used as-is, so no need to override them.
    public GraphicsGroup getWalls() {
        return walls;
    }

    public GraphicsGroup getFinishLine() {
        return finishLine;
    }

    public GraphicsGroup getEndZone() {
        return endZone;
    }

    public GraphicsGroup getSquareGroup() {
        return squareGroup;
    }
}