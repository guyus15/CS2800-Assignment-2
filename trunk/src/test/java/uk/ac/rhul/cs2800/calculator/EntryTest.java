package uk.ac.rhul.cs2800.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test case tests the Entry class.
 *
 * @author chamb
 */
public class EntryTest {
  Entry floatEntry;
  Entry stringEntry;
  Entry symbolEntry;

  @BeforeEach
  void createEntries() {
    floatEntry = new Entry(0.0f);
    stringEntry = new Entry("test");
    symbolEntry = new Entry(Symbol.INVALID);
  }

  @Test // Test 1
  void testGetFloatEntryType() {
    /*
     * This test ensures that we get the correct type from the entry
     * when that type is given in the constructor.
     * 
     * To make this test work I had to change the entry's type
     * depending on the overloaded constructor which was used
     * to create the entry.
     */
    
    assertEquals(floatEntry.getType(), Type.NUMBER);
  }

  @Test // Test 2
  void testGetStringEntryType() {
    /*
     * This test ensures that we get the correct type from the entry
     * when that type is given in the constructor.
     * 
     * To make this test work I had to change the entry's type
     * depending on the overloaded constructor which was used
     * to create the entry.
     */
    
    assertEquals(stringEntry.getType(), Type.STRING);
  }

  @Test // Test 3
  void testGetSymbolEntryType() {
    /*
     * This test ensures that we get the correct type from the entry
     * when that type is given in the constructor.
     * 
     * To make this test work I had to change the entry's type
     * depending on the overloaded constructor which was used
     * to create the entry.
     */
    
    assertEquals(symbolEntry.getType(), Type.SYMBOL);
  }

  @Test // Test 4
  void testGetStringEntryString() throws BadTypeException {
    /*
     * To make this test work I had add a check to the getString()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type String.
     */
    
    assertEquals(stringEntry.getString(), "test");
  }

  @Test // Test 5
  void testGetFloatEntryString() {
    /*
     * To make this test work I had add a check to the getString()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type String.
     */
    
    assertThrows(BadTypeException.class, () -> floatEntry.getString());
  }

  @Test // Test 6
  void testGetSymbolEntryString() {
    /*
     * To make this test work I had add a check to the getString()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type String.
     */
    
    assertThrows(BadTypeException.class, () -> symbolEntry.getString());
  }

  @Test // Test 7
  void testGetStringEntrySymbol() {
    /*
     * To make this test work I had add a check to the getSymbol()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type Symbol.
     */
    
    assertThrows(BadTypeException.class, () -> stringEntry.getSymbol());
  }

  @Test // Test 8
  void testGetFloatEntrySymbol() {
    /*
     * To make this test work I had add a check to the getSymbol()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type Symbol.
     */
    
    assertThrows(BadTypeException.class, () -> floatEntry.getSymbol());
  }

  @Test // Test 9
  void testGetSymbolEntrySymbol() throws BadTypeException {
    /*
     * To make this test work I had add a check to the getSymbol()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type Symbol.
     */
    
    assertEquals(symbolEntry.getSymbol(), Symbol.INVALID);
  }

  @Test // Test 10
  void testGetStringEntryNumber() {
    /*
     * To make this test work I had add a check to the getNumber()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type float.
     */
    
    assertThrows(BadTypeException.class, () -> stringEntry.getNumber());
  }

  @Test // Test 11
  void testGetFloatEntryNumber() throws BadTypeException {
    /*
     * To make this test work I had add a check to the getNumber()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type float.
     */
    
    assertEquals(floatEntry.getNumber(), 0.0f);
  }

  @Test // Test 12
  void testGetSymbolEntryNumber() {
    /*
     * To make this test work I had add a check to the getNumber()
     * method which determines the type of the entry and throws a
     * BadTypeException if it is not of type float.
     */
    
    assertThrows(BadTypeException.class, () -> symbolEntry.getNumber());
  }

  @Test // Test 13
  void testSetSymbol() { // Test 11
    floatEntry.setSymbol(Symbol.INVALID);
    // Float entry type should change to symbol type
    assertEquals(floatEntry.type, Type.SYMBOL);

    stringEntry.setSymbol(Symbol.INVALID);
    // String entry type should change to symbol type
    assertEquals(stringEntry.type, Type.SYMBOL);

    // Record entry's initial type to see if it changes
    Type symbolEntryStartType = symbolEntry.type;
    symbolEntry.setSymbol(Symbol.INVALID);
    // Symbol entry type should not change
    assertEquals(symbolEntryStartType, symbolEntry.type);
  }

  @Test // Test 14
  void testSetNumber() {
    // Record entry's initial type to see if it changes
    Type floatEntryStartType = floatEntry.type;
    floatEntry.setNumber(1.0f);
    // Float entry type should not change
    assertEquals(floatEntryStartType, floatEntry.type);

    stringEntry.setNumber(1.0f);
    // String entry type should change to number type
    assertEquals(stringEntry.type, Type.NUMBER);

    symbolEntry.setNumber(1.0f);
    // Symbol entry type should change to number type
    assertEquals(symbolEntry.type, Type.NUMBER);
  }

