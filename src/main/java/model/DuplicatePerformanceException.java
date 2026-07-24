package model;

/**
 * Thrown when a performance is added to a festival schedule that already contains it.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class DuplicatePerformanceException extends Exception {

   private static final long serialVersionUID = 1L;

   /**
    * Creates a new exception for the given duplicate performance.
    *
    * @param performance the performance that already exists in the schedule
    */
   public DuplicatePerformanceException(Performance performance) {
      super("Performance " + performance + " already exists");
   }

}
