Za zadati skup tacaka, formirati dva disjunktna skupa(klastera) tako da 
udaljenost konveksnih omotaca oko klastera bude maksimalna
Ocekivana slozenost: O(n^3)

Resenje: Jednom sortiramo tacke jer cemo tako kasnije moci da gradimo
konveksne omotace u O(n). Biramo svaki neuredjen par tacaka iz skupa. Za duz
koju te tacke grade, ostale tacke podelimo u dva niza, leve i desne od duzi(prave).
Ta dva niza ce biti sortirana jer ih kreiramo jednim prolazom kroz niz svih
tacaka, tako sto svaku tacku redom dodamo na kraj odgovarajuceg niza. Zatim
formiramo konveksne omotace oko levih odnosno desnih tacaka. Odredimo
udaljenost oba omotaca do duzi, tacke koje cine duz ce pripadati skupu tacaka
koje pripadaju blizem od dva omotaca. Trenutno najbolja udaljenost je
udaljenost do daljeg omotaca, ukupno najbolja udaljenost je maksimum 
svih trenutno najboljih udaljenosti.

Slozenost: O(n log n + n^3) = O(n^3)
sortiranje tacaka: O(n log n)
biranje duzi: O(n^2)
kreiranje omotaca: O(n) (tacke su vec sortirane)
udaljenost omotaca do duzi: O(n)
ukupno bez sortiranja: O(n^3) (n^2 * (c*n) = n^2 * n = 2n^3 = n^3)