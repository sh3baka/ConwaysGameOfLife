public class Universe {
    private Cell[][] state;

    public Universe(Cell.CellState[][] cellStates) {
        state = new Cell[cellStates.length][];
        for (int row = 0; row < cellStates.length; row++){
            state[row] = new Cell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++){
                state[row][col] = new Cell(cellStates[row][col]);
            }
        }
    }

    public Cell.CellState[][] getState() {
        Cell.CellState[][] cellStates = new Cell.CellState[state.length][];
        for (int row = 0; row < state.length; row++){
            cellStates[row] = new Cell.CellState[state[row].length];
            for (int col = 0; col < state[row].length; col++){
                cellStates[row][col] = state[row][col].getState();
            }
        }
        return cellStates;
    }

    public void update() {
        Cell.CellState[][] stateCopy = getState();
        updateUniverseState(stateCopy);
    }

    private int getNumberOfAliveMembers(Cell.CellState[][] state, int row, int col) {
        return getNumberOfAliveMembersAboveCell(state, row, col) +
                getNumberOfAliveMembersOnSidesOfCell(state, row, col) +
                getNumberOfAliveMembersBelowCell(state, row, col);
    }

    private int getNumberOfAliveMembersBelowCell(Cell.CellState[][] state, int row, int col) {
        int numberOfAliveMembers = 0;

        if (row < state.length - 1) {
            int rowBelow = row + 1;
            if (col > 0) {
                if (state[rowBelow][col - 1] == Cell.CellState.ALIVE)
                    numberOfAliveMembers++;
            }
            if (state[rowBelow][col] == Cell.CellState.ALIVE)
                numberOfAliveMembers++;
            if (col < state[row].length -1){
                if (state[rowBelow][col + 1] == Cell.CellState.ALIVE)
                    numberOfAliveMembers++;
            }
        }
        return numberOfAliveMembers;
    }

    private int getNumberOfAliveMembersOnSidesOfCell(Cell.CellState[][] state, int row, int col) {
        int numberOfAliveMembers = 0;

        if (col > 0) {
            if (state[row][col - 1] == Cell.CellState.ALIVE)
                numberOfAliveMembers++;
        }
        if (col < state[row].length -1){
            if (state[row][col + 1] == Cell.CellState.ALIVE)
                numberOfAliveMembers++;
        }
        return numberOfAliveMembers;
    }

    private int getNumberOfAliveMembersAboveCell(Cell.CellState[][] state, int row, int col) {
        int numberOfAliveMembers = 0;

        if (row > 0) {
            int rowAbove = row - 1;
            if (col > 0) {
                if (state[rowAbove][col - 1] == Cell.CellState.ALIVE)
                    numberOfAliveMembers++;
            }
            if (state[rowAbove][col] == Cell.CellState.ALIVE)
                numberOfAliveMembers++;
            if (col < state[row].length -1){
                if (state[rowAbove][col + 1] == Cell.CellState.ALIVE)
                    numberOfAliveMembers++;
            }
        }
        return numberOfAliveMembers;
    }

    private void updateUniverseState(Cell.CellState[][] stateCopy) {
        for (int row = 0; row < state.length; row++){
            for (int col = 0; col < state[row].length; col++){
                int numberOfAliveMembers = getNumberOfAliveMembers(stateCopy, row, col);
                state[row][col].update(numberOfAliveMembers);
            }
        }
    }
}
