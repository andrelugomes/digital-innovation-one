package one.digitalinnovation.statics;

public class Programa {

    public static void main(String[] args) {
        final Cachorro pitbull = new Cachorro();
        pitbull.zoologia = "Bipede";

        final Cachorro viraLatas = new Cachorro();

        System.out.println(pitbull.zoologia);
        System.out.println(viraLatas.zoologia);

        Cachorro.late();
    }

}
