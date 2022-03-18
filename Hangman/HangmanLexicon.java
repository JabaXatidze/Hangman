/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;

import acm.util.*;
import java.util.*;
import java.io.*;

public class HangmanLexicon {
	
	public HangmanLexicon(){
		try{
			BufferedReader lexicon = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true){
				String str = lexicon.readLine();
				if(str == null) break;
				words.add(str);
			}
			lexicon.close();
		}catch(IOException ex){
			throw new ErrorException(ex);
		}
	}
	

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return words.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return words.get(index);
	};
	
	private ArrayList<String> words = new ArrayList<String>();
}
