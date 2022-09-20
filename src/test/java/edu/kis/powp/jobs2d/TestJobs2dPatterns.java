package edu.kis.powp.jobs2d;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.ContinuousLineAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.CustomLineAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.DashedLineAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {

		application.addTest("Figure Joe 1", new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), SelectTestFigureOptionListener.Figure.JOE1));
		application.addTest("Figure Joe 2", new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), SelectTestFigureOptionListener.Figure.JOE2));
		application.addTest("Figure Rectangle", new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), SelectTestFigureOptionListener.Figure.RECTANGLE));
		application.addTest("Figure Triangle", new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), SelectTestFigureOptionListener.Figure.TRIANGLE));

	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		DrawPanelController drawPanelController = DrawerFeature.getDrawerController();

		Job2dDriver continuousLineAdapter = new ContinuousLineAdapter(drawPanelController);
		DriverFeature.addDriver("Continuous line Simulator", continuousLineAdapter);

		Job2dDriver dashedLineAdapter = new DashedLineAdapter(drawPanelController);
		DriverFeature.addDriver("Dashed line Simulator", dashedLineAdapter);

		Job2dDriver customLineAdapter = new CustomLineAdapter(drawPanelController, LineFactory.getDottedLine());
		DriverFeature.addDriver("Dotted line Simulator", customLineAdapter);

		Job2dDriver customCustomLineAdapter = new CustomLineAdapter(drawPanelController, new CustomLine(Color.RED, 10, false));
		DriverFeature.addDriver("Custom line Simulator", customCustomLineAdapter);


		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(true);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);
//				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
