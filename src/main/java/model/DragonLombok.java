package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a dragon using Lombok annotations. {@code @Data} generates
 * getters, setters, {@code equals}, {@code hashCode}, and {@code toString}.
 * {@code @AllArgsConstructor} generates a constructor for all fields. Compare
 * with {@link DragonClass} and {@link DragonRecord}.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class DragonLombok {

   private final String name;
   private final DragonType type;
   private int age;

}
