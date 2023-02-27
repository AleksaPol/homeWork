public class Exit implements Option {
    ConsoleUI ui;

    public Exit(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.exit();
    }

    @Override
    public String discription() {
        return "Выйти из меню";
    }
}