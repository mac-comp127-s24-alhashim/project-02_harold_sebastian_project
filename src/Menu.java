import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

public class Menu extends GraphicsGroup {// this menu has two buttons that will display the two game modes to choose from, the menu is called when the main game is started.
    private static final int MENU_WIDTH = 550;
    private static final int MENU_HEIGHT = 750;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static final int BORDER_WIDTH = (CANVAS_WIDTH - MENU_WIDTH) / 2;
    private static final int BORDER_HEIGHT = (CANVAS_HEIGHT - MENU_HEIGHT) / 2;

    private Button race1Button;
    private Button dm1Button;
    private GraphicsText title;
    private boolean isMenu;

    public Menu(boolean isMenu) { // makes the menu into a boolean which can be removed when stating if its true or false.
        this.isMenu = isMenu;
        setupMenu(isMenu);
    }

    public void setupMenu(boolean ifTrue)  {// creates the first menu and adds buttons for starting the two different game modes
        Rectangle overlay = new Rectangle(-300, -300, CANVAS_WIDTH + 300, CANVAS_HEIGHT + 300);
        overlay.setFillColor(new Color(100, 100, 100, 150)); // Grey opaque overlay
        overlay.setStrokeColor(new Color(100, 100, 100, 150));
        add(overlay);

        Rectangle menuBox = new Rectangle(BORDER_WIDTH, BORDER_HEIGHT, MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        menuBox.setStrokeColor(Color.WHITE);
        add(menuBox);

        title = new GraphicsText("Square Survival");
        title.setFont(FontStyle.BOLD_ITALIC, CANVAS_HEIGHT * 0.05);
        title.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.2);
        add(title);

        race1Button = new Button("Start Race");
        race1Button.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.5);
        add(race1Button);
        
        dm1Button = new Button("Start Death Match");
        dm1Button.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.6);
        add(dm1Button);
    }

    public Button getRace1Button() {
        return race1Button;
    }

    public Button getDM1Button() {
        return dm1Button;
    }

    public boolean isMenu() {
        return isMenu;
    }

    public void removeFromCanvas() {
        CanvasWindow canvas = getCanvas();
        if (canvas != null) {
            canvas.remove(this);
        }
    }
}