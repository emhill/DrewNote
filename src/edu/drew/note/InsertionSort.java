package edu.drew.note;

public class InsertionSort implements SortInterface { //find least # & bring to start of array

	public Note[] sort(Note[] s) {
		for (int j = 1; j < s.length; j++) {
			Note temp = s[j]; 
			int i = j-1; 
			while ((i >= 0) && (temp.getID() < s[i].getID()) ) { //goes thru array 
				s[i+1] = s[i]; //overriding position of element of s (which is last element)
				i--; //indexes within array
			}
			//what happens when temp.getID() < s[i].getID()
			s[i+1] = temp;
		}
		return s;
	}
//testing
	public static void main(String[] args) {
		Note a = new Note(); 
		Note b = new Note(); 
		Note c = new Note(); 
		Note[] n = {c, b, a}; 

		InsertionSort is = new InsertionSort();

		// swap first & last
		is.sort(n); 
		for (int i = 0; i < n.length; i++)
			System.out.println(n[i]); 
	}
}
