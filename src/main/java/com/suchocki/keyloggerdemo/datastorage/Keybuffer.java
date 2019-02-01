package com.suchocki.keyloggerdemo.datastorage;

import java.util.List;

public interface Keybuffer {
	public void addKey(String keyText);
	public void removeLastKey();
	public List<String> getBuffer();
	public int getMaxSize();
	public int getElementsNumber();
	public String getPartOfBuffer(int start, int end);
}
