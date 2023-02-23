import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    Family<Human> family = new Family<>();
    Service service = new Service(family);

    List<Option> commandList;

    public void start() {
        View view = new View();
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(view));
        commandList.add(new ShowAll(view));
        commandList.add(new FindHuman(view));
        commandList.add(new Exit(view));

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
}
