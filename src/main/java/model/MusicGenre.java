package model;

/**
 * Represents a music genre with a human-readable description.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public enum MusicGenre {

   ROCK("Rock"), POP("Pop"), JAZZ("Jazz"), METAL("Metal"), ELECTRONIC("Electronic");

   private final String description;

   MusicGenre(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

}
