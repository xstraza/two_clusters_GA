package view;

import java.util.ArrayList;

import algorithm.Point;

public class AlgorithmStep {
	private ArrayList<Point> all;
	private ArrayList<Point> setL;
	private ArrayList<Point> setR;
	private ArrayList<Point> hullL;
	private ArrayList<Point> hullR;
	private Point A;
	private Point B;
	private double curMax = 0;
	private double dL = 0;
	private double dR = 0;

	public AlgorithmStep(ArrayList<Point> all, ArrayList<Point> setL, ArrayList<Point> setR, ArrayList<Point> hullL,
			ArrayList<Point> hullR, Point a, Point b, double curMax, double dL, double dR) {
		super();
		this.all = all;
		this.setL = setL;
		this.setR = setR;
		this.hullL = hullL;
		this.hullR = hullR;
		A = a;
		B = b;
		this.curMax = curMax;
		this.dL = dL;
		this.dR = dR;
	}

	public ArrayList<Point> getAll() {
		return all;
	}

	public void setAll(ArrayList<Point> all) {
		this.all = all;
	}

	public ArrayList<Point> getSetL() {
		return setL;
	}

	public void setSetL(ArrayList<Point> setL) {
		this.setL = setL;
	}

	public ArrayList<Point> getSetR() {
		return setR;
	}

	public void setSetR(ArrayList<Point> setR) {
		this.setR = setR;
	}

	public ArrayList<Point> getHullL() {
		return hullL;
	}

	public void setHullL(ArrayList<Point> hullL) {
		this.hullL = hullL;
	}

	public ArrayList<Point> getHullR() {
		return hullR;
	}

	public void setHullR(ArrayList<Point> hullR) {
		this.hullR = hullR;
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public double getCurMax() {
		return curMax;
	}

	public void setCurMax(double curMax) {
		this.curMax = curMax;
	}

	public double getdL() {
		return dL;
	}

	public void setdL(double dL) {
		this.dL = dL;
	}

	public double getdR() {
		return dR;
	}

	public void setdR(double dR) {
		this.dR = dR;
	}

}
