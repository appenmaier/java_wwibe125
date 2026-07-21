package model;

/**
 * Represents the possible colors of a dice.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public enum Color {

   RED("rot"), GREEN("grün"), BLUE("blau");

   private final String description;

   Color(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

}
