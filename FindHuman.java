public class FindHuman implements Option {
    ConsoleUI ui;

    public FindHuman(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.findHuman();
    }

    @Override
    public String discription() {
        return "Найти человека";
    }
}