package com.company;

import javax.swing.*;
import java.awt.*;

public class Draw extends Canvas {
    final Toolkit tk = Toolkit.getDefaultToolkit();
    private final int WIDTH = (int) tk.getScreenSize().getWidth();
    private final int HEIGHT = (int) tk.getScreenSize().getHeight();

    private int maxIterations = 61; // increasing this will give you a more detailed fractal
    private double xLim = 2.5;                           // x = current tested value; xLim = boundary;
    private double yLim = xLim * HEIGHT / WIDTH;         // y = current tested value; yLim = boundary;
    private double centerX = -1, centerY = 0;

    private double diff = xLim / WIDTH / 2; // Limit is 0.0005
    private double magSize = WIDTH / (2 * xLim / diff) * 1 / diff;
    private int ORIGIN_X = WIDTH / 2, ORIGIN_Y = HEIGHT / 2;

    public Draw() {
        setSize(WIDTH, HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        Color[] arrColor = new Color[62];
        arrColor[0] = Color.BLACK;
        arrColor[1] = new Color(100, 0, 100);
        arrColor[21] = Color.WHITE;
        arrColor[41] = new Color(0, 0, 0);
        arrColor[61] = Color.BLACK;
        for (int i = 2; i < 21; i++)
            arrColor[i] = arrColor[i - 1].brighter();
        for (int i = 22; i < 41; i++)
            arrColor[i] = arrColor[i - 1].brighter();
        for (int i = 42; i < 61; i++)
            arrColor[i] = arrColor[i - 1].brighter();


        Complex z = new Complex(0, 0);
        Complex c = new Complex(0, 0);
        int iterations, graphX, graphY;
        for (double x = -xLim; x <= xLim; x += diff) {
            for (double y = -yLim; y <= yLim; y += diff) {
                iterations = 0;
                c.update(x + centerX, y + centerY);
                z.nullify();
                while (z.r < 2 && iterations < maxIterations) {
                    z.square().add(c);
                    iterations++;
                }
                g.setColor(arrColor[iterations]);
                graphX = ORIGIN_X + (int) (x * magSize);
                graphY = ORIGIN_Y + (int) (y * (-magSize));
                g.drawLine(graphX, graphY, graphX, graphY);

            }
        }
    }
}
