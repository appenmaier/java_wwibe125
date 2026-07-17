package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents an exam result with a date and a grade.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class Exam {

   private final LocalDate examDate;
   private double grade;

}
