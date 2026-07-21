package model;

import java.time.LocalTime;

/**
 * Represents a festival performance as an immutable record with a band name, start time, and music
 * genre.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public record PerformanceRecord(String bandName, LocalTime startTime, MusicGenre genre) // 1,5
      implements Comparable<PerformanceRecord> { // 0,5

   @Override
   public int compareTo(PerformanceRecord other) { // 0,5
      return startTime.compareTo(other.startTime); // 1,5
   } // 2

} // 4
