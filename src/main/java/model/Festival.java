package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * Represents a music festival with a name and a schedule mapping performances to stages.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public record Festival(String name, Map<Performance, Stage> schedule) { // 1

   /**
    * Adds a performance to the festival schedule on the given stage.
    *
    * @param performance the performance to add
    * @param stage       the stage on which the performance takes place
    * @throws DuplicatePerformanceException if the performance is already in the schedule
    */
   public void addPerformance(Performance performance, Stage stage) // 0,5
         throws DuplicatePerformanceException {
      // 0,5

      if (schedule.containsKey(performance)) { // 1
         throw new DuplicatePerformanceException(performance); // 1
      }

      schedule.put(performance, stage); // 1
   } // 4

   /**
    * Returns the stage on which the band with the given name performs, if found.
    *
    * @param bandName the name of the band to search for
    * @return an {@link Optional} containing the stage, or an empty Optional if not found
    */
   public Optional<Stage> getStageByBandName(String bandName) { // 0,5
      Optional<Stage> stage = Optional.empty(); // 1

      for (Entry<Performance, Stage> entry : schedule.entrySet()) { // 1
         Performance p = entry.getKey(); // 0,5
         Stage s = entry.getValue(); // 0,5

         if (p.getBandName().equals(bandName)) { // 1
            stage = Optional.of(s); // 1
            break; // +1
         }
      }

      return stage; // 0,5
   } // 6

   /**
    * Returns all performances of the given music genre, sorted by their natural order.
    *
    * @param genre the music genre to filter by
    * @return a sorted list of performances matching the given genre
    */
   public List<Performance> getPerformancesByGenre(MusicGenre genre) { // 0,5
      List<Performance> performances = new ArrayList<>(); // 0,5

      for (Performance f : schedule.keySet()) { // 1
         if (f.getGenre().equals(genre)) { // if (f.getGenre() == genre) { // 1
            performances.add(f); // 0,5
         }
      }

      performances.sort(null); // Collections.sort(performances); // 0,5

      return performances; // 0,5
   } // 4,5

}
