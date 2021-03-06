package com.suchocki.keytaker.keyaction;

import java.util.HashMap;
import java.util.Map;

public class ActionPerformer {
	private Map<String, Action> wordActions;

	public ActionPerformer() {
		wordActions = new HashMap<>();
	}

	public void addAction(String word, Action action) {
		word = word.toUpperCase();
		word = word.replaceAll("SPACE", "Space");
		wordActions.put(word, action);
	}
	

	public void performAction(String word) {
		System.out.println("Performing action for: " + word);
		Action action = wordActions.get(word);
		if (action != null) {
			action.performAction(word);
		}
	}

}
