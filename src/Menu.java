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

    private Button race1Button;
    private Button restartButton;
    private Button dm1Button;
    private Button quitButton;
    
    public Menu(boolean isRestartMenu) {
        Rectangle overlay = new Rectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        overlay.setFillColor(new Color(100, 100, 100, 150)); // Grey opaque overlay
        add(overlay);

        Rectangle menuBox = new Rectangle((CANVAS_WIDTH - MENU_WIDTH) / 2, (CANVAS_HEIGHT - MENU_HEIGHT) / 2,
                MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        add(menuBox);

        if (isRestartMenu) {
            restartButton = new Button("Restart Game?");
            restartButton.setPosition(CANVAS_WIDTH / 2 - restartButton.getWidth() / 2,
                    CANVAS_HEIGHT / 2 - restartButton.getHeight() / 2);
            add(restartButton);
            
            quitButton = new Button("Quit Game?");
            quitButton.setPosition(CANVAS_WIDTH / 2 - quitButton.getWidth() / 2,
                    CANVAS_HEIGHT / 2 - quitButton.getHeight() / 2 + 50); // Adjusted position for the quit button
            add(quitButton);
        } else {
            race1Button = new Button("Race");
            race1Button.setPosition(250, 350);
            add(race1Button);

            dm1Button = new Button("Death Match");
            dm1Button.setPosition(225, 450);
            add(dm1Button);
        }
    }

    public Button getRace1Button() {
        return race1Button;
    }

    public Button getDM1Button() {
        return dm1Button;
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
