package com.company.line_drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int absDx = Math.abs(x2 - x1);
        int absDy = Math.abs(y2 - y1);

        int dX = x2 - x1;
        int dY = y2 - y1;
        int gradient = 255;

        if (absDx > absDy) {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
                dX = -dX;
                dY = -dY;
            }
            if (y2 > y1) {
                int e = 2 * dY - dX;
                for (int i = x1; i <= x2; i++) {
                    if (dX != 0) gradient = 255 * e / (2 * dX);
                    pd.drawPixel(x1, y1, new Color(255, 0, 0, 255 - Math.abs(gradient)));
                    if (e >= 0) {
                        pd.drawPixel(x1, y1 + 1, new Color(255, 0, 0, Math.abs(gradient)));
                        y1++;
                        x1++;
                        e += 2 * (dY - dX);
                    } else {
                        pd.drawPixel(x1, y1 - 1, new Color(255, 0, 0, Math.abs(gradient)));
                        x1++;
                        e += 2 * dY;
                    }
                }
            } else if (y2 < y1) {
                int e = -2 * dY - dX;
                for (int i = x1; i <= x2; i++) {
                    if (dX != 0) gradient = 255 * e / (2 * dX);
                    pd.drawPixel(x1, y1, new Color(255, 0, 0, 255 - Math.abs(gradient)));
                    if (e >= 0) {
                        pd.drawPixel(x1, y1 - 1, new Color(255, 0, 0, Math.abs(gradient)));
                        y1--;
                        x1++;
                        e += -2 * (dY + dX);
                    } else {
                        pd.drawPixel(x1, y1 + 1, new Color(255, 0, 0, Math.abs(gradient)));
                        x1++;
                        e -= 2 * dY;
                    }
                }
            } else if (y2 == y1) {
                for (int i = x1; i <= x2; i++) {
                    pd.drawPixel(x1, y1, Color.PINK);
                    x1++;
                }
            }
        } else if (absDx < absDy) {
            if (y1 > y2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
                dX = -dX;
                dY = -dY;
            }
            if (x2 > x1) {
                int e = 2 * dX - dY;
                for (int i = y1; i <= y2; i++) {
                    if (dY != 0) gradient = 255 * e / (2 * dY);
                    pd.drawPixel(x1, y1, new Color(0, 0, 0, 255 - Math.abs(gradient)));
                    if (e >= 0) {
                        pd.drawPixel(x1 + 1, y1, new Color(0, 0, 0, Math.abs(gradient)));
                        y1++;
                        x1++;
                        e += 2 * (dX - dY);
                    } else {
                        pd.drawPixel(x1 - 1, y1, new Color(0, 0, 0, Math.abs(gradient)));
                        y1++;
                        e += 2 * dX;
                    }

                }
            } else if (x2 < x1) {
                int e = -2 * dX - dY;
                for (int i = y1; i <= y2; i++) {
                    if (dY != 0) gradient = 255 * e / (2 * dY);
                    pd.drawPixel(x1, y1, new Color(0, 0, 0, 255 - Math.abs(gradient)));
                    if (e >= 0) {
                        pd.drawPixel(x1 - 1, y1, new Color(0, 0, 0, Math.abs(gradient)));
                        y1++;
                        x1--;
                        e += -2 * (dX + dY);
                    } else {
                        pd.drawPixel(x1 + 1, y1, new Color(0, 0, 0, Math.abs(gradient)));
                        y1++;
                        e -= 2 * dX;
                    }

                }
            } else if (x2 == x1) {
                for (int i = y1; i <= y2; i++) {
                    pd.drawPixel(x1, y1, Color.BLACK);
                    y1++;
                }
            }
        }
    }
}
