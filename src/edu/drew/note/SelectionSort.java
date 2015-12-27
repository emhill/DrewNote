//Emily Evans

package edu.drew.note;

public class SelectionSort implements SortInterface{

	public Note[] sort(Note[] s) {
		for (int i = 0; i < s.length; i++) {
			int tempIndex = i;
			Note temp = s[i];
			for (int j = i+1; j < s.length; j++) {
				if (s[j].getID()<temp.getID()) {
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
