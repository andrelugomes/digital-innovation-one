package one.digitalinnovation.interfaces;

public class Programa {

    public static void main(String[] args) {

        final Carro gol = new Gol();
        System.out.println("Marca do Gol : "+gol.marca());
        gol.ligar();

        final Veiculo trator = new Trator();
        System.out.println("Registro do Trator :"+trator.registro());
        trator.ligar();

        final Fiesta fiesta = new Fiesta();

        System.out.println("Marca do Fiesta : "+fiesta.marca());
        System.out.println("Registro do Fiesta : "+fiesta.registro());

        fiesta.ligar();

        //Carro.super.ligar(); //só pode ser acessado por que implementa
    }

}
