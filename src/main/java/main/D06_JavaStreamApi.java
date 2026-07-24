package main;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import model.Movies;
import model.Movies.Genre;
import model.Movies.Movie;

/**
 * Demonstrates common Java Stream API operations using a movie dataset.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class D06_JavaStreamApi {

   private static List<Movie> movies;

   public static void main(String[] args) {
      movies = Movies.getMovies();
      movies.forEach(System.out::println);
      System.out.println();

      /* filter, map, forEach */
      System.out.println(
            "Alle Thriller mit einer Bewertung von min. 7 in der Form \"Titel (Jahr)\" ausgeben.");
      printThrillerWithRatingGE7();
      System.out.println();

      /* mapToInt/mapToDouble/mapToLong, average/sum */
      System.out.println("Die Durchschnittsbewertung über alle Filme zurückgeben.");
      OptionalDouble averageRating = getAverageRating();
      averageRating.ifPresent(System.out::println);
      System.out.println();

      /* filter, sorted, limit/skip, forEach */
      System.out.println("Die 5 besten Horrorfilme ausgeben.");
      printTop5HorrorMovies();
      System.out.println();

      /* max/min/count */
      System.out.println("Den längsten Film zurückgeben.");
      Optional<Movie> longestMovie = getLongestMovie();
      longestMovie.ifPresent(System.out::println);
      System.out.println();
   }

   /** Prints all thrillers with a rating of at least 7 in the format "Title (Year)". */
   private static void printThrillerWithRatingGE7() {
      movies.stream()
            .filter(m -> m.genres().contains(Genre.THRILLER))
            .filter(m -> m.rating() >= 7)
            .map(m -> m.title() + " (" + m.year() + ")")
            .forEach(System.out::println);
   }

   /**
    * Returns the average rating across all movies.
    *
    * @return an {@link java.util.OptionalDouble} with the average, or empty if the list is empty
    */
   private static OptionalDouble getAverageRating() {
      return movies.stream()
            .mapToDouble(m -> m.rating()) // .mapToDouble(Movie::rating)
            .average();
   }

   /** Prints the top 5 horror movies sorted by rating in descending order. */
   private static void printTop5HorrorMovies() {
      movies.stream()
            .filter(m -> m.genres().contains(Genre.HORROR))
            .sorted((m1, m2) -> Double.compare(m2.rating(), m1.rating()))
            .limit(5)
            .forEach(System.out::println);
   }

   /**
    * Returns the movie with the longest runtime.
    *
    * @return an {@link Optional} containing the longest movie, or empty if the list is empty
    */
   private static Optional<Movie> getLongestMovie() {
      return movies.stream()
            .max((m1, m2) -> Integer.compare(m1.runtimeInMinutes(), m2.runtimeInMinutes()));
   }

}
