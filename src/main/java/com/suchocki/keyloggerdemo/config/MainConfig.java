package com.suchocki.keyloggerdemo.config;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.suchocki.keyloggerdemo.dataprocessing.ActionPerformer;
import com.suchocki.keyloggerdemo.dataprocessing.GlobalKeyListener;
import com.suchocki.keyloggerdemo.dataprocessing.KeyProcesser;

public class MainConfig extends DefaultConfig {

	private final int MAX_WORD_LENGTH = 20;
	private ActionPerformer actionPerformer;
	private KeyProcesser keyProcesser;
	private GlobalKeyListener keyListener;

	public MainConfig() {
		setUpActionPerformer();
		setUpKeyProcesser();
		setUpKeyListener();
	}

	private void setUpActionPerformer() {
		actionPerformer = new ActionPerformer();
		actionPerformer.addAction("PROGRAMISTA", (word) -> {
			System.out.println("Programista lubi programować");
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_P);
				robot.keyPress(KeyEvent.VK_P);
			} catch (AWTException e) {
				System.err.println("Unable to simulate press");
				e.printStackTrace();
			}
		});
	}

	private void setUpKeyProcesser() {
		keyProcesser = new KeyProcesser(actionPerformer, MAX_WORD_LENGTH);
	}

	private void setUpKeyListener() {
		keyListener = new GlobalKeyListener(keyProcesser);
	}

	@Override
	public ActionPerformer getActionPerformer() {
		return actionPerformer;
	}

	@Override
	public KeyProcesser getKeyProcesser() {
		return keyProcesser;
	}

	@Override
	public GlobalKeyListener getKeyListener() {
		return keyListener;
	}

}
