package com.example.android.notepad.tests;

import junit.framework.Assert;

import com.example.android.notepad.NoteEditor;
import com.example.android.notepad.NotesList;
import com.example.android.notepad.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

public class NoteEditorTest extends ActivityInstrumentationTestCase2<NoteEditor> {
	private NoteEditor noteEditor;
	public NoteEditorTest() {
		super("com.example.android.notepad", NoteEditor.class);
		// TODO Auto-generated constructor stub
	}
	
	protected void setUp() throws Exception {
		super.setUp();
        noteEditor = this.getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testComponents() {
		Assert.assertNotNull(noteEditor); 
	}

}
