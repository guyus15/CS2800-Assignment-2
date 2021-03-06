package uk.ac.rhul.cs2800.calculator;

/**
 * This enum is used to determine an entry's type.
 *
 * @author Guy Chamberlain-Webber
 */
public enum Type {
  /** Number type. */
  NUMBER("Number"),
  /** Number type. */
  SYMBOL("Symbol"),
  /** Symbol type. */
  STRING("String"),
  /** Invalid type. */
  INVALID("Invalid");

  String typeString;

  Type(String string) {
    typeString = string;
  }

  @Override
  public String toString() {
    return typeString;
  }
}
