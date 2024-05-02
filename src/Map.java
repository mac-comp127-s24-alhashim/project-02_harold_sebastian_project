import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.ui.Button;

public class Map {
    protected GraphicsGroup walls;
    protected GraphicsGroup finishLine;
    protected GraphicsGroup endZone;
    protected List<Square> squares;
    protected GraphicsGroup squareGroup;
    protected Button restartButton;
    protected Button quitButton;
    protected double canvasWidth;
    protected double canvasHeight;

    public Map() {
        walls = new GraphicsGroup();
        finishLine = new GraphicsGroup();
        endZone = new GraphicsGroup();
        squares = new ArrayList<>();
        squareGroup = new GraphicsGroup();
        restartButton = new Button("Back to Main Menu");
        quitButton = new Button("Quit Game");
    }

    protected void addSquare(Square square) {
        squares.add(square);
        squareGroup.add(square.getSquare());
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

    public List<Square> getSquares() {
        return squares;
    }

    public GraphicsGroup getSquareGroup() {
        return squareGroup;
    }

    public Button getRestartButton() {
        return restartButton;
    }
    
    public Button getQuitButton() {
        return quitButton;
    }
}