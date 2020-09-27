package edu.uga.cs1302.txtbuff;

/**
 * The Class EditableTextLine extends TextLine class and implements the Editable interface and this will create an EditableTextLine object that contain an editable char array
 * @author Joseph Nguyen
 * 
 */
public class EditableTextLine extends TextLine implements Editable {


	/**
	 * Instantiates a new editable text line char array with default values (80 capacity and 0 line length)
	 */
	public EditableTextLine() {
		super();
	}


	/**
	 * Instantiates a new editable text line char array with values based on the string length
	 *
	 * @param line String that will be put into the char array
	 */
	public EditableTextLine(String line) {
		super(line);
	}

	/**
	 * Editable array is a helper method that will be called in the other methods and will increase the capacity of the text line char array if needed
	 */
	public void EditableArray() {
		multiplier++;
		lineCapacity = DEFAULT_SIZE * multiplier;
		char[] tempArray = new char[DEFAULT_SIZE * multiplier];
		for(int i = 0; i < textLine.length; i++) {
			tempArray[i] = textLine[i];
		}
		textLine = tempArray;

	}




	/**
	 * method for appending the char array with the chars from the String fragment
	 *
	 * @param fragment Fragment that will be added to end of the char array
	 */
	public void append(String fragment) {
		//checks to see if the capacity needs to be larger
		while(lineLength + fragment.length() > lineCapacity) {
			EditableArray();
		}
		int counter = 0;
		//adds fragment onto the end of char array
		for(int i = lineLength; i < fragment.length() + lineLength; i++) {
			textLine[i] = fragment.charAt(counter);
			counter++;
		}
		lineLength = lineLength + fragment.length();

	}


	/**
	 * method for inserting the char array with the chars from the String fragment at a specific index
	 *
	 * @param index Where the fragment will be inserted
	 * @param fragment Fragment that will be added at index
	 * @throws TextLineIndexOutOfBoundsException index is out of bounds
	 */
	public void insert(int index, String fragment) 
			throws TextLineIndexOutOfBoundsException {
		//checks to see if an exception needs to be thrown
		if(index > lineLength || index < 0) {
			throw new TextLineIndexOutOfBoundsException(index);
		}
		//checks to see if the capacity needs to be larger 
		while(lineLength + fragment.length() > lineCapacity) {
			EditableArray();
		}
		//shifts necessary chars over depending on the fragment and index
		for(int i = lineLength + fragment.length(); i > index; i--) {
			if(i - fragment.length() >= 0) {
				textLine[i] = textLine[i - fragment.length()];
			}
		}
		int counter = 0;
		//adds fragment at the index specified
		for (int i = index; i < fragment.length() + index; i++) {
			textLine[i] = fragment.charAt(counter);
			counter++;
		}
		lineLength = lineLength + fragment.length();

	}





	/**
	 * method for replacing the chars in between the start and end indexes of the char array with the chars from the String fragment
	 *
	 * @param start The beginning of what chars will be replaced (inclusive)
	 * @param end The end of what chars will be replaced (exclusive)
	 * @param fragment Fragment that will replace chars in between the start and end
	 * @throws TextLineIndexOutOfBoundsException start or end is out of bounds or start is greater than end
	 */
	public void replace(int start, int end, String fragment)
			throws TextLineIndexOutOfBoundsException {
		//checks to see if an exception needs to be thrown
		if(start > lineLength || start < 0) {
			throw new TextLineIndexOutOfBoundsException(start);
		}
		else if(end > lineLength || end < 0) {
			throw new TextLineIndexOutOfBoundsException(end);
		}
		else if(start > end) {
			throw new TextLineIndexOutOfBoundsException("Start Index Cannot be Greater Than End Index");
		}

		//checks to see if the capacity needs to be larger
		while(lineLength + fragment.length() - (end - start) > lineCapacity) {
			EditableArray();
		}

		//shifts over the chars in the char array depending on the fragment and start/end
		if (!fragment.equals("")) {
			if(fragment.length() - (end - start) >= 0) {
				for(int i = lineLength; i >= end; i--) {
					if(i + (end - start) >= 0) {
						textLine[i + (fragment.length() - (end - start))] = textLine[i];
					}
				}
			}
			else if (fragment.length() - (end - start) < 0) {
				for(int i = start; i < lineLength + fragment.length(); i++) {
					textLine[i] = textLine[i + (end - start) - fragment.length()];

				}

			}
		}
		else if (fragment.equals("")) {
			for(int i = start; i < lineLength + fragment.length(); i++) {
				textLine[i] = textLine[i + (end - start)];
			}
		}


		int counter = 0;
		//replaces the chars (start to end) with the fragment
		for (int i = start; i < fragment.length() + start; i++) {
			textLine[i] = fragment.charAt(counter);
			counter++;
		}

		lineLength = lineLength + fragment.length() - (end - start);
	}



	/**
	 * Takes the characters from the char array and make it into a string (overrides the one from TextLine class)
	 *
	 * @return A string with characters from the char array
	 */
	@Override
	public String toString() {
		String toString = "";
		//puts the char array into a string
		for(int i = 0; i < lineCapacity; i++) {
			if (textLine[i] > 0) {
				toString += textLine[i];
			}
			else {
				return toString;
			}
		}
		return toString;
	}




}
