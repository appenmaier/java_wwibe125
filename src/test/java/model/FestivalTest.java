package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for the {@link Festival} class using Mockito mocks for
 * {@link Performance} and {@link Stage} dependencies.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class FestivalTest { // 0,5

   Festival festival; // 0,5

   @Mock // 0,5
   Performance popPerformance1; // 0,5

   @Mock // 0,5
   Performance rockPerformance1; // 0,5

   @Mock // 0,5
   Performance rockPerformance2; // 0,5

   @Mock // 0,5
   Stage popStage; // 0,5

   @Mock // 0,5
   Stage rockStage; // 0,5

   /**
    * Initializes Mockito mocks and sets up a festival with two pre-scheduled performances.
    */
   @BeforeEach // 0,5
   void setUp() { // 0,5
      MockitoAnnotations.openMocks(this); // 1
      festival = new Festival("Rock & Pop 2026", new HashMap<>()); // 1

      festival.schedule().put(popPerformance1, popStage); // 1
      festival.schedule().put(rockPerformance1, rockStage); // 1
   } // 5

   /**
    * Verifies that a new performance can be added to the schedule without affecting existing entries.
    *
    * @throws DuplicatePerformanceException if the performance is already scheduled
    */
   @Test // 0,5
   void testAddPerformance() throws DuplicatePerformanceException { // 0,5
      festival.addPerformance(rockPerformance2, rockStage); // 1

      assertTrue(festival.schedule().containsKey(rockPerformance2)); // 1
      assertNotNull(festival.schedule().get(rockPerformance2)); // 1
      assertEquals(rockStage, festival.schedule().get(rockPerformance2)); // 1,5
      assertEquals(rockStage, festival.schedule().get(rockPerformance1)); // 1,5
      assertEquals(popStage, festival.schedule().get(popPerformance1)); // 1,5
   } // 8,5

   /**
    * Verifies that adding an already-scheduled performance throws a
    * {@link DuplicatePerformanceException}, regardless of which stage is given.
    */
   @Test // 0,5
   void testAddPerformance2() { // 0,5
      assertThrows(DuplicatePerformanceException.class,
            () -> festival.addPerformance(popPerformance1, popStage)); // 2
      assertThrows(DuplicatePerformanceException.class,
            () -> festival.addPerformance(popPerformance1, rockStage)); // 2
   } // 5

   /**
    * Verifies that the correct stage is returned for a known band name and that
    * an empty Optional is returned for an unknown band name.
    */
   @Test // 0,5
   void testGetStageByBandName() { // 0,5
      when(popPerformance1.getBandName()).thenReturn("Lady Gaga"); // 1
      when(rockPerformance1.getBandName()).thenReturn("Die Ärzte"); // 1

      assertEquals(Optional.of(rockStage), festival.getStageByBandName("Die Ärzte")); // 1,5
      assertEquals(Optional.empty(), festival.getStageByBandName("Sportfreunde Stiller")); // 1,5
   } // 6

   /**
    * Verifies that performances are filtered and sorted correctly by genre,
    * and that an empty list is returned for a genre with no scheduled performances.
    */
   @Test // 0,5
   void testGetPerformancesByGenre() { // 0,5
      festival.schedule().put(rockPerformance2, rockStage); // 1

      when(popPerformance1.getGenre()).thenReturn(MusicGenre.POP); // 1
      when(rockPerformance1.getGenre()).thenReturn(MusicGenre.ROCK); // 1
      when(rockPerformance2.getGenre()).thenReturn(MusicGenre.ROCK); // 1

      when(rockPerformance1.compareTo(rockPerformance2)).thenReturn(1); // 1
      when(rockPerformance2.compareTo(rockPerformance1)).thenReturn(-1); // 1

      List<Performance> rockPerformances = festival.getPerformancesByGenre(MusicGenre.ROCK); // 0,5
      assertTrue(rockPerformances.size() == 2); // 0,5
      assertTrue(rockPerformances.contains(rockPerformance1)); // 1
      assertTrue(rockPerformances.contains(rockPerformance2)); // 1

      assertTrue(rockPerformances.getFirst().equals(rockPerformance2)); // 1
      assertEquals(rockPerformance1, rockPerformances.getLast()); // 1,5

      assertEquals(0, festival.getPerformancesByGenre(MusicGenre.ELECTRONIC).size()); // 1,5
      assertEquals(new ArrayList<>(), festival.getPerformancesByGenre(MusicGenre.ELECTRONIC)); // 1,5
      assertNotNull(festival.getPerformancesByGenre(MusicGenre.ELECTRONIC)); // 1
   } // 16,5

} // 47
