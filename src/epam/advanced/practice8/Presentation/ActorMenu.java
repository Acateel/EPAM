package epam.advanced.practice8.Presentation;

import epam.advanced.practice8.Dao.ActorDao;

public class ActorMenu {
    ActorDao actorDao;

    public ActorMenu(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public void Start(){
        throw new IllegalCallerException("Don't realise");
    }
}
