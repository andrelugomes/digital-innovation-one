package one.digitalinnovation.tipos.tipagem;

public class Escopo {

    public static void main(String[] args) {
        final var escopo = new TesteDeEscopo();
        System.out.println("O número definido é : "+escopo.defineNumeroMinimo(2));
    }

}

class TesteDeEscopo {

    int numeroMinimo;
    Integer NumeroMaximo;

    public int defineNumeroMinimo(int numeroMinimo) {

        if (numeroMinimo > 10) {

            this.numeroMinimo = numeroMinimo;
        }

        return this.numeroMinimo;
    }

    public Integer defineNumeroMaximo(Integer numeroMaximo) {
        return this.NumeroMaximo;
    }


}
