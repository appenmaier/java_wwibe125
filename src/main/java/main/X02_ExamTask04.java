package main;

import model.Book;
import model.SantaClaus;
import model.Toy;

/**
 * Exam task 04: Demonstrates polymorphism and collections by building Santa's
 * present list, wrapping all presents, and extracting only the toys.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class X02_ExamTask04 {

   public static void main(String[] args) {
      SantaClaus santa = new SantaClaus();

      Toy t1 = new Toy("PS5 Pro", 899);
      Toy t2 = new Toy("PS5 Pro", 899);

      santa.addPresent(t1); // Upcast
      santa.addPresent(new Book("Es", "Stephen King")); // Upcast
      santa.getPresents().addFirst(new Toy("Spielzeugeisenbahn", 59.99)); // Upcast

      System.out.println(santa);
      System.out.println(t1.equals(t2));
      santa.wrapAllPresents();
      System.out.println(santa.getAllToys());
   }

}
