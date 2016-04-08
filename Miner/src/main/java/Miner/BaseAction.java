package Miner;

public class BaseAction implements IUserAction {
    private final IGeneratorBoard generator;
    private final IBoard board;
    private final ILogic logic;

    BaseAction(final ILogic logic, final IBoard board, final IGeneratorBoard generator) {
        this.board = board;
        this.generator = generator;
        this.logic = logic;
    }

    public void initGame() {
        final ICell[][] ICells = generator.generate();
        this.board.drawBoard(ICells);
        this.logic.loadBoard(ICells);
    }

    public void select(int x, int y, boolean bomb) {
        this.logic.suppose(x,y,bomb);
        this.board.drawCell(x,y);
        if (this.logic.shouldBang(x,y)){
            this.board.drawBang();
        }
        if(this.logic.finish()){
            this.board.drawCongratulate();
        }
    }

}
