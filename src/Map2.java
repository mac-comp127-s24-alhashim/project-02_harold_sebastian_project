import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

public class Map2 extends Map {

    public Map2() { 
        super();
    }

    public void setupMap(CanvasWindow canvas) {
        // Square square1 = new Square(75, 715, 20);
        // Square square2 = new Square(75, 680, 20);
        // Square square3 = new Square(75, 645, 20);
        // Square square4 = new Square(75, 610, 20);

        // square1.setSquareColor(Color.GREEN);
        // square2.setSquareColor(Color.CYAN);
        // square3.setSquareColor(Color.RED);
        // square4.setSquareColor(Color.ORANGE);

        // addSquare(square1);
        // addSquare(square2);
        // addSquare(square3);
        // addSquare(square4);

        Rectangle wall = new Rectangle(0, 0, 600, 52.5);
        wall.setStrokeColor(Color.PINK);
        wall.setFillColor(Color.GRAY);
        walls.add(wall);
        Rectangle wall2 = new Rectangle(0, 747.5, 600, 52.5);
        wall2.setStrokeColor(Color.GRAY);
        wall2.setFillColor(Color.GRAY);
        walls.add(wall2);
        Rectangle wall3 = new Rectangle(0, 0, 52.5, 800);
        wall3.setStrokeColor(Color.PINK);
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
        wall6.setFillColor(Color.PINK);
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
        wall9.setFillColor(Color.PINK);
        walls.add(wall9);
        Rectangle wall10 = new Rectangle(300, 125, 50, 50);
        wall10.setStrokeColor(Color.GRAY);
        wall10.setFillColor(Color.GRAY);
        walls.add(wall10);

        Rectangle finish = new Rectangle(422.5, 53.5, 5, 158);
        finish.setStrokeColor(Color.red);
        finish.setFillColor(Color.PINK);
        finishLine.add(finish);

        Rectangle zone = new Rectangle(427.5, 53.5, 120, 158);
        zone.setStrokeColor(Color.green);
        zone.setFillColor(Color.PINK);
        endZone.add(zone);

        canvas.add(walls);
        canvas.add(finishLine);
        canvas.add(endZone);
        // canvas.add(squareGroup);
    }

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