package whiles;

public class While {

  public static void main(String[] args) {

    var x = 0;

    //Testa a condição antes
    while (x < 1) {
      System.out.println("Dentro do while...");
      x++;
    }

    var y = 0;

    //Testa a condição depois
    do {
      System.out.println("Dentro do do/while...");
    } while (y++ < 1);
  }

}
