package edu.uga.cs1302.txtbuff;

/**
 * The Interface Editable that contains declared methods that will be implemented by EditableTextLine class
 * @author Joseph Nguyen
 * 
 */
public interface Editable {

	/**
	 * method for appending the char array with the chars from the String fragment that will be implemented in another class
	 *
	 * @param fragment Fragment that will be added to end of the char array
	 */
	public void append(String fragment);

	/**
	 * method for inserting the char array with the chars from the String fragment at a specific index that will be implemented in another class
	 *
	 * @param index Where the fragment will be inserted
	 * @param fragment Fragment that will be added at index
	 * @throws TextLineIndexOutOfBoundsException index is out of bounds
	 */
	public void insert(int index, String fragment) 
			throws TextLineIndexOutOfBoundsException;

	/**
	 * method for replacing the chars in between the start and end indexes of the char array with the chars from the String fragment that will be implemented in another class
	 *
	 * @param start The beginning of what chars will be replaced (inclusive)
	 * @param end The end of what chars will be replaced (exclusive)
	 * @param fragment Fragment that will replace chars in between the start and end
	 * @throws TextLineIndexOutOfBoundsException start or end is out of bounds or start is greater than end
	 */
	public void replace(int start, int end, String fragment)
			throws TextLineIndexOutOfBoundsException;


}
