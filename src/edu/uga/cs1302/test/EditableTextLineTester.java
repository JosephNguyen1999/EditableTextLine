package edu.uga.cs1302.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import edu.uga.cs1302.txtbuff.EditableTextLine;


public class EditableTextLineTester {

	
	private EditableTextLine line, line2;
	
	//set up and instantiates the objects before every test
	@Before
	public void setUp() {
		line = new EditableTextLine();
		line2 = new EditableTextLine("This is my Junit Test");
	}
	
	//tears down and cleans up after every test
	@After
	public void tearDown() {
		line = null;
		line2 = null;
	}
	
	//Test Case 1: instantiates default editable text line and tests length/capacity methods
	@Test
	public void testInstantiateDefault() {	
		assertEquals(line.length(), 0);
		assertEquals(line.capacity(), 80);
	}
	
	//Test Case 2: instantiates editable text line with lower amount of elements than default size and tests length/capacity methods
	@Test
	public void testInstantiateBelowCapcity() {	
		assertEquals(line2.length(), 21);
		assertEquals(line2.capacity(), 80);
	}
	
	//Test Case 3: instantiates editable text line with same amount of elements as default size and tests length/capacity methods
	@Test
	public void testInstantiateOnCapacity() {	
		line = new EditableTextLine("12345678123456781234567812345678123456781234567812345678123456781234567812345678");
		assertEquals(line.length(), 80);
		assertEquals(line.capacity(), 80);
	}
	
	//Test Case 4: instantiates editable text line with above amount of elements as default size and tests length/capacity methods
	@Test
	public void testInstantiateAboveCapacity() {	
		line = new EditableTextLine("1234567812345678123456781234567812345678123456781234567812345678123456781234567812345678");
		assertEquals(line.length(), 88);
		assertEquals(line.capacity(), 160);
	}
	
	//Test Case 5: instantiates editable text line with twice the amount of elements as default size and tests length/capacity methods
	@Test
	public void testInstantiate2Capacity() {	
		line = new EditableTextLine("1234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678");
		assertEquals(line.length(), 160);
		assertEquals(line.capacity(), 160);
	}
	
	//Test Case 6: instantiates editable text line with empty string and tests length/capacity methods
	@Test
	public void testInstantiate0Capacity() {	
		line = new EditableTextLine("");
		assertEquals(line.length(), 0);
		assertEquals(line.capacity(), 80);
	}
	
	//Test Case 7: tests indexOf(String fragment) method with String that is contained
	@Test
	public void testIndexOfOneParameterContained() {	
		line = new EditableTextLine("12345678");
		assertEquals(line.indexOf("1"), 0);
		assertEquals(line.indexOf("456"), 3);
	}
	
	//Test Case 8: tests  indexOf(String fragment) method with String that is not contained
	@Test
	public void testIndexOfOneParameterNotContained() {	
		line = new EditableTextLine("12345678");
		assertEquals(line.indexOf("679"), -1);
		assertEquals(line.indexOf("9"), -1);
	}
	
	//Test Case 9: tests indexOf(String fragment, int fromIndex) method with String that is not contained after fromIndex
	@Test
	public void testIndexOfTwoParameterContained() {	
		line = new EditableTextLine("12345678");
		assertEquals(line.indexOf("2", 1), 0);
		assertEquals(line.indexOf("456", 2), 1);
	}
	
	//Test Case 10: tests indexOf(String fragment, int fromIndex) method with String that is not contained after fromIndex
	@Test
	public void testIndexOfTwoParameterNotContained() {	
		line = new EditableTextLine("12345678");
		assertEquals(line.indexOf("1", 2), -1);
		assertEquals(line.indexOf("456", 4), -1);
		assertEquals(line.indexOf("679", 5), -1);
		assertEquals(line.indexOf("9", 5), -1);
	}
	
	//Test Case 11: tests indexOf(String fragment, int fromIndex) method with illegal input
	@Test (expected = edu.uga.cs1302.txtbuff.TextLineIndexOutOfBoundsException.class)
	public void testIndexOfTwoParameterError() {	
		line = new EditableTextLine("12345678");
		line.indexOf("79", -1);
		line.indexOf("1", 9);
	}
	
	//Test Case 12: tests equals method with two objects that have arrays with the same characters
	@Test
	public void testEqualsTrue() {	
		line = new EditableTextLine("12345678");
		line2 = new EditableTextLine("12345678");
		assertTrue(line.equals(line2));
		assertTrue(line.equals(line));
		assertTrue(line2.equals(line2));
		assertTrue(line2.equals(line));
	}
	
