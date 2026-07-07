package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents Santa Claus, who maintains a list of presents and can wrap them
 * all at once.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class SantaClaus {

   private final List<Present> presents;

   public SantaClaus() {
      this.presents = new ArrayList<>();
   }

   public List<Present> getPresents() {
      return presents;
   }

   /**
    * Adds a present to Santa's list.
    *
    * @param present the present to add
    */
   public void addPresent(Present present) {
      presents.add(present);
   }

   /**
    * Wraps all presents in Santa's list.
    */
   public void wrapAllPresents() {
      for (int i = 0; i < presents.size(); i++) {
         Present p = presents.get(i);
         p.wrap(); // Dynamische Polymorphie
      }

      for (Present p : presents) {
         p.wrap();
      }
   }

   /**
    * Returns a list containing only the {@link Toy} presents from Santa's list.
    *
    * @return list of toys
    */
   public List<Toy> getAllToys() {
      List<Toy> allToys = new ArrayList<>();

      for (Present p : presents) {
         if (p instanceof Toy) {
            Toy t = (Toy) p; // Downcast
            allToys.add(t);
         } else if (p instanceof Book b) { // Downcast
            System.out.println(b.getDescription()); // Statische Polymorphie
         }
      }

      return allToys;
   }

   @Override
   public int hashCode() {
      return Objects.hash(presents);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      SantaClaus other = (SantaClaus) obj;
      return Objects.equals(presents, other.presents);
   }

   @Override
   public String toString() {
      return "SantaClaus [presents=" + presents + "]";
   }

}
