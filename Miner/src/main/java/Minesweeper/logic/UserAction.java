package Minesweeper.logic;

import Minesweeper.interfaces.*;

public class UserAction implements IUserAction {

    private final IBoardGenerator generator;
    private final IBoard board;
    private final IMinesweeperLogic logic;

    public UserAction(final IMinesweeperLogic logic, final IBoard board, final IBoardGenerator generator){
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    public void initGame() {
        final ICell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    public void select(int x, int y, boolean bomb) {
        this.logic.check(x, y, bomb);
        if (this.logic.checkTheFirstMove() && !bomb) {
            this.logic.checkAroundEmptyCell(x, y);
            this.logic.bombsGeneration();
        }
        if (!bomb)
            this.logic.openEmptyCells();
        if (this.logic.shouldBlow(x, y)) {
            this.board.drawLose();
        } else
            this.board.drawCell(x, y);
        if (this.logic.shouldFinish() && !this.logic.shouldBlow(x, y))
            this.board.drawWin();

    }
}
