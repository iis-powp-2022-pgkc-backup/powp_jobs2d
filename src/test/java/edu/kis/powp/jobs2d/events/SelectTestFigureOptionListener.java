package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.factories.DrawFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	public enum Figure {
		JOE1, JOE2, RECTANGLE, TRIANGLE
	}
	private Figure figure;

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager, Figure figure) {
		this.driverManager = driverManager;
		this.figure = figure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(figure) {
			case JOE1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case JOE2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case RECTANGLE:
				DrawFactory.drawRectangle (-150,-150,150,200).execute(driverManager.getCurrentDriver());
				break;
			case TRIANGLE:
				DrawFactory.drawTriangle (-150,-150,150).execute(driverManager.getCurrentDriver());;
				break;
		}
	}
}
