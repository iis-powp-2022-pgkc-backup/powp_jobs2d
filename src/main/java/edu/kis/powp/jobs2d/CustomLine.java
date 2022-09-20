package edu.kis.powp.jobs2d;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

import java.awt.*;

public class CustomLine extends AbstractLine {
    public CustomLine(Color color, float thickness, boolean dotted) {
        this.color = color;
        this.thickness = thickness;
        this.dotted = dotted;
    }
}
