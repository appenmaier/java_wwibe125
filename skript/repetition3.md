# Wiederholung: Termin 6 - 7

**Beispielklausuraufgabe B**

Erstelle die Klasse `FestivalQueries` anhand des abgebildeten Klassendiagramms.

```mermaid
classDiagram
   Performance --o FestivalQueries
   Stage --o FestivalQueries
   MusicGenre --o Performance
   StageSize --o Stage
   Comparable~T~ <|.. Performance : implements
   class MusicGenre {
      <<enumeration>>
      ROCK = Rock
      POP = Pop
      JAZZ = Jazz
      METAL = Metal
      ELECTRONIC = Electronic
      -description: String #123;final#125;
      +toString() String
   }
   class StageSize {
      <<enumeration>>
      SMALL = Klein
      MEDIUM = Mittel
      LARGE = Groß
      -description: String #123;final#125;
      +toString() String
   }
   class Stage {
      <<record>>
      name: String
      size: StageSize
   }
   class Comparable~T~ {
      <<interface>>
      +compareTo(o: T) int
   }
   class Performance {
      <<record>>
      bandName: String
      startTime: LocalTime
      genre: MusicGenre
      +compareTo(other: Performance) int
   }
   class FestivalQueries {
      <<record>>
      schedule: Map~Performance, Stage~
      +getAllBandNamesSorted() List~String~
      +getAllStagesSortedByName() List~Stage~
      +getPerformancesByStartTime() Map~LocalTime#44; List~Performance~~
      +numberOfStagesBySize(size: StageSize) long
   }
   style FestivalQueries fill:#fff,stroke:#000
```

_Hinweise_

- Die Methode `List<String> getAllBandNamesSorted()` soll die Bandnamen aller Auftritte aufsteigend sortiert zurückgeben (4 Punkte)
- Die Methode `List<Stage> getAllStagesSortedByName()` soll alle Bühnen ohne Dopplungen absteigend sortiert nach ihrem Namen zurückgeben (4 Punkte)
- Die Methode `Map<LocalTime, List<Performance>> getPerformancesByStartTime()` soll alle Auftritte gruppiert nach ihrer Startzeit zurückgeben (3,5 Punkte)
- Die Methode `long numberOfStagesBySize(size: StageSize)` soll die Anzahl der Einträge im Spielplan zurückgeben, bei denen die Bühne die eingehende Bühnengröße besitzt (3,5 Punkte)

**Links**

[Solution: ExamTaskB](../src/main/java/main/X04_ExamTaskB.java)
