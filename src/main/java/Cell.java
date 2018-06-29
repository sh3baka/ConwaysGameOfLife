public class Cell {
    CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public enum CellState {
        ALIVE, DEAD
    }

    public CellState getNextState(int i) {
        if (state == CellState.DEAD) {
            return i == 3 ? CellState.ALIVE : CellState.DEAD;
        } else {
            return i > 1 && i < 4 ? CellState.ALIVE : CellState.DEAD;
        }
    }
}
