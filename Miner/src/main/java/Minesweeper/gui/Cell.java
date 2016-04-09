package Minesweeper.gui;

import Minesweeper.interfaces.ICell;

import java.awt.*;

public class Cell implements ICell<Graphics> {

    private boolean bomb;
    private boolean checked = false;
    private boolean supposing = false;
    private int countNearbyBombs;

    public Cell(boolean bomb){
        this.bomb=bomb;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isBomb() {
        return this.bomb;
    }

    public boolean isSupposingBomb() {
        return this.supposing;
    }

    public void setNearbyBombs(int countNearbyBombs) {
        this.countNearbyBombs = countNearbyBombs;
    }

    public int getNearbyBombs() {
        return this.countNearbyBombs;
    }

    public void supposingBomb() {
        this.supposing = true;
    }

    public void stopSupposingBomb() {
        this.supposing = false;
    }

    public void check() {
        this.checked = true;
    }

    private void switchColor(Graphics paint, int c) {
        switch (c) {
            case 1:
                paint.setColor(new Color(0, 13, 255));
                break;
            case 2:
                paint.setColor(new Color(45, 146, 40));
                break;
            case 3:
                paint.setColor(new Color(255, 0, 0));
                break;
            case 4:
                paint.setColor(new Color(34, 44, 118));
                break;
            case 5:
                paint.setColor(new Color(136, 96, 44));
                break;
            case 6:
            case 7:
            case 8:
                paint.setColor(Color.black);
                break;
        }

    }

    public void draw(Graphics paint, int x, int y, boolean real) {
        paint.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

        paint.setColor(new Color(187, 187, 187));
        paint.drawRect(x * Board.getCELL_SIZE(), y * Board.getCELL_SIZE(), Board.getCELL_SIZE(), Board.getCELL_SIZE());

        x = x * Board.getCELL_SIZE() + 16;
        y = y * Board.getCELL_SIZE() + 25;

        if (real) {
            if (this.isBomb()) {
                paint.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
                paint.setColor(Color.red);
                paint.drawString("*", x - 4, y + 15);
            } else if (this.getNearbyBombs() > 0) {
                switchColor(paint, this.getNearbyBombs());
                paint.drawString(String.valueOf(this.getNearbyBombs()), x, y);
            }
        } else {
            if (this.isSupposingBomb()) {
                paint.drawLine(x - 16, y - 25, x + 25, y + 15);
                paint.drawLine(x + 25, y - 25, x - 16, y + 15);
                paint.setColor(Color.black);
                paint.drawString("?", x, y);
            } else if (this.getNearbyBombs() > 0) {
                switchColor(paint, this.getNearbyBombs());
                paint.drawString(String.valueOf(this.getNearbyBombs()), x, y);
            } else {
                paint.drawLine(x - 16, y - 25, x + 25, y + 15);
                paint.drawLine(x + 25, y - 25, x - 16, y + 15);
            }
        }
    }
}
