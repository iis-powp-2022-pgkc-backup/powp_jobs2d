package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private String selectedImg;

	public SelectTestFigureOptionListener(DriverManager driverManager, String selectedImg) {
		this.driverManager = driverManager;
		this.selectedImg = selectedImg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DrawerFeature.getDrawerController().clearPanel();
		if(selectedImg.equals("Figure Joe 1"))
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else if(selectedImg.equals("Figure Joe 2"))
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
