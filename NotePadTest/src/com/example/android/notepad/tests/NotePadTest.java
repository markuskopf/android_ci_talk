package com.example.android.notepad.tests;

import com.example.android.notepad.NotesList;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;

public class NotePadTest extends ActivityInstrumentationTestCase2<NotesList> {
	private Solo solo;

	public NotePadTest() {
		super("com.example.android.notepad", NotesList.class);
		
	}
	
	 public void setUp() throws Exception {
		 solo = new Solo(getInstrumentation(), getActivity());
		  }
	 
	 @Smoke
	 public void testAddNote() throws Exception {
		 solo.clickOnMenuItem("Add note");
		 solo.assertCurrentActivity("Expected NoteEditor activity", "NoteEditor"); //Assert that NoteEditor activity is opened
		 solo.enterText(0, "Note 1"); //In text field 0, add Note 1
		 solo.goBack(); //Go back 
		 solo.clickOnMenuItem("Add note"); //Clicks on menu item 
		 solo.enterText(0, "Note 2"); //In text field 0, add Note 2
		 solo.goBackToActivity("NotesList"); //Go back to first activity named "NotesList"
		 boolean expected = true;
		 boolean actual = solo.searchText("Note 1") && solo.searchText("Note 2");
		 assertEquals("Note 1 and/or Note 2 are not found", expected, actual);
		
	 }
	
	@Smoke 
	public void testNoteChange() throws Exception {
		solo.clickInList(2); // Clicks on a list line
		solo.setActivityOrientation(Solo.LANDSCAPE); // Change orientation of activity
		solo.pressMenuItem(2); // Change title
		solo.enterText(0, " test"); //In text field 0, add test
		solo.goBack();
		solo.goBack();
		boolean expected = true;
		boolean actual = solo.searchText("(?i).*?note 1 test"); // (Regexp) case insensitive												// insensitive
		assertEquals("Note 1 test is not found", expected, actual);

	}
	

	@Smoke
	 public void testNoteRemove() throws Exception {
		 solo.clickOnText("(?i).*?test.*");   //(Regexp) case insensitive/text that contains "test"
		 solo.pressMenuItem(1);   //Delete Note 1 test
		 boolean expected = false;   //Note 1 test & Note 2 should not be found
		 boolean actual = solo.searchText("Note 1 test");
		 assertEquals("Note 1 Test is found", expected, actual);  //Assert that Note 1 test is not found
		 solo.clickLongOnText("Note 2");
		 solo.clickOnText("(?i).*?Delete.*");  //Clicks on Delete in the context menu
		 actual = solo.searchText("Note 2");
		 assertEquals("Note 2 is found", expected, actual);  //Assert that Note 2 is not found
	 }

	@Override
	public void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	} 
}

