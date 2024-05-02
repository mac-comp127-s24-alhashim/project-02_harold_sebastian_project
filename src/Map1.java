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
        Rectangle wall2 = new Rectangle(0, 747.5, 600, 52.5);
        wall2.setStrokeColor(Color.GRAY);
        wall2.setFillColor(Color.GRAY);
        walls.add(wall2);
        Rectangle wall3 = new Rectangle(0, 0, 52.5, 800);
        wall3.setStrokeColor(Color.GRAY);
        wall3.setFillColor(Color.GRAY);
        walls.add(wall3);
        Rectangle wall4 = new Rectangle(547.5, 0, 52.5, 800);
        wall4.setStrokeColor(Color.GRAY);
        wall4.setFillColor(Color.GRAY);
        walls.add(wall4);
        Rectangle wall5 = new Rectangle(0, 477.5, 300, 125);
        wall5.setStrokeColor(Color.GRAY);
        wall5.setFillColor(Color.GRAY);
        walls.add(wall5);
        Rectangle wall6 = new Rectangle(0, 402.5, 127.5, 125);
        wall6.setStrokeColor(Color.GRAY);
        wall6.setFillColor(Color.GRAY);
        walls.add(wall6);
        Rectangle wall7 = new Rectangle(472.5, 327.5, 127.5, 75);
        wall7.setStrokeColor(Color.GRAY);
        wall7.setFillColor(Color.GRAY);
        walls.add(wall7);
        Rectangle wall8 = new Rectangle(322.5, 257.5, 277.5, 75);
        wall8.setStrokeColor(Color.GRAY);
        wall8.setFillColor(Color.GRAY);
        walls.add(wall8);
        Rectangle wall9 = new Rectangle(422.5, 212.5, 177.5, 100);
        wall9.setStrokeColor(Color.GRAY);
        wall9.setFillColor(Color.GRAY);
        walls.add(wall9);
        Rectangle wall10 = new Rectangle(300, 125, 50, 50);
        wall10.setStrokeColor(Color.GRAY);
        wall10.setFillColor(Color.GRAY);
        walls.add(wall10);

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