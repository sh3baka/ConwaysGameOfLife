import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void ShouldDieWithOnlyOneNeighbour() {
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.getNextState(1);

        assertEquals(Cell.CellState.DEAD, actual);
    }
}