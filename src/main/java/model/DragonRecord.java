package model;

/**
 * Represents a dragon using a Java record. Records automatically provide a
 * canonical constructor, accessor methods, and implementations of
 * {@code equals}, {@code hashCode}, and {@code toString}. Note that record
 * fields are implicitly final (immutable). Compare with {@link DragonClass} and
 * {@link DragonLombok}.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public record DragonRecord(String name, DragonType type, int age) {

}
