package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.List;

public class ComplexCommand implements DriverCommand{
	private List<DriverCommand> commands;

	public ComplexCommand(List<DriverCommand> commands) {
		this.commands = commands;
	}

	@Override
	public void execute(Job2dDriver driver) {
		for (DriverCommand command : commands)
			command.execute(driver);
	}
}
