package zakupy;

public class Sklep {
    private TowarWSklepie[] listaTowarow;
    private double przychod;

    // konstruktor
    public Sklep(TowarWSklepie[] listTow) {
        this.listaTowarow = listTow;
        this.przychod = 0;
    } //Sklep()

    @Override
    public String toString() {
        String asortyment = "\n";
        for (TowarWSklepie tow: listaTowarow) {
            asortyment += "\t\t"+tow+";\n";
        }
        if (asortyment == "\n") asortyment = " (pusty)\n";
        return "SKLEP {\n\tPRZYCHÓD = "+String.format("%,.2f",przychod)+" PLN;\n\tASORTYMENT:"+asortyment+"}\n";
    } //toString()

    // metoda zwracająca asortyment
    public TowarWSklepie[] listaTowarow() {
        return this.listaTowarow;
    } //listaTowarow()

    // metoda skanująca kod kreskowy, wyszukująca za jego pomocą nim towar
    // i usuwająca ów towar z asortymentu sklepu, a dalej przekazująca rodzaj towaru do klienta.
    // ponadto przychód sklepu zwiększony będzie o cenę zeskanowanego towaru
    public Towar skanuj(int kodKreskowy) {

        int ile = this.listaTowarow.length;
        TowarWSklepie[] nowyAsortyment = new TowarWSklepie[ile];
        Towar zeskanowany = null;

        for (int i=0; i<ile; i++) {
            // towar z listy, na którego natrafiliśmy
            TowarWSklepie tow = this.listaTowarow[i];

            // jeżeli to ten towar, który chcemy zeskanować && jeżeli go jeszcze mamy
            if (i==kodKreskowy && tow.sztuk()>0) {
                try { // dodatkowe, niepotrzebne, ale wymagane przez javę,
                    // zabezpieczenie przed wyjątkiem metody zabierz()
                    nowyAsortyment[i] = tow.zabierz();
                    this.przychod += tow.cena();
                    zeskanowany = tow.Towar();
                    continue; //koniec iteracji
                } catch (BrakTowaruException e) {
                    // nic właściwie tutaj nie jest potrzebne
                    // ...chociaż pamiętam z wykładu, że taki kod jest nieładny, ale:
                    // a) instrukcją if i tak już upewniłem się, że nie zabraknie towaru
                    // b) nawet jeśli wyjątek się pojawi, to kompilator przejdzie po prostu do ostatniej linijki w tej pętli for
                    //    (czyli odłoży towar na miejsce, nie skanując, dokładnie tak jak powinno być w przypadku braku towaru -
                    //    - dlatego właśnie żadne dodatkowe instrukcje obsługujące wyjątek nie są tu potrzebne)
                } //try//catch
            } //if

            // jeżeli nie skończyliśmy wcześniej iteracji,
            // to znaczy że towaru "tow" nie skanujemy,
            // więc nie usuwamy go z asortymentu
            nowyAsortyment[i] = tow;
        } //for

        this.listaTowarow = nowyAsortyment;
        return zeskanowany; //jeśli nic nie zeskanowano, to zwraca null, ma to sens
    } //skanuj()

} //class Sklep