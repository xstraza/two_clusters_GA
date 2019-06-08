package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Show;

public class NextStep implements ActionListener {
	private Show show;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (show.getStep() < show.getSteps().size() - 1) {
			show.setStep(show.getStep() + 1);
		}
		show.repaint();
	}

	public NextStep(Show show) {
		this.show = show;
	}
}
