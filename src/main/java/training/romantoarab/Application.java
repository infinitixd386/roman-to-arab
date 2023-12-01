package training.romantoarab;

import training.romantoarab.service.RomanToArabConverter;
import training.romantoarab.service.RomanToArabConversionException;
import training.romantoarab.view.ConsoleIO;
import training.romantoarab.view.ConsoleInputOutput;
import training.romantoarab.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        ConsoleIO consoleIO = new ConsoleInputOutput();
        ConsoleView view = new ConsoleView(consoleIO);
        RomanToArabConverter converter = new RomanToArabConverter();
        try {
            view.printResult(converter.convert(view.readRoman()));
        }catch (RomanToArabConversionException ex){
            System.out.println(ex.getMessage());
        }
    }
}
