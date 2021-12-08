package uk.ac.rhul.cs2800.calculator;

import java.util.Objects;

/**
 * The Entry class is used to represent various data types for the Stack class.
 *
 * @author Guy Chamberlain-Webber
 */
public class Entry {

  float number;
  String string;
  Symbol symbol;
  Type type;

  /**
   * Creates a new instance of the class Entry of type float.
   *
   * @param value The entry's float value.
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
  }


  /**
   * Creates a new instance of the class Entry of type String.
   *
   * @param value The entry's String value.
   */
  public Entry(String value) {
    string = value;
    type = Type.STRING;
  }

  /**
   * Creates a new instance of the class Entry of type Symbol.
   *
   * @param value The entry's Symbol value.
   */
  public Entry(Symbol value) {
    symbol = value;
    type = Type.SYMBOL;
  }

  /**
   * Returns the entry's type.
   *
   * @return The entry type.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the entry's string.
   *
   * @return The entry string.
   * @throws BadTypeException When entry type is not String.
   */
  public String getString() throws BadTypeException {
    if (type == Type.STRING) {
      return string;
    } else {
      throw new BadTypeException("Incorrect type");
    }
  }


  /**
   * Sets the string of the entry and updates the type if necessary.
   *
   * @param newString The new string to update the entry with.
   */
  public void setString(String newString) {
    if (type != Type.STRING) {
      type = Type.STRING;
    }

    // Sets the string to be the new string, resets the other values.
    number = 0;
    symbol = null;
    string = newString;
  }

  /**
   * Returns the entry's symbol.
   *
   * @return The entry symbol.
   * @throws BadTypeException When entry type is not Symbol.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type == Type.SYMBOL) {
      return symbol;
    } else {
      throw new BadTypeException("Incorrect type");
    }
  }

  /**
   * Sets the symbol of the entry and updates the type if necessary.
   *
   * @param newSymbol The new symbol to update to update the entry with.
   */
  public void setSymbol(Symbol newSymbol) {
    if (type != Type.SYMBOL) {
      type = Type.SYMBOL;
    }

    // Sets the symbol to be the new symbol, resets the other values.
    number = 0;
    string = null;
    symbol = newSymbol;
  }


  /**
   * Returns the entry's value.
   *
   * @return Then entry value.
   * @throws BadTypeException When entry type is not float.
   */
  public float getNumber() throws BadTypeException {
    if (type == Type.NUMBER) {
      return number;
    } else {
      throw new BadTypeException("Incorrect type");
    }
  }

  /**
   * Sets the number of the entry and updates the type if necessary.
   *
   * @param newNumber The new number to update the entry with.
   */
  public void setNumber(float newNumber) {
    if (type != Type.NUMBER) {
      type = Type.NUMBER;
    }

    // Sets the number to be the new number, resets the other values.
    string = null;
    symbol = null;
    number = newNumber;
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

    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && Objects.equals(string, other.string) && symbol == other.symbol && type == other.type;
  }

  @Override
  public String toString() {
    String returnString = "";

    switch (type) {
      case NUMBER:
        returnString = Float.toString(number);
        break;
      case STRING:
        returnString = string;
        break;
      case SYMBOL:
        returnString = symbol.toString();
        break;
      default:
        break;
    }

    return returnString;
  }
}
