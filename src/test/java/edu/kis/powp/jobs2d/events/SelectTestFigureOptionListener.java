package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.resources.TypesOfFigure;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final TypesOfFigure figureType;

	public SelectTestFigureOptionListener(DriverManager driverManager, TypesOfFigure figureType) {
		this.driverManager = driverManager;
		this.figureType = figureType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(figureType){
			case Figure1: {
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			}
			case Figure2:{
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			}
		}
	}
}