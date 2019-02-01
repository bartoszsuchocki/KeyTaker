package com.suchocki.keyloggerdemo.config;

import com.suchocki.keyloggerdemo.dataprocessing.ActionPerformer;
import com.suchocki.keyloggerdemo.dataprocessing.GlobalKeyListener;
import com.suchocki.keyloggerdemo.dataprocessing.KeyProcesser;

public interface KeyLoggerConfiguration {
	public ActionPerformer getActionPerformer();

	public KeyProcesser getKeyProcesser();

	public GlobalKeyListener getKeyListener();
}
