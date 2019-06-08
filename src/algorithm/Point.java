package algorithm;

public class Point implements Comparable<Point> {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// Euklidska distanca izmedju dve tacke
	public double distanceTo(Point p) {
		double d = 0;
		d = Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2);
		d = Math.sqrt(d);
		return d;
	}

	@Override
	public boolean equals(Object o) {
		Point p = (Point) o;
		if (p.getX() == this.getX() && p.getY() == this.getY())
			return true;
		return false;

	}

	@Override
	public String toString() {
//		return x + "|" + y;
		return "unos.add(new Point(" + x + ", " + y + "));";
	}

	// Sortiramo po X pa po Y
	@Override
	public int compareTo(Point p) {
		if (p.x == this.x && p.y == this.y) {
			return 0;
		}
		if (p.x > this.x)
			return -1;
		if (p.x == this.x && p.y > this.y)
			return -1;

		return 1;
	}

}
