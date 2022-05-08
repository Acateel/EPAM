package epam.advanced.practice8.Presentation;

import epam.advanced.practice8.Dao.ActorDao;
import epam.advanced.practice8.Dao.FilmDao;

public class MainMenu {
    FilmMenu filmMenu;
    ActorMenu actorMenu;

    public MainMenu(FilmDao filmDao, ActorDao actorDao) {
        filmMenu = new FilmMenu(filmDao);
        actorMenu = new ActorMenu(actorDao);
    }

    public void Start(){
        boolean running = true;
        while (running) {
            ShowMenu();
            int command = InputHelper.getCommand();
            switch (command) {
                case 1:
                    filmMenu.Start();
                    break;
                case 2:
                    actorMenu.Start();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    InputHelper.showError("Command not found");
            }
        }
    }

    private void ShowMenu(){
        System.out.print("\u001B[32m");
        System.out.print("1. Film Menu | 2. Actor Menu | 3. Exit");
        System.out.println("\u001B[0m");
    }
}
