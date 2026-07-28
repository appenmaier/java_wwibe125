package main;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

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

      /* filter, findAny/findFirst */
      System.out.println("Ein Drama zurückgeben.");
      Optional<Movie> drama = getDrama();
      drama.ifPresent(System.out::println);
      System.out.println();

      /* anyMatch/allMatch/noneMatch */
      System.out.println("Gibt es einen Horrorfilm, der vor 1982 erschienen ist?");
      boolean horrorMovieBefore1982 = horrorMovieBefore1982();
      System.out.println(horrorMovieBefore1982);
      System.out.println();

      /* filter, toList */
      System.out.println("Alle Kurzfilme (< 90 Minuten) zurückgeben.");
      List<Movie> allShortMovies = getShortMovies();
      allShortMovies.forEach(System.out::println);
      System.out.println();

      /* map, distinct, sorted, toList */
      System.out.println("Alle Jahre sortiert zurückgeben.");
      List<String> allYearsSorted = getAllYearsSorted();
      allYearsSorted.forEach(System.out::println);
      System.out.println();
      allYearsSorted.reversed().forEach(System.out::println);
      System.out.println();

      /* flatMap, collect, Collectros.toSet */
      System.out.println("Alle vorkommenden Genres zurückgeben.");
      Set<Genre> allGenres = getAllGenres();
      allGenres.forEach(System.out::println);
      System.out.println();

      /* collect, Collectors.partitioningBy */
      System.out.println("Alle Filme partitioniert nach Bewertung >= 7 zurückgeben.");
      Map<Boolean, List<Movie>> moviesPartitionedByRating = getMoviesPartitionedByRating();
      moviesPartitionedByRating
            .forEach((partition, movies) -> System.out.println(partition + ": " + movies));
      System.out.println();

      /* collect, Collectors.groupingBy */
      System.out.println("Alle Filme gruppiert nach Jahr zurückgeben.");
      Map<String, List<Movie>> moviesGroupedByYear = getMoviesGroupedByYear();
      moviesGroupedByYear.forEach((year, movies) -> System.out.println(year + ": " + movies));
      System.out.println();

      /* collect, Collectors.groupingBy, Collectors.mapping, Collectors.toList/Collectors.joining */
      System.out.println("Alle Filmtitel gruppiert nach Jahr ausgeben.");
      printTitlesGroupedByYear();
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

   /**
    * Returns any drama from the movie list.
    *
    * @return an {@link Optional} containing a drama, or empty if none exists
    */
   private static Optional<Movie> getDrama() {
      return movies.stream().filter(m -> m.genres().contains(Genre.DRAMA)).findAny();
   }

   /**
    * Returns whether any horror movie was released before 1982.
    *
    * @return {@code true} if at least one horror movie was released before 1982
    */
   private static boolean horrorMovieBefore1982() {
      return movies.stream()
            .anyMatch(m -> m.genres().contains(Genre.HORROR) && m.year().compareTo("1982") < 0);
   }

   /**
    * Returns all short movies with a runtime of less than 90 minutes.
    *
    * @return a list of movies shorter than 90 minutes
    */
   private static List<Movie> getShortMovies() {
      return movies.stream().filter(m -> m.runtimeInMinutes() < 90).toList();
   }

   /**
    * Returns all distinct release years across all movies, sorted in ascending order.
    *
    * @return a sorted list of distinct year strings
    */
   private static List<String> getAllYearsSorted() {
      return movies.stream().map(Movie::year).distinct().sorted().toList();
   }

   /**
    * Returns all distinct genres that appear across all movies.
    *
    * @return a set of all genres present in the movie list
    */
   private static Set<Genre> getAllGenres() {
      return movies.stream().flatMap(m -> m.genres().stream()).collect(Collectors.toSet());
   }

   /**
    * Partitions all movies into two groups based on whether their rating is at least 7.
    *
    * @return a map with {@code true} for movies rated &ge; 7 and {@code false} for the rest
    */
   private static Map<Boolean, List<Movie>> getMoviesPartitionedByRating() {
      return movies.stream().collect(Collectors.partitioningBy(m -> m.rating() >= 7));
   }

   /**
    * Groups all movies by their release year.
    *
    * @return a map from year string to the list of movies released in that year
    */
   private static Map<String, List<Movie>> getMoviesGroupedByYear() {
      return movies.stream().collect(Collectors.groupingBy(Movie::year));
   }

   /** Prints all movie titles grouped by release year, once as a list and once as a joined string. */
   private static void printTitlesGroupedByYear() {
      Map<String, List<String>> titlesAsList = movies.stream()
            .collect(Collectors.groupingBy(Movie::year,
                  Collectors.mapping(Movie::title, Collectors.toList())));
      titlesAsList.forEach((year, titles) -> System.out.println(year + ": " + titles));

      System.out.println();

      Map<String, String> titlesAsString = movies.stream()
            .collect(Collectors.groupingBy(Movie::year,
                  Collectors.mapping(Movie::title, Collectors.joining(", "))));
      titlesAsString.forEach((year, titles) -> System.out.println(year + ": " + titles));
   }

}
