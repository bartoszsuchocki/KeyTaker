package com.suchocki.keytaker.keyaction;

@FunctionalInterface
public interface Action {
	public void performAction(String pattern);
}
