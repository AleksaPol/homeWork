
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    Family<Human> family = new Family<>();
    Service service = new Service(family);
    private Presenter presenter;
    private Scanner scanner;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    List<Option> commandList;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        ConsoleUI ui = new ConsoleUI();
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(ui));
        commandList.add(new ShowAll(ui));
        commandList.add(new FindHuman(ui));
        commandList.add(new Exit(ui));

        int menu = 0;
        while (menu != 3) {
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i + ": " + commandList.get(i).discription());
            }

            System.out.println("Выберите команду: ");
            Scanner scan = new Scanner(System.in);
            menu = scan.nextInt();
            commandList.get(menu).execute();
        }

    }

    public void addHuman() {
        service.createPerson();
    }

    public void showAll() {
        System.out.println(family);
    }

    public void findHuman() {
        service.searchMember();
    }

    public void findParents() {
        service.searchMember();
    }

    public void exit() {
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
