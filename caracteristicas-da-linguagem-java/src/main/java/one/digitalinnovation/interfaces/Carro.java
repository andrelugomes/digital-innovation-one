package one.digitalinnovation.interfaces;

public interface Carro {

    String marca();

    default void ligar() {
        System.out.println("Ligando o carro!");
    }

}
