package algorithm;

import java.util.ArrayList;
import java.util.Collections;

import view.AlgorithmStep;

public class ClusterPoints {

//	 Za zadati skup tacaka, formirati dva disjunktna skupa(klastera) tako da 
//	 udaljenost konveksnih omotaca oko klastera bude maksimalna
//	 Ocekivana slozenost: O(n^3)

//	 Resenje: Jednom sortiramo tacke jer cemo tako kasnije moci da gradimo
//	 konveksne omotace u O(n). Biramo svaki neuredjen par tacaka iz skupa. Za duz
//	 koju te tacke grade, ostale tacke podelimo u dva niza, leve i desne od duzi.
//	 Ta dva niza ce biti sortirana jer ih kreiramo jednim prolazom kroz niz svih
//	 tacaka, tako sto svaku tacku redom dodamo na kraj odgovarajuceg niza. Zatim
//	 formiramo konveksne omotace oko levih odnosno desnih tacaka. Odredimo
//	 udaljenost oba omotaca do duzi, tacke koje cine duz ce pripadati skupu tacaka
//	 koje pripadaju blizem od dva omotaca. Trenutno najbolja udaljenost je
//	 udaljenost do daljeg
//	 omotaca, ukupno najbolja udaljenost je maksimum svih trenutno najboljih
//	 udaljenosti.
//	 Slozenost: O(n log n + n^3) = O(n^3)
//	 sortiranje tacaka: O(n log n)
//	 biranje duzi: O(n^2)
//	 kreiranje omotaca: O(n) (tacke su vec sortirane)
//	 udaljenost omotaca do duzi: O(n)
//	 ukupno bez sortiranja: O(n^3) (n^2 * (n+n) = n^2 * 2n = 2n^3 = n^3)
	public ArrayList<AlgorithmStep> clusterMaximiseDistance(ArrayList<Point> points) {
		// Ovde cuvamo najvecu udaljenost
		double sol = 0;

		// Podaci za view
		ArrayList<AlgorithmStep> steps = new ArrayList<>();
		AlgorithmStep best = null;

		// Sortiramo tacke, O(n*logn)
		// Sortiramo ih jednom da bi kasnije mogli da gradimo konveksne omotace u O(n)
		Collections.sort(points);
		ArrayList<Point> sorted = points;

		// Biramo dve tacke iz skupa
		for (int i = 0; i < sorted.size() - 1; i++) {
			for (int j = i + 1; j < sorted.size(); j++) {
				Point A = sorted.get(i);
				Point B = sorted.get(j);
				// Nizovi koji cuvaju tacke levo/desno od duzi AB
				ArrayList<Point> leftOfAB = new ArrayList<>();
				ArrayList<Point> rightOfAB = new ArrayList<>();
				// Sve ostale tacke redom dodamo u odgovarajuci niz
				for (int k = 0; k < sorted.size(); k++) {
					Point P = sorted.get(k);
					if (k != i && k != j) {
						if (PointUtil.turn(A, B, P) >= 0) {
							leftOfAB.add(P);
						} else {
							rightOfAB.add(P);
						}
					}
				}
				// Moramo imati bar 3 tacke u oba niza da bi mogli da formiramo omotace
				if (leftOfAB.size() >= 3 && rightOfAB.size() >= 3) {
					// Oba niza su vec sortirana tako da kreiranje omotaca radimo u O(n)
					ArrayList<Point> leftHull = PointUtil.convexHull(leftOfAB);
					ArrayList<Point> rightHull = PointUtil.convexHull(rightOfAB);

					double maxL = -1;
					double maxR = -1;
					// Nadjemo minimalno rastojanje levog omotaca do duzi AB
					for (int k = 1; k < leftHull.size(); k++) {
						double dTmp = PointUtil.dPointToLine(leftHull.get(k), A, B);
						if (maxL < 0 || maxL > dTmp)
							maxL = dTmp;

						dTmp = PointUtil.dPointToLine(A, leftHull.get(k - 1), leftHull.get(k));
						maxL = Math.min(maxL, dTmp);
						dTmp = PointUtil.dPointToLine(B, leftHull.get(k - 1), leftHull.get(k));
						maxL = Math.min(maxL, dTmp);
					}

					// Nadjemo minimalno rastojanje desnog omotaca do duzi AB
					for (int k = 1; k < rightHull.size(); k++) {
						double dTmp = PointUtil.dPointToLine(rightHull.get(k), A, B);
						if (maxR < 0 || maxR > dTmp)
							maxR = dTmp;

						dTmp = PointUtil.dPointToLine(A, rightHull.get(k - 1), rightHull.get(k));
						maxR = Math.min(maxR, dTmp);
						dTmp = PointUtil.dPointToLine(B, rightHull.get(k - 1), rightHull.get(k));
						maxR = Math.min(maxR, dTmp);
					}

					for (int k = 1; k < leftHull.size(); k++) {
						double dTmp = PointUtil.dPointToLine(leftHull.get(k), A, B);
						if (maxL < 0 || maxL > dTmp)
							maxL = dTmp;
					}

					double oldSol = sol;
					double newSol = Math.max(maxL, maxR);
					// Resenje je maksimum prethodnog resenja i trenutnog resenja
					sol = Math.max(oldSol, newSol);
					// Podaci za view
					AlgorithmStep as = new AlgorithmStep(sorted, leftOfAB, rightOfAB, leftHull, rightHull, A, B, sol,
							maxL, maxR);
					steps.add(as);
					// U best cuvamo najbolju podelu, ako se resenje promenilo azuriramo best
					if (sol != oldSol) {
						if (maxL > maxR) {
							rightOfAB.add(A);
							rightOfAB.add(B);
						} else {
							leftOfAB.add(A);
							leftOfAB.add(B);
						}
						best = new AlgorithmStep(sorted, leftOfAB, rightOfAB, leftHull, rightHull, A, B, sol, maxL,
								maxR);
					}
				}
			}
		}
		steps.add(best);
		return steps;
	}
}
