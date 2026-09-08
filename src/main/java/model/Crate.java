package model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Represents a crate that holds a collection of geometric bodies.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public record Crate(List<Body> bodies) {

   /**
    * Adds the given body to this crate.
    *
    * @param body the body to add
    * @throws NullPointerException if {@code body} is {@code null}
    */
   public void addBody(Body body) throws NullPointerException {
      if (body == null) {
         throw new NullPointerException();
      }

      bodies.add(body);
   }

   /**
    * Returns the body with the highest volume in this crate, or an empty Optional if the crate is
    * empty.
    *
    * @return an Optional containing the body with the highest volume, or empty if no bodies exist
    */
   public Optional<Body> getBodyWithHighestVolume() {
      /* Variante A */
      // Optional<Body> bodyWithHighestVolume = Optional.empty(); // Body bodyWithHighestVolume =
      // null;
      //
      // double highestVolume = 0;
      //
      // for (Body b : bodies) {
      // if (b.getVolume() > highestVolume) {
      // highestVolume = b.getVolume();
      // bodyWithHighestVolume = Optional.of(b); // bodyWithHighestVolume = b;
      // }
      // }
      //
      // return bodyWithHighestVolume; // return Optional.ofNullable(bodyWithHighestVolume);

      /* Variante B */
      // return bodies.stream().max((b1, b2) -> Double.compare(b1.getVolume(), b2.getVolume()));

      /* Variante C */
      return bodies.stream().max(Comparator.comparingDouble(Body::getVolume));
   }

   /**
    * Returns a list of all {@link Sphere} instances contained in this crate.
    *
    * @return list of spheres; empty list if none exist
    */
   public List<Sphere> getAllSpheres() {
      /* Variante A */
      // List<Sphere> spheres = new ArrayList<>();
      //
      // for (Body b : bodies) {
      // if (b instanceof Sphere) {
      // Sphere s = (Sphere) b;
      // spheres.add(s);
      // }
      // }
      //
      // return spheres;

      /* Variante B */
      // return bodies.stream().filter(b -> b instanceof Sphere).map(b -> (Sphere) b).toList();

      /* Variante C */
      return bodies.stream().filter(Sphere.class::isInstance).map(Sphere.class::cast).toList();
   }

}
