package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import model.Movie;

/**
 * Demonstrates local classes, anonymous classes, lambda expressions, and method references as
 * alternative ways to define and pass a {@link java.util.Comparator} or
 * {@link java.util.function.Consumer}.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class D03_InnerClasses {

   public static void main(String[] args) {
      List<Movie> movies = new ArrayList<>();
      movies.add(new Movie("John Wick 4", "2023", 7.6));
      movies.add(new Movie("Disaster Movie", "2008", 1.9));
      movies.add(new Movie("Der Pate", "1972", 9.2));

      System.out.println(movies);

      /* Sorting with Local Class */
      class MovieByRatingAscendingComparator implements Comparator<Movie> {

         @Override
         public int compare(Movie movie1, Movie movie2) {
            return Double.compare(movie1.getRating(), movie2.getRating());
         }

      }
      Collections.sort(movies, new MovieByRatingAscendingComparator());
      System.out.println(movies);

      /* Sorting with Anonymous Class */
      Collections.sort(movies, new Comparator<Movie>() {

         @Override
         public int compare(Movie movie1, Movie movie2) {
            return movie2.getPublishingYear().compareTo(movie1.getPublishingYear());
         }

      });
      System.out.println(movies);

      /* Sorting with Lambda Expression */
      Collections.sort(movies,
            (movie1, movie2) -> movie1.getPublishingYear().compareTo(movie2.getPublishingYear()));
      System.out.println(movies);
      System.out.println();

      /* Output with Loop */
      for (Movie m : movies) {
         System.out.println(m);

      }
      System.out.println();

      /* Output with Local Class */
      class PrintMovieConsumer implements Consumer<Movie> {

         @Override
         public void accept(Movie m) {
            System.out.println(m);
         }

      }
      movies.forEach(new PrintMovieConsumer());
      System.out.println();

      /* Output with Anonymous Class */
      movies.forEach(new Consumer<Movie>() {

         @Override
         public void accept(Movie m) {
            System.out.println(m);
         }

      });
      System.out.println();

      /* Output with Lambda Expression */
      movies.forEach(m -> System.out.println(m));
      System.out.println();

      /* Method References */
      movies.forEach(m -> m.incrementRating()); // Lambda Expression
      movies.forEach(Movie::incrementRating); // Method Reference

      movies.forEach(m -> System.out.println(m)); // Lambda Expression
      movies.forEach(System.out::println); // Method Reference

      movies.sort(Comparator.comparing(m -> m.getRating())); // Lambda Expression
      movies.sort(Comparator.comparing(Movie::getRating)); // Method Reference
   }

}
