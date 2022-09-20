package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

import static edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController;

public class CustomLineAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final ILine iLine;
    private final DrawPanelController drawPanelController;
    public CustomLineAdapter(DrawPanelController drawPanelController, ILine iLine) {
        super();
        this.iLine = iLine;
        this.drawPanelController = drawPanelController;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        iLine.setStartCoordinates(this.startX, this.startY);
        iLine.setEndCoordinates(x, y);

        setPosition(x, y);
        drawPanelController.drawLine(iLine);
    }

    @Override
    public String toString() {
        return "Drawing custom line";
    }
}
