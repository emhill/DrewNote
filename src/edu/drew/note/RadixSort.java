
//Nikita Fedenchenko

/*
PSEUDOCODE
1)Keep an array count of size m(max range of output)
2)repeat following steps till input is exhausted 
a)read input number as x
b)implement count [x] by 1
3)repeat the following for i=0 to m
a)Assign j to zero
b) While count [i] is not equal to zero do 
	i) a[j] = I and increment j
	ii) Decrement count[i]
4) Return the sorted elements stored in array a.
   
    
Create an array a[0 n-1] elements
Call bucket sort repeatedly on least to most significant digit of each element as the key
Return the sorted array
 */
package edu.drew.note;
public class RadixSort implements SortInterface {
	
	 public static Note[] Radix(Note[] note){

	        // Largest place for a 32-bit int is the 1 billion's place
	        for(int place=1; place <= 1000000000; place *= 10){
	            // Use counting sort at each digit's place
	            note = countingSort(note, place);
	        }

	        return note;
	    }

	    private static Note[] countingSort(Note[] note, long place){ //Where the sorting actually happens
	        Note[] output = new Note[note.length]; //Creating a new note that would be our output.

	        int[] count = new int[10];  //Creating a counter

	        for(int i=0; i < note.length; i++){ //For loop that calculates 
	            int digit = getDigit(note[i].getID(), place);
	            count[digit] += 1;
	        }

	        for(int i=1; i < count.length; i++){
	            count[i] += count[i-1];
	        }

	        for(int i = note.length-1; i >= 0; i--){
	            int digit = getDigit((note[i].getID()), place);

	            output[count[digit]-1] = note[i];
	            count[digit]--;
	        }

	        return output;

	    }

	    private static int getDigit(long value, long digitPlace){  //Takes value of Note[i] and i. Returns digit.
	        return (int) ((value/digitPlace ) % 10);
	    }
	    
	    
	    public Note[] sort(Note[] s) {  //
			 s = Radix(s);
			 return s;
		}
	    
	    
	    //Main Method
	    public static void main(String[] args) {
			// make an array of notes
			Note q = new Note(" ", " ");
			Note n = new Note("CSCI 230 Project Plan", 
					"Each person will number their top 5 choices.\n" +
					"By next week, Dr. Hill will assign which piece\n" +
					"everyone will work on.\n");
			n.tag("CSCI 230");
			n.tag("final project");
			
			Note[] Note = {q,n};
			//print out not id's
			System.out.println(Note + " Worked");
			//call radix
			Radix(Note);
			System.out.println(Note);
			//print out note_id's
		}
	    
	}
	

