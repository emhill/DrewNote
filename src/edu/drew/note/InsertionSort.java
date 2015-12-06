package edu.drew.note;

public class InsertionSort implements SortInterface {  //find the least and bring it to the beginning of the array 

	//sorts the array entries a[first] through a[last] iteratively
	public Note[] sort(Note[] s) {
		for (int j = s.length-1; j < 0; j--) {
			Note temp = s[j]; 
			int i = j-1; 
			while (temp.getID() < s[i].getID()) { //goes thru the array 
				s[i+1] = s[i]; //overriding the position of the element of s (which is the last element)
				i--; //indexes within the array
			}
			//what happens when temp.getID() > s[i].getID()
			s[i] = temp;
		}
		return s;
	}
}



