package model;

/**
 * Represents an object that can be wrapped and unwrapped like a present.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public interface Wrappable {

   /**
    * Returns a human-readable description of this object.
    *
    * @return the description
    */
   String getDescription();

   /**
    * Wraps this object.
    */
   void wrap();

   /**
    * Unwraps this object.
    */
   void unwrap();

}
