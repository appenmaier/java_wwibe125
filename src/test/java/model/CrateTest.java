package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for the {@link Crate} class.
 *
 * @author Daniel Appenmaier
 * @version 1.0
 */
public class CrateTest {

   Crate crate;

   @Mock
   Sphere sphere3;

   @Mock
   Sphere sphere5;

   @Mock
   Body body;

   /**
    * Creates a fresh empty crate and initializes Mockito mocks before each test.
    */
   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
      crate = new Crate(new ArrayList<>());
   }

   /**
    * Verifies that bodies are added correctly and that passing {@code null} throws a
    * {@link NullPointerException}.
    */
   @Test
   void testAddBody() {
      crate.addBody(sphere3);
      crate.addBody(sphere5);

      assertTrue(crate.bodies().size() == 2); // assertFalse

      assertEquals(sphere3, crate.bodies().get(0)); // assertNotEquals
      assertEquals(sphere5, crate.bodies().get(1));

      assertThrows(NullPointerException.class, () -> crate.addBody(null)); // assertDoesNotThrow
   }

   /**
    * Verifies that the body with the highest volume is returned correctly when the crate contains
    * multiple bodies.
    */
   @Test
   void testGetBodyWithHighestVolume() {
      crate.addBody(sphere3);
      crate.addBody(sphere5);
      crate.addBody(body);

      when(sphere3.getVolume()).thenReturn(3.0);
      when(sphere5.getVolume()).thenReturn(5.0);
      when(body.getVolume()).thenReturn(2.0);

      assertEquals(Optional.of(sphere5), crate.getBodyWithHighestVolume());
      assertEquals(sphere5, crate.getBodyWithHighestVolume().get());
   }

   /**
    * Verifies that an empty Optional is returned when the crate contains no bodies.
    */
   @Test
   void testGetBodyWithHighestVolume2() {
      assertEquals(Optional.empty(), crate.getBodyWithHighestVolume());
   }

   /**
    * Verifies that only {@link Sphere} instances are returned and non-sphere bodies are excluded.
    */
   @Test
   void testGetAllSpheres() {
      crate.addBody(sphere3);
      crate.addBody(body);
      crate.addBody(sphere5);

      assertEquals(2, crate.getAllSpheres().size());
      assertTrue(crate.getAllSpheres().size() == 2);
   }

   /**
    * Verifies that an empty (but non-null) list is returned when the crate contains no spheres.
    */
   @Test
   void testGetAllSpheres2() {
      assertTrue(crate.getAllSpheres().isEmpty());
      assertNotNull(crate.getAllSpheres()); // assertNull
   }

}
