import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;



public class Map {
    public Wall wall;
    public static GraphicsGroup walls = new GraphicsGroup();
    public static GraphicsGroup finishLine = new GraphicsGroup();
    public static GraphicsGroup endZone = new GraphicsGroup();

    public Map() {}

    public static void walls(CanvasWindow canvas) {
        Rectangle wall = new Rectangle(47.5, 47.5, 500, 5);
        wall.setStrokeColor(Color.black);
        wall.setFillColor(Color.black);
        walls.add(wall);
        Rectangle wall2 = new Rectangle(47.5, 747.5, 500, 5);
        wall2.setStrokeColor(Color.black);
        wall2.setFillColor(Color.black);
        walls.add(wall2);
        Rectangle wall3 = new Rectangle(47.5, 597.5, 5, 150);
        wall3.setStrokeColor(Color.black);
        wall3.setFillColor(Color.black);
        walls.add(wall3);
        Rectangle wall4 = new Rectangle(47.5, 597.5, 250, 5);
        wall4.setStrokeColor(Color.black);
        wall4.setFillColor(Color.black);
        walls.add(wall4);
        Rectangle wall5 = new Rectangle(297.5, 477.5, 5, 125);
        wall5.setStrokeColor(Color.black);
        wall5.setFillColor(Color.black);
        walls.add(wall5);
        Rectangle wall6 = new Rectangle(547.5, 402.5, 5, 350);
        wall6.setStrokeColor(Color.black);
        wall6.setFillColor(Color.black);
        walls.add(wall6);
        Rectangle wall7 = new Rectangle(122.5, 477.5, 175, 5);
        wall7.setStrokeColor(Color.black);
        wall7.setFillColor(Color.black);
        walls.add(wall7);
        Rectangle wall8 = new Rectangle(122.5, 402.5, 5, 75);
        wall8.setStrokeColor(Color.black);
        wall8.setFillColor(Color.black);
        walls.add(wall8);
        Rectangle wall9 = new Rectangle(47.5, 402.5, 75, 5);
        wall9.setStrokeColor(Color.black);
        wall9.setFillColor(Color.black);
        walls.add(wall9);
        Rectangle wall10 = new Rectangle(47.5, 47.5, 5, 360);
        wall10.setStrokeColor(Color.black);
        wall10.setFillColor(Color.black);
        walls.add(wall10);
        Rectangle wall11 = new Rectangle(472.5, 397.5, 80, 5);
        wall11.setStrokeColor(Color.black);
        wall11.setFillColor(Color.black);
        walls.add(wall11);
        Rectangle wall12 = new Rectangle(472.5, 327.5, 5, 70);
        wall12.setStrokeColor(Color.black);
        wall12.setFillColor(Color.black);
        walls.add(wall12);
        Rectangle wall13 = new Rectangle(322.5, 327.5, 150, 5);
        wall13.setStrokeColor(Color.black);
        wall13.setFillColor(Color.black);
        walls.add(wall13);
        Rectangle wall14 = new Rectangle(322.5, 257.5, 5, 75);
        wall14.setStrokeColor(Color.black);
        wall14.setFillColor(Color.black);
        walls.add(wall14);
        Rectangle wall15 = new Rectangle(322.5, 257.5, 100, 5);
        wall15.setStrokeColor(Color.black);
        wall15.setFillColor(Color.black);
        walls.add(wall15);
        Rectangle wall16 = new Rectangle(422.5, 212.5, 5, 50);
        wall16.setStrokeColor(Color.black);
        wall16.setFillColor(Color.black);
        walls.add(wall16);
        Rectangle wall17 = new Rectangle(422.5, 212.5, 125, 5);
        wall17.setStrokeColor(Color.black);
        wall17.setFillColor(Color.black);
        walls.add(wall17);
        Rectangle wall18 = new Rectangle(547.5, 47.5, 5, 170);
        wall18.setStrokeColor(Color.black);
        wall18.setFillColor(Color.black);
        walls.add(wall18);
    }

    public static void addFinish(CanvasWindow canvas) {
        Rectangle finish = new Rectangle(422.5, 53.5, 5, 158);
        finish.setStrokeColor(Color.red);
        finish.setFillColor(Color.red);
        finishLine.add(finish);
    }

    public static void addEndZone(CanvasWindow canvas) {
        Rectangle zone = new Rectangle(427.5, 53.5, 120, 158);
        zone.setStrokeColor(Color.green);
        zone.setFillColor(Color.green);
        endZone.add(zone);
    }
}

