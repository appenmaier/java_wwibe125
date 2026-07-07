package model;

import java.util.Objects;

/**
 * Represents a dragon using a regular Java class with manually written
 * boilerplate (constructor, getters, setters, equals, hashCode, toString).
 * Compare with {@link DragonRecord} and {@link DragonLombok}.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class DragonClass {

   private final String name;
   private final DragonType type;
   private int age;

   /**
    * Creates a new dragon with the given name, type and age.
    *
    * @param name the name of the dragon
    * @param type the elemental type of the dragon
    * @param age  the age of the dragon in years
    */
   public DragonClass(String name, DragonType type, int age) {
      this.name = name;
      this.type = type;
      this.age = age;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public DragonType getType() {
      return type;
   }

   @Override
   public int hashCode() {
      return Objects.hash(age, name, type);
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
      DragonClass other = (DragonClass) obj;
      return age == other.age && Objects.equals(name, other.name) && type == other.type;
   }

   @Override
   public String toString() {
      return "DragonClass [name=" + name + ", type=" + type + ", age=" + age + "]";
   }

}
