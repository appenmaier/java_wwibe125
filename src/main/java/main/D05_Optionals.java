package main;

import java.util.Optional;
import java.util.Random;

/**
 * Demonstrates how to use {@link java.util.Optional} to avoid null checks.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class D05_Optionals {

   public static void main(String[] args) {
      /* Approach without Optionals */
      String text = getText();

      if (text != null) {
         System.out.println(text.toUpperCase());
      } else {
         System.err.println("null");
      }

      /* Approach with Optionals */
      Optional<String> text2 = getText2();

      if (text2.isPresent()) {
         System.out.println(text2.get().toUpperCase());
      } else {
         System.err.println("empty");
      }

      text2.ifPresentOrElse(t -> System.out.println(t.toUpperCase()),
            () -> System.err.println("empty"));
   }

   /**
    * Returns a text string or {@code null} with equal probability.
    *
    * @return {@code "Hello World"} or {@code null}
    */
   public static String getText() {
      String text = null;

      Random random = new Random();
      if (random.nextBoolean()) {
         text = "Hello World";
      }

      return text;
   }

   /**
    * Returns an {@link Optional} containing a text string or an empty Optional with equal
    * probability.
    *
    * @return an {@code Optional} with {@code "Hello World"} or an empty {@code Optional}
    */
   public static Optional<String> getText2() {
      Optional<String> text = Optional.empty();

      Random random = new Random();
      if (random.nextBoolean()) {
         text = Optional.of("Hello World");
      }

      return text;
   }

}
