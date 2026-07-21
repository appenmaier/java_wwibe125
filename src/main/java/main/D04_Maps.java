package main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.Exam;
import model.Student;

/**
 * Demonstrates basic {@link java.util.Map} operations such as inserting, reading, overriding, and
 * iterating over key-value pairs using a {@link java.util.HashMap}.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class D04_Maps {

   public static void main(String[] args) {
      Map<Student, Exam> studentsWithExam = new HashMap<>();

      LocalDate today = LocalDate.now();

      /* Put values */
      studentsWithExam.put(new Student("8172549", "Hans"), new Exam(today, 3.2));
      studentsWithExam.put(new Student("1280025", "Peter"), new Exam(today, 1.7));
      studentsWithExam.put(new Student("2284071", "Lisa"), new Exam(today, 4.6));
      studentsWithExam.put(new Student("5529631", "Heidi"), new Exam(today, 2.1));

      /* Read values */
      System.out.println(studentsWithExam.get(new Student("2284071", "Lisa")));

      /* Check keys and values */
      System.out.println(studentsWithExam.containsKey(new Student("5529631", "Heidi")));
      System.out.println(studentsWithExam.containsValue(new Exam(today, 1.7)));

      /* Override values */
      Exam oldExam = studentsWithExam.put(new Student("2284071", "Lisa"), new Exam(today, 3.7));
      System.out.println("oldExam: " + oldExam);
      System.out.println("newExam: " + studentsWithExam.get(new Student("2284071", "Lisa")));

      /* Print values */
      System.out.println(studentsWithExam);

      /* Collections: Key Set */
      System.out.println("Names:");
      for (Student s : studentsWithExam.keySet()) {
         System.out.printf("%-10s [ ]%n", s.getName());
      }
      System.out.println();

      /* Collections: All Values */
      double total = 0;
      int counter = 0;
      for (Exam e : studentsWithExam.values()) {
         total += e.getGrade();
         counter++;
      }
      System.out.println("Average Grade: " + total / counter);
      System.out.println();

      /* Collections: Entry Set */
      System.out.println("Grade list:");
      for (Entry<Student, Exam> entry : studentsWithExam.entrySet()) {
         Student s = entry.getKey();
         Exam e = entry.getValue();
         System.out.printf("%-7s: %s%n", s.getId(), e.getGrade());
      }
      System.out.println();

      /* forEach */
      System.out.println("Grade list:");
      studentsWithExam.forEach((s, e) -> System.out.printf("%-7s: %s%n", s.getId(), e.getGrade()));
   }

}
