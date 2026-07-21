package model;

import lombok.Data;

/**
 * Represents a student with a matriculation number and a name.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
@Data
public class Student {

   private final String id;
   private final String name;

}
