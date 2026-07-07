package model;

/**
 * Represents a book that can be given as a present.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class Book extends Present {

   private final String title;
   private final String author;

   /**
    * Creates a new book with the given title and author.
    *
    * @param title  the title of the book
    * @param author the author of the book
    */
   public Book(String title, String author) {
      this.title = title;
      this.author = author;
   }

   @Override
   public String getDescription() {
      return title + " " + author;
   }

}
