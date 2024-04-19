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

    private Button startButton;
    private Button restartButton;
    private Button mapsButton;


    public Menu() {
        Rectangle overlay = new Rectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        overlay.setFillColor(new Color(100, 100, 100, 150)); // Grey opaque overlay
        add(overlay);

        Rectangle menuBox = new Rectangle((CANVAS_WIDTH - MENU_WIDTH) / 2, (CANVAS_HEIGHT - MENU_HEIGHT) / 2,MENU_WIDTH, MENU_HEIGHT);
        menuBox.setFillColor(Color.WHITE);
        add(menuBox);

        startButton = new Button("Start Squares Race");
        startButton.setPosition(225,350);
        add(startButton);
        mapsButton = new Button("Death Match" + "\uD83D\uDC7D"+ "(Coming Soon)");
        mapsButton.setPosition(200,450);
        add(mapsButton);
    }

    public Button getStartButton() {
        return startButton;
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

