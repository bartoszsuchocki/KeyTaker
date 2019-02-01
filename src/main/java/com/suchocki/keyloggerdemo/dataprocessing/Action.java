package com.suchocki.keyloggerdemo.dataprocessing;

@FunctionalInterface
public interface Action {
	public void performAction(String pattern);
}
