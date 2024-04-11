package prezentodawcy;
import zakupy.*;
import java.util.Random;

public class Losowy extends Prezentodawca {

    private static final int ILE_PROB = 3;
    private Random rand = new Random();

    //konstruktor
    public Losowy(double budz) {
        super(budz);
    } //Losowy()

    // kupowanie prezentu
    public Towar kupPrezent(Sklep zeSklepu) {

        TowarWSklepie[] tow = zeSklepu.listaTowarow(); // asortyment sklepu

        if (tow.length > 0) // jeżeli są jakiekolwiek towary w sklepie
            for (int i=0; i<ILE_PROB; i++) { // losowanie ILE_PROB razy
                int kod = rand.nextInt(tow.length); // losowanie kodu kreskowego towaru
                if (tow[kod].cena() <= this.budzet && tow[kod].sztuk()>0) { // jeśli stać nas na wylosowany towar i jest on dostępny
                    this.budzet -= tow[kod].cena(); // zapłata
                    return zeSklepu.skanuj(kod); // zakup i jednocześnie koniec pętli (i metody)
                } //if (cena<=budzet)
            } //for

        return null; // jeżeli kompilator dotrwał do tej linijki, to znaczy,
        // że nic nie udało się kupić, więc zwracamy null.
    } //kupPrezent()

} //class Losowy