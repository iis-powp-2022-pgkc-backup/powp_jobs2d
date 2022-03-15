package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	boolean pattern;

	public SelectTestFigureOptionListener(DriverManager driverManager , boolean pattern) {
		this.driverManager = driverManager;
		this.pattern = pattern;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(pattern)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
