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

    @Test
    public void shouldUpdateCell(){
        Universe universe = new Universe(new Cell.CellState[][] { { X } });

        universe.update();
        Cell.CellState[][] actual = universe.getState();

        assertEquals(Cell.CellState.DEAD, actual[0][0]);
    }

    @Test
    public void shouldUpdateAllCells(){
        Universe universe = new Universe(new Cell.CellState[][] {
                {O, X, X},
                {X, O, X},
                {O, O, X},
        });
        Cell.CellState[][] expected = new  Cell.CellState[][] {
            {O, X, X},
            {O, O, X},
            {O, X, O}
        };

        universe.update();
        Cell.CellState[][] actual = universe.getState();

        assertArrayEquals(expected, actual);
    }
}