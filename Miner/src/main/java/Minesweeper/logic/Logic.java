package Minesweeper.logic;

import Minesweeper.gui.Cell;
import Minesweeper.interfaces.ICell;
import Minesweeper.interfaces.IMinesweeperLogic;

import java.util.Random;

public class Logic implements IMinesweeperLogic {


    private int countBombs = 10;
    private int boardSize = 9;
    private ICell[][] cells;


    public void loadBoard(ICell[][] cells) {
        this.cells = cells;
    }

    public ICell[][] sizeBoard() {
        return new ICell[boardSize][boardSize];
    }


    public boolean shouldBlow(int x, int y) {
        final ICell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isSupposingBomb() && selected.isChecked();
    }

    public boolean shouldFinish() {
        boolean finish = false;
        int check = 0;
        for (ICell[] row : this.cells)
            for (ICell cell : row)
                if ((cell.isSupposingBomb() && cell.isBomb()) ||
                        (cell.isChecked() && !cell.isBomb()) || (!cell.isChecked() && cell.isBomb())) {
                    check++;
                }
        if (check == (boardSize * boardSize))
            finish = true;
        return finish;
    }

    public void check(int x, int y, boolean bomb) {
        if (!bomb)
            this.cells[x][y].check();
        if (bomb && !this.cells[x][y].isChecked())
            this.cells[x][y].supposingBomb();
    }

    public boolean checkTheFirstMove() {
        boolean check = true;
        root:
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                if (this.cells[i][j].isBomb()) {
                    check = false;
                    break root;
                }
        return check;
    }

    public void checkAroundEmptyCell(int x, int y) {
        if (cells.length > 3) {
            if (y > 0) check(x, y - 1, false);
            if (y + 1 < boardSize) check(x, y + 1, false);
            if (x > 0) check(x - 1, y, false);
            if (x + 1 < boardSize) check(x + 1, y, false);
            if (x > 0 && y > 0) check(x - 1, y - 1, false);
            if (x + 1 < boardSize && y + 1 < boardSize) check(x + 1, y + 1, false);
            if (x > 0 && y + 1 < boardSize) check(x - 1, y + 1, false);
            if (x + 1 < boardSize && y > 0) check(x + 1, y - 1, false);
        }
    }

    public void bombsGeneration() {
        Random random = new Random();
        int sumBombs = this.countBombs;
        while (sumBombs > 0) {
            int row = random.nextInt(boardSize);
            int column = random.nextInt(boardSize);
            if (!this.cells[row][column].isBomb() && !this.cells[row][column].isChecked()) {
                this.cells[row][column] = new Cell(true);
                sumBombs--;
            }
        }
    }

    public int checkingNearbyBombs(int x, int y) {
        int bombCount = 0;

        if (y > 0 && cells[x][y - 1].isBomb()) bombCount++;
        if (x > 0 && cells[x - 1][y].isBomb()) bombCount++;
        if (y > 0 && x > 0 && cells[x - 1][y - 1].isBomb()) bombCount++;
        if (y + 1 < boardSize && cells[x][y + 1].isBomb()) bombCount++;
        if (x + 1 < boardSize && cells[x + 1][y].isBomb()) bombCount++;
        if (x + 1 < boardSize && y + 1 < boardSize && cells[x + 1][y + 1].isBomb()) bombCount++;
        if (x + 1 < boardSize && y > 0 && cells[x + 1][y - 1].isBomb()) bombCount++;
        if (x > 0 && y + 1 < boardSize && cells[x - 1][y + 1].isBomb()) bombCount++;
        this.cells[x][y].setNearbyBombs(bombCount);
        return bombCount;
    }

    public void openEmptyCells() {
        int check = 1, sumEmpty = 0;

        while (check != sumEmpty) {
            check = sumEmpty;
            // Проходим поле и проверяем пустые ячейки
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    // Если ячейка пустая и мы её ещё не проверяли
                    if (!cells[i][j].isChecked()) {
                        // Если возле ячейки нет бомб
                        if (checkingNearbyBombs(i, j) == 0) {
                            sumEmpty++;
                            // Открываем рядом стоящие ячейки
                            checkAroundEmptyCell(i, j);
                            // Помечаем данную ячейку как просмотренную
                            cells[i][j].check();
                        }
                    }
                }
            }
        }
    }
}
