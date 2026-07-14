package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a movie with a title, publishing year, and rating. Implements {@link Comparable} to
 * allow natural ordering by title.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class Movie implements Comparable<Movie> {

   private final String title;
   private final String publishingYear;
   private double rating;

   @Override
   public int compareTo(Movie anotherMovie) {
      return title.compareTo(anotherMovie.title);
   }

   /**
    * Increases the rating of this movie by 0.1.
    */
   public void incrementRating() {
      rating += 0.1;
   }

}
