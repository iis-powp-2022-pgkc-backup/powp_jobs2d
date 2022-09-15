package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.commands.ComplexCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectFactory implements ActionListener {
	private ComplexCommand commands = new ComplexCommand();

	public RectFactory(int startX, int startY, int endX, int endY) {
		commands.addCommand(new SetPositionCommand(startX, startY));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
