package com.suchocki.keyloggerdemo.config;

import com.suchocki.keyloggerdemo.dataprocessing.ActionPerformer;
import com.suchocki.keyloggerdemo.dataprocessing.GlobalKeyListener;
import com.suchocki.keyloggerdemo.dataprocessing.KeyProcesser;

public class DefaultConfig implements KeyLoggerConfiguration {

	private final int DEFAULT_MAX_WORD_SIZE = 20;
	
	@Override
	public ActionPerformer getActionPerformer() {
		return new ActionPerformer();
	}

	@Override
	public KeyProcesser getKeyProcesser() {
		return new KeyProcesser(getActionPerformer(), DEFAULT_MAX_WORD_SIZE);
	}

	@Override
	public GlobalKeyListener getKeyListener() {
		return new GlobalKeyListener(getKeyProcesser());
	}

}
