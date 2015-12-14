package edu.drew.note;

import java.util.Arrays;

public class JavaSort implements SortInterface {

	@Override
	public Note[] sort(Note[] s) {
		Arrays.sort(s);
		return s;
	}

}
