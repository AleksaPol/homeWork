public class AddHuman implements Option {
    ConsoleUI ui;

    public AddHuman(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.addHuman();
    }

    @Override
    public String discription() {
        return "Добавить человека";
    }
}