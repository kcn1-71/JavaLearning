package Miner;

public interface IBoard {

    void drawBoard(ICell[][] ICells);

    void drawCell(int x, int y);

    void drawBang();

    void drawCongratulate();

    void stopSupposeBomb(int x, int y);

    boolean returnSupposeBomb(int x, int y);
}
