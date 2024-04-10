package glowny;

import prezentodawcy.*;
import zakupy.*;
import java.util.Arrays;

public class Glowna {

    // metoda testZakupów
    public void testZakupow(){

        Sklep sk0 = new Sklep(new TowarWSklepie[]{});  // Pusty sklep

        Sklep sk1 = new Sklep(new TowarWSklepie[]{
                new TowarWSklepie(new Towar("DDR4 16GB", 350), 10),
                new TowarWSklepie(new Towar("SSD NVMe 512GB", 190), 5),
                new TowarWSklepie(new Towar("SSD NVMe 256GB", 99), 3),
                new TowarWSklepie(new Towar("SSD NVMe 1024GB", 460), 5),
                new TowarWSklepie(new Towar("DDR5 8GB", 415), 1),
                new TowarWSklepie(new Towar("Skarpetki", 15), 100)
        });

        Prezentodawca[] kupujacy = new Prezentodawca[]{
                new MaksymalistaCenowy(450),
                new MaksymalistaCenowy(450),
                new MinimalistaCenowy(200),
                new Losowy(600)
        };

        System.out.println("\n*** PRZED ZAKUPAMI ***\n");
        System.out.println("** PRL-market **\n"+sk0);
        System.out.println("** Automat na MIMie **\n"+sk1);
        System.out.printf("Kupujący: %s%n", Arrays.toString(kupujacy));

        System.out.println("\n\n\n*** Zakupy w PRL-markecie ***\n");
        for(Prezentodawca pr: kupujacy){
            Towar prezent = pr.kupPrezent(sk0);
            if (prezent != null)
                System.out.printf(" > %s kupił %s%n", pr, prezent);
            else System.out.println(" > "+pr+" nic nie kupił");
        }

        System.out.println("\n\n\n*** Stan po zakupach w PRL-markecie ***\n");
        System.out.println(sk0);
        System.out.printf("Kupujący: %s%n", Arrays.toString(kupujacy));

        System.out.println("\n\n\n*** Zakupy w automacie na MIMie ***\n");
        for(Prezentodawca pr: kupujacy){
            Towar prezent = pr.kupPrezent(sk1);
            if (prezent != null)
                System.out.printf(" > %s kupił %s%n", pr, prezent);
            else System.out.println(" > "+pr+" nic nie kupił");
        }

        System.out.println("\n\n\n*** Stan po zakupach w automacie na MIMie ***\n");
        System.out.println(sk1);
        System.out.printf("Kupujący: %s%n", Arrays.toString(kupujacy));

    } //testZakupow()

    // metoda main
    public static void main(String[] args) {
        Glowna g = new Glowna();
        g.testZakupow();
    } //main()

} //class Glowna
