import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents Map 1 in the Square Survival game.
 * Extends the Map class and provides specific setup for Map 1 elements.
 */
public class Map1 extends Map {

    /**
     * Constructs a new Map1 object.
     * Initializes the map elements by calling the superclass constructor.
     */
    public Map1() {
        super();
    }

    /**
     * Sets up the graphical elements for Map 1 on the given canvas.
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

        Rectangle finish = new Rectangle(422.5, 53.5, 5, 158);
        finish.setStrokeColor(Color.green);
        finish.setFillColor(Color.green);
        finishLine.add(finish);

        Rectangle zone = new Rectangle(427.5, 53.5, 120, 158);
        zone.setStrokeColor(Color.green);
        zone.setFillColor(Color.green);
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