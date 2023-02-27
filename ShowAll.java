public class ShowAll implements Option {
    ConsoleUI ui;

    public ShowAll(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.showAll();
    }

    @Override
    public String discription() {
        return "Показать всех";
    }
}