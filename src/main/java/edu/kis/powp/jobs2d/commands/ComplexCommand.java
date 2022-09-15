package edu.kis.powp.jobs2d.commands;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand{
	private ArrayList<DriverCommand> commands = new ArrayList<>();

	public void addCommand(DriverCommand driver) {
		commands.add(driver);
	}

	@Override
	public void execute() {
		for (DriverCommand command : commands)
			command.execute();
	}
}
