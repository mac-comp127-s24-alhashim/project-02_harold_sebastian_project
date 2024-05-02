import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Test cases for the SquareCollision class.
 */
public class SquareCollisionTest {
    /**
     * Tests the handleSquareCollision method when there is a collision between squares.
     */
    @Test
    void testHandleSquareCollision_Collision() {
        // Create two squares with collision
        Square square1 = new Square(100, 100, 50);
        Square square2 = new Square(125, 125, 50);
        
        // Add squares to the list
        List<Square> squares = new ArrayList<>();
        squares.add(square1);
        squares.add(square2);
        
        // Apply collision detection
        SquareCollision.handleSquareCollision(square1, squares);
        
        // Assert that the speed has changed
        assertNotEquals(0, square1.speedX);
        assertNotEquals(0, square1.speedY);
        assertNotEquals(0, square2.speedX);
        assertNotEquals(0, square2.speedY);
    }
}
