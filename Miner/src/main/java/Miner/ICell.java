package Miner;

public interface ICell<T> {

    boolean isBomb();

    boolean isSupposedBomb();
    boolean isSupposedEmpty();

    void supposeBomb();
    void supposeEmpty();

    void stopSupposingBomb();

    boolean isChecked();

    void check();

    void setCountNearby(int count);

    void draw(T graphics, int x, int y, boolean real);
}
