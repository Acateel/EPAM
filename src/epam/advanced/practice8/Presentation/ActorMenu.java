package epam.advanced.practice8.Presentation;

import epam.advanced.practice8.Dao.ActorDao;
import epam.advanced.practice8.Dao.DaoException;
import epam.advanced.practice8.Entities.Actor;
import epam.advanced.practice8.Entities.Film;

public class ActorMenu {
    ActorDao actorDao;

    public ActorMenu(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public void Start() {
        boolean running = true;
        while (running) {
            ShowMenu();
            int command = InputHelper.getCommand();
            switch (command) {
                case 1:
                    showAllActors();
                    break;
                case 2:
                    showActorWithId(InputHelper.getId());
                    break;
                case 3:
                    addActor(InputHelper.getActor());
                    break;
                case 4:
                    deleteActor(InputHelper.getActor());
                    break;
                case 5:
                    deleteActorWithId(InputHelper.getId());
                    break;
                case 6:
                    showActorsInFilm(InputHelper.getFilm());
                    break;
                case 7:
                    showActorsInFilmManyTimes(InputHelper.getNumber());
                    break;
                case 8:
                    showProducer();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    InputHelper.showError("Command not found");
            }
        }
    }

    private void ShowMenu() {
        System.out.print("\u001B[32m");
        System.out.println("1. ShowAll | 2. Show with id | 3. add actor | 4. delete actor | 5. delete actor with id");
        System.out.print("6. show actor in film | 7. show actor in film many times | 8. show producer | 9. Back");
        System.out.println("\u001B[0m");
    }

    private void showProducer() {
        try {
            var actors = actorDao.findActorsProducer();
            for (var actor : actors) {
                System.out.println(actor);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showActorsInFilmManyTimes(int times) {
        try {
            var actors = actorDao.findActorsInFilmManyTimes(times);
            for (var actor : actors) {
                System.out.println(actor);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showActorsInFilm(Film film) {
        try {
            var actors = actorDao.findActorsInFilm(film);
            for (var actor : actors) {
                System.out.println(actor);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void deleteActor(Actor actor) {
        try {
            boolean deleted = actorDao.delete(actor);
            System.out.println(actor);
            System.out.println(deleted ? "Deleted" : "Did not delete");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void deleteActorWithId(int id) {
        try {
            boolean deleted = actorDao.delete(id);
            System.out.println("Id = " + id);
            System.out.println(deleted ? "Deleted" : "Did not delete");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void addActor(Actor actor) {
        try {
            boolean added = actorDao.create(actor);
            System.out.println(actor);
            System.out.println(added ? "Added" : "Did not add");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showActorWithId(int id) {
        try {
            var actor = actorDao.findEntityById(id);
            System.out.println(actor);
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showAllActors() {
        try {
            var actors = actorDao.findAll();
            for (var actor : actors) {
                System.out.println(actor);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }
}
