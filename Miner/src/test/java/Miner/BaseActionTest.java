package Miner;

import Miner.console.ConsoleBoard;
import Miner.console.ConsoleICell;
import Miner.logic.Easy;
import org.junit.Test;

public class BaseActionTest {

    final BaseAction action = new BaseAction(
                new Easy(),
                new ConsoleBoard(),
                new IGeneratorBoard(){
                    public ICell[][] generate() {
                        return new ICell[][]{
                                {new ConsoleICell(true),new ConsoleICell(false)},
                                {new ConsoleICell(true),new ConsoleICell(false)}};
                    }
                }
    );

    @Test
    public void successGame(){
        action.initGame();
        action.select(0,0,true);
        action.select(1,0,true);
        action.select(0,1,false);
        action.select(1,1,false);
    }

    @Test
    public void failureGame(){
        action.initGame();
        action.select(0,0,true);
        action.select(1,0,false);
    }


}
