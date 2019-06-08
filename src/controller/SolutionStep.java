package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Show;

public class SolutionStep implements ActionListener {
	private Show show;

	@Override
	public void actionPerformed(ActionEvent e) {
		show.setStep(show.getSteps().size() - 1);
		show.repaint();
	}

	public SolutionStep(Show show) {
		this.show = show;
	}
}
