package Minesweeper.interfaces;

public interface ICell<T> {

    /**
     * флаг о проверке ячейки
     */
    boolean isChecked();

    /**
     * флаг что в ячейке бомба
     */
    boolean isBomb();

    /**
     *флаг о пометке ячейки (юзер предполагает что там бомба)
     */
    boolean isSupposingBomb();

    public boolean isSupposingEmpty();

    public void supposingEmpty();

    void setNearbyBombs(int countNearbyBombs);
    /**
     * возвращает значение поля NearbyBombs
     * (каждая ячейка знает сколько бомб в соседних восьми ячейках)
     * @return NearbyBombs
     */
    int getNearbyBombs();


    void supposingBomb();
    /**
     * сбрасываем флаг с предположением
     */
    void stopSupposingBomb();

    /**
     * ставим флаг о проверке
     */
    void check();

    /**
     * @param graphics передаём объект через который будем рисовать
     * @param x положение клетки
     * @param y
     * @param real рисуем реальное поле или то которое получилось во время игры
     */
    void draw(T graphics, int x, int y, boolean real);
}
