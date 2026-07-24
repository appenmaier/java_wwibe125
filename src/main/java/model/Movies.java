package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Provides a movie dataset loaded from a CSV file.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class Movies {

   private final static int MAX_MOVIES = 50;
   private final static int MIN_VOTES = 100_000;
   private final static String PATH = "src/main/resources/movies.csv";

   /**
    * Immutable record representing a single movie entry.
    *
    * @param title            the movie title
    * @param genres           the list of genres
    * @param year             the release year
    * @param runtimeInMinutes the runtime in minutes
    * @param rating           the IMDb rating
    * @param votes            the number of votes
    */
   public record Movie(String title, List<Genre> genres, String year, int runtimeInMinutes,
         double rating, int votes) {
   }

   /** Enumeration of all supported movie genres. */
   public enum Genre {

      ACTION("Action"), ADVENTURE("Adventure"), ANIMATION("Animation"), BIOGRAPHY(
            "Biography"), COMEDY("Comedy"), CRIME("Crime"), DOCUMENTARY("Documentary"), DRAMA(
                  "Drama"), FAMILY("Family"), FANTASY("Fantasy"), FILM_NOIR("Film Noir"), HISTORY(
                        "History"), HORROR("Horror"), MUSIC("Music"), MUSICAL("Musical"), MYSTERY(
                              "Mystery"), NEWS("News"), ROMANCE("Romance"), SCIENCE_FICTION(
                                    "Science Fiction"), SPORT("Sport"), THRILLER(
                                          "Thriller"), WAR("War"), WESTERN("Western");

      private final String name;

      Genre(String name) {
         this.name = name;
      }

      /**
       * Returns the display name of this genre.
       *
       * @return the genre name
       */
      public String getName() {
         return name;
      }

   }

   /**
    * Loads up to {@value #MAX_MOVIES} movies from the CSV file, filtered by minimum vote count.
    *
    * @return a shuffled list of at most {@value #MAX_MOVIES} movies
    */
   public static List<Movie> getMovies() {
      List<Movie> movies = new ArrayList<>();
      File file = new File(PATH);

      try (Scanner scanner = new Scanner(file)) {
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(";");

            if (Integer.valueOf(tokens[5]) < MIN_VOTES) {
               continue;
            }

            String title = tokens[0];
            double rating = Double.valueOf(tokens[1]);
            int runtimeInMinutes = Integer.valueOf(tokens[2]);
            String year = tokens[3];
            ArrayList<Genre> genres = new ArrayList<>();
            String[] genreTexts = tokens[4].split(",");
            for (String text : genreTexts) {
               Genre genre = Genre.valueOf(text);
               genres.add(genre);
            }
            int votes = Integer.valueOf(tokens[5]);

            Movie movie = new Movie(title, genres, year, runtimeInMinutes, rating, votes);
            movies.add(movie);
         }
      } catch (FileNotFoundException e) {
      }

      Collections.shuffle(movies);

      return movies.subList(0, MAX_MOVIES);
   }

}
