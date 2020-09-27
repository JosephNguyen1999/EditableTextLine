package edu.uga.cs1302.txtbuff;

/**
 * The Class TextLine will create an TextLine object that contains a char array
 * @author Joseph Nguyen
 * 
 */
public class TextLine {

	/** The default capacity of the char array (static and final because its a constant and we don't want it changed)*/
	public static final int DEFAULT_SIZE = 80;

	/** The char array that will be constructed (protected because we want the classes that extend this to be able to access it) */
	protected char[] textLine;

	/** The multiplier that will decrease or increase the capacity (protected because we want the classes that extend this to be able to access it) */
	protected int multiplier;

	/** The amount of elements in the char array (protected because we want the classes that extend this to be able to access it) */
	protected int lineLength;

	/** The current amount of possible elements in the char array (protected because we want the classes that extend this to be able to access it) */
	protected int lineCapacity;


	/**
	 * Instantiates a new text line char array with default values (80 capacity and 0 line length)
	 */
	public TextLine() {
		textLine = new char[DEFAULT_SIZE];
		lineCapacity = DEFAULT_SIZE;
	}

	/**
	 * Instantiates a new text line char array with values based on the string length
	 *
	 * @param line String that is put into a char array
	 */
	public TextLine(String line) {
		//different cases of line lengths change the formula to calculate the multiplier
		if (line.length() == 0) {
			multiplier = 1;
		}
		else if ((line.length() / (DEFAULT_SIZE * 1.0)) % 1.0 != 0.0) {
			multiplier = (line.length() / DEFAULT_SIZE) + 1;
		}
		else if ((line.length() / (DEFAULT_SIZE * 1.0)) % 1.0 == 0.0) {
			multiplier = (line.length() / DEFAULT_SIZE);
		}

		//creates a char array depending on the multiplier which is based off of line length
		textLine = new char[DEFAULT_SIZE * multiplier];
		for(int i = 0; i < line.length(); i++) {
			textLine[i] = line.charAt(i);
		}
		lineLength = this.length();
		lineCapacity = DEFAULT_SIZE * multiplier;
	}


	/**
	 * the amount of elements currently in the char array
	 *
	 * @return The amount of elements currently in the char array
	 */
	public int length() {
		int counter = 0;
		for(int i = 0; i < textLine.length; i++) {
			if (textLine[i] > 0) {
				counter++;
			}
			else {
				return counter;
			}
		}
		return counter;
	}

	/**
	 * the max amount of possible elements in the char array
	 *
	 * @return The amount of possible elements in the char array
	 */
	public int capacity() {
		return lineCapacity;
	}

	/**
	 * finds the index of where the fragment is in the char array if it is in there
	 *
	 * @param fragment String that we want to see the index of in the char array or the presense of it
	 * @return index of the instance of the fragment in char array
	 */
	public int indexOf(String fragment) {
		int position = -1;
		int counter = 0;
		int counterLength = fragment.length();
		//looks through char for the string fragment if any and returns back the index of the first char
		for(int i = 0; i < length(); i++) {
			if(textLine[i] == fragment.charAt(counter)) {
				position = i;
				counter++;
				if (counter == counterLength) {
					position = position - (counterLength - 1);
					return position;
				}
			}
			else {
				position = -1;
			}
		}
		return position;
	}


	/**
	 * finds the index of where the fragment is in the char array starting from a given index if it is in there 
	 *
	 * @param fragment String that we want to see the index of in the char array or the presence of it
	 * @param fromIndex The starting index from where to start looking
	 * @return index of the instance of the fragment in char array from fromIndex
	 * @throws TextLineIndexOutOfBoundsException fromIndex is out of bounds
	 */
	public int indexOf(String fragment, int fromIndex) 
			throws TextLineIndexOutOfBoundsException {
		if (fromIndex > this.length() - 1 || fromIndex < 0) {
			throw new TextLineIndexOutOfBoundsException(fromIndex);
		}
		int position = -1;
		int counter = 0;
		int counterLength = fragment.length();
		//looks through char for the string fragment if any and returns back the index of the first char from the fromIndex
		for(int i = fromIndex; i < length(); i++) {
			if(textLine[i] == fragment.charAt(counter)) {
				position = i;
				counter++;
				if (counter == counterLength) {
					position = position - (counterLength - 1) - fromIndex;
					return position;
				}
			}
			else {
				position = -1;
			}
		}
		return position;
	}

	/**
	 * checks to see if both char arrays from both objects contain the same characters
	 *
	 * @param obj object that it will be compared to to test for equality
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {
		TextLine anotherTextLine = (TextLine) obj;
		int counter = 0;
		int counterLength = length();
		//checks if the chars are the same in both arrays (including the number of elements)
		if(this.length() == anotherTextLine.length()) {
			for(int i = 0; i < textLine.length; i++) {
				if(textLine[i] == anotherTextLine.textLine[i]) {
					counter++;
					if (counter == counterLength) {
						return true;
					}
				}
				else {
					counter = 0;
				}
			}
		}
		return false;
	}

	/**
	 * Takes the characters from the char array and makes it into a string
	 *
	 * @return A string with characters from the char array
	 */
	public String toString() {
		String toString = "";
		//puts the char array into a string
		for(int i = 0; i < textLine.length; i++) {
			if (textLine[i] >= 0) {
				toString += textLine[i];
			}
			else {
				return toString;
			}
		}
		return toString;
	}




}
