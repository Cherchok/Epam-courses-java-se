package javase04.t04;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Movie implements Serializable {
    private String title;
    private Set<Actor> actors;

    Movie(String title) {
        this.title = title;
        actors = new HashSet<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public Set<Actor> getActors() {
        return actors;
    }

    @SuppressWarnings("unused")
    public void removeActor(Actor actor) {
        actors.remove(actor);
    }
}
