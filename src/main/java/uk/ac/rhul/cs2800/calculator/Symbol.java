package uk.ac.rhul.cs2800.calculator;

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
  
  /**
   * Converts a String to the equivalent symbol enum.
   *
   * @param strSymbol the symbol String we want to convert.
   * @return the Symbol corresponding to the given String. Returns invalid symbol if none found.
   */
  public static Symbol toSymbol(String strSymbol) {
    Symbol currentSymbol = Symbol.INVALID;
    
    for (Symbol symbol : Symbol.values()) {
      if (symbol.toString().equals(strSymbol)) {
        currentSymbol = symbol;
        break;
      }
    }
    
    return currentSymbol;
  }
}
