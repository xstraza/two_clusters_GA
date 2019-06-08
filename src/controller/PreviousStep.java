package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Show;

public class PreviousStep implements ActionListener {
	private Show show;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (show.getStep() > 0) {
			show.setStep(show.getStep() - 1);
		}
		show.repaint();
	}

	public PreviousStep(Show show) {
		this.show = show;
	}
}
