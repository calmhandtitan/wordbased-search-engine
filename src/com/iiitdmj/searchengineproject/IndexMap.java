package com.iiitdmj.searchengineproject;

import java.awt.List;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class IndexMap {

	private HashMap<String, HashMap<String,Integer>> indexMap;
	
	public IndexMap(){
		indexMap = new HashMap<String, HashMap<String,Integer>>();
	}

	public synchronized void insertWord(String word, String url){
		HashMap<String, Integer> urlToInt = indexMap.get(word);
		if (urlToInt != null){
			Integer val = urlToInt.get(url);
			val = (val != null) ? (val + 1) : 1; 
			urlToInt.put(url, val);
		} else {
			HashMap<String, Integer> urlMap = new HashMap<String, Integer>();
			urlMap.put(url, 1);
			indexMap.put(word, urlMap);
		}
	}
	
	
	public Vector<String> performSearch(String word){
		Vector<String> result = new Vector<String>();
		
		for(  java.util.Map.Entry<String, HashMap<String, Integer>> it : indexMap.entrySet())
		{
		//	System.out.println("ASDSDASD"+ "professor".matches("professor"));
		//	System.out.println(word +" "+it.getKey() + word.matches(it.getKey()) );
			if( it.getKey().matches(word) )
					{
						System.out.println(it.getKey());
						for ( java.util.Map.Entry<String, Integer> it_inner :  it.getValue().entrySet() )
								result.add( (it_inner.getKey()+" ------> "+ it.getKey()));
						 
						
								
				
					}
		}
		
		
		return result;
	
		
	}
	
}
