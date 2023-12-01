package training.romantoarab.view;

public class ConsoleView {

    ConsoleIO consoleIO;

    public ConsoleView(ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
    }

    public String readRoman(){
        consoleIO.print("Enter the Roman number: ");
        return consoleIO.readLine();
    }

    public void printResult(int number){
        consoleIO.print("The result is: "+number);
    }

}
