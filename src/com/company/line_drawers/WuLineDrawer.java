package com.company.line_drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x = x1;
        int y = y1;
    }
}
