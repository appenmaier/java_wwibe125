# Wiederholung: Termin 2 - 5

**Aufgabe 1**

Erstelle die Klasse `Performance` anhand des abgebildeten Klassendiagramms (4 Punkte).

```mermaid
classDiagram
   Performance ..|> Comparable~Performance~ : implements
   Performance o-- MusicGenre
   class Performance {
      <<record>>
      bandName: String
      startTime: LocalTime
      genre: MusicGenre
      +compareTo(other: Performance) int
   }
   class Comparable~Performance~ {
      <<interface>>
      +compareTo(o: Performance) int
   }
   class MusicGenre {
      <<enumeration>>
      ROCK = Rock
      POP = Pop
      JAZZ = Jazz
      METAL = Metal
      ELECTRONIC = Electronic
      -description: String #123;final#125;
   }
   style Performance fill:#fff,stroke:#000
```

_Hinweis_

Die Methode `int compareTo(other: Performance)` soll so implementiert werden, dass Auftritte aufsteigend nach ihrer Startzeit sortiert werden können (2 Punkte).

**Aufgabe 2**

Erstelle die Klasse `Festival` anhand des abgebildeten Klassendiagramms (11,5 Punkte).

```mermaid
classDiagram
   Performance ..|> Comparable~Performance~ : implements
   Performance o-- MusicGenre
   Stage o-- StageSize
   Festival o-- Performance
   Festival o-- Stage
   class Performance {
      <<record>>
      bandName: String
      startTime: LocalTime
      genre: MusicGenre
      +compareTo(other: Performance) int
   }
   class Comparable~Performance~ {
      <<interface>>
      +compareTo(o: Performance) int
   }
   class Stage {
      <<record>>
      name: String 
      size: StageSize
   }
   class Festival {
      <<record>>
      name: String
      schedule: Map~Performance, Stage~
      +addPerformance(performance: Performance, stage: Stage) void
      +getStageByBandName(bandName: String) Optional~Stage~
      +getPerformancesByGenre(genre: MusicGenre) List~Performance~
   }
   class MusicGenre {
      <<enumeration>>
      ROCK = Rock
      POP = Pop
      JAZZ = Jazz
      METAL = Metal
      ELECTRONIC = Electronic
      -description: String #123;final#125;
   }
   class StageSize {
      <<enumeration>>
      SMALL = Klein
      MEDIUM = Mittel
      LARGE = Groß
      -description: String #123;final#125;
   }
   style Festival fill:#fff,stroke:#000
```

_Hinweise_

- Die Schlüssel-Werte-Paare des Assoziativspeichers `schedule` beinhalten als Schlüssel den Auftritt sowie als Wert die zugehörige Bühne
- Die Methode `void addPerformance(performance: Performance, stage: Stage)` soll dem Spielplan das eingehende Auftritt-Bühnen-Paar hinzufügen. Für den Fall, dass der Auftritt bereits im Spielplan vorhanden ist, soll die Ausnahme `DuplicatePerformanceException` ausgelöst werden (4 Punkte)
- Die Methode `Optional<Stage> getStageByBandName(bandName: String)` soll die Bühne zum eingehenden Bandnamen zurückgeben (3 Punkte)
- Die Methode `List<Performance> getPerformancesByGenre(genre: MusicGenre)` soll alle Auftritte zurückgeben, deren Musikgenre dem eingehenden Genre entspricht, aufsteigend sortiert nach ihrer Startzeit (3,5 Punkte)

**Links**

_folgt_
