/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private HangmanLexicon hangmanLexicon;
	private HangmanCanvas canvas;

	/*
	 * initializes HangmanLexicon and HangmanCanvas
	 */
	public void init() {
		hangmanLexicon = new HangmanLexicon();
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {
		setup();
		while (gameIsGoing()) {
			play();
		}
		displayFinalMessage();
	}

	/*
	 * picks the word from the Lexicon and displays masked keyword
	 */
	private void setup() {
		canvas.reset();
		keyword = hangmanLexicon.getWord(rgen.nextInt(0,
				hangmanLexicon.getWordCount()));
		int n = keyword.length();
		for (int i = 0; i < n; i++) {
			hiddenkeyword += "-";
		}
		canvas.displayWord(hiddenkeyword);
	}

	private void play() {
		println("Welcome to Hangmen!");
		println("The word now looks like this " + hiddenkeyword);
		println("You have " + guesses + " guesses left.");
		char ch = getInput();
		checkChar(ch);
	}

	/*
	 * checks if the keyword contains the character, updates the displayed keyword, creates string of
	 * incorrect characters and counts how many guesses player has left. 
	 */
	private void checkChar(char ch) {
		if (keyword.indexOf(ch) > -1) {
			correctLetters += ch;
			int i = 0;
			while (true) {
				i = keyword.indexOf(ch, i);
				if (i == -1)
					break;
				hiddenkeyword = hiddenkeyword.substring(0, i) + ch
						+ hiddenkeyword.substring(++i);
				canvas.displayWord(hiddenkeyword);
			}
		} else {
			println("There are no " + ch + "'s in the word.");
			guesses--;
			wrongLetters += ch;
			canvas.noteIncorrectGuess(wrongLetters, guesses);
		}
	}

	private void displayFinalMessage() {
		if (keyword.equals(hiddenkeyword)) {
			println("You guessed the word: " + keyword);
			println("You Win.");
		} else {
			println("You Lose! The word was " + keyword);
		}
	}

	private boolean gameIsGoing() {
		return (guesses > 0 && !keyword.equals(hiddenkeyword));
	}

	/*
	 * reads the input string and turns it into uppercase character if necessary.
	 */
	private char getInput(){
		char ch;
		while (true) {
			String typedLetter = readLine("Your guess: ");
			if (typedLetter.length() != 1) {
				println("Please try again");
			} else {
				ch = typedLetter.charAt(0);
				ch = Character.toUpperCase(ch);
				if (correctLetters.indexOf(ch) > -1
						|| !Character.isAlphabetic(ch)) {
					println("Please try again");
				} else {
					break;
				}
			}
		}
		return ch;
	}
	private int guesses = 8;
	private String keyword;
	private String hiddenkeyword = "";
	private String wrongLetters = "";
	private String correctLetters = "";
	RandomGenerator rgen = RandomGenerator.getInstance();

}
