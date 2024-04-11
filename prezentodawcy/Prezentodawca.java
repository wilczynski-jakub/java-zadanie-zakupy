package prezentodawcy;

public abstract class Prezentodawca implements Kupowanie {

    protected double budzet;

    // konstruktor
    public Prezentodawca(double budz) {
        this.budzet = budz;
    } //Prezentodawca()

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        return name+"(ma "+String.format("%,.2f",this.budzet)+" zł)";
    } //toString

} //class Prezentodawca