package com.suchocki.keyloggerdemo.config;

public class MainConfigProvider {

	private static KeyLoggerConfiguration mainConfig;

	private MainConfigProvider() {
	}

	public static KeyLoggerConfiguration getConfig() {
		if (mainConfig == null) {
			mainConfig = new MainConfig();
		}
		return mainConfig;
	}

}
