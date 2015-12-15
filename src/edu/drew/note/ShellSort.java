package edu.drew.note;

public class ShellSort implements SortInterface{
	public Note[] sort(Note[] s){
		int space = s.length / 2;
		while (space > 0) {
			for (int i = space; i < s.length; i++) {
				int j = i;
				Note temp = s[i];
				while (j >= space && s[j - space].getID() > temp.getID()) {
					s[j] = s[j - space];
					j = j - space;
				}
				
				s[j] = temp;
			}
			if (space == 2) {
				space = 1;
			} else {
				space *= (5.0 / 11);
			}
		}
		return s;
	}
}
// Works Cited:
// Code implemented with assistance from http://rosettacode.org/wiki/Sorting_algorithms/Shell_sort#Java

