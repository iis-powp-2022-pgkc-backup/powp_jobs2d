package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.commands.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.factories.CircleFactory;
import edu.kis.powp.jobs2d.factories.RectFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int testIdx = 1;

	public SelectTestFigureOptionListener(DriverManager driverManager, int testIdx) {
		this.driverManager = driverManager;
		this.testIdx = testIdx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (testIdx) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				DriverCommand rectCommand = RectFactory.getRectCommand(50,50,100,200);
				rectCommand.execute(driverManager.getCurrentDriver());
				break;
			case 4:
				DriverCommand circleCommand = CircleFactory.getCircleCommand(100, 15, 100, 100);
				circleCommand.execute(driverManager.getCurrentDriver());
				break;
		}

	}
}
