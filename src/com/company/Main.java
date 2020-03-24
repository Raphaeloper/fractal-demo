package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {

    public Main() {
        setTitle("Mandlebrot");
        Canvas canvas = new Draw();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);
        add(canvas);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }


}
