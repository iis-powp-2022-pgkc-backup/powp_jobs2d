package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements  DriverCommand {
    private int x, y;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public void execute(Job2dDriver job2dDriver) {
        job2dDriver.operateTo(x, y);
    }
}
