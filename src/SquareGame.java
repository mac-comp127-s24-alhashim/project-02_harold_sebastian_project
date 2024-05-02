import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

public class SquareGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static CanvasWindow canvas;
    private static Menu menu;
    private static Restart restart;
    private static Map1 map1;
    private static Map2 map2;
    private static Map currentMap = null;
    private static boolean allFinished = true;
    private static boolean animationRunning = true;
    public static List<Square> squares = new ArrayList<>();
    private static List<Color> colors;
    public static List<Square> finishedSquares = new ArrayList<Square>();
    public static GraphicsGroup squareGroup = new GraphicsGroup();
    private static boolean map1Start = false;
    private static boolean map2Start = false;

    public SquareGame() {// starts the game with the menu screen, there are buttons for the game modes, for the end of the game theres buttons to quit and to restart.
        map1 = new Map1();
        map2 = new Map2();
        colors = List.of(new Color(255, 0, 128), new Color(255, 24, 0), new Color(255, 91, 0), new Color(255, 151, 0), new Color(255, 230, 0), new Color(0, 255, 230), new Color(0, 201, 255), new Color(0, 116, 255));
        canvas = new CanvasWindow("Square Survival!!!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.LIGHT_GRAY);
        menu = new Menu(true); // This creates the main menu
        restart = new Restart(false); // This creates the restart menu
        canvas.add(menu);

        menu.getRace1Button().onClick(() -> {// adds the map and squares to the canvas.
            // Instantiate Map1 and set it as the current map

            menu.removeFromCanvas();
            map1.setupMap(canvas);
            // Square square1 = new Square(400, 60, 20); // replace this with current squares to test the restart method
            // Square square2 = new Square(400, 160, 20);
            // Square square3 = new Square(400, 125, 20);
            // Square square4 = new Square(400, 90, 20);

            Square square1 = new Square(75, 715, 20);
            Square square2 = new Square(75, 680, 20);
            Square square3 = new Square(75, 645, 20);
            Square square4 = new Square(75, 610, 20);

            finishedSquares.clear();
            squares.clear();
            squares.add(square1);
            squares.add(square2);
            squares.add(square3);
            squares.add(square4);
            
            for (Square square : squares) {
                Random random = new Random();
                Color color = colors.get(random.nextInt(8));
                square.setSquareColor(color);
                for (Square otherSquare : squares) {
                    while (square.equals(otherSquare) == false && color.equals(otherSquare.getSquareColor())) {
                        color = colors.get(random.nextInt(8));
                        square.setSquareColor(color);
                    }
                }
                square.setStrokeWidth(1.7);
                //square.setStrokeColor(Color.TRANSLUCENT);
            }

            squareGroup.add(square1.getSquare());
            squareGroup.add(square2.getSquare());
            squareGroup.add(square3.getSquare());
            squareGroup.add(square4.getSquare());
            canvas.add(squareGroup);

            map1Start = true;

            map1.getRestartButton().onClick(() -> restartGame());
            map1.getQuitButton().onClick(() -> System.exit(0));
        });

        // Maps button event
        menu.getDM1Button().onClick(() -> {// when the button is clicked,  map2 and the squares are added to the canvas.
            // Instantiate Map2 and set it as the current map
            menu.removeFromCanvas();
            map2.setupMap(canvas);

            // Square square1 = new Square(150, 440, 20); // test restart
            // Square square2 = new Square(150, 461, 20);
            // Square square3 = new Square(150, 482, 20);
            // Square square4 = new Square(150, 503, 20);

            // Square square1 = new Square(75, 715, 20); //unused
            // Square square2 = new Square(75, 680, 20);
            // Square square3 = new Square(75, 645, 20);
            // Square square4 = new Square(75, 610, 20);

            Square square1 = new Square(300, 700, 20);
            Square square2 = new Square(300, 650, 20);
            Square square3 = new Square(300, 600, 20);
            Square square4 = new Square(300, 550, 20);

            finishedSquares.clear();
            squares.clear();
            squares.add(square1);
            squares.add(square2);
            squares.add(square3);
            squares.add(square4);
            
            for (Square square : squares) {
                Random random = new Random();
                Color color = colors.get(random.nextInt(8));
                square.setSquareColor(color);
                for (Square otherSquare : squares) {
                    while (square.equals(otherSquare) == false && color.equals(otherSquare.getSquareColor())) {
                        color = colors.get(random.nextInt(8));
                        square.setSquareColor(color);
                    }
                }
                square.setStrokeWidth(1.7);
                //square.setStrokeColor(Color.TRANSLUCENT);
            }

            squareGroup.add(square1.getSquare());
            squareGroup.add(square2.getSquare());
            squareGroup.add(square3.getSquare());
            squareGroup.add(square4.getSquare());
            canvas.add(squareGroup);

            map2Start = true;

            map2.getRestartButton().onClick(() -> restartGame());
            map2.getQuitButton().onClick(() -> System.exit(0));
        });

        canvas.animate(() -> {
            if (!animationRunning) {
                return;
            }
            if (map1Start == false && map2Start == false) {
                return;
            }

            //System.out.println("Number of squares: " + squares.size());
            if (allFinished) {
                Iterator<Square> iterator = squares.iterator();
                while (iterator.hasNext()) {
                    Square square = iterator.next();
                    if (!square.finished) {
                        square.move();
                        if (map1Start == true) {
                            currentMap = map1;
                        }
                        else if (map2Start == true) {
                            currentMap = map2;
                        }
                        square.testTouchingWall(square, canvas, currentMap);
                        square.testTouchingSquare(squares, canvas);
                        square.testFinish(square, canvas, currentMap);
                        if (square.finished) {
                            iterator.remove();;
                        }
                    }
                }
            }
            if (squares.size() == 0 && currentMap.equals(map1)) {// Check if all squares are finished
                allFinished = true;
                animationRunning = false; // Stops animation loop
                canvas.removeAll();
                canvas.add(restart);
                restart.restartGame(true);

            }
            else if (squares.size() <= 1 && currentMap.equals(map2)) {// Check if 1 square left
                allFinished = true;
                animationRunning = false; // Stops animation loop
                canvas.removeAll();
                canvas.add(restart);
                restart.restartGame(true);

            }

            restart.getRestartButton().onClick(() -> restartGame());
            restart.getQuitButton().onClick(() -> System.exit(0));
        });

        menu.getQuitButton().onClick(() -> System.exit(0));
    }

    public static void restartGame() {// resets everything and removes everything from the canvas before restarting the game.
        squareGroup.removeAll();
        map1Start = false;
        map2Start = false;
        canvas.removeAll();
        canvas.add(menu);
        animationRunning = true;
    }
    
    public static void main(String[] args) {
        new SquareGame();
    }
}