package com.metacube.training;

//Class to represent the working of Text Editor
public class TextEditor {

	private SpellChecker spellChecker;
	private String word;

	// Getters Setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	// Gettes Setters END

	public void check() {
		System.out.println(spellChecker.checkSpelling() + " of " + getWord());
	}
}
