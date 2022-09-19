package edu.kis.powp.jobs2d.commands;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    List<DriverCommand> commands = new ArrayList<>();

    public ComplexCommand(List<DriverCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for(DriverCommand command : commands) {
            command.execute();
        }
    }
}