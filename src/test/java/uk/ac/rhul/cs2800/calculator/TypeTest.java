package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the Type enum.
 *
 * @author chamb
 */
public class TypeTest {
  
  Type type;
  
  @BeforeEach
  void createType() {
    type = Type.INVALID;
  }
  
  @Test
  void testTypeToString() {
    /*
     * This test ensures the types's toString() method
     * returns the expected string.
     * 
     * To make this test work I had to add a toString() method
     * and constructor to the Type enum.
     */
    
    assertEquals(type.toString(), "Invalid");
  }
}
