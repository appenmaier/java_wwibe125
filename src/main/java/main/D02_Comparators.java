package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Movie;

public class D02_Comparators {

   public static void main(String[] args) {
      /* Numbers */
      List<Integer> numbers = new ArrayList<>();
      numbers.add(5);
      numbers.add(-2);
      numbers.add(943);
      numbers.add(5);
      numbers.add(-44);

      System.out.println(numbers);
      Collections.sort(numbers);
      System.out.println(numbers);

      /* Names */
      List<String> names = new ArrayList<>();
      names.add("Anna");
      names.add("Xaver");
      names.add("anna");
      names.add("Alf");
      names.add("Bert");

      System.out.println(names);
      Collections.sort(names);
      System.out.println(names);

      /* Movies */
      List<Movie> movies = new ArrayList<>();
      movies.add(new Movie("John Wick 4", "2023", 7.6));
      movies.add(new Movie("Disaster Movie", "2008", 1.9));
      movies.add(new Movie("Der Pate", "1972", 9.2));

      System.out.println(movies);
      // Collections.sort(movies);
      System.out.println(movies);
   }

}
