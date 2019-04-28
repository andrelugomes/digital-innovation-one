package one.digitalinnovation.classes.usuario;

public class ProgramaDoSuperUsuario {

    public static void main(String[] args) {
        final var superUsuario = new SuperUsuario("root", "1234%$#@");


        superUsuario.getLogin();

        superUsuario.getSenha();

        String root = superUsuario.nome;

    }

}
