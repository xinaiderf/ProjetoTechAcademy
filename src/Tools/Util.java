package Tools;

public class Util {
    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
