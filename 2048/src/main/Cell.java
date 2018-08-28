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
	
	// the value associated with the cell
	private Integer value;
	
	public Cell() {
		value = 0;
	}
	
	/**Changes the numerical value of the cell
	 * 
	 * @param newVal the new value of the cell
	 */
	public void setValue(int newVal) {
		value = newVal;
	}
	
	/**gets the current numerical value of the cell
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return value + "";
	}
	
	

}
