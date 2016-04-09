package Minesweeper.gui;

import Minesweeper.interfaces.IBoardGenerator;
import Minesweeper.interfaces.ICell;
import Minesweeper.interfaces.IMinesweeperLogic;
import Minesweeper.logic.Logic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    private static final JPanel controlPanel = new JPanel();
    private static JLabel label = new JLabel("");
    private static final Board board = new Board();

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("Сапер");
                frame.setLayout(new BorderLayout());
                frame.setSize(750, 750);
                frame.add(board, BorderLayout.CENTER);
                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.add(controlPanel, BorderLayout.PAGE_END);

                label.setVerticalAlignment(SwingConstants.TOP);
                frame.add(label, BorderLayout.EAST);

                controlPanel.setLayout(new FlowLayout());
                final JButton generate = new JButton("Начать");
                final IMinesweeperLogic logic = new Logic();
                generate.addActionListener(new ControllersAction(logic, board, new IBoardGenerator() {
                    public ICell[][] generate() {
                        ICell[][] cells = logic.sizeBoard();
                        label.setText("Флажки: 0 ");
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                cells[i][j] = new Cell(false);
                            }
                        }
                        return cells;
                    }
                }
                ));
                controlPanel.add(generate);
                center(frame);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        closePerform(frame);
                    }
                });
                frame.setVisible(true);
            }
        });
    }

    public static void center(Window w) {
        Dimension us = w.getSize();
        Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (them.width - us.width) / 2;
        int newY = (them.height - us.height) / 2;
        w.setLocation(newX, newY);
    }

    public static void closePerform(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }

    public static void setLabel(String textOnLabel) {
        label.setText(textOnLabel);
        label.repaint();
    }

    public static void setLosing(String body, String title) {
        JOptionPane.showMessageDialog(null, body, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
