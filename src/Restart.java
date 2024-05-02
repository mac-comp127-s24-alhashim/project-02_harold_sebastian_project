import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

/**
 * Represents the restart menu displayed when the game is over.
 * Provides buttons to restart the game or quit.
 * Extends GraphicsGroup to organize graphical elements.
 */
public class Restart extends GraphicsGroup {
    private static final int MENU_WIDTH = 525;
    private static final int MENU_HEIGHT = 725;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static final int BORDER_WIDTH = (CANVAS_WIDTH - MENU_WIDTH) / 2;
    private static final int BORDER_HEIGHT = (CANVAS_HEIGHT - MENU_HEIGHT) / 2;
    private Button restartButton;
    private Button quitButton;
    private GraphicsText title;
    private boolean isRestartMenu;

    /**
     * Constructs a Restart object.
     * @param isRestartMenu Indicates whether the restart menu is displayed or not.
     */
    public Restart(boolean isRestartMenu) {
        this.isRestartMenu = isRestartMenu;
        restartGame(isRestartMenu);
    }

    /**
     * Sets up the graphical elements and buttons for the restart menu.
     * @param isRestartMenu Indicates whether the restart menu is displayed or not.
     */
    public void restartGame(boolean isRestartMenu) {
        Rectangle overlay = new Rectangle(-300, -300, CANVAS_WIDTH + 300, CANVAS_HEIGHT + 300);
        overlay.setFillColor(Color.GRAY); // Grey opaque overlay
        overlay.setStrokeColor(new Color(100, 100, 100, 150));
        add(overlay);
    
        Rectangle menuBox = new Rectangle(BORDER_WIDTH, BORDER_HEIGHT, MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        menuBox.setStrokeColor(Color.BLACK);
        menuBox.setStrokeWidth(3);
        add(menuBox);

        title = new GraphicsText("Finished!");
        title.setFont(FontStyle.BOLD_ITALIC, CANVAS_HEIGHT * 0.05);
        title.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.2);
        add(title);

        restartButton = new Button("Back to Main Menu");
        restartButton.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.5);
        add(restartButton);
        
        quitButton = new Button("Quit Game");
        quitButton.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.6);
        add(quitButton);
    }
    
    /**
     * Retrieves the restart button.
     * @return The restartButton.
     */
    public Button getRestartButton() {
        return restartButton;
    }

    /**
     * Retrieves the quit button.
     * @return The quitButton.
     */
    public Button getQuitButton() {
        return quitButton;
    }

    /**
     * Checks if the restart menu is displayed.
     * @return True if the restart menu is displayed, false otherwise.
     */
    public boolean isRestartMenu() {
        return isRestartMenu;
    }

    /**
     * Removes the restart menu from the canvas.
     */
    public void removeFromCanvas() {
        CanvasWindow canvas = getCanvas();
        if (canvas != null) {
            canvas.remove(this);
        }
    }
}