package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private final List<DriverCommand> commandList;

    public ComplexCommand() {
        this.commandList = new ArrayList<>();
    }

    public ComplexCommand(List<DriverCommand> commandList) {
        this.commandList = commandList;
    }

    public void addCommand(DriverCommand command) {
        commandList.add(command);
    }

    public void addCommand(ComplexCommand command) {
        commandList.addAll(command.commandList);
    }

    public void execute(Job2dDriver driver) {
        for(DriverCommand command : commandList) {
            command.execute(driver);
        }
    }
}