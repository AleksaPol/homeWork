import java.io.*;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new ConsoleUI();
        Option option;
        view.start();
        Presenter presenter = new Presenter(view, null);

    }
}