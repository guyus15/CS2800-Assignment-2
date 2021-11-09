package uk.ac.rhul.cs2800.stack;

/**
 * This enum is used to determine an entry symbol.
 *
 * @author chamb
 */
public enum Symbol {
  /** Left bracket symbol. */
  LEFT_BRACKET("("),
  /** Right bracket symbol. */
  RIGHT_BRACKET(")"),
  /** Times symbol. */
  TIMES("*"),
  /** Divide symbol. */
  DIVIDE("/"),
  /** Plus symbol. */
  PLUS("+"),
  /** Minus symbol. */
  MINUS("-"),
  /** Invalid symbol. */
  INVALID("Invalid");
  
  String symbolString;
  
  Symbol(String string) {
    symbolString = string;
  }
  
  @Override
  public String toString() {
    return symbolString;
  }
}
