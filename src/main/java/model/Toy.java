package model;

import java.util.Objects;

/**
 * Represents a toy that can be given as a present.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class Toy extends Present {

   private final String description;
   private double priceInEuro;

   /**
    * Creates a new toy with the given description and price.
    *
    * @param description  a short description of the toy
    * @param priceInEuro  the price of the toy in euros
    */
   public Toy(String description, double priceInEuro) {
      this.description = description;
      this.priceInEuro = priceInEuro;
   }

   @Override
   public String getDescription() {
      return description;
   }

   public double getPriceInEuro() {
      return priceInEuro;
   }

   public void setPriceInEuro(double priceInEuro) {
      this.priceInEuro = priceInEuro;
   }

   @Override
   public int hashCode() {
      return Objects.hash(description, priceInEuro);
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
      Toy other = (Toy) obj;
      return Objects.equals(description, other.description)
            && Double.doubleToLongBits(priceInEuro) == Double.doubleToLongBits(other.priceInEuro);
   }

   @Override
   public String toString() {
      return "Toy [description=" + description + ", priceInEuro=" + priceInEuro + ", isWrapped()="
            + isWrapped() + "]";
   }

}
