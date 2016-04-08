package Miner;

public interface ILogic {

    void loadBoard(ICell[][] ICells);

    boolean shouldBang(int x, int y);

    boolean finish();

    void suppose(int x, int y, boolean bomb);

    boolean checkTheFirstMove();

    void clearAroundCell(int x, int y);

    void bombsGeneration();

    int checkingAroundCell(int x, int y);

    void openEmptyCells();
}
