package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the Symbol enum.
 *
 * @author Guy Chamberlain-Webber
 */
public class SymbolTest {

  Symbol symbol;

  @BeforeEach
  void createSymbol() {
    symbol = Symbol.INVALID;
  }

  @Test // Test 1
  void testSymbolToString() {
    /*
     * This test ensures the symbol's toString() method returns the expected string.
     * 
     * To make this test work I had to add a toString() method and constructor to the Symbol enum.
     */

    assertEquals(symbol.toString(), "Invalid");
  }

  @Test // Test 2
  void testStringToSymbol() {
    /*
     * This test ensures the symbol's toSymbol method returns the expected Symbol.
     * 
     * To make this test work I had to add another method to the Symbol enum which will iterator
     * through each of the enum's values looking for one which matches the symbol string. If it
     * finds one it will returns that symbol, otherwise it will return an invalid symbol.
     */

    // Checking for a symbol that we know does not exist.
    assertEquals(Symbol.toSymbol("test"), Symbol.INVALID);

    // Checking for a symbol that we know does exist.
    assertEquals(Symbol.toSymbol("*"), Symbol.TIMES);
  }
}
