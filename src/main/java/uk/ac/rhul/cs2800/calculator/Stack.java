package uk.ac.rhul.cs2800.calculator;

import java.util.ArrayList;

/**
 * The Stack class represents a last-in-first-out (LIFO) stack of objects.
 *
 * @author Guy Chamberlain-Webber
 */

public class Stack {

  ArrayList<Entry> entries; // A list of entries representing items in the stack.
  int size; // The size of the stack.


  /**
   * Creates a new instance of the stack class.
   */
  public Stack() {
    entries = new ArrayList<Entry>();
    size = 0;
  }

  /**
   * Push a float value onto the stack.
   *
   * @param floatValue The float value to be pushed onto the stack.
   */
  public void push(float floatValue) {
    Entry newEntry = new Entry(floatValue);
    entries.add(newEntry);
    size++;
  }

  /**
   * Push a String value onto the stack.
   *
   * @param stringValue The String value to pushed onto the stack.
   */
  public void push(String stringValue) {
    Entry newEntry = new Entry(stringValue);
    entries.add(newEntry);
    size++;
  }

  /**
   * Push a Symbol value onto the stack.
   *
   * @param symbolValue The Symbol value to pushed onto the stack.
   */
  public void push(Symbol symbolValue) {
    Entry newEntry = new Entry(symbolValue);
    entries.add(newEntry);
    size++;
  }

  /**
   * Pop a value off the stack.
   *
   * @return The value of the object which has been popped off the stack.
   * @throws EmptyStackException When called if the stack size is zero.
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException("Stack size must be greater than zero.");
    }

    // The top-most item in the stack.
    Entry entry = entries.get(size - 1);
    entries.remove(size - 1);
    size--;
    return entry;
  }

  /**
   * Returns the size of the stack.
   *
   * @return The size of the stack.
   */
  public int size() {
    return size;
  }


  /**
   * Returns the top-most object of the stack.
   *
   * @return The top-most object of the stack.
   * @throws EmptyStackException When called if the stack size is zero.
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException("Stack size must be greater than zero.");
    } else {
      // The top-most item in the stack.
      return entries.get(size - 1);
    }
  }
}
