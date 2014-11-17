package com.iiitdmj.searchengineproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.*;

public class SearchQueryForm extends JFrame implements Runnable,ActionListener {

	
	static SearchQueryForm query_form;
	
	static IndexMap indexmap;

    static JLabel enterYourName = new JLabel("Enter Search Query Here:");
    static JTextField queryBox = new JTextField(21);
    
    //textBoxToEnterName.setSize(40, 10);
    static JPanel panelTop = new JPanel();
    
    
    static JButton submit = new JButton("SEARCH");
    //submit.addActionListener(new SubmitButton());
    static JPanel panelBottom = new JPanel();
    
    //JFrame set-up
	JTextArea textArea;
    public void actionPerformed(ActionEvent e) {
    
    	try {
    	textArea.setText("");
    	Vector<String> mp =  indexmap.performSearch(queryBox.getText());
    	//System.out.println("size" +mp.size());
    	int size = mp.size();
    	
    	
    	textArea.append(size +" web pages matches found!!!\n\n");
    	
    	
    	for( String it : mp){
    		textArea.append(it + "\n");
    	}
    	
    	}
    	catch ( Exception e1)
    	{
    		textArea.append("No results found!!!");
        		
    	}
    	
    	
    }
    
	public SearchQueryForm(IndexMap im)
	{
		indexmap = im;
		setLayout(new FlowLayout());	

		textArea = new JTextArea ("No results",30,40);

		JScrollPane scroll = new JScrollPane (textArea, 
		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		submit.addActionListener(this);
		
		
		
	    panelTop.add(enterYourName);
	    panelTop.add(queryBox);
	    panelBottom.add(submit);

	    //Add panelTop to JFrame
	    add(panelTop, BorderLayout.NORTH);
	    add(panelBottom, BorderLayout.SOUTH);
	    add(scroll);
	    
	    JLabel pnames = new JLabel("made by Lokendra(2012127),Chandan(2012063),Rakesh(2012188) as part of SE course project.");
	    add(pnames);
	    setTitle("Search Engine with Regex");
	    setSize(700, 700);
	    
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void prepareGUI(IndexMap im)
	{
		query_form = new SearchQueryForm(im);
		
	}
    
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 prepareGUI(indexmap);
	     query_form.setVisible(true);
			
	}

	
}