/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	GLabel displayword;
	GLabel incorrectletters;

	/** Resets the display so that only the scaffold appears */
	public void reset() {
		drawScaffold();
	}

	/**
	 * Updates the word on the screen to correspond to the current state of the
	 * game. The argument string shows what letters have been guessed so far;
	 * unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		if(displayword!=null){
			remove(displayword);
		}
		displayword = new GLabel(word,
				(getWidth() - BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 - 30,
				(getHeight() + SCAFFOLD_HEIGHT) / 2 + 30);
		displayword.setFont("Sylfaen-15");
		add(displayword);
	}

	/**
	 * Updates the display to correspond to an incorrect guess by the user.
	 * Calling this method causes the next body part to appear on the scaffold
	 * and adds the letter to the list of incorrect guesses that appears at the
	 * bottom of the window.
	 */
	public void noteIncorrectGuess(String incorrectguesses, int guess) {
		switch (guess) {
		case 0:
			drawRightFoot();
			break;
		case 1:
			drawLeftFoot();
			break;
		case 2:
			drawRightLeg();
			break;
		case 3:
			drawLeftLeg();
			break;
		case 4:
			drawRightArm();
			break;
		case 5:
			drawLeftArm();
			break;
		case 6:
			drawBody();
			break;
		case 7:
			drawHead();
			break;
		}
		
		if(incorrectletters!=null){
			remove(incorrectletters);
		}
		incorrectletters = new GLabel(incorrectguesses, (getWidth()
				- BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 - 30,
				(getHeight() + SCAFFOLD_HEIGHT) / 2 + 50);
		incorrectletters.setFont("Sylfaen-15");
		add(incorrectletters);

	}

	private void drawRightFoot() {
		GLine foot = new GLine((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH)
				/ 2 + HIP_WIDTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
				+ ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 + HIP_WIDTH
						+ FOOT_LENGTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
						+ ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH
						+ LEG_LENGTH);
		add(foot);

	}

	private void drawLeftFoot() {
		GLine foot = new GLine((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH)
				/ 2 - HIP_WIDTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
				+ ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 - HIP_WIDTH
						- FOOT_LENGTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
						+ ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH
						+ LEG_LENGTH);
		add(foot);

	}

	private void drawRightLeg() {
		GLine hip = new GLine(
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 + HIP_WIDTH,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH);
		GLine leg = new GLine((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2
				+ HIP_WIDTH, (getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH
				+ 2 * HEAD_RADIUS + BODY_LENGTH,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 + HIP_WIDTH,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(hip);
		add(leg);
	}

	private void drawLeftLeg() {
		GLine hip = new GLine(
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 - HIP_WIDTH,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH);
		GLine leg = new GLine((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2
				- HIP_WIDTH, (getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH
				+ 2 * HEAD_RADIUS + BODY_LENGTH,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2 - HIP_WIDTH,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(hip);
		add(leg);
	}

	private void drawRightArm() {
		GLine arm = new GLine(
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, (getWidth()
						+ BEAM_LENGTH - UPPER_ARM_LENGTH)
						/ 2 + UPPER_ARM_LENGTH, (getHeight() - SCAFFOLD_HEIGHT)
						/ 2 + ROPE_LENGTH + 2 * HEAD_RADIUS
						+ ARM_OFFSET_FROM_HEAD);
		GLine hand = new GLine((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH)
				/ 2 + UPPER_ARM_LENGTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
				+ ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				(getWidth() + BEAM_LENGTH + UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(arm);
		add(hand);

	}

	private void drawLeftArm() {
		GLine arm = new GLine(
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, (getWidth()
						+ BEAM_LENGTH - UPPER_ARM_LENGTH)
						/ 2 - UPPER_ARM_LENGTH, (getHeight() - SCAFFOLD_HEIGHT)
						/ 2 + ROPE_LENGTH + 2 * HEAD_RADIUS
						+ ARM_OFFSET_FROM_HEAD);
		GLine hand = new GLine((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH)
				/ 2 - UPPER_ARM_LENGTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
				+ ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2
						- UPPER_ARM_LENGTH, (getHeight() - SCAFFOLD_HEIGHT) / 2
						+ ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD
						+ LOWER_ARM_LENGTH);
		add(arm);
		add(hand);

	}

	private void drawBody() {
		GLine body = new GLine(
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH + 2
						* HEAD_RADIUS + BODY_LENGTH);
		add(body);
	}

	private void drawHead() {
		GOval head = new GOval((getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH)
				/ 2 - HEAD_RADIUS, (getHeight() - SCAFFOLD_HEIGHT) / 2
				+ ROPE_LENGTH, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		add(head);
	}

	private void drawScaffold() {
		GLine scaffold = new GLine(
				(getWidth() - BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() + SCAFFOLD_HEIGHT) / 2,
				(getWidth() - BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2);
		GLine beam = new GLine(
				(getWidth() - BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2);
		GLine rope = new GLine(
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2,
				(getWidth() + BEAM_LENGTH - UPPER_ARM_LENGTH) / 2,
				(getHeight() - SCAFFOLD_HEIGHT) / 2 + ROPE_LENGTH);
		add(scaffold);
		add(beam);
		add(rope);
	};

	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
