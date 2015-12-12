package edu.drew.note;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrewNoteGUI implements  ActionListener{


	    JPanel titlePanel, notePanel, optionPanel;
	    JLabel currentNotes, blueLabel, redScore, blueScore;
	    JButton createNewNote, deleteNote, search;
	    final JTextField userText = new JTextField(6);

	    public JPanel createContentPane (){

	        // We create a bottom JPanel to place everything on.
	        JPanel totalGUI = new JPanel();
	        totalGUI.setLayout(null);

	        // Creation of a Panel to contain the title labels
	        titlePanel = new JPanel();
	        titlePanel.setLayout(null);
	        titlePanel.setLocation(0, 175);
	        titlePanel.setBackground(Color.PINK);
	        titlePanel.setSize(900, 70);
	        totalGUI.add(titlePanel);

	        // Creation of a Panel to contain the score labels.
	        optionPanel = new JPanel();
	        optionPanel.setLayout(null);
	        optionPanel.setLocation(0, 400);
	        optionPanel.setBackground(Color.WHITE);
	        optionPanel.setSize(260, 30);
	        totalGUI.add(optionPanel);

	        createNewNote = new JButton("New Note");
	        createNewNote.setLocation(0, 0);
	        createNewNote.setSize(120, 30);
	        createNewNote.addActionListener(this);
	        optionPanel.add(createNewNote);

	        deleteNote = new JButton("Delete");
	        deleteNote.setLocation(130, 0);
	        deleteNote.setSize(120, 30);
	        deleteNote.addActionListener(this);
	        titlePanel.add(deleteNote);

	        // Creation of a Panel to contain all the JButtons.
	        notePanel = new JPanel();
	        notePanel.setLayout(null);
	        notePanel.setLocation(500, 20); //(x,y)
	        notePanel.setSize(400, 70);
	        notePanel.setBackground(Color.CYAN);
	        totalGUI.add(notePanel);

	        // We create a button and manipulate it using the syntax we have
	        // used before. Now each button has an ActionListener which posts 
	        // its action out when the button is pressed.
	       
	        search = new JButton("Search");
	        search.setLocation(250, 25);
	        search.setSize(120, 30);
	        search.addActionListener(this);
	        notePanel.add(search);
	        
	        userText.setLocation(50, 25);
	        userText.setSize(200, 30);
	        userText.addActionListener(this);
	        notePanel.add(userText);
	        
	        totalGUI.setOpaque(true);
	        return totalGUI;
	    }

	    // This is the new ActionPerformed Method.
	    // It catches any events with an ActionListener attached.
	    // Using an if statement, we can determine which button was pressed
	    // and change the appropriate values in our GUI.
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == createNewNote)
	        {
	            redScoreAmount = redScoreAmount + 1;
	            redScore.setText(""+redScoreAmount);
	        }
	        else if(e.getSource() == deleteNote)
	        {
	            blueScoreAmount = blueScoreAmount + 1;
	            blueScore.setText(""+blueScoreAmount);
	        }
	        else if(e.getSource() == search)
	        {
	            redScoreAmount = 0;
	            blueScoreAmount = 0;
	            redScore.setText(""+redScoreAmount);
	            blueScore.setText(""+blueScoreAmount);
	        }
	    }

	    private static void createAndShowGUI() {

	        JFrame.setDefaultLookAndFeelDecorated(true);
	        JFrame frame = new JFrame("DrewNote");

	        //Create and set up the content pane.
	        DrewNoteGUI demo = new DrewNoteGUI();
	        frame.setContentPane(demo.createContentPane());

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(900, 900);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}


