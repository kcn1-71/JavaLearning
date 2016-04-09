package Minesweeper.gui;

import Minesweeper.interfaces.IBoardGenerator;
import Minesweeper.interfaces.IMinesweeperLogic;
import Minesweeper.logic.UserAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllersAction extends UserAction implements ActionListener, MouseListener {

    private Board board;

    public ControllersAction(IMinesweeperLogic logic, Board board, IBoardGenerator generator) {
        super(logic, board, generator);
        this.board = board;
        this.board.addMouseListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    public int returnX(MouseEvent e) {
        return e.getX() / Board.getCELL_SIZE();
    }

    public int returnY(MouseEvent e) {
        return e.getY() / Board.getCELL_SIZE();
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("X: " + returnX(e) + " Y: " + returnY(e));
        System.out.println();

        // Если ячейка уже помечена как бомба и пользователь говорит что в ячейке нет бомбы
        if (board.isSupposingBomb(returnX(e), returnY(e)) && e.getButton() != 1)  {
            board.stopSupposingBomb(returnX(e), returnY(e));
        } else if (board.isSupposingBomb(returnX(e), returnY(e)))
            select(returnX(e), returnY(e), true);
        else
            select(returnX(e), returnY(e), e.getButton() != 1);
        board.repaint();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
