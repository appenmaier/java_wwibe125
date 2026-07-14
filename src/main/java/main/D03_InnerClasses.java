package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import model.Movie;

/**
 * Demonstrates local classes, anonymous classes, lambda expressions, and method references
 * as alternative ways to define and pass a {@link java.util.Comparator} or
 * {@link java.util.function.Consumer}.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class D03_InnerClasses {

   public static void main(String[] args) {
      List<Movie> movies = new ArrayList<>();
      movies.add(new Movie("John Wick 4", "2023", 7.6));
      movies.add(new Movie("Disaster Movie", "2008", 1.9));
      movies.add(new Movie("Der Pate", "1972", 9.2));

      System.out.println(movies);

      /* Local Class */
      class MovieByRatingAscendingComparator implements Comparator<Movie> {

         @Override
         public int compare(Movie movie1, Movie movie2) {
            return Double.compare(movie1.getRating(), movie2.getRating());
         }

      }
      Collections.sort(movies, new MovieByRatingAscendingComparator());
      System.out.println(movies);

      /* Anonymous Class */
      Collections.sort(movies, new Comparator<Movie>() {

         @Override
         public int compare(Movie movie1, Movie movie2) {
            return movie2.getPublishingYear().compareTo(movie1.getPublishingYear());
         }

      });
      System.out.println(movies);

      /* Lambda Expression */
      Collections.sort(movies,
            (movie1, movie2) -> movie1.getPublishingYear().compareTo(movie2.getPublishingYear()));
      System.out.println(movies);
      System.out.println();

      /* for each */
      for (Movie m : movies) {
         System.out.println(m); // m.incrementRating();

      }
      System.out.println();

      // Local Class
      class PrintMovieConsumer implements Consumer<Movie> { // class IncrementRatingConsumer
                                                            // implements Consumer<Movie> {

         @Override
         public void accept(Movie m) {
            System.out.println(m); // m.incrementRating();
         }

      }
      movies.forEach(new PrintMovieConsumer()); // movies.forEach(new IncrementRatingConsumer());
      System.out.println();

      // Anonymous Class
      movies.forEach(new Consumer<Movie>() {

         @Override
         public void accept(Movie m) {
            System.out.println(m); // m.incrementRating();
         }

      });
      System.out.println();

      // Lambda Expression
      movies.forEach(m -> System.out.println(m)); // movies.forEach(m -> m.incrementRating());
      System.out.println();

      // Method Reference
      movies.forEach(System.out::println); // movies.forEach(Movie::incrementRating);
   }

}
