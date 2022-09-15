package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.commands.ComplexCommand;
import edu.kis.powp.jobs2d.commands.DriverCommand;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommandBuilder {
	private final List<DriverCommand> complexCommandList = new ArrayList<>();

	public ComplexCommandBuilder addCommand(DriverCommand driverCommand) {
		complexCommandList.add(driverCommand);
		return this;
	}

	public ComplexCommand build() {
		return new ComplexCommand(complexCommandList);
	}
}
