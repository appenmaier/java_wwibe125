package model;

/**
 * Represents a sphere defined by its radius.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public record Sphere(double r) implements Body {

   @Override
   public double getVolume() {
      return (4 / 3) * Math.PI * Math.pow(r, 3);
   }

}
