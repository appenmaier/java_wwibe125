package model;

import java.util.Comparator;

/**
 * Comparator that orders {@link Movie} objects by rating in descending order
 * (highest rating first).
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class MovieByRatingDescendingComparator implements Comparator<Movie> {

   @Override
   public int compare(Movie movie1, Movie movie2) {
      // Double rating1 = movie1.getRating();
      // Double rating2 = movie2.getRating();
      // return rating2.compareTo(rating1);

      // return Double.valueOf(movie2.getRating()).compareTo(movie1.getRating());

      return Double.compare(movie2.getRating(), movie1.getRating());
   }

}
