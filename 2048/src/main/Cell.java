package main;

/*
 * Every cell has:
 * - A Number value
 * - ????
 */

/** Holds information for a single cell
 * Every cell has a number value associated with it
 * @author beats
 *
 */
public class Cell {
	
	// the value associated with the cecll
	private Integer value;
	
	public Cell() {
		value = 0;
	}
	
	/**Changes the number value of the cell
	 * 
	 * @param newVal the new value of the cell
	 */
	public void setValue(int newVal) {
		value = newVal;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return value + "";
	}
	
	

}
