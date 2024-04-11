package zakupy;

public class TowarWSklepie implements Produkt {
    private Towar rodzaj;
    private int sztuk;

    // konstruktor
    public TowarWSklepie(Towar rdzj, int szt) {
        this.rodzaj = rdzj;
        this.sztuk = szt;
    } //TowarWSklepie()

    @Override
    public String toString() {
        return sztuk+"x "+this.rodzaj;
    } //toString()

    // zwróć siebie ale jako Towar a nie TowarWSklepie, przyda się taka metoda do zakupów
    public Towar Towar() {
        return this.rodzaj;
    } //Towar()

    // zabierz jedną sztukę ze stosu Towarów i zwróć ów stos
    public TowarWSklepie zabierz() throws BrakTowaruException {

        // w przypadku gdy jest 0 lub mniej sztuk
        if (this.sztuk <= 0) {
            throw new BrakTowaruException("Brak wskazanego towaru");
        } //if

        // liczba sztuk zmiejszana jest o 1
        this.sztuk -= 1;

        return this;
    } //zabierz()

    // zwracanie liczby sztuk
    public int sztuk() {
        return this.sztuk;
    } //sztuk()

    // Metody z interfejsu Produkt:

    // // zwracanie nazwy produktu
    public String nazwa() {
        return this.rodzaj.nazwa();
    } //nazwa()

    // // zwracanie ceny produktu
    public double cena() {
        return this.rodzaj.cena();
    } //cena()

} //class TowarWSklepie