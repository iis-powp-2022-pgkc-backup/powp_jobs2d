package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver {
    private ILine line;
    private int startX = 0, startY = 0;

    public LineDrawerAdapter(ILine line) {
        this.line = line;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        DrawerFeature.getDrawerController().drawLine(line);

        setPosition(x,y);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter";
    }
}
