package main;

import UI.ConsoleUI;
import presenter.Presenter;

public class Program {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        Tree<Human> familyTree = new Tree<>(fileHandler);
        Presenter presenter = new Presenter(familyTree);
        ConsoleUI consoleUI = new ConsoleUI(familyTree, fileHandler, presenter);
        consoleUI.start();

    }
}