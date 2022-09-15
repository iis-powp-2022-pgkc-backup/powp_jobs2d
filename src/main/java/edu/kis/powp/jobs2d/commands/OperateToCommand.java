package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand{
	private int x;
	private int y;

	Job2dDriver driver;

	public OperateToCommand(Job2dDriver driver) {
		this.driver = driver;
	}

	public void SetDriver(Job2dDriver driver) {
		this.driver = driver;
	}

	private void OperateTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute() {
		driver.operateTo(x, y);
	}
}

