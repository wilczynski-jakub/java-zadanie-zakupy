package zakupy;

public class Towar implements Produkt {
    private String nazwa;
    private double cena;

    // konstruktor
    public Towar(String nzw, double cn) {
        this.nazwa = nzw;
        this.cena = cn;
    } //Towar()

    @Override
    public String toString() {
        return "Towar("+nazwa+", "+String.format("%,.2f",cena)+" zł)";
    } //toString()

    // Metody z interfejsu Produkt:

    // // zwracanie nazwy produktu
    public String nazwa() {
        return this.nazwa;
    } //nazwa()

    // // zwracanie ceny produktu
    public double cena() {
        return this.cena;
    } //cena()

} //class Towar
