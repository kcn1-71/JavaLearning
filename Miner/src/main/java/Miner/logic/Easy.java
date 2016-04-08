package Miner.logic;

import Miner.ICell;
import Miner.ILogic;
import Miner.ISaperLogic;

public class Easy implements ILogic {
    private ICell[][] ICells;

    public void loadBoard(ICell[][] ICells) {
        this.ICells = ICells;
    }

    public boolean shouldBang(int x, int y) {
        final ICell selected = this.ICells[x][y];
        return selected.isBomb() && !selected.isSupposedBomb();
    }

    public boolean finish() {
        boolean finish = false;
        for (ICell[] row : ICells){
            for(ICell ICell : row){
                finish = ( ICell.isSupposedBomb() && ICell.isBomb() ) ||
                         ( ICell.isSupposedEmpty() && !ICell.isBomb() );
            }
        }
        return finish;
    }

    public void suppose(int x, int y, boolean bomb) {
        if(bomb){
            this.ICells[x][y].supposeBomb();
        }else{
            this.ICells[x][y].supposeEmpty();
        }
    }
}
