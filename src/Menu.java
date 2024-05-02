import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.TextAlignment;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

/**
 * Represents the main menu of the Square Survival game.
 * Provides buttons to start different game modes and options to quit the game.
 * Extends GraphicsGroup to organize graphical elements.
 */
public class Menu extends GraphicsGroup {
    private static final int MENU_WIDTH = 525;
    private static final int MENU_HEIGHT = 725;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static final int BORDER_WIDTH = (CANVAS_WIDTH - MENU_WIDTH) / 2;
    private static final int BORDER_HEIGHT = (CANVAS_HEIGHT - MENU_HEIGHT) / 2;

    private Button race1Button;
    private Button dm1Button;
    private Button quitButton;
    private GraphicsText text;
    private boolean isMenu;

    /**
     * Constructs a Menu object.
     * @param isMenu Indicates whether the menu is displayed or not.
     */
    public Menu(boolean isMenu) {
        this.isMenu = isMenu;
        setupMenu(isMenu);
    }

    /**
     * Sets up the graphical elements and buttons for the menu.
     * @param ifTrue Indicates whether the menu is displayed or not.
     */
    public void setupMenu(boolean ifTrue) {
        Rectangle overlay = new Rectangle(-300, -300, CANVAS_WIDTH + 300, CANVAS_HEIGHT + 300);
        overlay.setFillColor(Color.GRAY); // Grey opaque overlay
        overlay.setStrokeColor(new Color(100, 100, 100, 150));
        add(overlay);

        Rectangle menuBox = new Rectangle(BORDER_WIDTH, BORDER_HEIGHT, MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        menuBox.setStrokeColor(Color.BLACK);
        menuBox.setStrokeWidth(3);
        add(menuBox);

        text = new GraphicsText("Square Survival");
        text.setFont(FontStyle.BOLD_ITALIC, CANVAS_HEIGHT * 0.05);
        text.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.2);
        add(text);

        text = new GraphicsText("Welcome to Square Survival!\n\nSelect a course type:");
        text.setFont(FontStyle.BOLD, CANVAS_HEIGHT * 0.02);
        text.setAlignment(TextAlignment.CENTER);
        text.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.4);
        add(text);

        race1Button = new Button("Start Race");
        race1Button.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.55);
        add(race1Button);
        
        dm1Button = new Button("Start Death Match");
        dm1Button.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.6);
        add(dm1Button);

        quitButton = new Button("Quit Game");
        quitButton.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.8);
        add(quitButton);
        
        text = new GraphicsText("This game was inspired by @project_jdm on YouTube");
        text.setFont(FontStyle.ITALIC, CANVAS_HEIGHT * 0.02);
        text.setAlignment(TextAlignment.CENTER);
        text.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.9);
        add(text);
    }

    /**
     * Retrieves the button for starting the race game mode.
     * @return The race1Button.
     */
    public Button getRace1Button() {
        return race1Button;
    }

    /**
     * Retrieves the button for starting the death match game mode.
     * @return The dm1Button.
     */
    public Button getDM1Button() {
        return dm1Button;
    }
    
    /**
     * Retrieves the button for quitting the game.
     * @return The quitButton.
     */
    public Button getQuitButton() {
        return quitButton;
    }

    /**
     * Checks if the menu is displayed.
     * @return True if the menu is displayed, false otherwise.
     */
    public boolean isMenu() {
        return isMenu;
    }

    /**
     * Removes the menu from the canvas.
     */
    public void removeFromCanvas() {
        CanvasWindow canvas = getCanvas();
        if (canvas != null) {
            canvas.remove(this);
        }
    }
}