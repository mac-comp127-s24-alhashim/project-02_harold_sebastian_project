import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the Square class.
 */
public class SquareTest {
    private Square square;

    /**
     * Sets up a Square object before each test method.
     */
    @BeforeEach
    void setUp() {
        square = new Square(100, 100, 50);
    }

    /**
     * Tests the constructor of the Square class.
     */
    @Test
    void testConstructor() {
        assertEquals(125, square.getX());
        assertEquals(125, square.getY());
        assertEquals(0, square.getSideLength());
    }

    /**
     * Tests the move method of the Square class.
     */
    @Test
    void testMove() {
        double initialX = square.getX();
        double initialY = square.getY();

        square.move();

        assertNotEquals(initialX, square.getX());
        assertNotEquals(initialY, square.getY());
    }

    /**
     * Tests the setSquareColor and getSquareColor methods of the Square class.
     */
    @Test
    void testSetAndGetSquareColor() {
        Color color = Color.RED;
        square.setSquareColor(color);

        assertEquals(color, square.getSquareColor());
    }
}
