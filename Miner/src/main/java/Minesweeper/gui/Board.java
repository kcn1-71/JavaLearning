package Minesweeper.gui;

import Minesweeper.interfaces.IBoard;
import Minesweeper.interfaces.ICell;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements IBoard {

    private ICell[][] cells;

    private static final int CELL_SIZE = 40;

    public static int getCELL_SIZE(){
        return CELL_SIZE;
    }

    private boolean real = false;

    public void drawBoard(ICell[][] cells) {
        this.cells = cells;
        real = false;
        this.repaint();
    }

    public void drawCell(int x, int y) {
        this.repaint();
    }

    public void drawLose() {
        real = true;
        this.repaint();
        //Main.setLosing("Нажмите 'OK', чтобы закрыть окно.", " К сожалению Вы проиграли");
    }

    public void drawWin() {
        real=true;
        this.repaint();
        //Main.setLosing("Нажмите 'OK', чтобы закрыть окно.", " Поздравляем! Вы выиграли!");
    }

    public boolean isSupposingBomb(int x, int y) {
        return this.cells[x][y].isSupposingBomb();
    }

    public void stopSupposingBomb(int x, int y) {
        this.cells[x][y].stopSupposingBomb();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.cells != null) {
            for (int x = 0; x != cells.length; x++) {
                for (int y = 0; y != cells[0].length; y++) {
                    cells[x][y].draw(graphics, x, y, real);
                }
            }
        }
    }
}
