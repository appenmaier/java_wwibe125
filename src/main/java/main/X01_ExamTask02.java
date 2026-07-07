package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Color;
import model.Dice;

/**
 * Exam task 02: A dice game where the player guesses which color scores the
 * highest sum. The game continues until the player reaches the winning points.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class X01_ExamTask02 {

   private static List<Dice> dices;
   private static int winningPoints;
   private static int currentPoints;
   private static int rounds;
   private static Scanner scanner;

   public static void main(String[] args) {
      scanner = new Scanner(System.in);

      dices = new ArrayList<>(); // Upcast
      for (int i = 0; i < 5; i++) {
         dices.add(new Dice());
      }

      System.out.println("Gewinnpunkte: ");
      winningPoints = scanner.nextInt();

      while (currentPoints < winningPoints) {
         rounds++;
         System.out.println("Farbe: ");
         String color = scanner.next();

         int red = 0;
         int green = 0;
         int blue = 0;

         for (int i = 0; i < dices.size(); i++) {
            Dice dice = dices.get(i);
            dice.rollTheDice();

            if (dice.getColor().equals(Color.RED)) {
               red += dice.getValue();
            } else if (dice.getColor().equals(Color.GREEN)) {
               green += dice.getValue();
            } else {
               blue += dice.getValue();
            }
         }

         if (color.equals("Rot") && red >= green && red >= blue) {
            currentPoints++;
            System.out.println("Richtig");
         } else if (color.equals("Grün") && green >= red && green >= blue) {
            currentPoints++;
            System.out.println("Richtig");
         } else if (color.equals("Blau") && blue >= red && blue >= green) {
            currentPoints++;
            System.out.println("Richtig");
         } else {
            System.out.println("Falsch");
         }

         System.out.println("Rot: " + red);
         System.out.println("Grün: " + green);
         System.out.println("Blau: " + blue);
      }

      System.out.println("Runden: " + rounds);
   }

}
