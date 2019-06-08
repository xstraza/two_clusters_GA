package algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class PointUtil {

	// Zaokret koji grade 3 tacke
	public static int turn(Point first, Point second, Point third) {
		long cross = (long) (((long) second.getX() - first.getX()) * ((long) third.getY() - first.getY())
				- ((long) second.getY() - first.getY()) * ((long) third.getX() - first.getX()));
		if (cross > 0)
			return 1; // CCW tj LEVO
		else if (cross < 0)
			return -1; // CW tj DESNO
		else
			return 0; // CL
	}

	// Formiranje konveksnog omotaca oko skupa tacaka
	public static ArrayList<Point> convexHull(ArrayList<Point> points) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Point> result = new ArrayList<Point>();

		stack.push(0);

		// lower chain
		for (int i = 1; i < points.size(); i++) {
			int middle = 0;
			while (stack.size() > 1) {
				middle = stack.pop();
				if (turn(points.get(stack.peek()), points.get(middle), points.get(i)) > 0) {
					stack.push(middle);
					break;
				}
			}
			stack.push(i);
		}

		int lower_size = stack.size();
		// upper chain
		for (int i = points.size() - 2; i >= 0; i--) {
			int middle = 0;
			while (stack.size() > lower_size) {
				middle = stack.pop();
				if (turn(points.get(stack.peek()), points.get(middle), points.get(i)) > 0) {
					stack.push(middle);
					break;
				}
			}
			stack.push(i);
		}

		stack.pop();
		while (!stack.empty()) {
			result.add(points.get(stack.pop()));
		}

		// Dodamo prvu tacku na kraj
		result.add(result.get(0));
		return result;
	}

	// Euklidska distanca tacke p0 do duzi p1p2
	public static double dPointToLine(Point pX, Point pA, Point pB) {
		double d = 0;
		d = (pB.getY() - pA.getY()) * pX.getX();
		d -= (pB.getX() - pA.getX()) * pX.getY();
		d += pB.getX() * pA.getY();
		d -= pB.getY() * pA.getX();
		d = Math.abs(d);
		d = d / pA.distanceTo(pB);
		return d;

	}
}
