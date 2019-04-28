package one.digitalinnovation.classes.pessoa;

public class Pessoa {

    private Integer idade;
    private Float peso;

    public Pessoa() {
    }

    public Pessoa(final Integer idade) {

        this.idade = idade;
    }

    public Pessoa(final Integer idade, final Float peso) {
        this.idade = idade;
        this.peso = peso;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public Float getPeso() {
        return peso;
    }

    protected String relatorio() {
        return "Idade : " +idade+" e Peso: "+ peso;
    }
}
