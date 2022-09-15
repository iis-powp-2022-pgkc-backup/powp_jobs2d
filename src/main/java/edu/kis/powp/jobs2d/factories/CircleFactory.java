package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.commands.ComplexCommand;
import edu.kis.powp.jobs2d.commands.OperateToCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;

public class CircleFactory {

	public static ComplexCommand getCircleCommand(int centerX, int centerY, int radius, int elements) {
		if (elements < 3)
			throw new IllegalArgumentException("Not enought elements. Minimum 3");

		int startX = centerX + (int)(radius * Math.cos(0.0d));
		int startY = centerY + (int)(radius * Math.sin(0.0d));

		ComplexCommandBuilder builder = new ComplexCommandBuilder();
		builder.addCommand(new SetPositionCommand(startX, startY));

		double angleDelta = Math.PI * 2 / elements;
		double angle = angleDelta;
		for(int i = 0; i < elements - 1; ++i) {
			int xx = centerX + (int)(radius * Math.cos(angle));
			int yy = centerY + (int)(radius * Math.sin(angle));
			builder.addCommand(new OperateToCommand(xx, yy));
			angle += angleDelta;
		}

		builder.addCommand(new OperateToCommand(startX, startY));
		return builder.build();
	}
}
