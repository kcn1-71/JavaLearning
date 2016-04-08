package Miner.gui;

import Miner.ICell;

import javax.swing.*;
import java.awt.*;

public class GUICell extends JPanel implements ICell<Graphics> {

    private boolean bomb;
    private boolean supposeBomb = false;
    private boolean supposeEmpty = false;
    private int countNearby;

    private boolean checked = false;

    public GUICell(boolean bomb){this.bomb=bomb;}


    public boolean isBomb() {
        return this.bomb;
    }

    public boolean isSupposedBomb() {
        return this.supposeBomb;
    }

    public boolean isSupposedEmpty() {
        return this.supposeEmpty;
    }

    public void supposeBomb() {
        this.supposeBomb=true;
    }

    public void supposeEmpty() {
        this.supposeEmpty=true;
    }

    public void stopSupposingBomb() {
        this.supposeBomb=false;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void check() {
        this.checked=true;
    }

    public void setCountNearby(int countNearby) {
        this.countNearby = countNearby;
    }

    public void draw(Graphics paint, int x, int y, boolean real) {
        paint.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

        paint.setColor(new Color(187,187,187));
        paint.drawRect(x * GUIBoard.getPADDING(), y * GUIBoard.getPADDING(),
                GUIBoard.getPADDING(), GUIBoard.getPADDING());

        x = x * GUIBoard.getPADDING() + 16;
        y = y * GUIBoard.getPADDING() + 25;

        if (real) {
            if (this.isBomb()) {
                paint.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
                paint.setColor(Color.red);
                paint.drawString("*", x - 4, y + 15);
            }
            else if (this.countNearby>0) {
                paint.setColor(Color.black);
                paint.drawString(String.valueOf(this.countNearby), x, y);
            }
        } else {
            if (this.supposeBomb) {
                paint.drawLine(x - 16, y - 25, x + 25, y + 15);
                paint.drawLine(x + 25, y - 25, x - 16, y + 15);
                paint.setColor(Color.black);
                paint.drawString("?", x, y);
            }
            else if (this.countNearby>0) {
                paint.setColor(Color.black);
                paint.drawString(String.valueOf(this.countNearby), x, y);
            }
            else if (this.supposeEmpty) {
//				paint.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//				paint.setColor(Color.black);
//				paint.drawString("-", x - 2, y);
            }

            else {
                paint.drawLine(x - 16, y - 25, x + 25, y + 15);
                paint.drawLine(x + 25, y - 25, x - 16, y + 15);
            }
        }
    }

}
