import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.*;

public class Menu extends GraphicsGroup {
    private static final int MENU_WIDTH = 550;
    private static final int MENU_HEIGHT = 750;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static final int BORDER_WIDTH = (CANVAS_WIDTH - MENU_WIDTH) / 2;
    private static final int BORDER_HEIGHT = (CANVAS_HEIGHT - MENU_HEIGHT) / 2;

    private Button race1Button;
    private Button restartButton;
    private Button DM1Button;
    private GraphicsText title;


    public Menu() {
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
        Race1Button = new Button("Start Race");
        Race1Button.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.5);
        add(Race1Button);
        DM1Button = new Button("Start Death Match");
        DM1Button.setCenter(BORDER_WIDTH + MENU_WIDTH / 2, BORDER_HEIGHT + MENU_HEIGHT * 0.6);
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
