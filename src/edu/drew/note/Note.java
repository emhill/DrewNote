package edu.drew.note;

import java.util.Date;
import java.util.HashSet;

public class Note {
	private String title, text;
	private Date created = new Date();
	//private Date modified = new Date();
	private HashSet<String> tags = new HashSet<String>();
	
	private long id;
	private static long id_counter = 1;
	
	public Note(String t, String txt) {
		title = t;
		text = txt;
		id = id_counter++;
	}
	
	public void tag(String t) {
		tags.add(t);
	}
	
	public String toString() {
		return  title + "\n" +
				"----------------------\n" + 
				text + "\n---\n" +
				"Created on " + created + "\n" +
				"Tags: " + tags + "\n" +
				"id: " + id + "\n";
	}
	
	public static void main(String[] args) {
		Note n = new Note("CSCI 230 Project Plan", 
				"Each person will number their top 5 choices.\n" +
				"By next week, Dr. Hill will assign which piece\n" +
				"everyone will work on.\n");
		n.tag("CSCI 230");
		n.tag("final project");
		System.out.println(n);
		
		Note n2 = new Note("Testing", "The id counter");
		System.out.println(n2);
	}
}
