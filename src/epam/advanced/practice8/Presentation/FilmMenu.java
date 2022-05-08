package epam.advanced.practice8.Presentation;

import epam.advanced.practice8.Dao.FilmDao;

public class FilmMenu {
    FilmDao filmDao;

    public FilmMenu(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public void Start(){
        throw new IllegalCallerException("Don't realise");
    }
}
