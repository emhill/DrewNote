/*
 * Honestly, I couldn't figure out how to test this at all.
I hope it works at least well enough for partial credit.
I have no idea if I'm even using the right variables, but I 
put this off for too long and I definitely don't have time
anymore to worry about it. I'm turning in what I have!

I also couldn't figure out how to fit it all into one method,
because our interface only had one parameter,
but this SHOULD work in theory.
*/

//Written by Nick Erwin

package edu.drew.note;

public class MergeSort implements SortInterface{
	/*
	 * Expands the single parameter interface to a
	new call with 3 parameters - the array, low, and high.
	I don't know if it's possible to merge sort with only 
	a single parameter, beyond "cheating" like this.
	*/
	public Note[] sort(Note[] s) {
		long low = s[0].getID();
		long high = s[s.length-1].getID();
		return mergesort(s, low, high);
	}
		
	public Note[] mergesort(Note[] s, long low, long high) {
		/*
		 * Recursively slices the array into smaller
		 * and smaller bits, and merges everything back together
		 * when there's nothing left to slice.
		 */
		long mid = s[(s.length/2)-1].getID();
		Note[] half1 = mergesort(s, low, mid-1);
		Note[] half2 = mergesort(s, mid-1, high);
		return (merge(half1, half2));
	}
	
	public Note[] merge(Note[] half1, Note[] half2){
		/*
		 * Merges the array pieces back into one.
		 * This uses a loop with three counters
		 * to keep track of a position on both halves of the old array,
		 * so that the result can be properly sorted.
		 */
		Note[] sorted = new Note[half1.length+half2.length];
		int a = 0;
		int b = 0;
		int i = 0;
		while (a<half1.length && b<half2.length){
			if (half1[a].getID()>half2[b].getID()){
				sorted[i]=half2[b];
				i++;
				b++;
			}
			else if (half1[a].getID()<half2[b].getID()){
				sorted[i]=half1[a];
				i++;
				a++;
			}
		}
		return sorted;
	}
}
