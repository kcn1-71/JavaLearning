package Miner.gui;

import Miner.IBoard;
import Miner.ICell;

import javax.swing.*;
import java.awt.*;

public class GUIBoard extends JPanel implements IBoard {

    public static final int PADDING = 40;
    public boolean real = false;
    public ICell<Graphics>[][] cells;

    public static int getPADDING() {
        return PADDING;
    }

    public void drawBoard(ICell[][] cells) {
        this.cells = cells;
        real = false;
        this.repaint();
    }

    public void drawCell(int x, int y) {
        this.repaint();
    }

    public void drawBang() {
        real = true;
        this.repaint();
    }

    public void drawCongratulate() {
        this.repaint();
        Main.setLosing("Нажмите 'OK', чтобы закрыть окно.", " Поздравляем! Вы выиграли!");
    }

    public void stopSupposeBomb(int x, int y) {
        this.cells[x][y].stopSupposingBomb();
    }

    public boolean returnSupposeBomb(int x, int y) {
        return this.cells[x][y].isSupposedBomb();
    }
}

