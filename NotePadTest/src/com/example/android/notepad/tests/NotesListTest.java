package com.example.android.notepad.tests;

import com.example.android.notepad.NotesList;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.android.notepad.NotesListTest \
 * com.example.android.notepad.tests/android.test.InstrumentationTestRunner
 */
public class NotesListTest extends ActivityInstrumentationTestCase2<NotesList> {

    public NotesListTest() {
        super("com.example.android.notepad", NotesList.class);
    }
    public void testStart() {
    	Assert.assertTrue(true);
    }

}
