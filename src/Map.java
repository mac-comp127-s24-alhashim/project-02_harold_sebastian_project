import java.awt.Color;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Rectangle;



public class Map {
    public Wall wall;
    public static GraphicsGroup walls = new GraphicsGroup();

    public Map() {}

    public static void walls(CanvasWindow canvas) {
        Rectangle wall = new Rectangle(47.5, 47.5, 5, 100);
        wall.setStrokeColor(Color.black);
        wall.setFillColor(Color.black);
        walls.add(wall);
        Rectangle wall2 = new Rectangle(47.5, 147.5, 200, 5);
        wall2.setStrokeColor(Color.black);
        wall2.setFillColor(Color.black);
        walls.add(wall2);
        // Line wall = new Line(50,50,550,50);
        // wall.setStrokeColor(Color.black);
        // wall.setStrokeWidth(4);
        // walls.add(wall);
        // Line wall2 = new Line(50,50,50,200);
        // wall2.setStrokeColor(Color.black);
        // wall2.setStrokeWidth(4);
        // walls.add(wall2);
        // Line wall3 = new Line(550,50,550,325);
        // wall2.setStrokeColor(Color.black);
        // wall3.setStrokeWidth(4);
        // walls.add(wall3);
        // Line wall4 = new Line(50,200,300,200);
        // wall2.setStrokeColor(Color.black);
        // wall4.setStrokeWidth(4);
        // walls.add(wall4);
        // Line wall5 = new Line(300,200,300,275);
        // wall2.setStrokeColor(Color.black);
        // wall5.setStrokeWidth(4);
        // walls.add(wall5);
        // Line wall6 = new Line(300,275,125,275);
        // wall2.setStrokeColor(Color.black);
        // wall6.setStrokeWidth(4);
        // walls.add(wall6);
        // Line wall7 = new Line(125,275,125,350);
        // wall2.setStrokeColor(Color.black);
        // wall7.setStrokeWidth(4);
        // walls.add(wall7);
        // Line wall8 = new Line(125,350,50,350);
        // wall2.setStrokeColor(Color.black);
        // wall8.setStrokeWidth(4);
        // walls.add(wall8);
        // Line wall9 = new Line(550,325,475,325);
        // wall2.setStrokeColor(Color.black);
        // wall9.setStrokeWidth(4);
        // walls.add(wall9);
        // Line wall10 = new Line(475,325,475,400);
        // wall2.setStrokeColor(Color.black);
        // wall10.setStrokeWidth(4);
        // walls.add(wall10);
        // Line wall11 = new Line(475,400,300,400);
        // wall2.setStrokeColor(Color.black);
        // wall11.setStrokeWidth(4);
        // walls.add(wall11);
        // Line wall12 = new Line(300,400,300,475);
        // wall2.setStrokeColor(Color.black);
        // wall12.setStrokeWidth(4);
        // walls.add(wall12);
        // Line wall13 = new Line(300,475,400,475);
        // wall2.setStrokeColor(Color.black);
        // wall13.setStrokeWidth(4);
        // walls.add(wall13);
        // Line wall14 = new Line(400,475,400,550);
        // wall2.setStrokeColor(Color.black);
        // wall14.setStrokeWidth(4);
        // walls.add(wall14);
        // Line wall15 = new Line(50,750,400,750);
        // wall2.setStrokeColor(Color.black);
        // wall15.setStrokeWidth(4);
        // walls.add(wall15);
        // Line wall16 = new Line(50,750,50,350);
        // wall2.setStrokeColor(Color.black);
        // wall16.setStrokeWidth(4);
        // walls.add(wall16);
    }
}

