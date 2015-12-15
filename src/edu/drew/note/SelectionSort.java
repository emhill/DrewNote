package edu.drew.note;

public class SelectionSort implements SortInterface{

	public Note[] sort(Note[] s) {
		Note temp = null;
		int tempIndex = 0;
		for (int i = 0; i < s.length; i++) {
			tempIndex = i;
			for (int j = 0; j < s.length; j++) {
				if (s[j].getID()<s[i].getID() || s[j].getID()<temp.getID()) {
					temp = s[j];
					tempIndex = j;
				}
			}
			s[tempIndex] = s[i];
			s[i] = temp;
		}
		return s;
	}
}
