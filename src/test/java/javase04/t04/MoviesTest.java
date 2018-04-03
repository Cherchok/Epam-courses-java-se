package javase04.t04;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class MoviesTest {

    @Test
    void saveLoadTest() throws IOException, ClassNotFoundException {

        Movies collection = new Movies();
        Movie movie1 = new Movie("Shadow");
        Movie movie2 = new Movie("Escape");
        Movie movie3 = new Movie("Fighter");
        Movie movie4 = new Movie("Plane");

        collection.addMovie(movie1);
        collection.addMovie(movie2);
        collection.addMovie(movie3);
        collection.addMovie(movie4);

        collection.addActor("Shadow", new Actor("Piter", "Fat"));
        collection.addActor("Shadow", new Actor("Justin", "Stupid"));


        collection.addActor("Escape", new Actor("Robert", "Slow"));
        collection.addActor("Escape", new Actor("Justin", "Stupid"));

        collection.addActor("Fighter", new Actor("Piter", "Fat"));
        collection.addActor("Fighter", new Actor("Robert", "Slow"));
        collection.addActor("Fighter", new Actor("Piter", "Fat"));
        collection.addActor("Fighter", new Actor("Robert", "Slow"));
        collection.addActor("Fighter", new Actor("Justin", "Stupid"));

        collection.save();

        System.out.println("Before changes: ");
        System.out.println();

        for (String m : collection.getMovies()) {
            System.out.println(m);
        }
        System.out.println();
        System.out.println("After changes: ");
        System.out.println();
        collection.removeMovie("Escape");
        collection.removeMovie("Fighter");

        for (String m : collection.getMovies()) {
            System.out.println(m);
        }


        Movies collection1 = new Movies();
        collection1=collection1.load();
        System.out.println();
        System.out.println("After loading file without changes: ");
        System.out.println();
        for (String m: collection1.getMovies()) {
            System.out.println(m);
        }


        Assert.assertNotEquals(collection.getMovies(),collection1.getMovies());

        collection = collection.load();
        Assert.assertEquals(collection.getMovies(),collection1.getMovies());

    }
}