  @Test // Test 15
  void testSetString() {
    floatEntry.setString("updated");
    // Float entry type should change to string type
    assertEquals(floatEntry.type, Type.STRING);

    // Record entry's initial type to see if it changes
    Type stringEntryStartType = stringEntry.type;
    stringEntry.setString("updated");
    // String entry type should not change
    assertEquals(stringEntryStartType, stringEntry.type);

    symbolEntry.setString("updated");
    // Symbol entry type should change to string type
    assertEquals(symbolEntry.type, Type.STRING);
  }

  @Test // Test 16
  void testEntrysEqual() {
    /*
     * This test ensures that when two entries are instantiated with the same value, the two are
     * considered equal to one another.
     * 
     * To make this test work, I had to implement an equals in the Entry class.
     */

    Entry floatEntry1 = new Entry(0.0f);
    Entry floatEntry2 = new Entry(0.0f);
    // Two float entries with the same number should be equal.
    assertTrue(floatEntry1.equals(floatEntry2));

    Entry stringEntry1 = new Entry("test");
    Entry stringEntry2 = new Entry("test");
    // Two String entries with the same string should be equal.
    assertTrue(stringEntry1.equals(stringEntry2));

    Entry symbolEntry1 = new Entry(Symbol.INVALID);
    Entry symbolEntry2 = new Entry(Symbol.INVALID);
    // Two Symbol entries with the same symbol should be equal.
    assertTrue(symbolEntry1.equals(symbolEntry2));
  }

  @Test // Test 17
  void testEntrysNotEqual() {
    /*
     * This test ensures that when two entries are instantiated with different values,
     * the two are not considered equal to one another.
     */
    
    Entry floatEntry1 = new Entry(0.0f);
    Entry floatEntry2 = new Entry(1.0f);
    // Two float entries with different numbers should not be equal.
    assertFalse(floatEntry1.equals(floatEntry2));
    
    Entry stringEntry1 = new Entry("test");
    Entry stringEntry2 = new Entry("second test");
    // Two String entries with different strings should not be equal.
    assertFalse(stringEntry1.equals(stringEntry2));
    
    Entry symbolEntry1 = new Entry(Symbol.INVALID);
    Entry symbolEntry2 = new Entry(Symbol.DIVIDE);
    // Two Symbol entries with different symbols should not be equal.
    assertFalse(symbolEntry1.equals(symbolEntry2));
    
    /*
     * Two entrys with different type should not be equal
     * to one another 
     */
    assertFalse(floatEntry1.equals(stringEntry1));
    assertFalse(floatEntry1.equals(symbolEntry1));
    
    assertFalse(stringEntry1.equals(floatEntry1));
    assertFalse(stringEntry1.equals(symbolEntry1));
    
    assertFalse(symbolEntry1.equals(floatEntry1));
    assertFalse(symbolEntry1.equals(stringEntry1));
  }

  @Test // Test 18
  void testEntryEqualsWhenChanged() {
    /*
     * This test the equals method for the entry class still works even when set to a different
     * type.
     * 
     * To make this test work, I had to reset the non-affected entry attributes in each setter
     * to null. (i.e when calling setNumber(), the entry string and symbol are changed to null).
     */

    // Changing string and symbol types to float.
    stringEntry.setNumber(0.0f);
    assertTrue(stringEntry.equals(floatEntry));
    symbolEntry.setNumber(0.0f);
    assertTrue(symbolEntry.equals(floatEntry));
     
    // Resetting string and symbol entries.
    stringEntry = new Entry("test");
    symbolEntry = new Entry(Symbol.INVALID);
    
    // Changing float and symbol types to string.
    floatEntry.setString("test");
    assertTrue(floatEntry.equals(stringEntry));
    symbolEntry.setString("test");
    assertTrue(symbolEntry.equals(stringEntry));
    
    // Resetting float and symbol entries.
    floatEntry = new Entry(0.0f);
    symbolEntry = new Entry(Symbol.INVALID);
    
    // Changing float and string types to symbol.
    floatEntry.setSymbol(Symbol.INVALID);
    assertTrue(floatEntry.equals(symbolEntry));
    stringEntry.setSymbol(Symbol.INVALID);
    assertTrue(stringEntry.equals(symbolEntry));
  }
  
  @Test // Test 19
  void testEntryToString() {
    /*
     * This test will ensure that the correct string is given when
     * the toString() method is called on an Entry object.
     * 
     * To make this test work I had to create an override method for 
     * the toString() method which returns a string for each type
     * of entry.
     */
    
    assertEquals(floatEntry.toString(), "0.0");
    assertEquals(stringEntry.toString(), "test");
    assertEquals(symbolEntry.toString(), "Invalid");
  }
  
  @SuppressWarnings("unlikely-arg-type")
  @Test // Test 20
  void testEntryEquals() {
    
    // Testing if two of the same objects returns true
    assertTrue(floatEntry.equals(floatEntry));
    
    // Testing if an object and a null value returns false.
    assertFalse(floatEntry.equals(null));
    
    // Testing if an object and another object being of different types returns false.
    assertFalse(floatEntry.equals(0.0f));
  }
}
