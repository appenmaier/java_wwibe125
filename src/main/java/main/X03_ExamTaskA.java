package main;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Optional;

import model.DuplicatePerformanceException;
import model.Festival;
import model.MusicGenre;
import model.Performance;
import model.Stage;
import model.StageSize;

/**
 * Demo for exam task A: models a music festival with stages, performances, and scheduling.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class X03_ExamTaskA {

   public static void main(String[] args) {
      Performance p1 = new Performance("Die Ärtze", LocalTime.of(9, 0, 0), MusicGenre.ROCK);
      Performance p2 =
            new Performance("Sportfreunde Stiller", LocalTime.of(12, 0, 0), MusicGenre.ROCK);
      Performance p3 = new Performance("Miley Cyrus", LocalTime.of(9, 0, 0), MusicGenre.POP);
      Performance p4 = new Performance("Britney Spears", LocalTime.of(11, 0, 0), MusicGenre.POP);

      Stage rockStage = new Stage("Rock-Bühne", StageSize.LARGE);
      Stage popStage = new Stage("Pop-Bühne", StageSize.MEDIUM);

      Festival festival = new Festival("Rock&Pop im Park 2026", new HashMap<>());

      try {
         festival.addPerformance(p1, rockStage);
         festival.addPerformance(p2, rockStage);
         festival.addPerformance(p3, popStage);
         festival.addPerformance(p4, popStage);
         festival.addPerformance(p4, rockStage);
      } catch (DuplicatePerformanceException e) {
         System.err.println(e.getMessage());
      }

      System.out.println(festival); // System.out.println(festival.toString());

      Optional<Stage> stage = festival.getStageByBandName("Britney Spears");
      if (stage.isPresent()) {
         System.out.println(stage.get().name());
      }

      stage.ifPresent(s -> System.out.println(s.name()));

      System.out.println(festival.getPerformancesByGenre(MusicGenre.ROCK));
   }

}
