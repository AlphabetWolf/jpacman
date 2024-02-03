package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Test suite for the Board class.
 */
public class BoardTest {

    private Board board;
    private Square[][] grid;

    /**
     * Set up a board to test with.
     */
    @BeforeEach
    void setUp() {
        grid = new Square[4][5]; // 4 columns, 5 rows

        // Mock the Square objects.
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = mock(Square.class);
            }
        }

        board = new Board(grid);
    }

    /**
     * Test the getWidth method.
     */
    @Test
    void testGetWidth() {
        assertThat(board.getWidth()).isEqualTo(grid.length);
    }

    /**
     * Test the getHeight method.
     */
    @Test
    void testGetHeight() {
        assertThat(board.getHeight()).isEqualTo(grid[0].length);
    }

    /**
     * Test the squareAt method for a valid position within the board.
     */
    @Test
    void testSquareAtValidPosition() {
        int x = 1; // Valid column index
        int y = 1; // Valid row index
        assertThat(board.squareAt(x, y)).isEqualTo(grid[x][y]);
    }

    /**
     * Test the squareAt method for an invalid position outside the board.
     */
    @Test
    void testSquareAtInvalidPosition() {
        int x = 5; // Invalid column index
        int y = 5; // Invalid row index
        assertThat(board.withinBorders(x, y)).isEqualTo(false);
    }
}
