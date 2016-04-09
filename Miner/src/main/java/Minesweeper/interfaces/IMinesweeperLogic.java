package Minesweeper.interfaces;

public interface IMinesweeperLogic {

    void loadBoard(ICell[][] cells);

    ICell[][] sizeBoard();

    boolean shouldBlow(int x, int y);

    boolean shouldFinish();

    void check(int x, int y, boolean bomb);

    /**
     * Проверка первого хода
     * @return Если на поле нет бомб, возвращаем истину
     */
    boolean checkTheFirstMove();

    /**
     * Очистка вокруг ячейки при первом ходе
     */
    void checkAroundEmptyCell(int x, int y);

    /**
     * Генерация бомб на поле
     */
    void bombsGeneration();

    /**
     * Возвращаем количество бомб вокруг ячейки
     */
    int checkingNearbyBombs(int x, int y);

    /**
     * Проверка и открытие пустых ячеек
     */
    void openEmptyCells();
}
