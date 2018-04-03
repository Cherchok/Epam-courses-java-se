package javase04.t04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Movies implements Serializable {
    private Map<String, Movie> collection;


    Movies() {
        collection = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        collection.put(movie.getTitle(), movie);
    }

    public void addActor(String title, Actor actor) {
        collection.get(title).addActor(actor);
    }

    public Set<String> getMovies() {
        return collection.keySet();
    }

    public void removeMovie(String title) {
        collection.remove(title);
    }

    public void save() throws IOException {
         FileOutputStream fos = new FileOutputStream("movies");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);

    }

    public  Movies load() throws ClassNotFoundException, IOException {
        try (FileInputStream is = new FileInputStream("movies");
             ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Movies) ois.readObject();
        }
    }

}
