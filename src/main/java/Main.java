import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Application wordSquare = new Application();
        System.out.println("Hello, Welcome to my Word Square Generator Application!!");
        Console console = System.console();
        wordSquare.application(console);
    }
}
