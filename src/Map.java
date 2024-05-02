import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.ui.Button;
/**
 * Represents a map in the Square Survival game.
 * Each map contains walls, a finish line, an end zone, squares, and buttons for restarting or quitting the game.
 * Provides methods to access and manipulate these elements.
 * This class serves as the base class for specific maps (e.g., Map1, Map2).
 */
public class Map {
    protected GraphicsGroup walls;       // Represents the walls on the map
    protected GraphicsGroup finishLine;  // Represents the finish line on the map
    protected GraphicsGroup endZone;     // Represents the end zone on the map
    protected List<Square> squares;      // Represents the squares on the map
    protected GraphicsGroup squareGroup; // Represents the group of squares on the map
    protected Button restartButton;      // Button for restarting the game
    protected Button quitButton;         // Button for quitting the game
    protected double canvasWidth;        // Width of the canvas
    protected double canvasHeight;       // Height of the canvas

    /**
     * Constructs a new Map object.
     * Initializes the graphical elements and buttons for the map.
     */
    public Map() {
        walls = new GraphicsGroup();
        finishLine = new GraphicsGroup();
        endZone = new GraphicsGroup();
        squares = new ArrayList<>();
        squareGroup = new GraphicsGroup();
        restartButton = new Button("Back to Main Menu");
        quitButton = new Button("Quit Game");
    }

    /**
     * Adds a square to the map.
     * @param square The square to add to the map.
     */
    protected void addSquare(Square square) {
        squares.add(square);
        squareGroup.add(square.getSquare());
    }

    /**
     * Gets the graphical group representing the walls on the map.
     * @return The graphical group representing the walls.
     */
    public GraphicsGroup getWalls() {
        return walls;
    }

    /**
     * Gets the graphical group representing the finish line on the map.
     * @return The graphical group representing the finish line.
     */
    public GraphicsGroup getFinishLine() {
        return finishLine;
    }

    /**
     * Gets the graphical group representing the end zone on the map.
     * @return The graphical group representing the end zone.
     */
    public GraphicsGroup getEndZone() {
        return endZone;
    }

    /**
     * Gets the list of squares on the map.
     * @return The list of squares.
     */
    public List<Square> getSquares() {
        return squares;
    }

    /**
     * Gets the graphical group representing the squares on the map.
     * @return The graphical group representing the squares.
     */
    public GraphicsGroup getSquareGroup() {
        return squareGroup;
    }

    /**
     * Gets the restart button for the map.
     * @return The restart button.
     */
    public Button getRestartButton() {
        return restartButton;
    }
    
    /**
     * Gets the quit button for the map.
     * @return The quit button.
     */
    public Button getQuitButton() {
        return quitButton;
    }
}