package strings;

public class StringBuilder {

  public static void main(String[] args) {

    var nome = "André";

    final var builder = new java.lang.StringBuilder(nome);
    System.out.println(builder.append("Luis"));

    final var reverse = builder.reverse();

    System.out.println(reverse);

    final var insert = reverse.insert(0, "#").insert(reverse.length(), "#");
    System.out.println(insert);

  }

}
