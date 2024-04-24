import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

public class Menu extends GraphicsGroup {
    private static final int MENU_WIDTH = 550;
    private static final int MENU_HEIGHT = 750;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private Button Race1Button;
    private Button restartButton;
    private Button DM1Button;


    public Menu() {
        Rectangle overlay = new Rectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        overlay.setFillColor(new Color(100, 100, 100, 150)); // Grey opaque overlay
        add(overlay);

        Rectangle menuBox = new Rectangle((CANVAS_WIDTH - MENU_WIDTH) / 2, (CANVAS_HEIGHT - MENU_HEIGHT) / 2,MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        add(menuBox);

        Race1Button = new Button("Race");
        Race1Button.setPosition(250,350);
        add(Race1Button);
        DM1Button = new Button("Death Match");
        DM1Button.setPosition(225,450);
        add(DM1Button);
    }

    public Button getRace1Button() {
        return Race1Button;
    }

    public Button getDM1Button() {
        return DM1Button;
    }

    public void Restart() {
        Rectangle overlay = new Rectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        overlay.setFillColor(new Color(100, 100, 100, 150)); // Grey opaque overlay
        add(overlay);

        Rectangle menuBox = new Rectangle((CANVAS_WIDTH - MENU_WIDTH) / 2, (CANVAS_HEIGHT - MENU_HEIGHT) / 2,
                MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        add(menuBox);

        restartButton = new Button("Restart Game?");
        restartButton.setPosition(CANVAS_WIDTH / 2 - restartButton.getWidth() / 2,
                CANVAS_HEIGHT / 2 - restartButton.getHeight() / 2);
        add(restartButton);
    }
    

    public Button getRestartButton() {
        return restartButton;
    }

    public void removeFromCanvas() {
        CanvasWindow canvas = getCanvas();
        if (canvas != null) {
            canvas.remove(this);
        }
    }
}

