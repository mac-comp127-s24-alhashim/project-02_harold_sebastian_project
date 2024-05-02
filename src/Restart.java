import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

public class Restart extends GraphicsGroup{ // handles the restart menu, its given a boolean parameter wether to show the restart screen when the game is over.
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

    public Restart(boolean isRestartMenu) {// makes restart into a boolean to control its visibility. true = visible, false = not visible.
        this.isRestartMenu = isRestartMenu;
        restartGame(isRestartMenu);
    }
    public void restartGame(boolean isRestartMenu) {// creates the graphics objects on the canvas when called by the main 

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
    
    public Button getRestartButton() {
        return restartButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    public boolean isRestartMenu() {
        return isRestartMenu;
    }

    public void removeFromCanvas() {
        CanvasWindow canvas = getCanvas();
        if (canvas != null) {
            canvas.remove(this);
        }
    }
}