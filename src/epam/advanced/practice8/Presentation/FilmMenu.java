package epam.advanced.practice8.Presentation;

import epam.advanced.practice8.Dao.DaoException;
import epam.advanced.practice8.Dao.FilmDao;
import epam.advanced.practice8.Entities.Film;

public class FilmMenu {
    FilmDao filmDao;

    public FilmMenu(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public void Start() {
        boolean running = true;
        while (running) {
            ShowMenu();
            int command = InputHelper.getCommand();
            switch (command) {
                case 1:
                    showAllFilms();
                    break;
                case 2:
                    showFilmWithId(InputHelper.getId());
                    break;
                case 3:
                    addFilm(InputHelper.getFilm());
                    break;
                case 4:
                    deleteFilm(InputHelper.getFilm());
                    break;
                case 5:
                    deleteFilmWithId(InputHelper.getId());
                    break;
                case 6:
                    showFilmsCurrentYear();
                    break;
                case 7:
                    addActor(InputHelper.getId(), InputHelper.getId());
                    break;
                case 8:
                    addProducer(InputHelper.getId(), InputHelper.getId());
                    break;
                case 9:
                    deleteOldFilm(InputHelper.getNumber());
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    InputHelper.showError("Command not found");
            }
        }
    }

    private void ShowMenu() {
        System.out.print("\u001B[32m");
        System.out.println("1. ShowAll | 2. Show with id | 3. add film | 4. delete film | 5. delete film with id");
        System.out.print("6. show films current year | 7. add actor | 8 add producer | 9. delete old films | 10. Back");
        System.out.println("\u001B[0m");
    }

    private void addProducer(int filmId, int actorId) {
        try {
            boolean added = filmDao.addProducerToFilm(filmId, actorId);
            System.out.println(added ? "Added" : "Did not add");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void addActor(int filmId, int actorId) {
        try {
            boolean added = filmDao.addActorToFilm(filmId, actorId);
            System.out.println(added ? "Added" : "Did not add");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void deleteOldFilm(int years) {
        try {
            var films = filmDao.deleteOldFilm(years);
            System.out.println("Deleted films");
            for (var film : films) {
                System.out.println(film);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showFilmsCurrentYear() {
        try {
            var list = filmDao.findFilmsInThisYear();
            for (var film : list) {
                System.out.println(film);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void deleteFilm(Film film) {
        try {
            boolean deleted = filmDao.delete(film);
            System.out.println(film);
            System.out.println(deleted ? "Deleted" : "Did not delete");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void deleteFilmWithId(int id) {
        try {
            boolean deleted = filmDao.delete(id);
            System.out.println("Id = " + id);
            System.out.println(deleted ? "Deleted" : "Did not delete");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void addFilm(Film film) {
        try {
            boolean added = filmDao.create(film);
            System.out.println(film);
            System.out.println(added ? "Added" : "Did not add");
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showFilmWithId(int id) {
        try {
            var film = filmDao.findEntityById(id);
            System.out.println(film);
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }

    private void showAllFilms() {
        try {
            var films = filmDao.findAll();
            for (var film : films) {
                System.out.println(film);
            }
        } catch (DaoException ex) {
            InputHelper.showError(ex.getMessage());
        }
    }
}
