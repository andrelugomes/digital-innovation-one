package operadores;

public class Logicos {

  public static void main(String[] args) {

    final var numero = 2;
    final var letra = "A";

    //Sort Circuit
    if (numero < 5 && letra.equals("A")) {
      System.out.println("Atendeu a condição");
    }

    if (numero < 5 || letra.equals("A")) {
      System.out.println("Atendeu a outracondição");
    }

    if ((10 - 5) > 1 && (5 - 3) > 1) {
      System.out.println("Lógica maluca...");
    }

    //Non Sort Circuit
    /*if (verifica(15) | verifica("A")) {
        System.out.println("OK");
    } else {
        System.out.println("Não OK");
    }*/

  }

  private static boolean verifica(String letra) {
    System.out.println("Verificando letra...");
    return letra.equals("A");
  }

  private static boolean verifica(Integer numero) {
    System.out.println("verificando numero...");
    return numero > 10;
  }
}
