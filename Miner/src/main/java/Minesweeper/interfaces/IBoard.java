package Minesweeper.interfaces;

public interface IBoard {

    /**
     * рисуем доску
     * @param cells массив значений ячеек
     */
    void drawBoard(ICell[][] cells);

    /**
     * рисуем(перерисовываем) ячейку
     * @param x координаты ячейки
     * @param y
     */
    void drawCell(int x, int y);

    /**
     * рисуем поле при поражении
     */
    void drawLose();

    /**
     * рисуем поле при победе
     */
    void drawWin();

    boolean isSupposingBomb(int x, int y);

    void stopSupposingBomb(int x, int y);
}
