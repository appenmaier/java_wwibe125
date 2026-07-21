package model;

import java.time.LocalTime;

import lombok.Data;

/**
 * Represents a festival performance with a band name, start time, and music genre.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
@Data // 0,25
public class Performance implements Comparable<Performance> { // 1

   private final String bandName; // 0,25
   private final LocalTime startTime; // 0,25
   private final MusicGenre genre; // 0,25

   @Override
   public int compareTo(Performance other) { // 0,5
      return startTime.compareTo(other.startTime); // 1,5
   } // 2

} // 4
