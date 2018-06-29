import org.junit.Test;

import static org.junit.Assert.*;

public class UniverseTest {

    public static final Cell.CellState X = Cell.CellState.ALIVE;
    public static final Cell.CellState O = Cell.CellState.DEAD;

    @Test
    public void shouldStoreInitialState(){
        Cell.CellState[][] original = new Cell.CellState[][] {
                {X, O, X},
                {O, O, O},
                {O, X, X},
        };
        Universe universe = new Universe(original);

        Cell.CellState[][] actual = universe.getState();
        assertArrayEquals(original, actual);
    }

}