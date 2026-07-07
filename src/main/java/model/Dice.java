package model;

import java.util.Random;

/**
 * Represents a dice that rolls a random value and color on each throw.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class Dice {

   private Color color;
   private int value;

   public Dice() {
      rollTheDice();
   }

   /**
    * Rolls the dice by randomly setting a new value (1–6) and a new color.
    */
   public void rollTheDice() {
      Random random = new Random();

      value = random.nextInt(1, 7);

      color = switch (random.nextInt(1, 4)) {
         case 1  -> Color.RED;
         case 2  -> Color.GREEN;
         default -> Color.BLUE;
      };
   }

   public Color getColor() {
      return color;
   }

   public int getValue() {
      return value;
   }

}
