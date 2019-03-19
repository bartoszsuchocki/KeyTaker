package com.suchocki.keyloggerdemo.keyaction;

import org.jnativehook.keyboard.NativeKeyEvent;

import com.suchocki.keyloggerdemo.buffer.KeyBufferArrayListImpl;
import com.suchocki.keyloggerdemo.buffer.KeyBuffer;

public class KeyProcesser {

	private final KeyBuffer DEFAULT_KEY_BUFFER = new KeyBufferArrayListImpl();

	private KeyBuffer keyBuffer;
	private ActionPerformer actionPerformer;

	public KeyProcesser(ActionPerformer actionPerformer) {
		this.actionPerformer = actionPerformer;
		keyBuffer = DEFAULT_KEY_BUFFER;
	}

	public KeyProcesser(ActionPerformer actionPerformer, int maxWordLength) {
		this(actionPerformer);
		keyBuffer.setMaxSize(maxWordLength);
	}

	public KeyProcesser(ActionPerformer actionPerformer, KeyBuffer keyBuffer) {
		this.actionPerformer = actionPerformer;
		this.keyBuffer = keyBuffer;
	}

	public void addKey(int keyCode) {
		if (keyCode == NativeKeyEvent.VC_BACKSPACE) {
			keyBuffer.removeLastKey();
		} else {
			keyBuffer.addKey(NativeKeyEvent.getKeyText(keyCode));
			passWordsToActionPerformer();
		}
	}

	public void setKeyBuffer(KeyBuffer buffer) {
		this.keyBuffer = buffer;
	}

	private void passWordsToActionPerformer() {
		for (int i = 0; i < keyBuffer.getElementsNumber(); i++) {
			actionPerformer.performAction(keyBuffer.getPartOfBuffer(i, keyBuffer.getElementsNumber()));
		}
	}

}
