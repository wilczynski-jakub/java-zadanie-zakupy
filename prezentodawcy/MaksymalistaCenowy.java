package prezentodawcy;
import zakupy.*;

public class MaksymalistaCenowy extends Prezentodawca {

    // konstruktor
    public MaksymalistaCenowy(double budzet) {
        super(budzet);
    } //MaksymalistaCenowy()

    // kupowanie prezentu
    public Towar kupPrezent(Sklep zeSklepu) {

        int kodPrezentu = -1; // początkowo -1, i jeżeli się nie uda nic kupić to to nadal będzie -1
        TowarWSklepie[] tow = zeSklepu.listaTowarow(); // asortyment sklepu

        for (int i=0; i<tow.length; i++) {
            // kupić można tylko te towary, na które nas stać i które są dostępne w asortymencie
            if (tow[i].cena() <= this.budzet && tow[i].sztuk()>0) {
                if (kodPrezentu == -1) // jeżeli to pierwszy dostępny towar, na który nas stać:
                    kodPrezentu = i; // to zakładamy, że jest on też najdroższy
                else if (tow[i].cena() > tow[kodPrezentu].cena()) // jeżeli nie pierwszy, to szukamy droższego:
                    kodPrezentu = i;
                // linijkę musiałem powtórzyć, żeby nie użyć (-1) jako indeksu tablicy
            } //if (cena<=budzet)
        } //for

        if (kodPrezentu != -1) { // jeżeli znaleźliśmy jakikolwiek prezent, na który nas stać
            this.budzet -= tow[kodPrezentu].cena(); // zapłata
            return zeSklepu.skanuj(kodPrezentu); // zakup
        } else // jeżeli nie znaleźliśmy żadnego
            return null; // to nic nie kupujemy, więc metoda zwraca null, ma to sens
    } //kupPrezent()

} //class MaksymalistaCenowy