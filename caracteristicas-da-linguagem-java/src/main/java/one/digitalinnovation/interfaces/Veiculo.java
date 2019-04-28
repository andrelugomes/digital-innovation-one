package one.digitalinnovation.interfaces;

public interface Veiculo {

    String registro();

    default void ligar() {

        System.out.println("Ligando o veículo!");
    }

    //void desligar();

    /*default void desligar() {
        System.out.println("Desligando o veículo!");
    }*/
}
