package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.commands.ComplexCommand;
import edu.kis.powp.jobs2d.commands.OperateToCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;

public class RectFactory {
	public static ComplexCommand getRectCommand(int startX, int startY, int endX, int endY) {
		return new ComplexCommandBuilder()
				.addCommand(new SetPositionCommand(startX, startY))
				.addCommand(new OperateToCommand(endX, startY))
				.addCommand(new OperateToCommand(endX, endY))
				.addCommand(new OperateToCommand(startX, endY))
				.addCommand(new OperateToCommand(startX, startY))
				.build();
	}
}
