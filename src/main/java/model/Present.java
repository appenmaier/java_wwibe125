package model;

/**
 * Abstract base class for all presents. Implements the wrapping behaviour
 * defined by {@link Wrappable}.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public abstract class Present implements Wrappable {

   private boolean isWrapped;

   @Override
   public void wrap() {
      isWrapped = true;
   }

   @Override
   public void unwrap() {
      isWrapped = false;
   }

   public boolean isWrapped() {
      return isWrapped;
   }

}
