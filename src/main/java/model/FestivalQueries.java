package model;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Provides stream-based query methods over a festival schedule.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public record FestivalQueries(Map<Performance, Stage> schedule) { // 1

   /**
    * Returns a sorted list of all distinct band names in the schedule.
    *
    * @return alphabetically sorted list of band names
    */
   public List<String> getAllBandNamesSorted() { // 0,5
      return schedule.keySet() // 1
            .stream() // 0,5
            .map(Performance::getBandName) // 1
            // .sorted((n1, n2) -> n1.compareTo(n2))
            // .sorted(String::compareTo)
            .distinct() // +0,5
            .sorted() // 0,5
            .toList(); // 0,5
   } // 4

   /**
    * Returns a sorted list of all distinct stages, ordered by name in descending order.
    *
    * @return list of stages sorted by name descending
    */
   public List<Stage> getAllStagesSortedByName() { // 0,5
      return schedule.values() // 1
            .stream() // 0,5
            .distinct() // 0,5
            .sorted((s1, s2) -> s2.name().compareTo(s1.name())) // 1
            // .sorted(Comparator.comparing(Stage::name)) // 0,5
            .toList(); // 0,5
      // .reversed(); // 0,5
   } // 4

   /**
    * Groups all performances by their start time.
    *
    * @return a map from start time to the list of performances at that time
    */
   public Map<LocalTime, List<Performance>> getPerformancesByStartTime() { // 0,5
      return schedule.keySet() // 1
            .stream() // 0,5
            .collect(Collectors.groupingBy(Performance::getStartTime)); // 1,5
   } // 3,5

   /**
    * Counts how many stages in the schedule have the given size.
    *
    * @param size the stage size to filter by
    * @return the number of stages with the given size
    */
   public long numberOfStagesBySize(StageSize size) { // 0,5
      return schedule.values() // 1
            .stream() // 0,5
            // .filter(s -> s.size() == size) // 1
            .filter(s -> s.size().equals(size)) // 1
            .count(); // 0,5
   } // 3,5

   /**
    * Groups band names by start time, collecting each group as a list.
    *
    * @return a map from start time to a list of band names performing at that time
    */
   public Map<LocalTime, List<String>> getBandNamesByStartTimeAsList() { // 0,5
      return schedule.keySet() // 1
            .stream() // 0,5
            .collect(Collectors.groupingBy(Performance::getStartTime, // 1,5
                  Collectors.mapping(Performance::getBandName, Collectors.toList()))); // 1,5
   } // 5

   /**
    * Groups band names by start time, joining each group into a comma-separated string.
    *
    * @return a map from start time to a comma-separated string of band names
    */
   public Map<LocalTime, String> getBandNamesByStartTimeAsString() { // 0,5
      return schedule.keySet() // 1
            .stream() // 0,5
            .collect(Collectors.groupingBy(Performance::getStartTime, // 1,5
                  Collectors.mapping(Performance::getBandName, Collectors.joining(", ")))); // 1,5
   } // 5

   /**
    * Counts the number of performances grouped by start time.
    *
    * @return a map from start time to the count of performances at that time
    */
   public Map<LocalTime, Long> getNumberOfPerformancesByStartTime() { // 0,5
      return schedule.keySet() // 1
            .stream() // 0,5
            .collect(Collectors.groupingBy(Performance::getStartTime, Collectors.counting())); // 2
   } // 4

}
