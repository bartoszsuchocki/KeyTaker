package com.suchocki.keyloggerdemo.keyaction;

@FunctionalInterface
public interface Action {
	public void performAction(String pattern);
}
