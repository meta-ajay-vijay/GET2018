package com.metacube.training;

//Class for TextEditor
public class TextEditor {

	private SpellChecker spellChecker;
	private String word;

	// Constructor
	public TextEditor(SpellChecker spellChecker, String word) {
		this.spellChecker = spellChecker;
		this.word = word;
	}

	// Getters And Setters
	public String getWord() {
		return word;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void check() {
		System.out.println(spellChecker.checkSpelling() + " of " + getWord());
	}
	// Getters And Setters End
}


