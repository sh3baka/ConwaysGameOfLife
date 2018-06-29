public class Cell {
    private CellState state;
    public enum CellState {
        ALIVE, DEAD
    }

    public Cell(CellState state) {
        this.state = state;
    }

    public void update(int neighbors) {
        if (isaDeadCell()) {
            willBecomeAliveCheck(neighbors);
        } else {
            updateCellState(neighbors);
        }
    }

    public CellState getState() {
        return state;
    }

    private void updateCellState(int neighbors) {
        state = neighbors > 1 && neighbors < 4 ? CellState.ALIVE : CellState.DEAD;
    }

    private void willBecomeAliveCheck(int neighbors) {
        state =  neighbors == 3 ? CellState.ALIVE : CellState.DEAD;
    }

    private boolean isaDeadCell() {
        return state == CellState.DEAD;
    }
}
