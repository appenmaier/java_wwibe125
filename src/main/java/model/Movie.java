package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

   private final String title;
   private final String publishingYear;
   private double rating;

}
