package model;

/**
 * Enumerates the possible size categories of a festival stage.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public enum StageSize {

   SMALL("Klein"), MEDIUM("Mittel"), LARGE("Groß");

   private final String description;

   StageSize(String description) {
      this.description = description;
   }

   /**
    * Returns the German description of this stage size.
    *
    * @return the German label for this size
    */
   public String getDescription() {
      return description;
   }

}
