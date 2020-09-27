package edu.uga.cs1302.txtbuff;

/**
 * The Class TextLineIndexOutOfBoundsException is an extension of the IndexOutOfBoundsException which will be thrown when the methods append, insert, and replace use indexes in the parameters that are not possible
 * @author Joseph Nguyen
 * 
 */
public class TextLineIndexOutOfBoundsException extends IndexOutOfBoundsException {

	/**
	 * Instantiates a new text line index out of bounds exception (default)
	 */
	public TextLineIndexOutOfBoundsException() {
		super();

	}

	/**
	 * Instantiates a new text line index out of bounds exception (with an error message)
	 *
	 * @param errMsg Error Message
	 */
	public TextLineIndexOutOfBoundsException(String errMsg) {
		super(errMsg);

	}

	/**
	 * Instantiates a new text line index out of bounds exception (with an index that was out of range)
	 *
	 * @param index The index that is out of range
	 */
	public TextLineIndexOutOfBoundsException(int index) {
		super("TextLine index out of range: " + index);

	}


}