	//Test Case 13: tests equals method with two objects that do not have arrays with the same characters
	@Test
	public void testEqualsFalse() {	
		line = new EditableTextLine("12345678");
		line2 = new EditableTextLine("123456789");
		assertFalse(line.equals(line2));
		assertFalse(line2.equals(line));
	}
	
	//Test Case 14: tests toString method
	@Test
	public void testToStringDefault() {	
		line = new EditableTextLine("12345678");
		line2 = new EditableTextLine("123456789 True");
		assertTrue(line.toString().equals("12345678"));
		assertTrue(line2.toString().equals("123456789 True"));
	}
	
	//Test Case 15: tests append method is under capacity
	@Test
	public void testAppendMethodUnderCap() {	
		line = new EditableTextLine("12345678");
		line.append("91011");
		assertTrue(line.toString().equals("1234567891011"));
		assertEquals(line.length(), 13);
		assertEquals(line.capacity(), 80);
		line.append("");
		assertTrue(line.toString().equals("1234567891011"));
		assertEquals(line.length(), 13);
		assertEquals(line.capacity(), 80);
	}
	
	//Test Case 16: tests append method that goes over capacity
	@Test
	public void testAppendMethodOverCap() {	
		line = new EditableTextLine("12345678");
		line.append("1234567812345678123456781234567812345678123456781234567812345678123456781234567812345678");
		assertTrue(line.toString().equals("123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678"));
		assertEquals(line.length(), 96);
		assertEquals(line.capacity(), 160);
	}
	
	//Test Case 17: tests insert method is under capacity
	@Test
	public void testInsertMethodUnderCap() {	
		line = new EditableTextLine("1234567891011");
		line.insert(0, "hi");
		assertTrue(line.toString().equals("hi1234567891011"));
		assertEquals(line.length(), 15);
		assertEquals(line.capacity(), 80);
		line.insert(2, "");
		assertTrue(line.toString().equals("hi1234567891011"));
		assertEquals(line.length(), 15);
		assertEquals(line.capacity(), 80);
		line.insert(15, "bye");
		assertTrue(line.toString().equals("hi1234567891011bye"));
		assertEquals(line.length(), 18);
		assertEquals(line.capacity(), 80);

	}
	
	//Test Case 18: tests insert method that goes over capacity
	@Test
	public void testInsertMethodOverCap() {	
		line = new EditableTextLine("12345678");
		line.insert(4, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(line.toString().equals("1234AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5678"));
		assertEquals(line.length(), 108);
		assertEquals(line.capacity(), 160);
	}
	
	//Test Case 19: tests insert method with illegal input
	@Test (expected = edu.uga.cs1302.txtbuff.TextLineIndexOutOfBoundsException.class)
	public void testInsertError() {	
		line = new EditableTextLine("12345678");
		line.insert(9, "hi");
		line.insert(-1, "bye");
	}
	
	//Test Case 20: tests replace method is under capacity
	@Test
	public void testReplaceMethodUnderCap() {	
		line = new EditableTextLine("12345678");
		line.replace(0, 0, "hi");
		assertTrue(line.toString().equals("hi12345678"));
		assertEquals(line.length(), 10);
		assertEquals(line.capacity(), 80);
		line.replace(1, 3, "");
		assertTrue(line.toString().equals("h2345678"));
		assertEquals(line.length(), 8);
		assertEquals(line.capacity(), 80);
		line.replace(4, 5, "bye");
		assertTrue(line.toString().equals("h234bye678"));
		assertEquals(line.length(), 10);
		assertEquals(line.capacity(), 80);
		line.replace(4, 6, "po");
		assertTrue(line.toString().equals("h234poe678"));
		assertEquals(line.length(), 10);
		assertEquals(line.capacity(), 80);
		line.replace(10, 10, "poop");
		assertTrue(line.toString().equals("h234poe678poop"));
		assertEquals(line.length(), 14);
		assertEquals(line.capacity(), 80);


	}
	
	//Test Case 21: tests replace method that goes over capacity
	@Test
	public void testReplaceMethodOverCap() {	
		line = new EditableTextLine("12345678");
		line.replace(4, 7, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(line.toString().equals("1234AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA8"));
		assertEquals(line.length(), 105);
		assertEquals(line.capacity(), 160);
		line.replace(0, 0, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(line.toString().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1234AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA8"));
		assertEquals(line.length(), 205);
		assertEquals(line.capacity(), 240);
	}
	
	//Test Case 22: tests replace method with illegal input
	@Test (expected = edu.uga.cs1302.txtbuff.TextLineIndexOutOfBoundsException.class)
	public void testReplaceError() {	
		line = new EditableTextLine("12345678");
		line.replace(-1, 3, "hi");
		line.replace(0, 12, "bye");
		line.replace(9, 3, "hope");
		line.replace(-5, 50, "nope");
	}
	
	
}
