package training.romantoarab.view;

import java.util.Scanner;

public class ConsoleInputOutput implements ConsoleIO{
    private final Scanner reader = new Scanner(System.in);

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public String readLine() {
        return reader.nextLine();
    }
}
