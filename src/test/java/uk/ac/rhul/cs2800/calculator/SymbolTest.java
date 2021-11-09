package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the Symbol enum.
 *
 * @author chamb
 */
public class SymbolTest {
  
  Symbol symbol;
  
  @BeforeEach
  void createSymbol() {
    symbol = Symbol.INVALID;
  }
  
  @Test
  void testSymbolToString() {
    /*
     * This test ensures the symbol's toString() method
     * returns the expected string.
     * 
     * To make this test work I had to add a toString() method
     * and constructor to the Symbol enum.
     */
    
    assertEquals(symbol.toString(), "Invalid");
  }
}
