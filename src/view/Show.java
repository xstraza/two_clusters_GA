package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithm.Point;
import controller.NextStep;
import controller.PreviousStep;
import controller.SolutionStep;

public class Show extends JPanel {
	private static final long serialVersionUID = -2808747719807424974L;
	private ArrayList<AlgorithmStep> steps;
	private int step = 0;
	private JLabel sol = new JLabel("!!!");
	private JLabel dL = new JLabel("!!!");
	private JLabel dR = new JLabel("!!!");
	private JButton next = new JButton("Next");
	private JButton previous = new JButton("Prev");
	private JButton solution = new JButton("Finish");
	private JLabel position = new JLabel();

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (steps != null && steps.size() > 0) {
			AlgorithmStep currentStep = steps.get(step);
			sol.setText("" + currentStep.getCurMax());
			dL.setText("" + currentStep.getdL());
			dR.setText("" + currentStep.getdR());
			Graphics2D g2 = (Graphics2D) g;
			Ellipse2D e;
			Line2D l;
			Color color = Color.black;
			g2.drawRect(100, 100, 400, 400);
			ArrayList<Point> all = currentStep.getAll();
			for (int i = 0; i < all.size(); i++) {
				e = new Ellipse2D.Double(100 + all.get(i).getX() - 3, 500 - all.get(i).getY() - 3, 6, 6);
				g2.setPaint(color);
				g2.fill(e);
			}
			Point a = currentStep.getA();
			Point b = currentStep.getB();
			l = new Line2D.Double(100 + a.getX(), 500 - a.getY(), 100 + b.getX(), 500 - b.getY());
			g2.setPaint(color);
			g2.draw(l);

			color = Color.blue;
			dL.setForeground(color);
			ArrayList<Point> set1 = currentStep.getSetL();
			for (int i = 0; i < set1.size(); i++) {
				e = new Ellipse2D.Double(100 + set1.get(i).getX() - 3, 500 - set1.get(i).getY() - 3, 6, 6);
				g2.setPaint(color);
				g2.fill(e);
			}
			color = Color.orange;
			ArrayList<Point> hull1 = currentStep.getHullL();
			for (int i = 1; i < hull1.size(); i++) {
				l = new Line2D.Double(100 + hull1.get(i - 1).getX(), 500 - hull1.get(i - 1).getY(),
						100 + hull1.get(i).getX(), 500 - hull1.get(i).getY());
				g2.setPaint(color);
				g2.draw(l);
			}

			color = Color.red;
			dR.setForeground(color);
			ArrayList<Point> set2 = currentStep.getSetR();
			for (int i = 0; i < set2.size(); i++) {
				e = new Ellipse2D.Double(100 + set2.get(i).getX() - 3, 500 - set2.get(i).getY() - 3, 6, 6);
				g2.setPaint(color);
				g2.fill(e);
			}
			color = Color.green;
			ArrayList<Point> hull2 = currentStep.getHullR();
			for (int i = 1; i < hull2.size(); i++) {
				l = new Line2D.Double(100 + hull2.get(i - 1).getX(), 500 - hull2.get(i - 1).getY(),
						100 + hull2.get(i).getX(), 500 - hull2.get(i).getY());
				g2.setPaint(color);
				g2.draw(l);
			}
			dL.setText("Dist. to Blue: " + String.format("%.2f", currentStep.getdL()));
			dR.setText("Dist. to Red: " + String.format("%.2f", currentStep.getdR()));
			sol.setText("Best Dist.: " + String.format("%.2f", currentStep.getCurMax()));
			position.setText((step + 1) + "/" + steps.size());
		}
	}

	public Show(ArrayList<AlgorithmStep> steps) {
		this.steps = steps;
		this.add(dL);
		this.add(dR);
		this.add(sol);
		next.addActionListener(new NextStep(this));
		previous.addActionListener(new PreviousStep(this));
		solution.addActionListener(new SolutionStep(this));
		this.add(previous);
		this.add(next);
		this.add(solution);
		this.add(position);
	}

	public ArrayList<AlgorithmStep> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<AlgorithmStep> steps) {
		this.steps = steps;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public JLabel getSol() {
		return sol;
	}

	public void setSol(JLabel sol) {
		this.sol = sol;
	}

	public JLabel getdL() {
		return dL;
	}

	public void setdL(JLabel dL) {
		this.dL = dL;
	}

	public JLabel getdR() {
		return dR;
	}

	public void setdR(JLabel dR) {
		this.dR = dR;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public JButton getPrevious() {
		return previous;
	}

	public void setPrevious(JButton previous) {
		this.previous = previous;
	}

}
