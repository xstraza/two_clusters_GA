package view;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import algorithm.ClusterPoints;
import algorithm.Point;

public class Main {
	private final static int POINTS = 25;
	private static ArrayList<Point> unos = new ArrayList<>();

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < POINTS; i++) {
			int x = Math.abs(r.nextInt() % 400);
			int y = Math.abs(r.nextInt() % 400);
			Point p = new Point(x, y);
			unos.add(p);
			System.out.println(p);
		}
	
		JFrame f = new JFrame("Marko Matovic");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ClusterPoints cp = new ClusterPoints();
		ArrayList<AlgorithmStep> steps = cp.clusterMaximiseDistance(unos);
		Show show = new Show(steps);
		f.getContentPane().add(show);
		f.setSize(600, 600);
		f.setResizable(false);
		f.setVisible(true);
	}

}
